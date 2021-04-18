package com.spring.springselenium.config;

import com.github.javafaker.Faker;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FakerConfig {

  @Bean
  public Faker getFaker() {
    return new Faker();
  }

  @Bean
  public List<String> list() {
    return List.of("a", "b", "c");
  }
}
