package com.spring.springselenium.googleTest;

import com.spring.springselenium.SpringBaseTestNGTest;
import com.spring.springselenium.page.google.GooglePage;
import com.spring.springselenium.util.ScreenshotUtil;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends SpringBaseTestNGTest {

  @Autowired private GooglePage googlePage;
  @Lazy @Autowired private ScreenshotUtil screenshotUtil;

  @Test
  public void googleTest() throws IOException {
    this.googlePage.goTo();
    Assert.assertTrue(this.googlePage.isAt());

    this.googlePage.getSearchComponent().search("spring boot");
    Assert.assertTrue(this.googlePage.getSearchResult().isAt());
    Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
    //   this.screenshotUtil.takeScreenshot();
  }
}
