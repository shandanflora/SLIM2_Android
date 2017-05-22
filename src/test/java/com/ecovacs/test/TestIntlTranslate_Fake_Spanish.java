package com.ecovacs.test;

import com.ecovacs.test.common.Common;
import com.ecovacs.test.common.PropertyData;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by ecosqa on 17/4/28.
 *
 */
public class TestIntlTranslate_Fake_Spanish {
    private AndroidDriver driver = null;

    @BeforeClass
    public void setUp(){
        driver = Common.getInstance().getDriver();
        if(driver == null){
            return;
        }
        HandleFake.getInstance().init(driver);
        HandleFake.getInstance().translate_init("Spanish");
        //only for debug
        //HandleFake.getInstance().translateErrorReport_init();
    }

    @AfterClass
    public void tearDown(){
        HandleFake.getInstance().changeLanguage(PropertyData.getProperty("French"));
        driver.quit();
    }

    @Test
    public void translateAlertBump(){
        Assert.assertTrue(HandleFake.getInstance().translateAlertBump());
    }

    @Test
    public void translateAlertDrop(){
        Assert.assertTrue(HandleFake.getInstance().translateAlertDrop());
    }

    @Test
    public void translateAlertWheel(){
        Assert.assertTrue(HandleFake.getInstance().translateAlertWheel());
    }

    @Test
    public void translateAlertMainBrush(){
        Assert.assertTrue(HandleFake.getInstance().translateMainBrush());
    }

    @Test
    public void translateAlertSideBrush(){
        Assert.assertTrue(HandleFake.getInstance().translateSideBrush());
    }

    @Test
    public void translateDustBin(){
        Assert.assertTrue(HandleFake.getInstance().translateDustBin());
    }

    @Test
    public void translateSuspendDeebot(){
        Assert.assertTrue(HandleFake.getInstance().translateSuspendDeebot());
    }

    @Test
    public void translateSideBrushWillExpire(){
        Assert.assertTrue(HandleFake.getInstance().translateSideBrushWillExpire());
    }

    @Test
    public void translateFilterWillExpire(){
        Assert.assertTrue(HandleFake.getInstance().translateFilterWillExpire());
    }

    @Test
    public void translateFilterExpired(){
        Assert.assertTrue(HandleFake.getInstance().translateFilterExpired());
    }

    @Test
    public void translateSideBrushExpired(){
        Assert.assertTrue(HandleFake.getInstance().translateSideBrushExpired());
    }

    @Test
    public void translateLowBatteryStopCharger(){
        Assert.assertTrue(HandleFake.getInstance().translateLowBatteryStopCharger());
    }
}

