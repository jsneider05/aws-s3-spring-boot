package com.practice.awss3.infrastructure.configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {

  @Value("${application.cloud.aws-s3.access-key}")
  private String accessKey;

  @Value("${application.cloud.aws-s3.secret-key}")
  private String secretKey;

  @Value("${application.cloud.aws-s3.client-region}")
  private String clientRegion;

  @Bean
  public AmazonS3 s3() {
    AWSCredentials awsCredentials = new BasicAWSCredentials(
        accessKey,
        secretKey
    );
    return AmazonS3ClientBuilder
        .standard()
        .withRegion(clientRegion)
        .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
        .build();
  }

}
