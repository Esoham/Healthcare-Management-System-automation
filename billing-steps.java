package com.healthcare.steps;

import com.healthcare.pages.BillingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class BillingSteps {

    private WebDriver driver;
    private BillingPage billingPage;

    public BillingSteps() {
        // Initialize WebDriver here or inject it using dependency injection
        this.driver = // ... initialize driver
        this.billingPage = new BillingPage(driver);
    }

    @Given("I am on the billing page")
    public void iAmOnTheBillingPage() {
        driver.get("http://your-healthcare-system-url.com/billing");
    }

    @When("I enter the following billing details:")
    public void iEnterTheFollowingBillingDetails(DataTable dataTable) {
        List<Map<String, String>> billingData = dataTable.asMaps(String.class, String.class);
        Map<String, String> billing = billingData.get(0);

        billingPage.enterPatientId(billing.get("Patient ID"));
        billingPage.enterServiceCode(billing.get("Service Code"));
        billingPage.enterAmount(billing.get("Amount"));
        billingPage.enterBillDate(billing.get("Date"));
        billingPage.selectPaymentMethod(billing.get("Payment Method"));
    }

    @When("I click the generate bill button")
    public void iClickTheGenerateBillButton() {
        billingPage.clickGenerateBillButton();
    }

    @Then("I should see a bill generation confirmation message")
    public void iShouldSeeABillGenerationConfirmationMessage() {
        String message = billingPage.getBillMessage();
        Assert.assertTrue(message.contains("Bill generated successfully"), "Bill generation confirmation message not found");
    }

    @Then("I should see an error message for invalid service code")
    public void iShouldSeeAnErrorMessageForInvalidServiceCode() {
        String message = billingPage.getBillMessage();
        Assert.assertTrue(message.contains("Invalid service code"), "Error message for invalid service code not found");
    }

    @Then("I should see an error message for invalid amount")
    public void iShouldSeeAnErrorMessageForInvalidAmount() {
        String message = billingPage.getBillMessage();
        Assert.assertTrue(message.contains("Invalid amount"), "Error message for invalid amount not found");
    }
}
