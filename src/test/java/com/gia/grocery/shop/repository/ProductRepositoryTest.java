package com.gia.grocery.shop.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.gia.grocery.shop.model.Product;
import com.gia.grocery.shop.model.Unit;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ProductRepositoryTest {

  @Test
  @TestTransaction
  public void shouldCreateProduct() {
    Product product = new Product();
    product.name = "Carrot";
    product.imageUrl = "https://cnd.gia-grocery.com/img/products/carrot.webp";
    product.stock = 100;
    product.price = new BigDecimal(20);
    product.unit = Unit.GRAM;

    Product.persist(product);
    assertNotNull(product.id);
  }
}
