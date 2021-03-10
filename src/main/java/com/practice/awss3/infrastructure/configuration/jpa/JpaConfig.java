package com.practice.awss3.infrastructure.configuration.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {
    "com.practice.awss3.infrastructure.entity"
})
@EnableJpaRepositories(basePackages = {
    "com.practice.awss3.infrastructure.adapter.datastore"
})
public class JpaConfig {
}
