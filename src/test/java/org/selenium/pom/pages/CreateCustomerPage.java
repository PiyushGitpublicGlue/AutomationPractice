package org.selenium.pom.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.NewCustomerData;

public class CreateCustomerPage extends BasePage {
    private By setMaleGender = By.id("uniform-id_gender1");
    private By setFemaleGender = By.id("uniform-id_gender2");
    private By setFirstName = By.id("customer_firstname");
    private By setLastName = By.id("customer_lastname");
    private By setPassword = By.id("passwd");
    private By setBirthDate = By.id("days");
    private By setBirthMonth = By.id("months");
    private By setBirthYear = By.id("years");
    private By selectPromo = By.id("uniform-optin");
    private By setAddress = By.id("address1");
    private By setCity = By.id("city");
    private By setState = By.id("id_state");
    private By setPostCode = By.id("postcode");
    private By setMobileNumber = By.id("phone_mobile");
    private By clickOnSubmitBtn = By.id("submitAccount");
    private By getPageTitle = By.xpath("//div//h1");

    public CreateCustomerPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle(){
        wait.until(ExpectedConditions.urlContains("account-creation"));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getPageTitle)).getText();
    }

    public CreateCustomerPage setCreateNewCustomer(NewCustomerData newCustomerData){
        return  setMaleGender()
                .setFirstName(newCustomerData.getFirstName())
                .setLastName(newCustomerData.getLastName())
                .setPassword(newCustomerData.getPassword())
                .setDOB(newCustomerData.getBirthDate(), newCustomerData.getBirthMonth(), newCustomerData.getBirthYear())
                .selectPromo()
                .setAddress(newCustomerData.getAddress())
                .setCity(newCustomerData.getCity())
                .setState(newCustomerData.getState())
                .setPostCode(newCustomerData.getPostCode())
                .setMobileNumber(newCustomerData.getMobileNumber());
    }

    public CreateCustomerPage setMaleGender(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(setMaleGender)).click();
        return this;
    }
    public CreateCustomerPage setFemaleGender(){
        wait.until(ExpectedConditions.elementToBeClickable(setFemaleGender)).click();
        return this;
    }
    public CreateCustomerPage setFirstName(String firstName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(setFirstName)).sendKeys(firstName);
        return this;
    }
    public CreateCustomerPage setLastName(String lastName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(setLastName)).sendKeys(lastName);
        return this;
    }
    public CreateCustomerPage setPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(setPassword)).sendKeys(password);
        return this;
    }
    public CreateCustomerPage setDOB(String date, String month, String year){
        Select selectDay = new Select(driver.findElement(setBirthDate));
        selectDay.selectByValue(date);
        Select selectMonth = new Select(driver.findElement(setBirthMonth));
        selectMonth.selectByValue(month);//Month
        Select selectYear = new Select(driver.findElement(setBirthYear));
        selectYear.selectByValue(year);//Years
        return this;
    }
    public CreateCustomerPage selectPromo(){
        wait.until(ExpectedConditions.elementToBeClickable(selectPromo)).click();
        return this;
    }
    public CreateCustomerPage setAddress(String address){
        wait.until(ExpectedConditions.visibilityOfElementLocated(setAddress)).sendKeys(address);
        return this;
    }
    public CreateCustomerPage setCity(String city){

        wait.until(ExpectedConditions.visibilityOfElementLocated(setCity)).sendKeys(city);
        return this;
    }
    public CreateCustomerPage setState(String state) {
        Select selectDay = new Select(driver.findElement(setState));
        selectDay.selectByVisibleText(state);
        return this;
    }
    public CreateCustomerPage setPostCode(String postCode){

        wait.until(ExpectedConditions.visibilityOfElementLocated(setPostCode)).sendKeys(postCode);
        return this;
    }
    public CreateCustomerPage setMobileNumber(String mobileNumber){

        wait.until(ExpectedConditions.visibilityOfElementLocated(setMobileNumber)).sendKeys(mobileNumber);
        return this;
    }
    public OrderCheckoutPage clickOnSubmitBtn(){

        wait.until(ExpectedConditions.elementToBeClickable(clickOnSubmitBtn)).click();
        return new OrderCheckoutPage(driver);
    }
}
