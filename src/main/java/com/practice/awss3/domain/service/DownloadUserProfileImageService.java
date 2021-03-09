package com.practice.awss3.domain.service;

import com.practice.awss3.domain.model.UserProfile;
import com.practice.awss3.domain.port.datastore.dao.UserProfileDao;
import com.practice.awss3.domain.port.filestore.FileStore;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DownloadUserProfileImageService {

  // TODO: Refactor bucketName
  @Value("${application.cloud.aws-s3.bucket-name}")
  private String bucketName;

  private final UserProfileDao userProfileDao;
  private final FileStore fileStore;

  public byte[] execute(UUID userProfileId) {
    // Validate whether exist user by userProfileID
    UserProfile user = userProfileDao.getUserProfileById(userProfileId);

    // TODO: Refactor this filepath
    String filepath = String.format("%s/%s", bucketName, user.getUserProfileId());

    return user.getUserImageKey()
        .map(key -> fileStore.download(filepath, key))
        .orElse(new byte[0]);
  }

}
