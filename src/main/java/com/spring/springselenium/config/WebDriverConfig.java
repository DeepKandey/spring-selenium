package com.spring.springselenium.config;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
public class WebDriverConfig {

  @Value("${default.timeout:30}")
  private int timeout;

  @Bean
  public WebDriver chromeDriver() {
    System.setProperty(
        "webdriver.chrome.driver", "C:\\Users\\deepa\\Downloads\\BrowserDrivers\\chromedriver.exe");
    return new ChromeDriver();
  }

  @Bean
  public WebDriverWait webDriverWait(WebDriver driver) {
    return new WebDriverWait(driver, Duration.ofSeconds(this.timeout));
  }
}
