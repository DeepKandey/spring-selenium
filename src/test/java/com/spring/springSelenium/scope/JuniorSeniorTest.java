package com.spring.springSelenium.scope;

import com.spring.springSelenium.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class JuniorSeniorTest extends SpringBaseTestNGTest {

  @Autowired private JuniorEngg juniorEngg;

  @Autowired private SeniorEngg seniorEngg;

  @Test
  public void scopeTest() {
    this.juniorEngg.setAmount(100);
    System.out.println("Junior :: " + this.juniorEngg.getSalary().getAmount());

    this.seniorEngg.setAmount(200);
    System.out.println("Senior :: " + this.seniorEngg.getSalary().getAmount());
    System.out.println("Junior :: " + this.juniorEngg.getSalary().getAmount());
  }
}
