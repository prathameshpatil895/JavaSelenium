package com.salesforceselenium.in.Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SauceHomePage {

    WebDriver driver;

    public SauceHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[text()='Swag Labs']")
    WebElement title;

    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    WebElement cart;

    public void cartLogo(){
        cart.click();
    }

    public void VerifyTitle(){
        Assert.assertEquals(title.getText(),"Swag Labs");
        
    }

    public void addProduct(String product){
        WebElement ele = driver.findElement(By.xpath("(//div[@class='inventory_item_name ' and contains(.,'"+product+"')]/following::button[text()='Add to cart'])[1]"));
        Assert.assertEquals(ele.getText(), "Add to cart");
        ele.click();

    }

    public void removeProduct(String product){
        WebElement ele = driver.findElement(By.xpath("(//div[@class='inventory_item_name ' and contains(.,'"+product+"')]/following::button[text()='Remove'])[1]"));
        Assert.assertEquals(ele.getText(), "Remove");
        ele.click();
    }

}