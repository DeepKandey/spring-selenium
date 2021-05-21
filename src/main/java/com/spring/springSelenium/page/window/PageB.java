package com.spring.springSelenium.page.window;

import com.spring.springSelenium.kelvin.annotation.Window;
import com.spring.springSelenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Window("Page B")
public class PageB extends Base {

  @FindBy(id = "area")
  private WebElement textArea;

  public void addToArea(final String msg) {
    this.webDriverWait.until(ExpectedConditions.elementToBeClickable(textArea));
    this.textArea.sendKeys(msg);
  }

  @Override
  public boolean isAt() {
    return this.webDriverWait.until(d -> this.textArea.isDisplayed());
  }
}
