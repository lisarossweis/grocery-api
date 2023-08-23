package com.gia.grocery.shop.model;

import java.time.Instant;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "g_categories")
public class Category extends PanacheEntity {

  @Column(length = 50, nullable = false)
  public String title;

  @Column(name = "image_url")
  public String imageUrl;

  @Column(name = "created_at", nullable = false)
  public Instant createdAt = Instant.now();

  @Column(name = "updated_at", nullable = false)
  public Instant updatedAt = Instant.now();
}
