package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class OrderCheckoutPage extends BasePage {

    private By getBillingAddressTitle = By.xpath("//*[@id='address_invoice']//h3");
    private By submitBillingAddressBtn = By.xpath("//*[@name='processAddress']");
    private By getShippingAddressTitle = By.xpath("//div//h1");
    private By clickOptInCheckbox = By.id("uniform-cgv");
    private By submitShippingAddressBtn = By.cssSelector(".standard-checkout");
    private By getPaymentVerificationTitle= By.xpath("//div//h1");
    private By selectPayByWireBank = By.xpath("//*[@title='Pay by bank wire']");
    private By getOrderSummaryTitle = By.xpath("//div//h1");
    private By verifyPaymentMethodTitle = By.xpath("//div//h3");
    private By clickOnConfirmOderBtn = By.xpath("//*[contains(text(),'I confirm my order')]");
    private By verifyOrderConfirmationMessage = By.xpath("//div//h1");
    private By selectPayByCheck = By.xpath("//*[@title='Pay by check.']");


    public OrderCheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getBillingAddressTitle(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(getBillingAddressTitle)).getText();
    }
    public String getShippingAddressTitle(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(getShippingAddressTitle)).getText();
    }
    public OrderCheckoutPage submitBillingAddress(){

        wait.until(ExpectedConditions.elementToBeClickable(submitBillingAddressBtn)).click();
        return this;
    }
    public OrderCheckoutPage submitShippingAddress(){
        wait.until(ExpectedConditions.elementToBeClickable(submitShippingAddressBtn)).click();
        return this;
    }
    public OrderCheckoutPage clickOptInCheckbox(){

        wait.until(ExpectedConditions.elementToBeClickable(clickOptInCheckbox)).click();
        return this;
    }
    public String getPaymentVerificationTitle(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(getPaymentVerificationTitle)).getText();
    }
    public OrderCheckoutPage selectPayByWireBank(){

        wait.until(ExpectedConditions.elementToBeClickable(selectPayByWireBank)).click();
        return this;
    }
    public OrderCheckoutPage selectPayByCheck(){

        wait.until(ExpectedConditions.elementToBeClickable(selectPayByCheck)).click();
        return this;
    }
    public String getOrderSummaryTitle(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(getOrderSummaryTitle)).getText();

    }
    public String verifyPaymentMethodTitle(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(verifyPaymentMethodTitle)).getText();
    }
    public OrderCheckoutPage clickOnConfirmOrderBtn(){

        wait.until(ExpectedConditions.elementToBeClickable(clickOnConfirmOderBtn)).click();
        return this;
    }
    public String verifyOrderConfirmationMessage(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(verifyOrderConfirmationMessage)).getText();
    }

}
