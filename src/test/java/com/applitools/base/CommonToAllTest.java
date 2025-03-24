package com.applitools.base;

import com.applitools.driver.DriverManager;
import com.applitools.pages.pageObjectModel.applitools.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CommonToAllTest {

    @AfterMethod
    protected void tearDown() {
        DriverManager.tearDown();
    }

    @BeforeMethod
    @Parameters("browser")
    protected void setUp(String browser) {



        DriverManager.init(browser);
    }
}


