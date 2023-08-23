package com.gia.grocery.shop.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

  @Test
  @TestTransaction
  public void shouldFindUser() {
    String name = "John Snow";
    String email = "john.snow@stark.com";
    String password = "YouKnowNothing";
    UserRole role = UserRole.ADMIN;

    User user = new User();
    user.name = name;
    user.email = email;
    user.password = password;
    user.role = role;

    User.persist(user);
    assertNotNull(user.id);

    user = User.findById(user.id);
    assertEquals(name, user.name);
    assertEquals(email, user.email);
    assertEquals(password, user.password);
    assertEquals(role, user.role);
  }

  @Test
  @TestTransaction
  public void shouldUpdateUser() {
    String name = "John Snow";
    String email = "john.snow@stark.com";
    String password = "YouKnowNothing";
    UserRole role = UserRole.ADMIN;

    User user = new User();
    user.name = name;
    user.email = email;
    user.password = password;
    user.role = role;

    User.persist(user);
    assertNotNull(user.id);
    Long originalUserId = user.id;

    user = User.findById(user.id);
    assertEquals(name, user.name);
    assertEquals(email, user.email);
    assertEquals(password, user.password);
    assertEquals(role, user.role);

    // update user data
    name = "Arya Stark";
    email = "arya@stark.com";
    password = "valarmogulis";
    role = UserRole.SHOP_MANAGER;

    user.name = name;
    user.email = email;
    user.password = password;
    user.role = role;

    User.persist(user);

    assertEquals(originalUserId, user.id);
    assertEquals(name, user.name);
    assertEquals(email, user.email);
    assertEquals(password, user.password);
    assertEquals(role, user.role);
  }
}
