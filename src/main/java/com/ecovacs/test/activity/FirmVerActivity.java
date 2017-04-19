package com.ecovacs.test.activity;

import com.ecovacs.test.common.Common;
import com.ecovacs.test.common.TranslateErrorReport;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

/**
 * Created by ecosqa on 17/2/17.
 * firmware version activity
 */
public class FirmVerActivity {
    private static FirmVerActivity firmVerActivity = null;

    @FindBy(id = "com.ecovacs.ecosphere.intl:id/titleContent")
    private AndroidElement title = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/tv_SN")
    private AndroidElement textViewSN = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/tv_version")
    private AndroidElement currentFirmVer = null;

    private FirmVerActivity(){

    }

    public static FirmVerActivity getInstance(){
        if (firmVerActivity == null){
            firmVerActivity = new FirmVerActivity();
        }
        return firmVerActivity;
    }

    public void init(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean staticUITranslation(Map<String, String> tranMap){
        String strLanguage = tranMap.get("language");
        boolean bTitle = title.getText().equalsIgnoreCase(tranMap.get("The_host_Settings"));
        if(!bTitle){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "FirmwareVer", title.getText(),
                    tranMap.get("The_host_Settings"), "fail");
        }
        Common.getInstance().showActivity(currentFirmVer);
        boolean bcurrentFirmVer = currentFirmVer.getText().equalsIgnoreCase(tranMap.get("fir_version_old_text"));
        if(!bcurrentFirmVer){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "FirmwareVer", currentFirmVer.getText(),
                    tranMap.get("fir_version_old_text"), "fail");
        }
        boolean btextViewSN = textViewSN.getText().equalsIgnoreCase(tranMap.get("fir_version_get_text"));
        if(!btextViewSN){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "FirmwareVer", textViewSN.getText(),
                    tranMap.get("fir_version_get_text"), "fail");
        }
        return bTitle && btextViewSN && bcurrentFirmVer;
    }
}
