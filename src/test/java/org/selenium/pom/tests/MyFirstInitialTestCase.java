package org.selenium.pom.tests;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstInitialTestCase {

    @Test
    public void checkoutUsingExistingCustomerPayWithBankWire() throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().cachePath("Drivers").setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        //verify storePage title
        Assert.assertEquals(driver.getTitle(),"My Store");
        driver.getCurrentUrl().contains("http://automationpractice.com/index.php");
        //code
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@class='product_img_link']//img[@title='Blouse']"))).perform();
        //action.moveToElement(driver.findElement(By.xpath("//*[@class='product_img_link']//img[@title='Blouse']"))).contextClick().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@data-id-product=2]")).click();
        Thread.sleep(2000);
        //verify product text on cartPage
        Assert.assertEquals(driver.findElement(By.id("layer_cart_product_title")).getText(),"Blouse");
        driver.findElement(By.xpath("//*[contains(text(),'Proceed to checkout')]")).click();
        //verify checkoutPage or orderPage title
        Assert.assertEquals(driver.getTitle(),"Order - My Store");
        //verify product text on checkoutPage
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//td//p[@class='product-name']//a")).getText(),"Blouse");
        driver.findElement(By.cssSelector(".standard-checkout")).click();
        //verify loginPage title
        Assert.assertEquals(driver.getTitle(),"Login - My Store");
        driver.findElement(By.id("email")).sendKeys("testpiyushauto@test.com");
        driver.findElement(By.id("passwd")).sendKeys("Test@12345");
        driver.findElement(By.id("SubmitLogin")).click();
        //verify Address on orderPage
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='address_invoice']//h3")).getText(),"YOUR BILLING ADDRESS");
        driver.findElement(By.xpath("//*[@name='processAddress']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div//h1")).getText(),"SHIPPING");
        driver.findElement(By.id("cgv")).click();
        //click on proceed to checkout on shipping address confirm
        driver.findElement(By.cssSelector(".standard-checkout")).click();
        //verify payment section
        Assert.assertEquals(driver.findElement(By.xpath("//div//h1")).getText(),"PLEASE CHOOSE YOUR PAYMENT METHOD");
        //pay by wireBank
        driver.findElement(By.xpath("//*[@title='Pay by bank wire']")).click();
        //verify order summary
        Assert.assertEquals(driver.findElement(By.xpath("//div//h1")).getText(),"ORDER SUMMARY");
        Assert.assertEquals(driver.findElement(By.xpath("//div//h3")).getText(),"BANK-WIRE PAYMENT.");
        driver.findElement(By.xpath("//*[contains(text(),'I confirm my order')]")).click();
        //verify order confirmation
        Assert.assertEquals(driver.findElement(By.xpath("//div//h1")).getText(),"ORDER CONFIRMATION");
        driver.quit();
    }

    @Test
    public void checkoutUsingExistingCustomerPayWithCheck() throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().cachePath("Drivers").setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        //verify storePage title
        Assert.assertEquals(driver.getTitle(),"My Store");
        driver.getCurrentUrl().contains("http://automationpractice.com/index.php");
        //code
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@class='product_img_link']//img[@title='Blouse']"))).perform();
        //action.moveToElement(driver.findElement(By.xpath("//*[@class='product_img_link']//img[@title='Blouse']"))).contextClick().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@data-id-product=2]")).click();
        Thread.sleep(2000);
        //verify product text on cartPage
        Assert.assertEquals(driver.findElement(By.id("layer_cart_product_title")).getText(),"Blouse");
        driver.findElement(By.xpath("//*[contains(text(),'Proceed to checkout')]")).click();
        //verify checkoutPage or orderPage title
        Assert.assertEquals(driver.getTitle(),"Order - My Store");
        //verify product text on checkoutPage
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//td//p[@class='product-name']//a")).getText(),"Blouse");
        driver.findElement(By.cssSelector(".standard-checkout")).click();
        //verify loginPage title
        Assert.assertEquals(driver.getTitle(),"Login - My Store");
        driver.findElement(By.id("email")).sendKeys("testpiyushauto@test.com");
        driver.findElement(By.id("passwd")).sendKeys("Test@12345");
        driver.findElement(By.id("SubmitLogin")).click();
        //verify Address on orderPage
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='address_invoice']//h3")).getText(),"YOUR BILLING ADDRESS");
        driver.findElement(By.xpath("//*[@name='processAddress']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div//h1")).getText(),"SHIPPING");
        driver.findElement(By.id("cgv")).click();
        //click on proceed to checkout on shipping address confirm
        driver.findElement(By.cssSelector(".standard-checkout")).click();
        //verify payment section
        Assert.assertEquals(driver.findElement(By.xpath("//div//h1")).getText(),"PLEASE CHOOSE YOUR PAYMENT METHOD");
        //pay by check
        driver.findElement(By.xpath("//*[@title='Pay by check.']")).click();
        //verify order summary
        Assert.assertEquals(driver.findElement(By.xpath("//div//h1")).getText(),"ORDER SUMMARY");
        Assert.assertEquals(driver.findElement(By.xpath("//div//h3")).getText(),"CHECK PAYMENT");
        driver.findElement(By.xpath("//*[contains(text(),'I confirm my order')]")).click();
        //verify order confirmation
        Assert.assertEquals(driver.findElement(By.xpath("//div//h1")).getText(),"ORDER CONFIRMATION");
        driver.quit();
    }

    @Test
    public void checkoutUsingNewCustomer() throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().cachePath("Drivers").setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        //verify storePage title
        Assert.assertEquals(driver.getTitle(),"My Store");
        driver.getCurrentUrl().contains("http://automationpractice.com/index.php");
        //code
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@class='product_img_link']//img[@title='Blouse']"))).perform();
        //action.moveToElement(driver.findElement(By.xpath("//*[@class='product_img_link']//img[@title='Blouse']"))).contextClick().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@data-id-product=2]")).click();
        Thread.sleep(2000);
        //verify product text on cartPage
        Assert.assertEquals(driver.findElement(By.id("layer_cart_product_title")).getText(),"Blouse");
        driver.findElement(By.xpath("//*[contains(text(),'Proceed to checkout')]")).click();
        //verify checkoutPage or orderPage title
        Assert.assertEquals(driver.getTitle(),"Order - My Store");
        //verify product text on checkoutPage
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//td//p[@class='product-name']//a")).getText(),"Blouse");
        driver.findElement(By.cssSelector(".standard-checkout")).click();
        //verify loginPage title
        Assert.assertEquals(driver.getTitle(),"Login - My Store");
        Faker faker = new Faker();
        String userEmail = "useremail"+faker.number().randomNumber();
        driver.findElement(By.id("email_create")).sendKeys(userEmail+"@test.com");
        driver.findElement(By.id("SubmitCreate")).click();
        //verify create account page
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//div//h1")).getText(),"CREATE AN ACCOUNT");
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("firstName");
        driver.findElement(By.id("customer_lastname")).sendKeys("lastName");
        driver.findElement(By.id("passwd")).sendKeys(userEmail+"testPassword");
        Select selectDay = new Select(driver.findElement(By.id("days")));
        selectDay.selectByValue("10");//Date
        Select selectMonth = new Select(driver.findElement(By.id("months")));
        selectMonth.selectByValue("4");//Month
        Select selectYear = new Select(driver.findElement(By.id("years")));
        selectYear.selectByValue("2012");//Years
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.id("address1")).sendKeys("Address1");
        driver.findElement(By.id("city")).sendKeys("City1");
        Select selectState = new Select(driver.findElement(By.id("id_state")));
        selectState.selectByVisibleText("Texas");
        driver.findElement(By.id("postcode")).sendKeys("75462");
        driver.findElement(By.id("phone_mobile")).sendKeys("0909090909");
        driver.findElement(By.id("submitAccount")).click();
        //verify Address on orderPage
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='address_invoice']//h3")).getText(),"YOUR BILLING ADDRESS");
        driver.findElement(By.xpath("//*[@name='processAddress']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div//h1")).getText(),"SHIPPING");
        driver.findElement(By.id("cgv")).click();
        //click on proceed to checkout on shipping address confirm
        driver.findElement(By.cssSelector(".standard-checkout")).click();
        //verify payment section
        Assert.assertEquals(driver.findElement(By.xpath("//div//h1")).getText(),"PLEASE CHOOSE YOUR PAYMENT METHOD");
        //pay by check
        driver.findElement(By.xpath("//*[@title='Pay by check.']")).click();
        //verify order summary
        Assert.assertEquals(driver.findElement(By.xpath("//div//h1")).getText(),"ORDER SUMMARY");
        Assert.assertEquals(driver.findElement(By.xpath("//div//h3")).getText(),"CHECK PAYMENT");
        driver.findElement(By.xpath("//*[contains(text(),'I confirm my order')]")).click();
        //verify order confirmation
        Assert.assertEquals(driver.findElement(By.xpath("//div//h1")).getText(),"ORDER CONFIRMATION");
        driver.quit();
    }
}
