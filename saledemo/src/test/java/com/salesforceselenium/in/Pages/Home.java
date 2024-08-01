package com.salesforceselenium.in.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {

    WebDriver driver;

    public Home(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="//p[text()='Special Offers']")
    WebElement specialOffer;

    @FindBy(xpath = "//a[text()='Our Products']") 
    WebElement ourProd;

    public void ClickElement(WebElement element){
        Actions act = new Actions(driver);
        WebElement ele = element;
        act.scrollToElement(ele).moveToElement(ele).click().build().perform();
    }

    
}
