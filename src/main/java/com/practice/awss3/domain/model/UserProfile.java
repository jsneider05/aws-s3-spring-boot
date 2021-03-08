package com.practice.awss3.domain.model;

import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
@AllArgsConstructor
public class UserProfile {

  @Value("application.cloud.aws-s3.bucket-name")
  private String bucketName;

  private UUID userProfileId;
  private String userName;
  private String userImageLink;

  public Optional<String> getUserImageLink() {
    return Optional.ofNullable(userImageLink);
  }

  public String getFilePath() {
    return String.format("%s/%s", bucketName, this.getUserProfileId());
  }

}
