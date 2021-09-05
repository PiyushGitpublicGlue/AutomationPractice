package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.User;

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
        enterOldUserEmail(email);
        enterOldUserPwd(password);
        submitOldUserBtn();
        return new OrderCheckoutPage(driver);
    }

    public OrderCheckoutPage setLoginCred(User user){
        enterOldUserEmail(user.getUserEmail());
        enterOldUserPwd(user.getPassword());
        submitOldUserBtn();
        return new OrderCheckoutPage(driver);
    }

    public LoginPage enterNewUserEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterNewUserEmail)).sendKeys(email);
        return this;
    }

    public LoginPage enterOldUserEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(getEmail)).sendKeys(email);
        return this;
    }

    public LoginPage enterOldUserPwd(String pwd){

        wait.until(ExpectedConditions.visibilityOfElementLocated(getPassword)).sendKeys(pwd);
        return this;
    }

    public LoginPage submitOldUserBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(clickLoginBtn)).click();
        return this;
    }


    public CreateCustomerPage clickOnCreateCustomerBtn(){

        wait.until(ExpectedConditions.elementToBeClickable(clickOnCreateCustomerBtn)).click();
        return new CreateCustomerPage(driver);
    }
}
