package com.practice.awss3.application;

import com.practice.awss3.domain.service.UploadUserProfileService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Component
public class UploadUserProfileHandler {

  private final UploadUserProfileService service;

  public void execute(UUID userProfileId, MultipartFile file) {
    this.service.execute(userProfileId, file);
  }

}
