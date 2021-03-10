package com.practice.awss3.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "application.cloud.aws-s3.bucket-name")
@ConstructorBinding
public class UserProfileBucket {

  private final String bucketName;

}
