package com.spring.springSelenium.page.google;

import com.spring.springSelenium.annotation.PageFragment;
import com.spring.springSelenium.page.Base;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageFragment
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
