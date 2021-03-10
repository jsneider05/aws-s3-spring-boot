package com.practice.awss3.domain.service;

import com.practice.awss3.domain.model.UserProfile;
import com.practice.awss3.domain.model.UserProfileBucket;
import com.practice.awss3.domain.port.datastore.dao.UserProfileDao;
import com.practice.awss3.domain.port.filestore.FileStore;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DownloadUserProfileImageService {

  private final UserProfileDao userProfileDao;
  private final FileStore fileStore;
  private final UserProfileBucket bucket;

  public byte[] execute(UUID userProfileId) {
    // Validate whether an user exist by userProfileId
    UserProfile user = userProfileDao.getUserProfileById(userProfileId);

    String filepath = user.getImagePath(bucket.getBucketName());

    return user.getUserImageKey()
        .map(key -> fileStore.download(filepath, key))
        .orElse(new byte[0]);
  }

}
