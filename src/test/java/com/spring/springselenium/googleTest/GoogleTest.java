package com.spring.springselenium.googleTest;

import com.google.common.util.concurrent.Uninterruptibles;
import com.spring.springselenium.SpringBaseTestNGTest;
import com.spring.springselenium.page.google.GooglePage;
import com.spring.springselenium.util.ScreenshotUtil;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

@Lazy
public class GoogleTest extends SpringBaseTestNGTest {

  @Autowired private GooglePage googlePage;
  @Lazy @Autowired private ScreenshotUtil screenshotUtil;

  @Test
  public void googleTest() throws IOException, InterruptedException {
    this.googlePage.goTo();
    Assert.assertTrue(this.googlePage.isAt());

    Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

    // this.googlePage.getSearchComponent().search("spring boot");
    this.googlePage.getSearchComponent().search("environment");
    Assert.assertTrue(this.googlePage.getSearchResult().isAt());
    Thread.sleep(3000);
    Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
    //   this.screenshotUtil.takeScreenshot();
  }
}
