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
    USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "janetjones", null));
    USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "antoniojunior", null));
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
