package com.practice.awss3.application;

import com.practice.awss3.domain.service.DownloadUserProfileImageService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DownloadUserProfileImageHandler {

  private final DownloadUserProfileImageService service;

  public byte[] execute(UUID userProfileId) {
    return this.service.execute(userProfileId);
  }
}
