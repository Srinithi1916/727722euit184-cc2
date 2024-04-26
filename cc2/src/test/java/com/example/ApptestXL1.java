package com.example;


import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
public class ApptestXL1 {
    public static Logger log = LogManager.getLogger(ApptestXL1.class);
    WebDriver driver;
    ExtentReports reports;
    ExtentTest test;

    @BeforeMethod
    public void mybfre() throws Exception
    {
        driver=new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        test=reports.createTest("test started");
        log.info("URL is being opened!!!");
        driver.get("https://www.barnesandnoble.com/");
        log.info("URL opened Successfully!!!!!");
         PropertyConfigurator.configure("D:\\log4j.properties");

    }

    @Test
    public void testing1() throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.barnesandnoble.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/div[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/div[1]/div/a[2]")).click();
        Thread.sleep(2000);

        File file = new File("D:\\dbankdemo.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh = wb.getSheet("Sheet1");
        XSSFRow r = sh.getRow(2);
        String x = r.getCell(0).getStringCellValue();
        driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/div[2]/div/input[1]"))
                .sendKeys(x);
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[3]/form/div/span")).click();
        Thread.sleep(2000);
        WebElement page = driver
                .findElement(By.xpath("//*[@id='searchGrid']/div/section[1]/section[1]/div/div[1]/div[1]/h1/span"));
        String source = page.getText();
        if (source.equals("Chetan Bhagat"))
            System.out.print("Name found");
        else
            System.out.print("Name not found");
        driver.quit();
    }

    @Test
    public void testing2() throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.barnesandnoble.com/");
        driver.manage().window().maximize();
        WebElement clickable = driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/div[4]/div/ul/li[5]/a"));
        new Actions(driver)
                .clickAndHold(clickable)
                .perform();
        driver.findElement(By.linkText("Audiobooks Top 100")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div/div[2]/div/div[2]/section[2]/ol/li[1]/div/div[2]/div[1]/h3/a")).click();
        Thread.sleep(2000);
        // driver.findElement(By.xpath("/html/body/main/div[2]/div[2]/section/div[2]/div/div[3]/div[2]/ul/li[2]/div/div/label/span")).click();
        // Thread.sleep(2000);
        JavascriptExecutor js10 = (JavascriptExecutor) driver;
         js10.executeScript("window.scrollBy(0,1000)");
         Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"commerce-zone\"]/div[2]/ul/li[2]/div/div/label/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"find-radio-checked\"]/div[1]/form/input[5]")).click();
        Thread.sleep(2000);
        //WebElement cart = driver.findElement(By.xpath("//*[@id='add-to-bag-main']/div[1]"));
    }

    @Test
    public void testing3() throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.barnesandnoble.com/");
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("window.scrollBy(0,2000)");
        // Thread.sleep(2000);
        driver.navigate().to("https://www.barnesandnoble.com/membership/");
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/section/div[1]/div[2]/div/div/div[2]/div/div[73]/div/div[1]/a")).click();
        Thread.sleep(2000);
       // WebElement check2=driver.findElement(By.xpath("//*[@id=\"dialog-title\"]"));
        //Assert.assertTrue(check2.getText().contains("Sign in or Create an Account"), "Sign in first!!");
    }
    @AfterMethod
    public void myaftrmthd() throws Exception{
        log.info("Tests Executed!!!");
        driver.quit();
    }
}