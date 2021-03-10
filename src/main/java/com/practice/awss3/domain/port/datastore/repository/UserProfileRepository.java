package com.practice.awss3.domain.port.datastore.repository;

import java.util.UUID;

public interface UserProfileRepository {

  void updateUserImageKey(UUID userProfileId, String userImageKey);

}
