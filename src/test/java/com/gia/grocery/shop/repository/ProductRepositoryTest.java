package com.gia.grocery.shop.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

  @Test
  @TestTransaction
  public void shouldFindProduct() {
    String name = "Carrot";
    String imageUrl = "https://cnd.gia-grocery.com/img/products/carrot.webp";
    int stock = 100;
    BigDecimal price = new BigDecimal(20);
    Unit unit = Unit.GRAM;

    Product product = new Product();
    product.name = name;
    product.imageUrl = imageUrl;
    product.stock = stock;
    product.price = price;
    product.unit = unit;

    Product.persist(product);
    assertNotNull(product.id);

    product = Product.findById(product.id);
    assertEquals(name, product.name);
    assertEquals(imageUrl, product.imageUrl);
    assertEquals(stock, product.stock);
    assertEquals(price, product.price);
    assertEquals(unit, product.unit);
  }

  @Test
  @TestTransaction
  public void shouldUpdateProduct() {
    String name = "Carrot";
    String imageUrl = "https://cnd.gia-grocery.com/img/products/carrot.webp";
    int stock = 100;
    BigDecimal price = new BigDecimal(20);
    Unit unit = Unit.GRAM;

    Product product = new Product();
    product.name = name;
    product.imageUrl = imageUrl;
    product.stock = stock;
    product.price = price;
    product.unit = unit;

    Product.persist(product);
    assertNotNull(product.id);
    assertEquals(name, product.name);
    assertEquals(imageUrl, product.imageUrl);
    assertEquals(stock, product.stock);
    assertEquals(price, product.price);
    assertEquals(unit, product.unit);

    // update product
    name = "Potato";
    imageUrl = "https://cnd.gia-grocery.com/img/products/potato.webp";
    stock = 1000;
    price = new BigDecimal(10);
    unit = Unit.GRAM;

    product.name = name;
    product.imageUrl = imageUrl;
    product.stock = stock;
    product.price = price;
    product.unit = unit;
    Product.persist(product);

    product = Product.findById(product.id);
    assertEquals(name, product.name);
    assertEquals(imageUrl, product.imageUrl);
    assertEquals(stock, product.stock);
    assertEquals(price, product.price);
    assertEquals(unit, product.unit);
  }
}
