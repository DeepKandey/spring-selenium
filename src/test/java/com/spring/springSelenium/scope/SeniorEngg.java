package com.spring.springSelenium.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeniorEngg {
  @Autowired private EnggSalary salary;

  public EnggSalary getSalary() {
    return salary;
  }

  public void setAmount(int amount) {
    this.salary.setAmount(amount);
  }
}
