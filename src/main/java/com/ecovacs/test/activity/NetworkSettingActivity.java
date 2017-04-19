package com.ecovacs.test.activity;

import com.ecovacs.test.common.Common;
import com.ecovacs.test.common.TranslateErrorReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

//import com.ecovacs.test.com.ecovacs.test.common.PropertyData;

/**
 * Created by ecosqa on 17/3/8.
 * network setting activity
 */
public class NetworkSettingActivity {
    private static NetworkSettingActivity networkSettingActivity = null;
    //private AndroidDriver driver = null;

    @FindBy(id = "com.ecovacs.ecosphere.intl:id/titleContent")
    private MobileElement title = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/title_back")
    private MobileElement back = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/conn_tip_tv")
    private MobileElement textConnectWlan = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[2]")
    private MobileElement textNot5G = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/tv_wlan_tips")
    private MobileElement textChangeWlan = null;
    /*@FindBy(id = "com.ecovacs.ecosphere.intl:id/edt_wifiname")
    private MobileElement editWifiName = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/wrongTipsTV")
    private MobileElement textWrongTips = null;*/
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/edt_password")
    private MobileElement editPassword = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/passwordvisible")
    private MobileElement checkboxVisible = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")
    private MobileElement textRemeber = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/distribution_network_nextstep1")
    private MobileElement btnNextStep = null;

    private NetworkSettingActivity(){

    }

    public static NetworkSettingActivity getInstance(){
        if (networkSettingActivity == null){
            networkSettingActivity = new NetworkSettingActivity();
        }
        return networkSettingActivity;
    }

    public void init(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        //this.driver = driver;
    }

    public boolean showActivity(){
        return Common.getInstance().showActivity(btnNextStep);
    }
/*
    private boolean translateWifi(Map<String, String> tranMap){
        editPassword.clear();
        Common.getInstance().goBack(driver, 1);
        boolean beditPassword = editPassword.getText().equalsIgnoreCase(tranMap.get("password"));
        if(!beditPassword){
            TranslateErrorReport.getInstance().insetNewLine(
                    tranMap.get("language"), "NetworkSettingActivity", editPassword.getText(),
                    tranMap.get("password"), "fail");
        }
        btnNextStep.click();
        boolean btextWrongTips = textWrongTips.getText().equalsIgnoreCase(tranMap.get("random_deebot_select_empty_password"));
        if(!btextWrongTips){
            TranslateErrorReport.getInstance().insetNewLine(
                    tranMap.get("language"), "NetworkSettingActivity", textWrongTips.getText(),
                    tranMap.get("random_deebot_select_empty_password"), "fail");
        }
        return btextWrongTips && beditPassword;
    }

    public void enterWifiPass(){
        editPassword.clear();
        editPassword.sendKeys(PropertyData.getProperty("wifiPass"));
        Common.getInstance().goBack(driver, 1);
    }*/

    private boolean staticUI(Map<String, String> tranMap){
        String strLanguage = tranMap.get("language");
        boolean bTitle = title.getText().equalsIgnoreCase(tranMap.get("random_deebot_select_network_set"));
        if(!bTitle){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "NetworkSetting", title.getText(),
                    tranMap.get("random_deebot_select_network_set"), "fail");
        }
        boolean btextConnectWlan = textConnectWlan.getText().equalsIgnoreCase(tranMap.get("random_deebot_select_connect_wlan"));
        if(!btextConnectWlan){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "NetworkSetting", textConnectWlan.getText(),
                    tranMap.get("random_deebot_select_connect_wlan"), "fail");
        }
        boolean btextNot5G = textNot5G.getText().equalsIgnoreCase(tranMap.get("config_net_hint").trim());
        if(!btextNot5G){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "NetworkSetting", textNot5G.getText(),
                    tranMap.get("config_net_hint").trim(), "fail");
        }
        boolean btextChangeWlan = textChangeWlan.getText().equalsIgnoreCase(tranMap.get("random_deebot_select_change_wlan"));
        if(!btextChangeWlan){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "NetworkSetting", textChangeWlan.getText(),
                    tranMap.get("random_deebot_select_change_wlan"), "fail");
        }
        checkboxVisible.click();
        boolean beditPassword = editPassword.getText().equalsIgnoreCase(tranMap.get("random_deebot_password"));
        if(!beditPassword){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "NetworkSetting", editPassword.getText(),
                    tranMap.get("random_deebot_password"), "fail");
        }
        boolean btextRemeber = textRemeber.getText().equalsIgnoreCase(tranMap.get("random_deebot_select_remeber"));
        if(!btextRemeber){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "NetworkSetting", textRemeber.getText(),
                    tranMap.get("random_deebot_select_remeber"), "fail");
        }
        boolean bbtnNextStep = btnNextStep.getText().equalsIgnoreCase(tranMap.get("random_deebot_select_start_set"));
        if(!bbtnNextStep){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "NetworkSetting", btnNextStep.getText(),
                    tranMap.get("random_deebot_select_start_set"), "fail");
        }
        return bTitle && btextConnectWlan && btextNot5G && beditPassword &&
                btextChangeWlan && btextRemeber && bbtnNextStep;
    }

    public boolean translate(Map<String, String> tranMap){
        return staticUI(tranMap);
    }

    public void clickNext(){
        btnNextStep.click();
    }

    public void clickBack(){
        back.click();
    }


}
