package com.healthcare.steps;

import com.healthcare.pages.AppointmentSchedulingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class AppointmentSchedulingSteps {

    private WebDriver driver;
    private AppointmentSchedulingPage schedulingPage;

    public AppointmentSchedulingSteps() {
        // Initialize WebDriver here or inject it using dependency injection
        this.driver = // ... initialize driver
        this.schedulingPage = new AppointmentSchedulingPage(driver);
    }

    @Given("I am on the appointment scheduling page")
    public void iAmOnTheAppointmentSchedulingPage() {
        driver.get("http://your-healthcare-system-url.com/appointment-scheduling");
    }

    @When("I enter the following appointment details:")
    public void iEnterTheFollowingAppointmentDetails(DataTable dataTable) {
        List<Map<String, String>> appointmentData = dataTable.asMaps(String.class, String.class);
        Map<String, String> appointment = appointmentData.get(0);

        schedulingPage.enterPatientId(appointment.get("Patient ID"));
        schedulingPage.enterDoctorId(appointment.get("Doctor ID"));
        schedulingPage.enterAppointmentDate(appointment.get("Date"));
        schedulingPage.enterAppointmentTime(appointment.get("Time"));
        schedulingPage.selectAppointmentType(appointment.get("Type"));
    }

    @When("I click the schedule button")
    public void iClickTheScheduleButton() {
        schedulingPage.clickScheduleButton();
    }

    @Then("I should see an appointment confirmation message")
    public void iShouldSeeAnAppointmentConfirmationMessage() {
        String message = schedulingPage.getAppointmentMessage();
        Assert.assertTrue(message.contains("Appointment scheduled successfully"), "Appointment confirmation message not found");
    }

    @Then("I should see a message indicating the time slot is unavailable")
    public void iShouldSeeAMessageIndicatingTheTimeSlotIsUnavailable() {
        String message = schedulingPage.getAppointmentMessage();
        Assert.assertTrue(message.contains("The selected time slot is unavailable"), "Time slot unavailable message not found");
    }

    @Then("I should see an error message for invalid patient ID")
    public void iShouldSeeAnErrorMessageForInvalidPatientID() {
        String message = schedulingPage.getAppointmentMessage();
        Assert.assertTrue(message.contains("Invalid patient ID"), "Error message for invalid patient ID not found");
    }
}
