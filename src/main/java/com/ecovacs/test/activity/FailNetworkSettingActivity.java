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
 * fail to setting network
 */
public class FailNetworkSettingActivity {
    private static FailNetworkSettingActivity failNetworkSettingActivity = null;

    @FindBy(id = "com.ecovacs.ecosphere.intl:id/titleContent")
    private MobileElement title = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/title_back")
    private MobileElement back = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/text_tips")
    private MobileElement textTipTitle = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/tv_peiWangShiBai")
    private MobileElement textTipDescription = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/distribution_network_nextstep1")
    private MobileElement btnRetry = null;

    private FailNetworkSettingActivity(){

    }

    public static FailNetworkSettingActivity getInstance(){
        if (failNetworkSettingActivity == null){
            failNetworkSettingActivity = new FailNetworkSettingActivity();
        }
        return failNetworkSettingActivity;
    }

    public void init(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean showActivity(){
        return Common.getInstance().showActivity(btnRetry);
    }

    private boolean staticUI(Map<String, String> tranMap){
        String strLanguage = tranMap.get("language");
        boolean bTitle = title.getText().equalsIgnoreCase(tranMap.get("random_deebot_select_network_set"));
        if(!bTitle){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "FailNetworkSetting", title.getText(),
                    tranMap.get("random_deebot_select_network_set"), "fail");
        }
        /*boolean bback = back.getText().equalsIgnoreCase(tranMap.get("random_deebot_cancel"));
        if(!bback){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "FailNetworkSetting", back.getText(),
                    tranMap.get("random_deebot_cancel"), "fail");
        }*/
        boolean btextTipTitle = textTipTitle.getText().equalsIgnoreCase(tranMap.get("random_deebot_network_fail"));
        if(!btextTipTitle){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "FailNetworkSetting", textTipTitle.getText(),
                    tranMap.get("random_deebot_network_fail"), "fail");
        }
        String title = tranMap.get("config_net_error_title") + ("\n");
        String strDes = tranMap.get("config_net_error0").replace("\\n", "\n") + ("\n");
        String strDes7 = ("7.") + tranMap.get("config_net_error7");
        System.out.println(strDes7);
        String strError = title + strDes + strDes7;
        System.out.println(strError);
        boolean btextTipDescription = textTipDescription.getText().equalsIgnoreCase(strError);
        if(!btextTipDescription){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "FailNetworkSetting", textTipDescription.getText(),
                    strError, "fail");
        }
        boolean bbtnRetry = btnRetry.getText().equalsIgnoreCase(tranMap.get("config_net_retry"));
        if(!bbtnRetry){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "FailNetworkSetting", btnRetry.getText(),
                    tranMap.get("config_net_retry"), "fail");
        }
        return bTitle && btextTipTitle &&
                btextTipDescription && bbtnRetry;
    }

    public boolean translate(Map<String, String> tranMap){
        return staticUI(tranMap);
    }

    public void clickBack(){
        back.click();
    }
}
