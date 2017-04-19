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
 * Created by ecosqa on 17/3/8.
 * is network setting
 */
public class NetworkSettingActivity_ing {
    private static NetworkSettingActivity_ing networkSettingActivity_ing = null;

    @FindBy(id = "com.ecovacs.ecosphere.intl:id/titleContent")
    private MobileElement title = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/title_back")
    private MobileElement back = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/text_tips")
    private MobileElement textSetting = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]")
    private MobileElement textDoNotChange = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/content")
    private MobileElement promptContent = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/cancel")
    private MobileElement promptCancel = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/sure")
    private MobileElement promptSure = null;

    private NetworkSettingActivity_ing(){

    }

    public static NetworkSettingActivity_ing getInstance(){
        if (networkSettingActivity_ing == null){
            networkSettingActivity_ing = new NetworkSettingActivity_ing();
        }
        return networkSettingActivity_ing;
    }

    public void init(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean showActivity(){
        return Common.getInstance().showActivity(textSetting);
    }

    private boolean staticUI(Map<String, String> tranMap){
        String strLanguage = tranMap.get("language");
        boolean bTitle = title.getText().equalsIgnoreCase(tranMap.get("random_deebot_select_network_set"));
        if(!bTitle){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "NetworkSetting_ing", title.getText(),
                    tranMap.get("random_deebot_select_network_set"), "fail");
        }
        /*boolean bback = back.getText().equalsIgnoreCase(tranMap.get("random_deebot_cancel"));
        if(!bback){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "NetworkSetting_ing", back.getText(),
                    tranMap.get("random_deebot_cancel"), "fail");
        }*/
        boolean btextSetting = textSetting.getText().equalsIgnoreCase(tranMap.get("random_deebot_network_setting"));
        if(!btextSetting){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "NetworkSetting_ing", textSetting.getText(),
                    tranMap.get("random_deebot_network_setting"), "fail");
        }
        boolean btextDoNotChange = textDoNotChange.getText().equalsIgnoreCase(tranMap.get("random_deebot_not_switch"));
        if(!btextDoNotChange){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "NetworkSetting_ing", textDoNotChange.getText(),
                    tranMap.get("random_deebot_not_switch"), "fail");
        }
        return bTitle /*&& bback*/ && btextSetting && btextDoNotChange;
    }

    private boolean promptTranslate(Map<String, String> tranMap){
        clickCancel();
        String strLanguage = tranMap.get("language");
        boolean bpromptContent = promptContent.getText().trim().equalsIgnoreCase(tranMap.get("random_deebot_end_network").trim());
        if(!bpromptContent){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "NetworkSettingActivity_ing", promptContent.getText(),
                    tranMap.get("random_deebot_end_network").trim(), "fail");
        }
        boolean bpromptCancel = promptCancel.getText().equalsIgnoreCase(tranMap.get("random_deebot_cancel"));
        if(!bpromptCancel){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "NetworkSetting_ing", promptCancel.getText(),
                    tranMap.get("random_deebot_cancel"), "fail");
        }
        boolean bpromptSure = promptSure.getText().equalsIgnoreCase(tranMap.get("random_deebot_confirm"));
        if(!bpromptSure){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "NetworkSetting_ing", promptSure.getText(),
                    tranMap.get("random_deebot_confirm"), "fail");
        }
        //return network setting
        promptSure.click();
        return bpromptContent && bpromptCancel && bpromptSure;
    }

    public boolean translate(Map<String, String> tranMap){
        boolean bStatic = staticUI(tranMap);
        boolean bPrompt = promptTranslate(tranMap);
        return bStatic && bPrompt;
    }

    private void clickCancel(){
        back.click();
    }


}
