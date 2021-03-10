package com.practice.awss3.domain.model;

import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserProfile {

  private final UUID userProfileId;
  private final String userName;
  private String userImageKey;

  public Optional<String> getUserImageKey() {
    return Optional.ofNullable(userImageKey);
  }

  public String getImagePath(String bucketName) {
    return String.format("%s/%s", bucketName, userProfileId);
  }

}
