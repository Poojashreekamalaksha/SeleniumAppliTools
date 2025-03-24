package com.applitools.pages.pageObjectModel.applitools;

import com.applitools.base.CommonToAllPage;
import com.applitools.driver.DriverManager;
import com.applitools.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DashBoardPage extends CommonToAllPage {
    By table = By.xpath("//table[@class='table table-padded']/tbody");

    public float validateTotalSum() {

        custom_waits();
        WebElement table1 = getElement(table);
        float totalSum = addElement(table1);
        return totalSum;
    }
}