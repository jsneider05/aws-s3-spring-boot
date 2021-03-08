package com.practice.awss3.domain.port.datastore.dao;

import com.practice.awss3.domain.model.UserProfile;
import java.util.List;
import java.util.UUID;

public interface UserProfileDao {

  List<UserProfile> getUserProfiles();

  UserProfile getUserProfileById(UUID userProfileId);

}
