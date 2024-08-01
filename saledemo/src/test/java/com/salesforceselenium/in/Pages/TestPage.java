package com.salesforceselenium.in.Pages;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.salesforceselenium.in.DataReader.ReadData;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPage {

    public static WebDriver driver;
    public String baseURL = "https://www.saucedemo.com/";
    public String url ="https://webdriveruniversity.com/Page-Object-Model/index.html";
    String filename ="/Users/prathameshpatil/Desktop/Test folder/JavaSelenium/saledemo/templates/Book1.xlsx";
    String sheetname ="Data";

    ReadData r1 = new ReadData();

    @BeforeSuite
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();  
    }

    @BeforeTest
    public void browserSetup(){
        System.out.println("---TEST START---");
        driver.manage().window().maximize();
    }

    @Test(enabled = true)
    public void Test1() throws InterruptedException{
        System.out.println("----TEST 1----");
        driver.get(baseURL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(    
        10));
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='user-name']")));
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement loginbtn = driver.findElement(By.xpath("//input[@id='login-button']"));
        Thread.sleep(2000);
        username.sendKeys("standard_user");
        Thread.sleep(2000);
        password.sendKeys("secret_sauce");
        Thread.sleep(2000);
        loginbtn.click();
        Thread.sleep(5000);
        //driver.close();
        System.out.println("----TEST 1 END----");
    }

    @Test(enabled = false)
    public void Test2() throws InterruptedException, IOException{
        System.out.println("----TEST 2----");
        driver.get(url);
        Thread.sleep(2000);
        Home home = new Home(driver);
        Thread.sleep(2000);
        home.ClickElement(home.ourProd);
        home.ClickElement(home.specialOffer);  
        Thread.sleep(2000);
        //driver.close();
        System.out.println("----TEST 2 END----");
    }

    @Test
    public void Test3(){
        List<List<String>> Testdata = ReadData.readExcelData(filename, sheetname);
        ReadData.processData(Testdata);
    }

    @AfterTest
    public void teardown(){
        //driver.close();
        System.out.println("----TEST END----");
        driver.quit();
    }
    
}
