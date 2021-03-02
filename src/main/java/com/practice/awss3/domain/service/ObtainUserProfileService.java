package com.practice.awss3.domain.service;

import com.practice.awss3.domain.model.UserProfile;
import com.practice.awss3.domain.port.datastore.dao.UserProfileDao;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ObtainUserProfileService {

  private final UserProfileDao userProfileDao;

  public List<UserProfile> getUserProfile() {
    return userProfileDao.getUserProfile();
  }

}
