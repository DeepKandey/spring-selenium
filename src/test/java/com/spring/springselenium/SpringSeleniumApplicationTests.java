package com.spring.springselenium;

import com.github.javafaker.Faker;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSeleniumApplicationTests {

  @Autowired private User user;

  @Value("${Path}")
  private String path;

  @Value("${TEST_URL:http://www.google.com}")
  private String url;

  @Value("${fruits}")
  private String fruits;

  @Value("${fruits}")
  private List<String> fruitsList;

  @Test
  void contextLoads() {
    System.out.println(this.path);
    System.out.println(this.fruits);
    System.out.println(this.fruitsList);
    System.out.println(this.url);
    this.user.printDetails();

    Faker faker = new Faker();
    System.out.println(faker.name().firstName());
  }

  /*
  Address address = new Address();
    Salary salary = new Salary();

    User user = new User(address, salary);
    user.printDetails();
   */
}
