package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class OrderCheckoutPage extends BasePage {

    private By getBillingAddressTitle = By.xpath("//*[@id='address_invoice']//h3");
    private By submitBillingAddressBtn = By.xpath("//*[@name='processAddress']");
    private By getShippingAddressTitle = By.xpath("//div//h1");
    private By clickOptInCheckbox = By.id("cgv");
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
        return driver.findElement(getBillingAddressTitle).getText();
    }
    public String getShippingAddressTitle(){
        return driver.findElement(getShippingAddressTitle).getText();
    }
    public OrderCheckoutPage submitBillingAddress(){
        driver.findElement(submitBillingAddressBtn).click();
        return this;
    }
    public OrderCheckoutPage submitShippingAddress(){
        driver.findElement(submitShippingAddressBtn).click();
        return this;
    }
    public OrderCheckoutPage clickOptInCheckbox(){
        driver.findElement(clickOptInCheckbox).click();
        return this;
    }
    public String getPaymentVerificationTitle(){
        return driver.findElement(getPaymentVerificationTitle).getText();
    }
    public OrderCheckoutPage selectPayByWireBank(){
        driver.findElement(selectPayByWireBank).click();
        return this;
    }
    public OrderCheckoutPage selectPayByCheck(){
        driver.findElement(selectPayByCheck).click();
        return this;
    }
    public String getOrderSummaryTitle(){
        return driver.findElement(getOrderSummaryTitle).getText();
    }
    public String verifyPaymentMethodTitle(){
        return driver.findElement(verifyPaymentMethodTitle).getText();
    }
    public OrderCheckoutPage clickOnConfirmOrderBtn(){
        driver.findElement(clickOnConfirmOderBtn).click();
        return this;
    }
    public String verifyOrderConfirmationMessage(){
        return driver.findElement(verifyOrderConfirmationMessage).getText();
    }

}
