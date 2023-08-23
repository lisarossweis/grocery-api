package com.gia.grocery.shop.model;

import java.time.Instant;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "g_users")
public class User extends PanacheEntity {

  @Column(length = 50, nullable = false)
  public String name;

  @Column(unique = true)
  public String email;

  public String password;

  @Enumerated(EnumType.STRING)
  public UserRole role;

  @Column(name = "created_at", nullable = false)
  public Instant createdAt = Instant.now();

  @Column(name = "updated_at", nullable = false)
  public Instant updatedAt = Instant.now();
}
