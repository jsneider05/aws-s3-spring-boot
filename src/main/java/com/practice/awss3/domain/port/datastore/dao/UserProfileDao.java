package com.practice.awss3.domain.port.datastore.dao;

import com.practice.awss3.domain.model.UserProfile;
import java.util.List;

public interface UserProfileDao {

  List<UserProfile> getUserProfile();

}
