package com.healthcare.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EHRManagementPage extends BasePage {

    @FindBy(id = "patientId")
    private WebElement patientIdInput;

    @FindBy(id = "recordType")
    private WebElement recordTypeSelect;

    @FindBy(id = "recordDate")
    private WebElement recordDateInput;

    @FindBy(id = "recordDetails")
    private WebElement recordDetailsTextarea;

    @FindBy(id = "addRecordButton")
    private WebElement addRecordButton;

    @FindBy(id = "recordMessage")
    private WebElement recordMessage;

    public EHRManagementPage(WebDriver driver) {
        super(driver);
    }

    public void enterPatientId(String patientId) {
        sendKeys(patientIdInput, patientId);
    }

    public void selectRecordType(String type) {
        sendKeys(recordTypeSelect, type);
    }

    public void enterRecordDate(String date) {
        sendKeys(recordDateInput, date);
    }

    public void enterRecordDetails(String details) {
        sendKeys(recordDetailsTextarea, details);
    }

    public void clickAddRecordButton() {
        click(addRecordButton);
    }

    public String getRecordMessage() {
        return getText(recordMessage);
    }

    public void addEHRRecord(String patientId, String recordType, String date, String details) {
        enterPatientId(patientId);
        selectRecordType(recordType);
        enterRecordDate(date);
        enterRecordDetails(details);
        clickAddRecordButton();
    }
}
