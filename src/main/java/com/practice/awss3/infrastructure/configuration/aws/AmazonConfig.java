package com.practice.awss3.infrastructure.configuration.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class AmazonConfig {

  private final AmazonS3Properties s3Properties;

  @Bean
  public AmazonS3 s3() {
    AWSCredentials awsCredentials = new BasicAWSCredentials(
        s3Properties.getAccessKey(),
        s3Properties.getSecretKey()
    );
    return AmazonS3ClientBuilder
        .standard()
        .withRegion(s3Properties.getClientRegion())
        .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
        .build();
  }

}
