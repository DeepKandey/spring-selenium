package com.spring.springselenium.page.google;

import com.spring.springselenium.page.Base;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class SearchResult extends Base {

  @FindBy(css = "div.yuRUbf")
  private List<WebElement> results;

  public int getCount() {
    return this.results.size();
  }

  @Override
  public boolean isAt() {
    return this.webDriverWait.until(d -> !this.results.isEmpty());
  }
}
