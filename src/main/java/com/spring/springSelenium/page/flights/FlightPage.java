package com.spring.springSelenium.page.flights;

import com.spring.springSelenium.kelvin.annotation.Page;
import com.spring.springSelenium.page.Base;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class FlightPage extends Base {

  @FindBy(css = "a.P4z3kc.KgqTrc div.PH4Kgc.QwCDkd span")
  private List<WebElement> elements;

  public void goTo(final String url) {
    this.driver.get(url);
  }

  public List<String> getLabels() {
    return this.elements.stream()
        .map(WebElement::getText)
        .map(String::trim)
        .collect(Collectors.toList());
  }

  @Override
  public boolean isAt() {
    return this.webDriverWait.until(d -> !this.elements.isEmpty());
  }

  public void close() {
    this.driver.quit();
  }
}
