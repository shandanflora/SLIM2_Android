package com.ecovacs.test.activity;

import com.ecovacs.test.common.Common;
import com.ecovacs.test.common.TranslateErrorReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

/**
 * Created by ecosqa on 17/2/16.
 *
 */
public class SettingActivity {
    private static SettingActivity settingActivity = null;
    private AndroidDriver driver = null;

    @FindBy(id = "com.ecovacs.ecosphere.intl:id/titleContent")
    private MobileElement title = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/title_back")
    private MobileElement back = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/work_log")
    private MobileElement textViewWorkLog = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")
    private MobileElement textViewContinuedClean = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/tv_block_status")
    private MobileElement textDisturbStatus = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/appointment_time")
    private MobileElement textViewTimeSchedule = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/consumable_timing")
    private MobileElement textViewConsumable = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/rename")
    private MobileElement textViewRename = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/firmware_version")
    private MobileElement textViewFirmware = null;

    private SettingActivity(){

    }

    public static SettingActivity getInstance(){
        if (settingActivity == null){
            settingActivity = new SettingActivity();
        }
        return settingActivity;
    }

    public void init(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    public void clickBack(){
        back.click();
    }

    public void clickWorkLog(){
        textViewWorkLog.click();
    }

    public void clickContinuedClean(){
        textViewContinuedClean.click();
    }

    public void clickTimeSchedule(){
        textViewTimeSchedule.click();
    }

    public void clickConsumable(){
        textViewConsumable.click();
    }

    public void clickRename(){
        textViewRename.click();
    }

    public void clickFirmware(){
        textViewFirmware.click();
    }

    public void showFirmVersion(){
        for(int i = 0; i < 5; i++){
            driver.tap(1, title, 0);
        }
        Common.getInstance().waitForSecond(1000);
    }

    public boolean showActivity(){
        return Common.getInstance().showActivity(textDisturbStatus);
    }

    public boolean checkDisturbStatus(Map<String, String> tranMap){
        boolean btextDisturbStatus = textDisturbStatus.getText().equalsIgnoreCase(tranMap.get("random_deebot_open"));
        if (!btextDisturbStatus) {
            TranslateErrorReport.getInstance().insetNewLine(
                    tranMap.get("language"), "Settting", textDisturbStatus.getText(),
                    tranMap.get("random_deebot_open"), "fail");
        }
        return btextDisturbStatus;
    }

    public boolean staticUiTranslate(Map<String, String> tranMap){
        String strLanguage = tranMap.get("language");
        boolean bTitle = title.getText().equalsIgnoreCase(tranMap.get("random_deebot_settings"));
        if (!bTitle) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Settting", title.getText(),
                    tranMap.get("random_deebot_settings"), "fail");
        }
        boolean btextViewTimeSchedule = textViewTimeSchedule.getText().equalsIgnoreCase(tranMap.get("random_deebot_appointment"));
        if (!btextViewTimeSchedule) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Settting", textViewTimeSchedule.getText(),
                    tranMap.get("random_deebot_appointment"), "fail");
        }
        boolean btextViewWorkLog = textViewWorkLog.getText().equalsIgnoreCase(tranMap.get("random_deebot_work_log"));
        if (!btextViewWorkLog) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Settting", textViewWorkLog.getText(),
                    tranMap.get("random_deebot_work_log"), "fail");
        }
        boolean btextViewContinuedClean = textViewContinuedClean.getText().equalsIgnoreCase(tranMap.get("random_deebot_no_disturb"));
        if (!btextViewContinuedClean) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Settting", textViewContinuedClean.getText(),
                    tranMap.get("random_deebot_no_disturb"), "fail");
        }
        boolean btextDisturbStatus = textDisturbStatus.getText().equalsIgnoreCase(tranMap.get("random_deebot_close"));
        if (!btextDisturbStatus) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Settting", textDisturbStatus.getText(),
                    tranMap.get("random_deebot_close"), "fail");
        }
        boolean btextViewConsumable = textViewConsumable.getText().equalsIgnoreCase(tranMap.get("random_deebot_consumable"));
        if (!btextViewConsumable) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Settting", textViewConsumable.getText(),
                    tranMap.get("random_deebot_consumable"), "fail");
        }
        boolean btextViewRename = textViewRename.getText().equalsIgnoreCase(tranMap.get("random_deebot_rename"));
        if (!btextViewRename) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Settting", textViewRename.getText(),
                    tranMap.get("random_deebot_rename"), "fail");
        }
        /*boolean btextViewFirmware = textViewFirmware.getText().equalsIgnoreCase(tranMap.get("The_host_Settings"));
        if (!btextViewFirmware) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Settting", textViewFirmware.getText(),
                    tranMap.get("The_host_Settings"), "fail");
        }*/
        return bTitle && btextViewWorkLog && btextViewContinuedClean &&
                btextViewTimeSchedule && btextDisturbStatus && btextViewConsumable &&
                btextViewRename /*&& btextViewFirmware*/;
    }


}
