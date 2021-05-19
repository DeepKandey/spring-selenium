package com.spring.springSelenium.kelvin.config;

import com.github.javafaker.Faker;
import com.spring.springSelenium.kelvin.annotation.LazyConfiguration;
import java.util.List;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
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
