package com.applitools.driver;

import java.util.Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

    public static void init() {
        if (Objects.isNull(DriverManager.getDriver())) {
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--guest");
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver=new ChromeDriver(options);
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


