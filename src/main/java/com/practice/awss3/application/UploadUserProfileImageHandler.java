package com.practice.awss3.application;

import com.practice.awss3.domain.port.datastore.repository.UserProfileRepository;
import com.practice.awss3.domain.service.UploadUserProfileImageService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Component
public class UploadUserProfileImageHandler {

  private final UploadUserProfileImageService service;
  private final UserProfileRepository userProfileRepository;

  @Transactional
  public void execute(UUID userProfileId, MultipartFile file) {
    String userImageKey = this.service.execute(userProfileId, file);
    this.userProfileRepository.updateUserImageKey(userProfileId, userImageKey);
  }

}
