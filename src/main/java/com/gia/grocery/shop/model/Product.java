package com.gia.grocery.shop.model;

import java.math.BigDecimal;
import java.time.Instant;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "g_products")
public class Product extends PanacheEntity {

  @Column(length = 100, nullable = false)
  public String name;

  @Column(name = "image_url", nullable = false)
  public String imageUrl;

  @Column(nullable = false)
  public int stock;

  @Column(nullable = false)
  public BigDecimal price;

  @Enumerated(EnumType.STRING)
  public Unit unit;

  @Column(name = "created_at", nullable = false)
  public Instant createdAt = Instant.now();

  @Column(name = "updated_at", nullable = false)
  public Instant updatedAt = Instant.now();
}
