package com.practice.awss3.domain.service;

import static org.apache.http.entity.ContentType.*;

import com.practice.awss3.domain.model.UserProfile;
import com.practice.awss3.domain.model.UserProfileBucket;
import com.practice.awss3.domain.model.exception.InternalProcessException;
import com.practice.awss3.domain.model.exception.InvalidValueException;
import com.practice.awss3.domain.model.exception.RequiredValueException;
import com.practice.awss3.domain.port.datastore.dao.UserProfileDao;
import com.practice.awss3.domain.port.filestore.FileStore;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class UploadUserProfileImageService {

  private final UserProfileDao userProfileDao;
  private final FileStore fileStore;
  private final UserProfileBucket bucket;

  public String execute(UUID userProfileId, MultipartFile file) {
    // 1. Check if image is not empty
    checkEmptyImage.accept(file);

    // 2. Check if file is an image
    checkFileImageType.accept(file);

    // 3. The user exists in our database
    UserProfile user = userProfileDao.getUserProfileById(userProfileId);

    // 4. Grab some metadata from file if any
    Optional<Map<String, String>> metadata = extractMetadata.apply(file);

    // 5. Store the image in s3 and update database with s3 image link
    String filepath = user.getImagePath(bucket.getBucketName());
    String filename = String.format("%s-%s", file.getOriginalFilename(), UUID.randomUUID());

    try {
      fileStore.save(filepath, filename, metadata, file.getInputStream());
    } catch (IOException e) {
      throw new InternalProcessException(String.valueOf(e));
    }
    return filename;
  }

  private final Consumer<MultipartFile> checkEmptyImage = file -> {
    if (file.isEmpty()) {
      throw new RequiredValueException("Image cant be empty [" + file.getSize() + "]");
    }
  };

  private final Supplier<Stream<String>> imageContentTypeAllowed = () ->
      Stream.of(IMAGE_JPEG.getMimeType(), IMAGE_PNG.getMimeType(), IMAGE_GIF.getMimeType());

  private final Consumer<MultipartFile> checkFileImageType = file -> {
    if (this.imageContentTypeAllowed.get()
        .noneMatch(contentType -> contentType.equals(file.getContentType()))) {
      throw new InvalidValueException("File must be an image [" + file.getContentType() + "]");
    }
  };

  private final Function<MultipartFile, Optional<Map<String, String>>> extractMetadata = file ->
      Optional.of(Map.of(
          "Content-Type", file.getContentType(),
          "Content-Lenght", String.valueOf(file.getSize())
      ));

}
