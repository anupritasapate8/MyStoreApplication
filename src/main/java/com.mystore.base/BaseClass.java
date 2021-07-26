package com.mystore.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static Properties prop;
    public static WebDriver driver;
    //Declare Thread local Driver
    //public static ThreadLocal<RemoteWebDriver>driver=new ThreadLocal<>();
    @BeforeSuite
    public void loadConfig() throws IOException {
        prop=new Properties();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
        prop.load(fis);
        System.out.println("diver"+driver);

    }

    /*public static WebDriver getDriver()
    {
        //get Driver from localThreadMap
        return driver.get();
    }*/
    public static void launchApp( )
    {
        String browserName= prop.getProperty("browser");
        if(browserName.equalsIgnoreCase("Chrome"))
        {
            WebDriverManager.chromedriver().setup();
            //set ChromeDriver to localThreadMap
          //  driver.set(new ChromeDriver());
            driver=new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("Firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
           // driver.set(new FirefoxDriver());
            driver=new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("IE"))
        {
            WebDriverManager.iedriver().setup();
           // driver.set(new InternetExplorerDriver());
            driver=new InternetExplorerDriver();
        }
        //Maximize the screen
        //getDriver().manage().window().fullscreen();
        driver.manage().window().fullscreen();
        //delete all cookies
        //getDriver().manage().deleteAllCookies();
        driver.manage().deleteAllCookies();
        // launching the url
        //getDriver().get(prop.getProperty("url"));
        driver.get(prop.getProperty("url"));
    }
    @AfterSuite
    public void cleanup()
    {
        //getDriver().quit();
        driver.quit();
    }
}
