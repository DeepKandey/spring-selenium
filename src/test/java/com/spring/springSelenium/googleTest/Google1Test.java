package com.spring.springSelenium.googleTest;

import com.google.common.util.concurrent.Uninterruptibles;
import com.spring.springSelenium.SpringBaseTestNGTest;
import com.spring.springSelenium.kelvin.annotation.LazyAutowired;
import com.spring.springSelenium.kelvin.service.ScreenshotService;
import com.spring.springSelenium.page.google.GooglePage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

@Lazy
public class Google1Test extends SpringBaseTestNGTest {

  @LazyAutowired private GooglePage googlePage;
  @LazyAutowired private ScreenshotService screenshotUtil;

  @Test
  public void googleTest() throws IOException, InterruptedException {
    this.googlePage.goTo();
    Assert.assertTrue(this.googlePage.isAt());

    Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

    // this.googlePage.getSearchComponent().search("spring boot");
    this.googlePage.getSearchComponent().search("selenium");
    Assert.assertTrue(this.googlePage.getSearchResult().isAt());
    Thread.sleep(3000);
    Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
    this.screenshotUtil.takeScreenshot();
    this.googlePage.close();
  }
}
