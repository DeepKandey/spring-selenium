package com.spring.springSelenium.config;

import com.spring.springSelenium.annotation.LazyConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

@LazyConfiguration
@Profile("!remote")
public class WebDriverConfig {

  @Primary
  @Bean
  @ConditionalOnProperty(name = "browser", havingValue = "firefox")
  public WebDriver firefoxDriver() {
    System.setProperty(
        "webdriver.gecko.driver", "C:\\Users\\deepa\\Downloads\\BrowserDrivers\\geckodriver.exe");
    return new FirefoxDriver();
  }

  @Bean
  // @Scope("prototype")
  @Scope("browserScope")
  @ConditionalOnMissingBean
  public WebDriver chromeDriver() {
    System.setProperty(
        "webdriver.chrome.driver", "C:\\Users\\deepa\\Downloads\\BrowserDrivers\\chromedriver.exe");
    return new ChromeDriver();
  }
}
