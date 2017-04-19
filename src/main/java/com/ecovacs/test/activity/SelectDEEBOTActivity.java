package com.ecovacs.test.activity;

import com.ecovacs.test.common.TranslateErrorReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by ecosqa on 17/3/8.
 * select deebot
 */
public class SelectDEEBOTActivity {
    private static SelectDEEBOTActivity selectDEEBOTActivity = null;
    private AndroidDriver driver = null;
    private static Logger logger = LoggerFactory.getLogger(SelectDEEBOTActivity.class);

    @FindBy(id = "com.ecovacs.ecosphere.intl:id/titleContent")
    private MobileElement title = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
    private MobileElement textViewSelectDeebot = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/listView_conn_device")
    private MobileElement listView = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/title_back")
    private MobileElement back = null;

    private SelectDEEBOTActivity(){

    }

    public static SelectDEEBOTActivity getInstance(){
        if (selectDEEBOTActivity == null){
            selectDEEBOTActivity = new SelectDEEBOTActivity();
        }
        return selectDEEBOTActivity;
    }

    public void init(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    public void clickBack(){
        back.click();
    }

    private boolean staticUI(Map<String, String> tranMap){
        String strLanguage = tranMap.get("language");
        boolean bTitle = title.getText().equalsIgnoreCase(tranMap.get("random_deebot_select_deebot"));
        if(!bTitle){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "SelectDEEBOTActivity", title.getText(),
                    tranMap.get("random_deebot_select_deebot"), "fail");
        }
        boolean btextViewSelectDeebot = textViewSelectDeebot.getText().equalsIgnoreCase(tranMap.get("random_deebot_select_device"));
        if(!btextViewSelectDeebot){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "SelectDEEBOTActivity", textViewSelectDeebot.getText(),
                    tranMap.get("random_deebot_select_device"), "fail");
        }
        return bTitle && btextViewSelectDeebot;
    }

    public boolean translate(Map<String, String> tranMap){
        return staticUI(tranMap);
    }

    public boolean selectDM80i(String strDeebot){

        String str = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(";
        str = str + "\"" + strDeebot + "\"" + ").instance(0))";
        MobileElement textViewCountry;
        try {
            textViewCountry = (MobileElement) driver
                    .findElementByAndroidUIAutomator(str);
        }catch (NoSuchElementException e){
            return false;
        }
        textViewCountry.click();
        logger.info("Selected DEEBOT - " + strDeebot);
        return true;
    }


}
