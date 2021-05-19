package com.spring.springSelenium.page.google;

import com.spring.springSelenium.kelvin.annotation.Page;
import com.spring.springSelenium.page.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Page
public class GooglePage extends Base {

  @Autowired private SearchComponent searchComponent;
  @Autowired private SearchResult searchResult;

  @Value("${application.url}")
  private String url;

  public void goTo() {
    this.driver.get(this.url);
  }

  public SearchComponent getSearchComponent() {
    return searchComponent;
  }

  public SearchResult getSearchResult() {
    return searchResult;
  }

  @Override
  public boolean isAt() {
    return this.searchComponent.isAt();
  }

  public void close() {
    this.driver.quit();
  }
}
