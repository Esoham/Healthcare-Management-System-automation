package com.healthcare.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BillingPage extends BasePage {

    @FindBy(id = "patientId")
    private WebElement patientIdInput;

    @FindBy(id = "serviceCode")
    private WebElement serviceCodeInput;

    @FindBy(id = "amount")
    private WebElement amountInput;

    @FindBy(id = "billDate")
    private WebElement billDateInput;

    @FindBy(id = "paymentMethod")
    private WebElement paymentMethodSelect;

    @FindBy(id = "generateBillButton")
    private WebElement generateBillButton;

    @FindBy(id = "billMessage")
    private WebElement billMessage;

    public BillingPage(WebDriver driver) {
        super(driver);
    }

    public void enterPatientId(String patientId) {
        sendKeys(patientIdInput, patientId);
    }

    public void enterServiceCode(String serviceCode) {
        sendKeys(serviceCodeInput, serviceCode);
    }

    public void enterAmount(String amount) {
        sendKeys(amountInput, amount);
    }

    public void enterBillDate(String date) {
        sendKeys(billDateInput, date);
    }

    public void selectPaymentMethod(String method) {
        sendKeys(paymentMethodSelect, method);
    }

    public void clickGenerateBillButton() {
        click(generateBillButton);
    }

    public String getBillMessage() {
        return getText(billMessage);
    }

    public void generateBill(String patientId, String serviceCode, String amount, String date, String paymentMethod) {
        enterPatientId(patientId);
        enterServiceCode(serviceCode);
        enterAmount(amount);
        enterBillDate(date);
        selectPaymentMethod(paymentMethod);
        clickGenerateBillButton();
    }
}
