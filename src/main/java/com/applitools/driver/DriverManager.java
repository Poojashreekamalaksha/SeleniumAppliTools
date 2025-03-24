package com.applitools.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    public static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static void setDriver(WebDriver driverRef) {

        dr.set(driverRef);
    }

    public static WebDriver getDriver() {
        return dr.get();


    }

    public static void unLoad() {

        dr.remove();
    }



    public static void init(String browser) {
        if (Objects.isNull(getDriver())) {
         //   String browser = System.getProperty("browser", "chrome"); // Default browser is Chrome

            WebDriver driver;
            switch (browser.toLowerCase()) {
              /*  case "firefox":
                    FirefoxOptions options1 = new FirefoxOptions();
                    options1.addArguments("--remote-allow-origins=*");
                    driver = new FirefoxDriver(options1);
                    break;*/

                case "edge":
                    EdgeOptions options2 = new EdgeOptions();
                    options2.addArguments("--remote-allow-origins=*");
                    driver = new EdgeDriver(options2);
                    break;
                case "chrome":
                default:
                    ChromeOptions options3 = new ChromeOptions();
                    options3.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options3);
                    break;
            }

            driver.manage().window().maximize();
            setDriver(driver);
        }
    }


    public static void tearDown() {
        if (Objects.nonNull(DriverManager.getDriver())) {

            getDriver().quit();
            unLoad();
        }
    }
}


