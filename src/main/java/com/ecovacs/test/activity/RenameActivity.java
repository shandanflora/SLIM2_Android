package com.ecovacs.test.activity;

import com.ecovacs.test.common.TranslateErrorReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

/**
 * Created by ecosqa on 17/3/7.
 *
 */
public class RenameActivity {
    private static RenameActivity renameActivity = null;

    @FindBy(id = "com.ecovacs.ecosphere.intl:id/titleContent")
    private MobileElement title = null;
    /*@FindBy(id = "com.ecovacs.ecosphere.intl:id/right")
    private MobileElement btnSave = null;*/
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
    private MobileElement textViewMessage = null;

    private RenameActivity(){

    }

    public static RenameActivity getInstance(){
        if (renameActivity == null){
            renameActivity = new RenameActivity();
        }
        return renameActivity;
    }

    public void init(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private boolean staticUI(Map<String, String> tranMap){
        String strLanguage = tranMap.get("language");
        boolean btitle = title.getText().equalsIgnoreCase(tranMap.get("random_deebot_rename"));
        if (!btitle){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Rename", title.getText(),
                    tranMap.get("random_deebot_rename"), "fail");
        }
        /*boolean bbtnSave = btnSave.getText().equalsIgnoreCase(tranMap.get("random_deebot_save"));
        if (!bbtnSave){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Rename", btnSave.getText(),
                    tranMap.get("random_deebot_save"), "fail");
        }*/
        boolean btextViewMessage = textViewMessage.getText().equalsIgnoreCase(tranMap.get("random_deebot_hint_modify_nickname"));
        if (!btextViewMessage){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Rename", textViewMessage.getText(),
                    tranMap.get("random_deebot_hint_modify_nickname"), "fail");
        }
        return btitle /*&& bbtnSave*/ && btextViewMessage;
    }

    public boolean translate(Map<String, String> tranMap){
        return staticUI(tranMap);
    }

}
