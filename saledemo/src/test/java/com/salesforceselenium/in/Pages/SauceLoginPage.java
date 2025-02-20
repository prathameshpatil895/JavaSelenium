package com.salesforceselenium.in.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLoginPage {
    
    WebDriver driver;

    public SauceLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder ='Username']")
    WebElement username;

    @FindBy(xpath = "//input[@placeholder ='Password']")
    WebElement password;

    @FindBy(xpath = "//input[@type ='submit' and @value='Login']")
    WebElement loginBtn;

    public void login(String arg1, String arg2){
        username.sendKeys(arg1);
        password.sendKeys(arg2);
        loginBtn.click();
    }

}
