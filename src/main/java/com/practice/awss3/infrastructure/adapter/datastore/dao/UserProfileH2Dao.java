package com.practice.awss3.infrastructure.adapter.datastore.dao;

import com.practice.awss3.domain.model.UserProfile;
import com.practice.awss3.domain.model.exception.NoDataException;
import com.practice.awss3.domain.port.datastore.dao.UserProfileDao;
import com.practice.awss3.infrastructure.adapter.datastore.UserProfileJpaRepository;
import com.practice.awss3.infrastructure.adapter.datastore.mapper.UserProfileMapper;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@RequiredArgsConstructor
@Repository
public class UserProfileH2Dao implements UserProfileDao {

  private final UserProfileJpaRepository jpaRepository;
  private final UserProfileMapper mapper;

  @Override
  public List<UserProfile> getUserProfiles() {
    return this.mapper.toUserProfileList.apply(this.jpaRepository.findAll());
  }

  @Override
  public UserProfile getUserProfileById(UUID userProfileId) {
    return this.mapper.toUserProfile.apply(
        this.jpaRepository.findById(userProfileId)
            .orElseThrow(() -> new NoDataException(String.format("User profile %s not found",
                userProfileId))));
  }

}
