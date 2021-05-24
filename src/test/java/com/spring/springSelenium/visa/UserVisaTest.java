package com.spring.springSelenium.visa;

import com.spring.springSelenium.SpringBaseTestNGTest;
import com.spring.springSelenium.entity.User;
import com.spring.springSelenium.page.visa.VisaRegistrationPage;
import com.spring.springSelenium.repository.UserRepository;
import java.sql.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserVisaTest extends SpringBaseTestNGTest {

  private static final Logger logger = LoggerFactory.getLogger(UserVisaTest.class);

  @Autowired private UserRepository repository;
  @Autowired private VisaRegistrationPage visaRegistrationPage;

  @Test(dataProvider = "getData")
  public void visaTest(User uer) {
    System.out.println(this.repository.findAll().size());
    this.repository.findById(85).ifPresent(u -> System.out.println(u.getFirstName()));

    // List<User> users = this.repository.findAll().stream().limit(3).collect(Collectors.toList());
    // List<User> users =
    //        this.repository.findByFirstNameStartingWith("Mi").stream()
    //            .limit(3)
    //            .collect(Collectors.toList());

    this.visaRegistrationPage.goTo();
    this.visaRegistrationPage.setNames(uer.getFirstName(), uer.getLastName());
    this.visaRegistrationPage.setCountryFromAndTo(uer.getFromCountry(), uer.getToCountry());
    this.visaRegistrationPage.setBirthDate(uer.getDob().toLocalDate());
    this.visaRegistrationPage.setComments(uer.getComments());
    this.visaRegistrationPage.submit();

    //  System.out.println(this.visaRegistrationPage.getConfirmationNumber());

    logger.info(
        "Request confirmation # INFO : " + this.visaRegistrationPage.getConfirmationNumber());
    logger.warn(
        "Request confirmation # WARN : " + this.visaRegistrationPage.getConfirmationNumber());
  }

  @DataProvider
  public Object[] getData(ITestContext context) {
    return this.repository
        .findByDobBetween(
            Date.valueOf(context.getCurrentXmlTest().getParameter("dobFrom")),
            Date.valueOf(context.getCurrentXmlTest().getParameter("dobTo")))
        .stream()
        .limit(3)
        .toArray();
  }
}
