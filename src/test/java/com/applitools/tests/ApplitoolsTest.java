package com.applitools.tests;

import com.applitools.base.CommonToAllTest;
import com.applitools.pages.pageObjectModel.applitools.DashBoardPage;
import com.applitools.pages.pageObjectModel.applitools.LoginPage;
import com.applitools.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class ApplitoolsTest extends CommonToAllTest {
    private static final Logger logger = LogManager.getLogger(ApplitoolsTest.class);
    @Test(priority =1)
    public void testLoginApplitools()
    {
        logger.info("Initialized driver , launched URL and tested valid login");
        new LoginPage().openURL(PropertyReader.readKey("Url")).validLoginAppliTools();
    }
    @Test(priority =2)
    public void testSumAmounttable()
    {
        logger.info("Validate sum amount in dashboard page");
        new LoginPage().openURL(PropertyReader.readKey("Url")).validLoginAppliTools();
        float totalSum = new DashBoardPage().validateTotalSum();
        Assert.assertEquals(totalSum,1996.22f,"total sum is not correct!");
    }
}
