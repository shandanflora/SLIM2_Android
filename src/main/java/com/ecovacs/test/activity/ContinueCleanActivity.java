package com.ecovacs.test.activity;

import com.ecovacs.test.common.Common;
import com.ecovacs.test.common.TranslateErrorReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

/**
 * Created by ecosqa on 17/2/17.
 * Continue clean activity
 */
public class ContinueCleanActivity {
    private static ContinueCleanActivity continueCleanActivity = null;
    private AndroidDriver driver = null;

    @FindBy(id = "com.ecovacs.ecosphere.intl:id/titleContent")
    private AndroidElement title = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/title_back")
    private AndroidElement back = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
    private AndroidElement textViewline1 = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[2]")
    private AndroidElement textViewMessage = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/img_kaiGuan")
    private AndroidElement imageViewSwitch = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
    private AndroidElement textViewStart = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TimePicker[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.NumberPicker[1]")
    private AndroidElement pickerH = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TimePicker[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.NumberPicker[2]")
    private AndroidElement pickerM = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.RelativeLayout[2]/android.widget.TextView[1]")
    private AndroidElement textViewEnd = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/content")
    private AndroidElement promptContent = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/sure")
    private AndroidElement promptSure = null;

    private ContinueCleanActivity(){

    }

    public static ContinueCleanActivity getInstance(){
        if (continueCleanActivity == null){
            continueCleanActivity = new ContinueCleanActivity();
        }
        return continueCleanActivity;
    }

    public void init(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    public void clickSwitch(){
        imageViewSwitch.click();
    }

    public void clickBack(){
        back.click();
    }

    private boolean staticUITranslation(Map<String, String> tranMap){
        String strLanguage = tranMap.get("language");
        boolean btitle = title.getText().equalsIgnoreCase(tranMap.get("random_deebot_no_disturb"));
        if (!btitle) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "ContinueClean", title.getText(),
                    tranMap.get("random_deebot_no_disturb"), "fail");
        }
        boolean btextViewline1 = textViewline1.getText().equalsIgnoreCase(tranMap.get("random_deebot_no_disturb"));
        if (!btextViewline1) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "ContinueClean", textViewline1.getText(),
                    tranMap.get("random_deebot_no_disturb"), "fail");
        }
        boolean btextViewMessage = textViewMessage.getText().equalsIgnoreCase(tranMap.get("random_deebot_no_disturb_onoff_hint"));
        if (!btextViewMessage) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "ContinueClean", textViewMessage.getText(),
                    tranMap.get("random_deebot_no_disturb_onoff_hint"), "fail");
        }
        return btitle && btextViewline1 && btextViewMessage;
    }

    public void showStartTime(){
        Common.getInstance().showActivity(textViewStart);
    }

    private boolean forbidTimeConfig(Map<String, String> tranMap){
        String strLanguage = tranMap.get("language");
        clickSwitch();
        showStartTime();
        boolean btextViewStart = textViewStart.getText().equalsIgnoreCase(tranMap.get("random_deebot_no_disturb_start"));
        if (!btextViewStart) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "ContinueClean", textViewStart.getText(),
                    tranMap.get("random_deebot_no_disturb_start"), "fail");
        }
        boolean btextViewEnd = textViewEnd.getText().equalsIgnoreCase(tranMap.get("random_deebot_no_disturb_end"));
        if (!btextViewEnd) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "ContinueClean", textViewEnd.getText(),
                    tranMap.get("random_deebot_no_disturb_end"), "fail");
        }
        clickSwitch();
        return btextViewStart && btextViewEnd;
    }

    private void setTimeNight(MobileElement textView){
        textView.click();
        Common.getInstance().setStartTimeNight(driver, pickerH, pickerM);
        textView.click();
        Common.getInstance().waitForSecond(1000);
    }

    public void setTime(){
        setTimeNight(textViewStart);
        setTimeNight(textViewEnd);
    }

    public boolean translateSameTime(Map<String, String> tranMap){
        String strLanguage = tranMap.get("language");
        boolean bContent = promptContent.getText().trim().equalsIgnoreCase(tranMap.get("random_deebot_no_disturb_error"));
        if(!bContent) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "ContinueClean", promptContent.getText(),
                    tranMap.get("random_deebot_no_disturb_error"), "fail");
        }
        boolean bSure = promptSure.getText().trim().equalsIgnoreCase(tranMap.get("random_deebot_btn_known"));
        if(!bSure){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "ContinueClean", promptSure.getText(),
                    tranMap.get("random_deebot_btn_known"), "fail");
        }
        promptSure.click();
        return bContent && bSure;
    }

    public boolean translate(Map<String, String> tranMap){
        boolean bStatic = staticUITranslation(tranMap);
        boolean bForbid = forbidTimeConfig(tranMap);
        return bStatic && bForbid;
    }

}
