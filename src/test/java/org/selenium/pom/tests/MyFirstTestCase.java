package org.selenium.pom.tests;
import org.openqa.selenium.By;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.NewCustomerData;
import org.selenium.pom.objects.Products;
import org.selenium.pom.pages.*;
import org.selenium.pom.utils.FakerUtils;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyFirstTestCase extends BaseTest {

    @Test
    public void checkoutUsingExistingCustomerPayWithBankWire() throws InterruptedException, IOException {

        HomePage homePage = new HomePage(driver).load();
        Products products = new Products(2);
        //verify storePage title
        Assert.assertEquals(homePage.getPageTitle(),"My Store");
        homePage.hoverOverElement(products.getName()).addToCart(products.getId());
        //verify product text on cartPage
        Thread.sleep(10000);
        Assert.assertEquals(homePage.getProductTitleOnCartPopup(),products.getName());
        CartPage cartPage = homePage.proceedToCheckOut();
        //verify checkoutPage or orderPage title
        Assert.assertEquals(cartPage.getCartPageTitle(),"Order - My Store");
        //verify product text on checkoutPage
        Assert.assertEquals(cartPage.getProductTitleOnCartPage(),products.getName());
        LoginPage loginPage = cartPage.cartPageSubmit();
        //verify loginPage title
        Assert.assertEquals(loginPage.getLoginPageTitle(),"Login - My Store");
        OrderCheckoutPage orderCheckoutPage = loginPage.doLogin("testpiyushauto@test.com","Test@12345");
        //verify Address on orderPage
        Assert.assertEquals(orderCheckoutPage.getBillingAddressTitle(),"YOUR BILLING ADDRESS");
        //click on proceed to checkout on billing address confirm
        orderCheckoutPage.submitBillingAddress();
        Assert.assertEquals(orderCheckoutPage.getShippingAddressTitle(),"SHIPPING");
        //click on proceed to checkout on shipping address confirm
        orderCheckoutPage.clickOptInCheckbox().submitShippingAddress();
        //verify payment section
        Assert.assertEquals(orderCheckoutPage.getPaymentVerificationTitle(),"PLEASE CHOOSE YOUR PAYMENT METHOD");
        //pay by wireBank
        orderCheckoutPage.selectPayByWireBank();
        //verify order summary
        Assert.assertEquals(orderCheckoutPage.getOrderSummaryTitle(),"ORDER SUMMARY");
        Assert.assertEquals(orderCheckoutPage.verifyPaymentMethodTitle(),"BANK-WIRE PAYMENT.");
        orderCheckoutPage.clickOnConfirmOrderBtn();
        //verify order confirmation
        Assert.assertEquals(orderCheckoutPage.verifyOrderConfirmationMessage(),"ORDER CONFIRMATION");
    }

    @Test
    public void checkoutUsingExistingCustomerPayWithCheck() throws InterruptedException, IOException {

        HomePage homePage = new HomePage(driver).load();
        Products products = new Products(3);
        //verify storePage title
        Assert.assertEquals(homePage.getPageTitle(),"My Store");
        homePage.hoverOverElement(products.getName()).addToCart(products.getId());
        //verify product text on cartPage
        Thread.sleep(10000);
        CartPage cartPage = homePage.proceedToCheckOut();
        //verify checkoutPage or orderPage title
        Assert.assertEquals(cartPage.getCartPageTitle(),"Order - My Store");
        //verify product text on checkoutPage
        LoginPage loginPage = cartPage.cartPageSubmit();
        //verify loginPage title
        Assert.assertEquals(loginPage.getLoginPageTitle(),"Login - My Store");
        OrderCheckoutPage orderCheckoutPage = loginPage.doLogin("testpiyushauto@test.com","Test@12345");
        //verify Address on orderPage
        Assert.assertEquals(orderCheckoutPage.getBillingAddressTitle(),"YOUR BILLING ADDRESS");
        //click on proceed to checkout on billing address confirm
        orderCheckoutPage.submitBillingAddress();
        //click on proceed to checkout on shipping address confirm
        orderCheckoutPage.clickOptInCheckbox().submitShippingAddress();
        //verify payment section
        //pay by wireBank
        orderCheckoutPage.selectPayByCheck();
        //verify order summary
        Assert.assertEquals(orderCheckoutPage.verifyPaymentMethodTitle(),"CHECK PAYMENT");
        orderCheckoutPage.clickOnConfirmOrderBtn();
        //verify order confirmation
        Assert.assertEquals(orderCheckoutPage.verifyOrderConfirmationMessage(),"ORDER CONFIRMATION");
    }

    @Test
    public void checkoutUsingNewCustomer() throws InterruptedException {

        HomePage homePage = new HomePage(driver).load();
        //verify storePage title
        Assert.assertEquals(homePage.getPageTitle(),"My Store");
        homePage.hoverOverElement("Printed Chiffon Dress").addToCart(7);
        //verify product text on cartPage
        //Thread.sleep(10000);
        CartPage cartPage = homePage.proceedToCheckOut();
        //verify checkoutPage or orderPage title
        Assert.assertEquals(cartPage.getCartPageTitle(),"Order - My Store");
        //verify product text on checkoutPage
        LoginPage loginPage = cartPage.cartPageSubmit();
        //verify loginPage title
        Assert.assertEquals(loginPage.getLoginPageTitle(),"Login - My Store");
        CreateCustomerPage createCustomerPage = loginPage
                .enterNewUserEmail(FakerUtils.getRandomEmail())
                .clickOnCreateCustomerBtn();
        Thread.sleep(3000);
        Assert.assertEquals(createCustomerPage.getPageTitle(),"CREATE AN ACCOUNT");
        OrderCheckoutPage orderCheckoutPage = createCustomerPage
                .setMaleGender()
                .setFirstName("firstName")
                .setLastName("lastName")
                .setPassword("testPassword")
                .setDOB("10","4","1999")
                .selectPromo()
                .setAddress("address1")
                .setCity("city1")
                .setState("Texas")
                .setPostCode("75462")
                .setMobileNumber("0909090909")
                .clickOnSubmitBtn();
        //verify Address on orderPage
        Assert.assertEquals(orderCheckoutPage.getBillingAddressTitle(),"YOUR BILLING ADDRESS");
        //click on proceed to checkout on billing address confirm
        orderCheckoutPage.submitBillingAddress();
        //click on proceed to checkout on shipping address confirm
        orderCheckoutPage.clickOptInCheckbox().submitShippingAddress();
        //verify payment section
        //pay by wireBank
        orderCheckoutPage.selectPayByCheck();
        //verify order summary
        Assert.assertEquals(orderCheckoutPage.verifyPaymentMethodTitle(),"CHECK PAYMENT");
        orderCheckoutPage.clickOnConfirmOrderBtn();
        //verify order confirmation
        Assert.assertEquals(orderCheckoutPage.verifyOrderConfirmationMessage(),"ORDER CONFIRMATION");
    }

    @Test
    public void checkoutUsingNewCustomerByPOJO() throws InterruptedException, IOException {
        NewCustomerData newCustomerData = new NewCustomerData();
        Products products = new Products(7);
        newCustomerData=JacksonUtils.deserializeJson("myNewCustomerData.json",newCustomerData.getClass());
        HomePage homePage = new HomePage(driver).load();
        //verify storePage title
        Assert.assertEquals(homePage.getPageTitle(),"My Store");
        homePage.hoverOverElement(products.getName()).addToCart(products.getId());
        CartPage cartPage = homePage.proceedToCheckOut();
        //verify checkoutPage or orderPage title
        Assert.assertEquals(cartPage.getCartPageTitle(),"Order - My Store");
        //verify product text on checkoutPage
        LoginPage loginPage = cartPage.cartPageSubmit();
        //verify loginPage title
        Assert.assertEquals(loginPage.getLoginPageTitle(),"Login - My Store");
        CreateCustomerPage createCustomerPage = loginPage
                .enterNewUserEmail(FakerUtils.getRandomEmail())
                .clickOnCreateCustomerBtn();
        Thread.sleep(5000);
        Assert.assertEquals(createCustomerPage.getPageTitle(),"CREATE AN ACCOUNT");
        OrderCheckoutPage orderCheckoutPage = createCustomerPage
                .setCreateNewCustomer(newCustomerData)
                .clickOnSubmitBtn();
        //verify Address on orderPage
        Assert.assertEquals(orderCheckoutPage.getBillingAddressTitle(),"YOUR BILLING ADDRESS");
        //click on proceed to checkout on billing address confirm
        orderCheckoutPage.submitBillingAddress();
        //click on proceed to checkout on shipping address confirm
        orderCheckoutPage.clickOptInCheckbox().submitShippingAddress();
        //verify payment section
        //pay by wireBank
        orderCheckoutPage.selectPayByCheck();
        //verify order summary
        Assert.assertEquals(orderCheckoutPage.verifyPaymentMethodTitle(),"CHECK PAYMENT");
        orderCheckoutPage.clickOnConfirmOrderBtn();
        //verify order confirmation
        Assert.assertEquals(orderCheckoutPage.verifyOrderConfirmationMessage(),"ORDER CONFIRMATION");
    }
}
