package com.practice.awss3.infrastructure.adapter.datastore.repository;

import com.practice.awss3.domain.port.datastore.repository.UserProfileRepository;
import com.practice.awss3.infrastructure.adapter.datastore.UserProfileJpaRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@RequiredArgsConstructor
@Repository
public class UserProfileH2Repository implements UserProfileRepository {

  private final UserProfileJpaRepository jpaRepository;

  @Override
  public void updateUserImageKey(UUID userProfileId, String userImageKey) {
    this.jpaRepository.updateUserImageKey(userProfileId, userImageKey);
  }

}
