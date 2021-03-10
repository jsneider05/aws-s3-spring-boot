package com.practice.awss3.infrastructure.adapter.filestore;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;
import com.practice.awss3.domain.model.exception.ExternalApiException;
import com.practice.awss3.domain.port.filestore.FileStore;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FileStoreS3 implements FileStore {

  private final AmazonS3 s3;

  public void save(String path, String filename, Optional<Map<String, String>> optionalMetadata,
      InputStream inputStream) {

    ObjectMetadata metadata = new ObjectMetadata();

    optionalMetadata.ifPresent(map -> {
      if (!map.isEmpty()) {
        map.forEach(metadata::addUserMetadata);
      }
    });

    try {
      s3.putObject(path, filename, inputStream, metadata);
    } catch (AmazonServiceException e) {
      throw new ExternalApiException(String.format("Failed to store file to s3 %s", e));
    }
  }

  @Override
  public byte[] download(String path, String key) {
    try {
      S3Object s3Object = s3.getObject(path, key);
      return IOUtils.toByteArray(s3Object.getObjectContent());
    } catch (AmazonServiceException | IOException e) {
      throw new ExternalApiException(String.format("Failed to download file from s3 %s", e));
    }
  }

}
