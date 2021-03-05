package com.practice.awss3.domain.service;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class UploadUserProfileService {

  public void execute(UUID userProfileId, MultipartFile file) {
    // TODO: 1. Check if image is not empty
    // TODO: 2. Check if file is an image
    // TODO: 3. The user exists in our database
    // TODO: 4. Grab some metadata from file if any
    // TODO: 5. Store the image in s3 and update database with s3 image link
  }

}
