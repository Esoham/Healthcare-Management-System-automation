package com.healthcare.steps;

import com.healthcare.pages.EHRManagementPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class EHRManagementSteps {

    private WebDriver driver;
    private EHRManagementPage ehrPage;

    public EHRManagementSteps() {
        // Initialize WebDriver here or inject it using dependency injection
        this.driver = // ... initialize driver
        this.ehrPage = new EHRManagementPage(driver);
    }

    @Given("I am on the EHR management page")
    public void iAmOnTheEHRManagementPage() {
        driver.get("http://your-healthcare-system-url.com/ehr-management");
    }

    @When("I enter the following EHR details:")
    public void iEnterTheFollowingEHRDetails(DataTable dataTable) {
        List<Map<String, String>> ehrData = dataTable.asMaps(String.class, String.class);
        Map<String, String> ehr = ehrData.get(0);

        ehrPage.enterPatientId(ehr.get("Patient ID"));
        ehrPage.selectRecordType(ehr.get("Record Type"));
        ehrPage.enterRecordDate(ehr.get("Date"));
        ehrPage.enterRecordDetails(ehr.get("Details"));
    }

    @When("I click the add record button")
    public void iClickTheAddRecordButton() {
        ehrPage.clickAddRecordButton();
    }

    @Then("I should see a record creation confirmation message")
    public void iShouldSeeARecordCreationConfirmationMessage() {
        String message = ehrPage.getRecordMessage();
        Assert.assertTrue(message.contains("EHR record created successfully"), "Record creation confirmation message not found");
    }

    @Then("I should see an error message for invalid patient ID")
    public void iShouldSeeAnErrorMessageForInvalidPatientID() {
        String message = ehrPage.getRecordMessage();
        Assert.assertTrue(message.contains("Invalid patient ID"), "Error message for invalid patient ID not found");
    }

    @Then("I should see an error message for invalid date")
    public void iShouldSeeAnErrorMessageForInvalidDate() {
        String message = ehrPage.getRecordMessage();
        Assert.assertTrue(message.contains("Invalid date"), "Error message for invalid date not found");
    }
}
