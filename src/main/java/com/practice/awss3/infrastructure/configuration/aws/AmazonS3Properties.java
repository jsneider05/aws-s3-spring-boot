package com.practice.awss3.infrastructure.configuration.aws;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "application.cloud.aws-s3")
@ConstructorBinding
public class AmazonS3Properties {

  private final String accessKey;
  private final String secretKey;
  private final String clientRegion;

}
