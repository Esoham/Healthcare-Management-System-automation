package com.healthcare.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppointmentSchedulingPage extends BasePage {

    @FindBy(id = "patientId")
    private WebElement patientIdInput;

    @FindBy(id = "doctorId")
    private WebElement doctorIdInput;

    @FindBy(id = "appointmentDate")
    private WebElement appointmentDateInput;

    @FindBy(id = "appointmentTime")
    private WebElement appointmentTimeInput;

    @FindBy(id = "appointmentType")
    private WebElement appointmentTypeSelect;

    @FindBy(id = "scheduleButton")
    private WebElement scheduleButton;

    @FindBy(id = "appointmentMessage")
    private WebElement appointmentMessage;

    public AppointmentSchedulingPage(WebDriver driver) {
        super(driver);
    }

    public void enterPatientId(String patientId) {
        sendKeys(patientIdInput, patientId);
    }

    public void enterDoctorId(String doctorId) {
        sendKeys(doctorIdInput, doctorId);
    }

    public void enterAppointmentDate(String date) {
        sendKeys(appointmentDateInput, date);
    }

    public void enterAppointmentTime(String time) {
        sendKeys(appointmentTimeInput, time);
    }

    public void selectAppointmentType(String type) {
        sendKeys(appointmentTypeSelect, type);
    }

    public void clickScheduleButton() {
        click(scheduleButton);
    }

    public String getAppointmentMessage() {
        return getText(appointmentMessage);
    }

    public void scheduleAppointment(String patientId, String doctorId, String date, String time, String type) {
        enterPatientId(patientId);
        enterDoctorId(doctorId);
        enterAppointmentDate(date);
        enterAppointmentTime(time);
        selectAppointmentType(type);
        clickScheduleButton();
    }
}
