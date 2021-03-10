package com.practice.awss3.infrastructure.adapter.datastore.mapper;

import com.practice.awss3.domain.model.UserProfile;
import com.practice.awss3.infrastructure.entity.UserProfileEntity;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public final class UserProfileMapper {

  public final Function<UserProfileEntity, UserProfile> toUserProfile = entity ->
      new UserProfile(
          entity.getUserProfileId(),
          entity.getUserName(),
          entity.getUserImageKey());

  public final Function<List<UserProfileEntity>, List<UserProfile>> toUserProfileList = entityList ->
      entityList.stream()
          .map(this.toUserProfile)
          .collect(Collectors.toList());

}
