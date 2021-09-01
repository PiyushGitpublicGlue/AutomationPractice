package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.utils.FakerUtils;

public class LoginPage extends BasePage {

    private By getEmail = By.id("email");
    private By getPassword = By.id("passwd");
    private By clickLoginBtn = By.id("SubmitLogin");
    private By enterNewUserEmail = By.id("email_create");
    private By clickOnCreateCustomerBtn = By.id("SubmitCreate");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    public OrderCheckoutPage doLogin(String email, String password){
        driver.findElement(getEmail).sendKeys(email);
        driver.findElement(getPassword).sendKeys(password);
        driver.findElement(clickLoginBtn).click();
        return new OrderCheckoutPage(driver);
    }

    public LoginPage enterNewUserEmail(String email){
        driver.findElement(enterNewUserEmail).sendKeys(email);
        return this;
    }

    public CreateCustomerPage clickOnCreateCustomerBtn(){
        driver.findElement(clickOnCreateCustomerBtn).click();
        return new CreateCustomerPage(driver);
    }
}
