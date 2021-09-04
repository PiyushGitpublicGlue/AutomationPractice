package org.selenium.pom.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.NewCustomerData;

public class CreateCustomerPage extends BasePage {
    private By setMaleGender = By.id("id_gender1");
    private By setFemaleGender = By.id("id_gender1");
    private By setFirstName = By.id("customer_firstname");
    private By setLastName = By.id("customer_lastname");
    private By setPassword = By.id("passwd");
    private By setBirthDate = By.id("days");
    private By setBirthMonth = By.id("months");
    private By setBirthYear = By.id("years");
    private By selectPromo = By.id("optin");
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
        return driver.findElement(getPageTitle).getText();
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
        driver.findElement(setMaleGender).click();
        return this;
    }
    public CreateCustomerPage setFemaleGender(){
        driver.findElement(setFemaleGender).click();
        return this;
    }
    public CreateCustomerPage setFirstName(String firstName){
        driver.findElement(setFirstName).sendKeys(firstName);
        return this;
    }
    public CreateCustomerPage setLastName(String lastName){
        driver.findElement(setLastName).sendKeys(lastName);
        return this;
    }
    public CreateCustomerPage setPassword(String password){
        driver.findElement(setPassword).sendKeys(password);
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
        driver.findElement(selectPromo).click();
        return this;
    }
    public CreateCustomerPage setAddress(String address){
        driver.findElement(setAddress).sendKeys(address);
        return this;
    }
    public CreateCustomerPage setCity(String city){
        driver.findElement(setCity).sendKeys(city);
        return this;
    }
    public CreateCustomerPage setState(String state) {
        Select selectDay = new Select(driver.findElement(setState));
        selectDay.selectByVisibleText(state);
        return this;
    }
    public CreateCustomerPage setPostCode(String postCode){
        driver.findElement(setPostCode).sendKeys(postCode);
        return this;
    }
    public CreateCustomerPage setMobileNumber(String mobileNumber){
        driver.findElement(setMobileNumber).sendKeys(mobileNumber);
        return this;
    }
    public OrderCheckoutPage clickOnSubmitBtn(){
        driver.findElement(clickOnSubmitBtn).click();
        return new OrderCheckoutPage(driver);
    }
}
