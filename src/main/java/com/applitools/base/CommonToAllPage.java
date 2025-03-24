package com.applitools.base;

import com.applitools.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class CommonToAllPage {
    public CommonToAllPage() {
    }

    //waits
    public void implicitWait() {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void clickElement(By by) {
        DriverManager.getDriver().findElement(by).click();
    }

    public void enterInput(By by,String key) {
        DriverManager.getDriver().findElement(by).sendKeys(key);
    }


    public WebElement getElement(By key) {
        return DriverManager.getDriver().findElement(key);
    }

   public float addElement(WebElement key)
   {
     float sum=0;
       List<WebElement> rows = key.findElements(By.tagName("tr"));
       for (WebElement row:rows)
       {
           List<WebElement> cols = row.findElements(By.tagName("td"));

           String amountText = cols.get(4).getText().trim();
           boolean negativeValue = amountText.contains("-");
           String  cleanedAmount=amountText.replaceAll("[^0-9\\.]", "");
           float value;
           if(!cleanedAmount.isEmpty())
           {
              value= Float.parseFloat(cleanedAmount);
               sum += negativeValue?-value:value;
           }

       }
       System.out.println(sum);
       return sum;
   }


    public void custom_waits()
    {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public WebElement visibilityOfElementLocated(By key) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(key)); // Pass key directly
    }




}


