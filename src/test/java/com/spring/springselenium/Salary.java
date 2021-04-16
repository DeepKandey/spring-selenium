package com.spring.springselenium;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Salary {

  private int amount;

  @Value("${amount:1000}")
  public void setAmount(int amount) {
    this.amount = amount;
  }

  //  public Salary() {
  //    this.amount = 1000;
  //  }

  public int getAmount() {
    return amount;
  }
}
