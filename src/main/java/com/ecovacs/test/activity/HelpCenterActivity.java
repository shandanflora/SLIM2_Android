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
 * Created by ecosqa on 17/3/6.
 *
 */
public class HelpCenterActivity {
    private static HelpCenterActivity helpCenterActivity = null;

    @FindBy(id = "com.ecovacs.ecosphere.intl:id/titleContent")
    private MobileElement title = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/title_back")
    private MobileElement back = null;

    private HelpCenterActivity(){

    }

    public static HelpCenterActivity getInstance(){
        if(helpCenterActivity == null){
            helpCenterActivity = new HelpCenterActivity();
        }
        return helpCenterActivity;
    }

    public void init(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickBack(){
        back.click();
    }

    public void showActivity(){
        Common.getInstance().showActivity(title);
    }

    private boolean staticUI(Map<String, String> tranMap){
        String strLanguage = tranMap.get("language");
        boolean bTtitle = title.getText().equalsIgnoreCase(tranMap.get("setting_help_center"));
        if(!bTtitle){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "setting_help_center", title.getText(),
                    tranMap.get("language"), "fail");
        }
        return bTtitle;
    }

    public boolean translate(Map<String, String> tranMap){
        return staticUI(tranMap);
    }


}
