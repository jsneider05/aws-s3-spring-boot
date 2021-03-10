package com.practice.awss3.infrastructure.adapter.datastore;

import com.practice.awss3.infrastructure.entity.UserProfileEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserProfileJpaRepository extends JpaRepository<UserProfileEntity, UUID> {

  @Modifying
  @Query("update UserProfileEntity u set u.userImageKey = :userImageKey where u.userProfileId = :userProfileId")
  void updateUserImageKey(
      @Param(value = "userProfileId") UUID userProfileId,
      @Param(value = "userImageKey") String userImageKey
  );

}
