package com.practice.awss3.domain.service;

import com.practice.awss3.domain.model.UserProfile;
import com.practice.awss3.domain.port.datastore.dao.UserProfileDao;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.apache.http.entity.ContentType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class UploadUserProfileService {

  private final UserProfileDao userProfileDao;

  public void execute(UUID userProfileId, MultipartFile file) {
    // TODO: 1. Check if image is not empty
    checkEmptyImage.accept(file);

    // TODO: 2. Check if file is an image
    checkFileImageType.accept(file);

    // TODO: 3. The user exists in our database
    UserProfile userProfile = userProfileDao.getUserProfileById(userProfileId);

    // TODO: 4. Grab some metadata from file if any
    extractMetadata.apply(file);

    // TODO: 5. Store the image in s3 and update database with s3 image link


  }

  private final Consumer<MultipartFile> checkEmptyImage = file -> {
    if (file.isEmpty()) {
      throw new IllegalStateException("Image cant be empty [" + file.getSize() + "]");
    }
  };

  private final Supplier<Stream<ContentType>> imageContentTypeAllowed = () ->
      Stream.of(ContentType.IMAGE_JPEG, ContentType.IMAGE_PNG);

  private final Consumer<MultipartFile> checkFileImageType = file -> {
    if (this.imageContentTypeAllowed.get()
        .noneMatch(contentType -> contentType.toString().equals(file.getContentType()))) {
      throw new IllegalStateException("File must be an image [" + file.getContentType() + "]");
    }
  };

  private final Function<MultipartFile, Map<String, String>> extractMetadata = file ->
    Map.of(
        "Content-Type", file.getContentType(),
        "Content-Lenght", String.valueOf(file.getSize())
    );


}
