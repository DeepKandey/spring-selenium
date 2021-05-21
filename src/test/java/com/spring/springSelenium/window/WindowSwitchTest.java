package com.spring.springSelenium.window;

import com.spring.springSelenium.SpringBaseTestNGTest;
import com.spring.springSelenium.kelvin.service.WindowsSwitchService;
import com.spring.springSelenium.page.window.MainPage;
import com.spring.springSelenium.page.window.PageA;
import com.spring.springSelenium.page.window.PageB;
import com.spring.springSelenium.page.window.PageC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@TestPropertySource(properties = "browser=chrome")
public class WindowSwitchTest extends SpringBaseTestNGTest {

  @Autowired private MainPage mainPage;
  @Autowired private PageA pageA;
  @Autowired private PageB pageB;
  @Autowired private PageC pageC;
  @Autowired private WindowsSwitchService windowsSwitchService;

  @BeforeClass
  public void setUp() {
    this.mainPage.goTo();
    this.mainPage.isAt();
    this.mainPage.launchAllWindows();
  }

  @Test(dataProvider = "getData")
  public void switchTest(int index) {
    this.pageA.addToArea(index + "\n");
    this.pageB.addToArea(index + "\n");
    this.pageC.addToArea(index + "\n");
  }

  @DataProvider
  public Object[] getData() {
    return new Object[] {3, 4, 1, 5, 6, 2};
  }
}
