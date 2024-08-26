package com.healthcare.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientRegistrationPage extends BasePage {

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "dateOfBirth")
    private WebElement dateOfBirthInput;

    @FindBy(id = "gender")
    private WebElement genderSelect;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "phone")
    private WebElement phoneInput;

    @FindBy(id = "address")
    private WebElement addressInput;

    @FindBy(id = "registerButton")
    private WebElement registerButton;

    @FindBy(id = "registrationMessage")
    private WebElement registrationMessage;

    public PatientRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstName) {
        sendKeys(firstNameInput, firstName);
    }

    public void enterLastName(String lastName) {
        sendKeys(lastNameInput, lastName);
    }

    public void enterDateOfBirth(String dateOfBirth) {
        sendKeys(dateOfBirthInput, dateOfBirth);
    }

    public void selectGender(String gender) {
        sendKeys(genderSelect, gender);
    }

    public void enterEmail(String email) {
        sendKeys(emailInput, email);
    }

    public void enterPhone(String phone) {
        sendKeys(phoneInput, phone);
    }

    public void enterAddress(String address) {
        sendKeys(addressInput, address);
    }

    public void clickRegisterButton() {
        click(registerButton);
    }

    public String getRegistrationMessage() {
        return getText(registrationMessage);
    }

    public void registerPatient(String firstName, String lastName, String dateOfBirth, String gender, String email, String phone, String address) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterDateOfBirth(dateOfBirth);
        selectGender(gender);
        enterEmail(email);
        enterPhone(phone);
        enterAddress(address);
        clickRegisterButton();
    }
}
