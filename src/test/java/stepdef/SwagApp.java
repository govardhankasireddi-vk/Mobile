package stepdef;

import appium.AppiumTest;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AppHome;
import pages.LoginApp;
import pages.ProductPage;

import java.net.MalformedURLException;

public class SwagApp {

    LoginApp loginapp;
    AndroidDriver driver;
    AppHome appHome;
    ProductPage productPage;


    @Given("the app name {string}")
    public void the_app_name(String string) throws MalformedURLException {

        driver =  AppiumTest.setdriver("swag");
    }
    @Given("login to the app")
    public void login_to_the_app() {
        loginapp = new LoginApp(driver);
        loginapp.selectStandardUser();
        loginapp.clickOnLogin();

    }
    @Then("logged in sucessfully.")
    public void logged_in_sucessfully() {
        appHome = new AppHome(driver);
        if(appHome.cartIsDisplayed()){
            System.out.println("logged in");
        }
        else System.out.println("not logged in");

    }

    @And("check the products and prices")
    public void checkTheProductsAndPrices() {
        appHome.clickonFilter();
        appHome.getTitles();
    }

    @When("user added the product to the cart")
    public void userAddedTheProductToTheCart() {
        appHome.selectProduct();
        productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        productPage.clickBackToProducts();
    }

    @Then("product should be display in the cart")
    public void productShouldBeDisplayInTheCart() {
        appHome.clickViewCart();
    }
}
