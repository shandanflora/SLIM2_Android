package com.ecovacs.test.activity;

import com.ecovacs.test.common.TranslateErrorReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

/**
 * Created by ecosqa on 17/3/8.
 * connect guide
 */
public class ConnectGuideActivity {
    private static ConnectGuideActivity connectGuideActivity = null;

    @FindBy(id = "com.ecovacs.ecosphere.intl:id/titleContent")
    private MobileElement title = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/title_back")
    private MobileElement back = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/text_tips")
    private MobileElement textTips = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/distribution_network_nextstep1")
    private MobileElement btnNext = null;


    private ConnectGuideActivity(){

    }

    public static ConnectGuideActivity getInstance(){
        if (connectGuideActivity == null){
            connectGuideActivity = new ConnectGuideActivity();
        }
        return connectGuideActivity;
    }

    public void init(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickNext(){
        btnNext.click();
    }

    public void clickBack(){
        back.click();
    }

    private boolean staticUI(Map<String, String> tranMap, String strTipKey){
        String strLanguage = tranMap.get("language");
        boolean bTitle = title.getText().equalsIgnoreCase(tranMap.get("random_deebot_select_guide"));
        if(!bTitle){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "ConnectGuide", title.getText(),
                    tranMap.get("random_deebot_select_guide"), "fail");
        }
        String strTips = tranMap.get(strTipKey);
        boolean btextTips = textTips.getText().trim().equalsIgnoreCase(strTips.trim());
        if(!btextTips){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "ConnectGuide", textTips.getText().trim(),
                    strTips.trim(), "fail");
        }
        boolean bbtnNext = btnNext.getText().equalsIgnoreCase(tranMap.get("random_deebot_select_next"));
        if(!bbtnNext){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "ConnectGuide", btnNext.getText(),
                    tranMap.get("random_deebot_select_next"), "fail");
        }
        return bTitle && btextTips && bbtnNext;
    }

    public boolean translate(Map<String, String> tranMap, String strTipKey){
        return staticUI(tranMap, strTipKey);
    }


}
