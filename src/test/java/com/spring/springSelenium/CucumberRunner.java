package com.spring.springSelenium;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "classpath:features",
    glue = "com.spring.springSelenium.bdd",
    tags = "@visa or @google", // tags = "@visa and @google",
    plugin = {
      "pretty",
      "html:C:/Data/Git Projects/spring-selenium/spring-selenium/target/cucumberReports/report.html"
    })
public class CucumberRunner extends AbstractTestNGCucumberTests {

  @Override
  @DataProvider(parallel = true)
  public Object[][] scenarios() {
    return super.scenarios();
  }
}
