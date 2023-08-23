package com.gia.grocery.shop.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.gia.grocery.shop.model.User;
import com.gia.grocery.shop.model.UserRole;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class UserRepositoryTest {

  @Test
  @TestTransaction
  public void shouldCreateUser() {
    User user = new User();
    user.name = "John Snow";
    user.email = "john.snow@stark.com";
    user.password = "secret";
    user.role = UserRole.ADMIN;

    User.persist(user);
    assertNotNull(user.id);
  }
}
