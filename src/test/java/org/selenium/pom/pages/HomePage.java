package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {

    //private By getProductHoverElement = By.xpath("//*[@class='product_img_link']//img[@title='Blouse']");
    private By clickAddToCart = By.xpath("//*[@data-id-product=2]");
    private By clickProceedToCheckOutBtn = By.xpath("//*[contains(text(),'Proceed to checkout')]");
    private By cartPopup = By.id("layer_cart_product_title");



    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage load(){
        load("index.php");
        return this;
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getProductTitleOnCartPopup(){
        return driver.findElement(cartPopup).getText();
    }

    public HomePage hoverOverElement(String productName){
        Actions actions = new Actions(driver);
        By getProductHoverElement = By.xpath("//*[@class='product_img_link']//img[@title='"+productName+"']");
        actions.moveToElement(driver.findElement(getProductHoverElement)).perform();
        return this;
    }

    public HomePage addToCart(int productID){
        By clickAddToCart = By.xpath("//*[@data-id-product="+productID+"]");
        driver.findElement(clickAddToCart).click();
        return this;
    }

    public CartPage proceedToCheckOut(){
        driver.findElement(clickProceedToCheckOutBtn).click();
        return new CartPage(driver);
    }
}
