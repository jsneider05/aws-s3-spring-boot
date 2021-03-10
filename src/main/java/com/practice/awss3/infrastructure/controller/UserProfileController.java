package com.practice.awss3.infrastructure.controller;

import static org.springframework.http.HttpHeaders.*;

import com.practice.awss3.application.DownloadUserProfileImageHandler;
import com.practice.awss3.application.ObtainUserProfileHandler;
import com.practice.awss3.application.UploadUserProfileImageHandler;
import com.practice.awss3.domain.model.UserProfile;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public void uploadUserProfileImage(@PathVariable("user-profile-id") UUID userProfileId,
      @RequestParam("file") MultipartFile file) {
    this.uploadUserProfileImageHandler.execute(userProfileId, file);
  }

  @GetMapping("{user-profile-id}/image/download")
  public ResponseEntity<ByteArrayResource> downloadUserProfileImage(
      @PathVariable("user-profile-id") UUID userProfileId) {
    byte[] image = this.downloadUserProfileImageHandler.execute(userProfileId);
    ByteArrayResource resource = new ByteArrayResource(image);
    return ResponseEntity
        .ok()
        .header(CONTENT_DISPOSITION, "attachment; filename=" + "user-image-" + userProfileId)
        .body(resource);
  }

}
