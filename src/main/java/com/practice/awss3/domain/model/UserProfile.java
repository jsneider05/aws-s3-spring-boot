package com.practice.awss3.domain.model;

import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserProfile {

  private UUID userProfileId;
  private String userName;
  private String userImageLink;

  public Optional<String> getUserImageLink() {
    return Optional.ofNullable(userImageLink);
  }

}
