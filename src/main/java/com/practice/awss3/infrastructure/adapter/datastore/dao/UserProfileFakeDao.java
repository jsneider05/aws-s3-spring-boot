package com.practice.awss3.infrastructure.adapter.datastore.dao;

import com.practice.awss3.domain.model.UserProfile;
import com.practice.awss3.domain.port.datastore.dao.UserProfileDao;
import com.practice.awss3.infrastructure.adapter.datastore.UserProfileFakeDataStore;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserProfileFakeDao implements UserProfileDao {

  private final UserProfileFakeDataStore dataStore;

  @Override
  public List<UserProfile> getUserProfiles() {
    return this.dataStore.getUserProfiles();
  }

  @Override
  public UserProfile getUserProfileById(UUID userProfileId) {
    return this.dataStore.getUserProfile(userProfileId)
        .orElseThrow(() -> new IllegalStateException(String.format("User profile %s not found",
            userProfileId)));
  }

}
