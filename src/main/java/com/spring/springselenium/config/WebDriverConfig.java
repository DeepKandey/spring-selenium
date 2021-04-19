package com.spring.springselenium.config;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

@Lazy
@Configuration
public class WebDriverConfig {

  @Value("${default.timeout:30}")
  private int timeout;

  @Primary
  @Bean
  @ConditionalOnProperty(name = "browser", havingValue = "firefox")
  public WebDriver firefoxDriver() {
    System.setProperty(
        "webdriver.gecko.driver", "C:\\Users\\deepa\\Downloads\\BrowserDrivers\\geckodriver.exe");
    return new FirefoxDriver();
  }

  @Bean
  @ConditionalOnMissingBean
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
