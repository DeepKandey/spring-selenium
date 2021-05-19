package com.spring.springSelenium.kelvin.config;

import com.spring.springSelenium.kelvin.annotation.LazyConfiguration;
import com.spring.springSelenium.kelvin.annotation.ThreadScopeBean;
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
  @ThreadScopeBean
  @ConditionalOnProperty(name = "browser", havingValue = "firefox")
  public WebDriver firefoxDriver() {
    System.setProperty(
        "webdriver.gecko.driver", "C:\\Users\\deepa\\Downloads\\BrowserDrivers\\geckodriver.exe");
    return new FirefoxDriver();
  }

  @ThreadScopeBean
  // @Scope("prototype")
  @ConditionalOnMissingBean
  public WebDriver chromeDriver() {
    System.setProperty(
        "webdriver.chrome.driver", "C:\\Users\\deepa\\Downloads\\BrowserDrivers\\chromedriver.exe");
    return new ChromeDriver();
  }
}
