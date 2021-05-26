package com.spring.springSelenium.bdd;

import com.spring.springSelenium.kelvin.annotation.LazyAutowired;
import com.spring.springSelenium.page.visa.VisaRegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.LocalDate;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ObjectUtils;

@SpringBootTest
public class VisaSteps {

  @LazyAutowired private VisaRegistrationPage registrationPage;

  @Given("I am on VISA registration form")
  public void launchSite() {
    this.registrationPage.goTo();
    Assert.assertTrue(this.registrationPage.isAt());
  }

  @When("I select my from country {string} and to country {string}")
  public void selectCountry(String from, String to) {
    this.registrationPage.setCountryFromAndTo(from, to);
  }

  @And("I enter my dob as {string}")
  public void enterDob(String dob) {
    this.registrationPage.setBirthDate(LocalDate.parse(dob));
  }

  @And("I enter my name as {string} and {string}")
  public void enterNames(String fn, String ln) {
    this.registrationPage.setNames(fn, ln);
  }

  @And("I enter my contact details as {string} and {string}")
  public void enterContactDetails(String email, String phone) {
    this.registrationPage.setContactDetails(email, phone);
  }

  @And("I enter the comment {string}")
  public void enterComment(String comment) {
    this.registrationPage.setComments(comment);
  }

  @And("I submit the form")
  public void submit() {
    this.registrationPage.submit();
  }

  @Then("I should see get the confirmation number")
  public void verifyConfirmationNumber() {
    boolean isEmpty = ObjectUtils.isEmpty(this.registrationPage.getConfirmationNumber().trim());
    Assert.assertFalse(isEmpty);
  }
}
