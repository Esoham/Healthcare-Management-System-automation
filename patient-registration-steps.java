package com.healthcare.steps;

import com.healthcare.pages.PatientRegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class PatientRegistrationSteps {

    private WebDriver driver;
    private PatientRegistrationPage registrationPage;

    public PatientRegistrationSteps() {
        // Initialize WebDriver here or inject it using dependency injection
        this.driver = // ... initialize driver
        this.registrationPage = new PatientRegistrationPage(driver);
    }

    @Given("I am on the patient registration page")
    public void iAmOnThePatientRegistrationPage() {
        driver.get("http://your-healthcare-system-url.com/patient-registration");
    }

    @When("I enter the following patient details:")
    public void iEnterTheFollowingPatientDetails(DataTable dataTable) {
        List<Map<String, String>> patientData = dataTable.asMaps(String.class, String.class);
        Map<String, String> patient = patientData.get(0);

        registrationPage.enterFirstName(patient.get("First Name"));
        registrationPage.enterLastName(patient.get("Last Name"));
        registrationPage.enterDateOfBirth(patient.get("Date of Birth"));
        registrationPage.selectGender(patient.get("Gender"));
        registrationPage.enterEmail(patient.get("Email"));
        registrationPage.enterPhone(patient.get("Phone"));
        registrationPage.enterAddress(patient.get("Address"));
    }

    @When("I click the register button")
    public void iClickTheRegisterButton() {
        registrationPage.clickRegisterButton();
    }

    @Then("I should see a registration success message")
    public void iShouldSeeARegistrationSuccessMessage() {
        String message = registrationPage.getRegistrationMessage();
        Assert.assertTrue(message.contains("Patient registered successfully"), "Registration success message not found");
    }

    @Then("I should see error messages for the missing fields")
    public void iShouldSeeErrorMessagesForTheMissingFields() {
        String message = registrationPage.getRegistrationMessage();
        Assert.assertTrue(message.contains("Please fill in all required fields"), "Error message for missing fields not found");
    }

    @Then("I should see an error message for invalid email")
    public void iShouldSeeAnErrorMessageForInvalidEmail() {
        String message = registrationPage.getRegistrationMessage();
        Assert.assertTrue(message.contains("Please enter a valid email address"), "Error message for invalid email not found");
    }
}
