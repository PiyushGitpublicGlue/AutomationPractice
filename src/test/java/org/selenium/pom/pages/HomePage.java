package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.base.BasePage;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {

    //private By getProductHoverElement = By.xpath("//*[@class='product_img_link']//img[@title='Blouse']");
    private By clickAddToCart = By.xpath("//*[@data-id-product=2]");
    private By clickProceedToCheckOutBtn = By.xpath("//*[contains(text(),'Proceed to checkout')]");
    private By cartPopupTitle = By.id("layer_cart_product_title");
    private By cartPopupDisplay = By.id("layer_cart");



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
        waitForCartPopupDisplay(cartPopupDisplay);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartPopupTitle)).getText();
    }

    public HomePage hoverOverElement(String productName){
        Actions actions = new Actions(driver);
        By getProductHoverElement = By.xpath("//*[@class='product_img_link']//img[@title='"+productName+"']");
        actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(getProductHoverElement))).perform();
        return this;
    }

    public HomePage addToCart(int productID){
        By clickAddToCart = By.xpath("//*[@data-id-product="+productID+"]");
        wait.until(ExpectedConditions.elementToBeClickable(clickAddToCart)).click();
        return this;
    }

    public CartPage proceedToCheckOut(){
        wait.until(ExpectedConditions.elementToBeClickable(clickProceedToCheckOutBtn)).click();
        return new CartPage(driver);
    }
}
