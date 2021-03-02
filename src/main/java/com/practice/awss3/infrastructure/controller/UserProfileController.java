package com.practice.awss3.infrastructure.controller;

import com.practice.awss3.application.ObtainUserProfileHandler;
import com.practice.awss3.domain.model.UserProfile;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/user-profile")
public class UserProfileController {

  private final ObtainUserProfileHandler obtainUserProfileHandler;

  @GetMapping
  public List<UserProfile> getUserProfile() {
    return obtainUserProfileHandler.getUserProfile();
  }

}
