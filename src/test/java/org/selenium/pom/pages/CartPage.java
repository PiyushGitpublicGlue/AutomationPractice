package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        return driver.findElement(verifyProductNameOnCartPage).getText();
    }

    public LoginPage cartPageSubmit(){
        driver.findElement(clickCartPageSubmit).click();
        return new LoginPage(driver);
    }
}
