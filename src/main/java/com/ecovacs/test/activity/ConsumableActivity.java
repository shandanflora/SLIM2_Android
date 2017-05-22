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
 * Created by ecosqa on 17/3/7.
 *
 */
public class ConsumableActivity {
    private static ConsumableActivity consumableActivity = null;

    @FindBy(id = "com.ecovacs.ecosphere.intl:id/titleContent")
    private MobileElement title = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/title_back")
    private MobileElement back = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/btn_bianShua")
    private MobileElement btnSide = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/btn_HEPA")
    private MobileElement btnHEPA = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/tv_lala")
    private MobileElement textRemain = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
    private MobileElement textViewNote = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/btn_reset")
    private MobileElement btnReset = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/content")
    private MobileElement promptContent = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/cancel")
    private MobileElement promptCancel = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/sure")
    private MobileElement promptSure = null;

    private ConsumableActivity(){

    }

    public static ConsumableActivity getInstance(){
        if (consumableActivity == null){
            consumableActivity = new ConsumableActivity();
        }
        return consumableActivity;
    }

    public void init(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickBack(){
        back.click();
    }

    private boolean staticUI(Map<String, String> tranMap){
        String strLanguage = tranMap.get("language");
        boolean btitle = title.getText().equalsIgnoreCase(tranMap.get("random_deebot_consumable"));
        if (!btitle){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Consumable", title.getText(),
                    tranMap.get("random_deebot_consumable"), "fail");
        }
        boolean bbtnSide = btnSide.getText().equalsIgnoreCase(tranMap.get("random_deebot_Side_brush_consumables"));
        if (!bbtnSide){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Consumable", btnSide.getText(),
                    tranMap.get("random_deebot_Side_brush_consumables"), "fail");
        }
        boolean bbtnHEPA = btnHEPA.getText().equalsIgnoreCase(tranMap.get("random_deebot_filter"));
        if (!bbtnHEPA){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Consumable", btnHEPA.getText(),
                    tranMap.get("random_deebot_filter"), "fail");
        }
        boolean btextRemain = textRemain.getText().equalsIgnoreCase(tranMap.get("random_deebot_consumable_remain"));
        if (!btextRemain){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Consumable", textRemain.getText(),
                    tranMap.get("random_deebot_consumable_remain"), "fail");
        }
        boolean btextViewNote = textViewNote.getText().equalsIgnoreCase(tranMap.get("random_deebot_consumable_remain_hint"));
        if (!btextViewNote){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Consumable", textViewNote.getText(),
                    tranMap.get("random_deebot_consumable_remain_hint"), "fail");
        }
        boolean bbtnReset = btnReset.getText().equalsIgnoreCase(tranMap.get("random_deebot_consumable_reset"));
        if (!bbtnReset){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Consumable", btnReset.getText(),
                    tranMap.get("random_deebot_consumable_reset"), "fail");
        }
        return btitle && bbtnSide && bbtnHEPA && btextRemain
                && btextViewNote && bbtnReset;
    }

    private boolean translateReset(Map<String, String> tranMap, MobileElement element, String strContent){
        String strLanguage = tranMap.get("language");
        element.click();
        btnReset.click();
        boolean bpromptContent = promptContent.getText().equalsIgnoreCase(strContent);
        if (!bpromptContent){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Consumable", promptContent.getText(),
                    strContent, "fail");
        }
        boolean bpromptCancel = promptCancel.getText().equalsIgnoreCase(tranMap.get("random_deebot_cancel"));
        if (!bpromptCancel){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Consumable", promptCancel.getText(),
                    tranMap.get("random_deebot_cancel"), "fail");
        }
        boolean bpromptSure = promptSure.getText().equalsIgnoreCase(tranMap.get("random_deebot_confirm"));
        if (!bpromptSure){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Consumable", promptContent.getText(),
                    tranMap.get("random_deebot_confirm"), "fail");
        }
        promptCancel.click();
        return bpromptContent && bpromptCancel && bpromptSure;
    }

    public boolean translate(Map<String, String> tranMap){
        boolean bStatic = staticUI(tranMap);
        boolean bResetSide = translateReset(tranMap, btnSide,
                tranMap.get("random_deebot_consumable_reset_hint_side_brush"));
        boolean bResetFilter = translateReset(tranMap, btnHEPA,
                tranMap.get("random_deebot_consumable_reset_hint_filter"));
        return bStatic && bResetSide && bResetFilter;
    }

    public void resetSidebrush(){
        btnSide.click();
        btnReset.click();
        promptSure.click();
    }

    public void resetFilter(){
        btnHEPA.click();
        btnReset.click();
        promptSure.click();
    }
}
