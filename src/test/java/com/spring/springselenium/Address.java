package com.spring.springselenium;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Address {

  @Autowired private Faker faker;

  //  @Value("${street}")
  //  private String street;

  //  public Address() {
  //    this.street = "123 non main st";
  //  }

  public String getStreet() {
    return faker.address().streetAddress();
  }
}
