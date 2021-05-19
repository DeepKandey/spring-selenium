package com.spring.springSelenium.config;

import com.spring.springSelenium.annotation.LazyConfiguration;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class WebDriverWaitConfig {

  @Value("${default.timeout:30}")
  private int timeout;

  @Bean
  public WebDriverWait webDriverWait(WebDriver driver) {
    return new WebDriverWait(driver, Duration.ofSeconds(this.timeout));
  }
}
