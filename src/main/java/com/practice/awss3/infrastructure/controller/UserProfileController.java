package com.practice.awss3.infrastructure.controller;

import com.practice.awss3.application.DownloadUserProfileImageHandler;
import com.practice.awss3.application.ObtainUserProfileHandler;
import com.practice.awss3.application.UploadUserProfileImageHandler;
import com.practice.awss3.domain.model.UserProfile;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestControllerAdvice
@RestController
@CrossOrigin("*")
@RequestMapping("/v1/user-profile")
public class UserProfileController {

  private final ObtainUserProfileHandler obtainUserProfileHandler;
  private final UploadUserProfileImageHandler uploadUserProfileImageHandler;
  private final DownloadUserProfileImageHandler downloadUserProfileImageHandler;

  @GetMapping
  public List<UserProfile> getUserProfile() {
    return this.obtainUserProfileHandler.getUserProfile();
  }

  @PostMapping(
      path = "{user-profile-id}/image/upload",
      consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public void uploadUserProfileImage(@PathVariable("user-profile-id") UUID userProfileId,
      @RequestParam("file") MultipartFile file) {
    this.uploadUserProfileImageHandler.execute(userProfileId, file);
  }

  @GetMapping("{user-profile-id}/image/download")
  public byte[] downloadUserProfileImage(@PathVariable("user-profile-id") UUID userProfileId) {
    return this.downloadUserProfileImageHandler.execute(userProfileId);
  }

}
