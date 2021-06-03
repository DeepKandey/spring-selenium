package com.spring.springSelenium.kelvin.aop;

import com.spring.springSelenium.kelvin.annotation.Window;
import com.spring.springSelenium.kelvin.service.WindowSwitchService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowAspect {

  @Autowired private WindowSwitchService windowSwitchService;

  @Before("@target(window) && within(com.spring.springSelenium..*)")
  public void before(Window window) {
    this.windowSwitchService.switchByTitle(window.value());
  }

  @After("@target(window) && within(com.spring.springSelenium..*)")
  public void after(Window window) {
    this.windowSwitchService.switchByIndex(0);
  }
}
