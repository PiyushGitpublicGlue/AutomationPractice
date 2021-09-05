package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {

    private By verifyProductNameOnCartPage = By.xpath("//td//p[@class='product-name']//a");
    private By clickCartPageSubmit = By.cssSelector(".standard-checkout");



    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getCartPageTitle(){
        return driver.getTitle();
    }

    public String getProductTitleOnCartPage(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(verifyProductNameOnCartPage)).getText();
    }

    public LoginPage cartPageSubmit(){
        wait.until(ExpectedConditions.elementToBeClickable(clickCartPageSubmit)).click();
        return new LoginPage(driver);
    }
}
