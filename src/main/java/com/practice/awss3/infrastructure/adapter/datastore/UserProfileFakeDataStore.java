package com.practice.awss3.infrastructure.adapter.datastore;

import com.practice.awss3.domain.model.UserProfile;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class UserProfileFakeDataStore {

  private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

  static {
    USER_PROFILES.add(new UserProfile(UUID.fromString("dbd7b79a-53ee-4627-8e64-19bbd92254ad"), "janetjones", null));
    USER_PROFILES.add(new UserProfile(UUID.fromString("1e7e9482-7cfb-4e2d-bbf8-e299d7dc9307"), "antoniojunior", null));
  }

  public List<UserProfile> getUserProfiles() {
    return USER_PROFILES;
  }

  public Optional<UserProfile> getUserProfile(UUID userProfileId) {
    return USER_PROFILES.stream()
        .filter(userProfile -> userProfile.getUserProfileId().equals(userProfileId))
        .findFirst();
  }

}
