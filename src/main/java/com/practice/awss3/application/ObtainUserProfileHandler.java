package com.practice.awss3.application;

import com.practice.awss3.domain.model.UserProfile;
import com.practice.awss3.domain.service.ObtainUserProfileService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ObtainUserProfileHandler {

  private final ObtainUserProfileService service;

  public List<UserProfile> getUserProfile() {
    return service.getUserProfile();
  }

}
