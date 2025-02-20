package com.salesforceselenium.in;


import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.salesforceselenium.in.Pages.SauceCartPage;
import com.salesforceselenium.in.Pages.SauceHomePage;
import com.salesforceselenium.in.Pages.SauceLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest2 {
        /**
     * Rigorous Test :-)
     */
    WebDriver driver;
    SauceLoginPage loginPage ;
    SauceHomePage homePage  ;
    SauceCartPage cartPage ;
    String weburl ="https://www.saucedemo.com/";

    @DataProvider(name="loginData")
    public Object[][] getlogindata(){
        return new Object[][]{
            {"standard_user", "secret_sauce"},
            {"problem_user", "secret_sauce"},
            {"visual_user", "secret_sauce"}
        };
    }


    @BeforeMethod
    public void startBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(weburl);
        
    }

    @Test(dataProvider ="loginData" )
    public void successLogin(String username, String password){
        loginPage = new SauceLoginPage(driver);
        homePage = new SauceHomePage(driver);
        Reporter.log("Logging in to the Website.");
        loginPage.login(username, password);        
        homePage.VerifyTitle();

    }

    @Test
    public void addProduct() throws InterruptedException{
        loginPage = new SauceLoginPage(driver);
        homePage = new SauceHomePage(driver);
        loginPage.login("standard_user", "secret_sauce");        
        homePage.VerifyTitle();
        String prd = "Sauce Labs Backpack";
        homePage.addProduct(prd);
        Thread.sleep(3000);
    
    }

    @Test
    public void removeProduct() throws InterruptedException{
        loginPage = new SauceLoginPage(driver);
        homePage = new SauceHomePage(driver);
        loginPage.login("standard_user", "secret_sauce");        
        homePage.VerifyTitle();
        String prd = "Sauce Labs Bike Light";
        homePage.addProduct(prd);
        Thread.sleep(3000);
        homePage.removeProduct(prd);
        Thread.sleep(3000);
   
    }


    @Test
    public void cartpage() throws InterruptedException{
        loginPage = new SauceLoginPage(driver);
        homePage = new SauceHomePage(driver);
        cartPage = new SauceCartPage(driver);
        loginPage.login("standard_user", "secret_sauce");        
        homePage.VerifyTitle();
        String prd = "Sauce Labs Bolt T-Shirt";
        homePage.addProduct(prd);
        Thread.sleep(3000);
        homePage.cartLogo();
        Thread.sleep(3000);

    }

    @AfterMethod
    public void closebrowser(){
        driver.close();
    }

    @AfterSuite
    public void quitBrowser(){
        driver.quit();
    }
}
