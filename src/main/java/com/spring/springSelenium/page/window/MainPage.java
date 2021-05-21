package com.spring.springSelenium.page.window;

import com.spring.springSelenium.kelvin.annotation.Page;
import com.spring.springSelenium.page.Base;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Page
public class MainPage extends Base {

  @FindBy(tagName = "a")
  private List<WebElement> links;

  public void goTo() {
    this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/window/main.html");
  }

  public void launchAllWindows() {
    for (int i = 0; i < links.size(); i++) {
      links.get(i).click();
      this.webDriverWait.until(ExpectedConditions.numberOfWindowsToBe(i + 2));
    }
  }

  @Override
  public boolean isAt() {
    return this.webDriverWait.until(d -> !this.links.isEmpty());
  }

  public void quitBrowser() {
    this.driver.quit();
  }
}
