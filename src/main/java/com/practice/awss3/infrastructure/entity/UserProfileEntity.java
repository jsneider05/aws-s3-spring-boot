package com.practice.awss3.infrastructure.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_profile")
public class UserProfileEntity {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
      name = "UUID",
      strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(name = "id", unique = true, nullable = false, columnDefinition = "uuid")
  @ColumnDefault("random_uuid()")
  private UUID userProfileId;

  @Column(name = "name", nullable = false)
  private String userName;

  @Column(name = "image_key", columnDefinition = "TEXT")
  private String userImageKey;

}
