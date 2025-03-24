package com.applitools.pages.pageObjectModel.applitools;

import com.applitools.base.CommonToAllPage;
import com.applitools.driver.DriverManager;
import com.applitools.utils.PropertyReader;
import org.openqa.selenium.By;

public class LoginPage extends CommonToAllPage {
    public LoginPage() {
        super();
    }


    private By username = By.id("username");
    private By password = By.id("password");
    private By signIN = By.id("log-in");

    public LoginPage validLoginAppliTools() {
        custom_waits();
        enterInput(username, PropertyReader.readKey("Username"));
        enterInput(password, PropertyReader.readKey("Password"));
        clickElement(signIN);
        return this;
    }

    public LoginPage openURL(String url) {
        DriverManager.getDriver().get(url);
        return this;
    }


    public DashBoardPage afterLogin() {
        return new DashBoardPage();


    }

}



