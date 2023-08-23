package com.gia.grocery.shop.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.gia.grocery.shop.model.Category;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class CategoryRepositoryTest {

  @Test
  @TestTransaction
  public void shouldCreateCategory() {
    Category category = new Category();
    category.title = "Vegetables";
    category.imageUrl = "https://cdn.gia-gracery/img/category/vegetables.svg";

    Category.persist(category);
    assertNotNull(category.id);
  }

  @Test
  @TestTransaction
  public void shouldFindCategory() {
    String title = "Vegetables";
    String imageUrl = "https://cdn.gia-gracery/img/category/vegetables.svg";
    Category category = new Category();
    category.title = title;
    category.imageUrl = imageUrl;

    Category.persist(category);
    assertNotNull(category.id);

    category = Category.findById(category.id);
    assertEquals(title, category.title);
    assertEquals(imageUrl, category.imageUrl);
  }
}
