package com.salesforceselenium.in.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceCartPage {

    WebDriver driver;
    
    public SauceCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    WebElement cart;

    public void cartLogo(){
        cart.click();
    }

}
