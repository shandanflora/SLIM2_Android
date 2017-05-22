package com.ecovacs.test.activity;

import com.ecovacs.test.common.Common;
import com.ecovacs.test.common.TranslateErrorReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by ecosqa on 17/2/15.
 * unibot cleaning
 */
public class UnibotCleanActivity {
    private static UnibotCleanActivity unibotCleanActivity = null;
    private static Logger logger = LoggerFactory.getLogger(UnibotCleanActivity.class);

    @FindBy(id = "com.ecovacs.ecosphere.intl:id/right")
    private MobileElement textViewRight = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/title_back")
    private MobileElement textViewBack = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/current_statue")
    private MobileElement textViewStatusValue = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[2]")
    private MobileElement textViewStatus = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/stand_electricity")
    private MobileElement textViewDeBattery = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/auto")
    private MobileElement textViewDeAuto = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/charge")
    private MobileElement textViewDeCharge = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/border")
    private MobileElement textViewEdge = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/fixed")
    private MobileElement textViewSpot = null;
    //malfunction
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/title")
    private MobileElement titlePrompt = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/content")
    private MobileElement contentPrompt = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/sure")
    private MobileElement surePrompt = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/cancel")
    private MobileElement cancelPrompt = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/warn_tip")
    private MobileElement textViewWarnTip = null;


    private UnibotCleanActivity() {

    }

    public static UnibotCleanActivity getInstance() {
        if (unibotCleanActivity == null) {
            unibotCleanActivity = new UnibotCleanActivity();
        }
        return unibotCleanActivity;
    }

    public void init(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickCharge(){
        textViewDeCharge.click();
    }

    public void clickBack(){
        textViewBack.click();
    }

    public boolean showActivity(){
        return Common.getInstance().showActivity(textViewStatusValue);
    }

    public void showText(String strText) {
        while (true) {
            if (textViewStatusValue.getText().contains(strText)) {
                logger.info(textViewStatusValue.getText());
                Common.getInstance().waitForSecond(500);
            } else {
                logger.info(textViewStatusValue.getText());
                break;
            }
        }
    }

    public void clickSetting(){
        textViewRight.click();
    }

    private boolean staticUITranslate(Map<String, String> tranMap) {
        Common.getInstance().waitForSecond(2000);
        String strLanguage = tranMap.get("language");
        boolean btextViewStatus = textViewStatus.getText().equalsIgnoreCase(tranMap.get("random_deebot_state"));
        if (!btextViewStatus) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "UnibotClean", textViewStatus.getText(),
                    tranMap.get("random_deebot_state"), "fail");
        }
        boolean btextViewStatusValue = textViewStatusValue.getText().equalsIgnoreCase(tranMap.get("random_deebot_state_standby"));
        if (!btextViewStatusValue) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "UnibotClean", textViewStatusValue.getText(),
                    tranMap.get("random_deebot_state_standby"), "fail");
        }
        boolean btextViewDeBattery = textViewDeBattery.getText().equalsIgnoreCase(tranMap.get("random_deebot_battery"));
        if (!btextViewDeBattery) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "UnibotClean", textViewDeBattery.getText(),
                    tranMap.get("random_deebot_battery"), "fail");
        }
        if(tranMap.get("language").equals("English")) {
            boolean btextViewDeAuto = textViewDeAuto.getText().equalsIgnoreCase(tranMap.get("random_deebot_auto"));
            if (!btextViewDeAuto) {
                TranslateErrorReport.getInstance().insetNewLine(
                        strLanguage, "UnibotClean", textViewDeAuto.getText(),
                        tranMap.get("random_deebot_auto"), "fail");
            }
            boolean btextViewDeCharge = textViewDeCharge.getText().equalsIgnoreCase(tranMap.get("random_deebot_state_go_charging"));
            if (!btextViewDeCharge) {
                TranslateErrorReport.getInstance().insetNewLine(
                        strLanguage, "UnibotClean", textViewDeCharge.getText(),
                        tranMap.get("random_deebot_state_go_charging"), "fail");
            }
            boolean btextViewEdge = textViewEdge.getText().equalsIgnoreCase(tranMap.get("random_deebot_edge"));
            if (!btextViewEdge) {
                TranslateErrorReport.getInstance().insetNewLine(
                        strLanguage, "UnibotClean", textViewEdge.getText(),
                        tranMap.get("random_deebot_edge"), "fail");
            }
            boolean btextViewSpot = textViewSpot.getText().equalsIgnoreCase(tranMap.get("random_deebot_spot"));
            if (!btextViewSpot) {
                TranslateErrorReport.getInstance().insetNewLine(
                        strLanguage, "UnibotClean", textViewSpot.getText(),
                        tranMap.get("random_deebot_spot"), "fail");
            }
            return btextViewStatus && btextViewStatusValue && btextViewDeBattery &&
                    btextViewDeAuto && btextViewDeCharge && btextViewEdge && btextViewSpot;
        }else {
            return btextViewStatus && btextViewStatusValue && btextViewDeBattery;
        }

    }

    public boolean translate(Map<String, String> tranMap){
        boolean bStatic = staticUITranslate(tranMap);
        boolean bCheckStatus = checkStatus(tranMap);
        return bStatic && bCheckStatus;
    }

    private boolean checkStatus_clean_charge(Map<String, String> tranMap, MobileElement element){
        //auto to charge
        String strLanguage = tranMap.get("language");
        //check auto
        element.click();
        logger.info(textViewStatusValue.getText());
        boolean btextViewStatusValue = textViewStatusValue.getText().equalsIgnoreCase(tranMap.get("random_deebot_state_clean"));
        if (!btextViewStatusValue) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "UnibotClean", textViewStatusValue.getText(),
                    tranMap.get("random_deebot_state_clean"), "fail");
        }
        Common.getInstance().waitForSecond(1000 * 5);
        //check stand by
        element.click();
        logger.info(textViewStatusValue.getText());
        boolean btextViewStatusValue1 = textViewStatusValue.getText().equalsIgnoreCase(tranMap.get("random_deebot_state_standby"));
        if (!btextViewStatusValue1) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "UnibotClean", textViewStatusValue.getText(),
                    tranMap.get("random_deebot_state_standby"), "fail");
        }
        //check charge
        textViewDeCharge.click();
        logger.info(textViewStatusValue.getText());
        boolean btextViewStatusValue2 = textViewStatusValue.getText().equalsIgnoreCase(tranMap.get("ibt_return_charge_text"));
        if (!btextViewStatusValue2) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "UnibotClean", textViewStatusValue.getText(),
                    tranMap.get("ibt_return_charge_text"), "fail");
        }
        //check stand by
        textViewDeCharge.click();
        logger.info(textViewStatusValue.getText());
        boolean btextViewStatusValue3 = textViewStatusValue.getText().equalsIgnoreCase(tranMap.get("random_deebot_state_standby"));
        if (!btextViewStatusValue3) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "UnibotClean", textViewStatusValue.getText(),
                    tranMap.get("random_deebot_state_standby"), "fail");
        }
        textViewDeCharge.click();
        logger.info(textViewStatusValue.getText());
        showText(textViewStatusValue.getText());
        return btextViewStatusValue && btextViewStatusValue1 && btextViewStatusValue2
                && btextViewStatusValue3;
    }

    public void clickAuto7(){
        for (int i = 0; i < 7; i++){
            //auto
            textViewDeAuto.click();
            Common.getInstance().waitForSecond(2500);
            //standby
            textViewDeAuto.click();
            logger.info("i--" + i);
        }
        //charge
        textViewDeCharge.click();
        logger.info(textViewStatusValue.getText());
        showText(textViewStatusValue.getText());
    }

    private boolean checkStatus(Map<String, String> tranMap){
        //check auto to standby to charge
        boolean bAuto = checkStatus_clean_charge(tranMap, textViewDeAuto);
        //check edge to standby to charge
        boolean bEdge = checkStatus_clean_charge(tranMap, textViewEdge);
        //check spot to standby to charge
        boolean bSpot = checkStatus_clean_charge(tranMap, textViewSpot);
        return bAuto && bEdge && bSpot;
    }

//fake robot

    public void clickTip(){
        textViewWarnTip.click();
    }

    private boolean translateMalPrompt(Map<String, String> tranMap, String strKey, String strPage, boolean bSuspend){
        String strLanguage = tranMap.get("language");
        boolean bTitle = false;
        if(!bSuspend){
            //System.out.println(bSupspend);
            Common.getInstance().showActivity(titlePrompt);
            Common.getInstance().waitForSecond(1000);
            String strTitle = titlePrompt.getText().trim();
            bTitle = strTitle.equalsIgnoreCase
                    (tranMap.get("random_deebot_state_error").trim());
            if (!bTitle){
                TranslateErrorReport.getInstance().insetNewLine(
                        strLanguage, strPage, strTitle,
                        tranMap.get("random_deebot_state_error"), "fail");
            }
        }
        boolean bContent = contentPrompt.getText().trim().equalsIgnoreCase
                (tranMap.get(strKey).trim());
        if (!bContent){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, strPage, contentPrompt.getText(),
                    tranMap.get(strKey), "fail");
        }
        boolean bSure = surePrompt.getText().trim().equalsIgnoreCase
                (tranMap.get("random_deebot_confirm").trim());
        if (!bSure){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, strPage, surePrompt.getText(),
                    tranMap.get("random_deebot_confirm"), "fail");
        }
        surePrompt.click();
        if (bSuspend){
            return bContent && bSure;
        }
        return bTitle && bContent && bSure;
    }

    //check status
    private boolean translateMalState(Map<String, String> tranMap, String strKey){
        boolean bStatusValue = textViewStatusValue.getText().trim().equalsIgnoreCase
                (tranMap.get(strKey).trim());
        if (!bStatusValue){
            TranslateErrorReport.getInstance().insetNewLine(
                    tranMap.get("language"), "Malfunction", textViewStatusValue.getText(),
                    tranMap.get(strKey), "fail");
        }
        return bStatusValue;
    }

    //check warn tip
    private boolean translateWarnTip(Map<String, String> tranMap, String strKey){
        boolean bWarnTip = textViewWarnTip.getText().trim().equalsIgnoreCase
                (tranMap.get(strKey).trim());
        if (!bWarnTip){
            TranslateErrorReport.getInstance().insetNewLine(
                    tranMap.get("language"), "Malfunction", textViewWarnTip.getText(),
                    tranMap.get(strKey), "fail");
        }
        return bWarnTip;
    }

    private boolean translateSumWarnTip(Map<String, String> tranMap){
        String strInfo = textViewWarnTip.getText().trim().substring(1);
        boolean bWarnTip = strInfo.equalsIgnoreCase
                (tranMap.get("random_deebot_warn_info_sum").trim());
        if (!bWarnTip){
            TranslateErrorReport.getInstance().insetNewLine(
                    tranMap.get("language"), "Malfunction", strInfo,
                    tranMap.get("random_deebot_warn_info_sum"), "fail");
        }
        return bWarnTip;
    }

    public boolean bumpMalfunction(Map<String, String> tranMap){
        logger.info("----bumpMalfunction----");
        boolean bPrompt = translateMalPrompt(tranMap, "random_deebot_bump_malfunction",
                "bumpMalfunction", false);
        boolean bState = translateMalState(tranMap, "random_deebot_state_error");
        boolean bTip = translateWarnTip(tranMap, "random_deebot_bump_malfunction");
        return bPrompt && bState && bTip;
    }

    public boolean dropMalfunction(Map<String, String> tranMap){
        logger.info("----dropMalfunction----");
        boolean bPrompt = translateMalPrompt(tranMap, "random_deebot_drop_malfunction",
                "dropMalfunction", false);
        boolean bState = translateMalState(tranMap, "random_deebot_state_error");
        boolean bTip = translateWarnTip(tranMap, "random_deebot_drop_malfunction");
        return bPrompt && bState && bTip;
    }

    public boolean wheelMalfunction(Map<String, String> tranMap){
        logger.info("----wheelMalfunction----");
        boolean bPrompt = translateMalPrompt(tranMap, "random_deebot_wheel_malfunction",
                "wheelMalfunction", false);
        boolean bState = translateMalState(tranMap, "random_deebot_state_error");
        boolean bTip = translateWarnTip(tranMap, "random_deebot_wheel_malfunction");
        return bPrompt && bState && bTip;
    }

    public boolean mainBrushMalfunction(Map<String, String> tranMap){
        logger.info("----mainBrushMalfunction----");
        boolean bPrompt = translateMalPrompt(tranMap, "random_deebot_mainbrush_malfunction",
                "mainBrushMalfunction", false);
        boolean bState = translateMalState(tranMap, "random_deebot_state_error");
        boolean bTip = translateWarnTip(tranMap, "random_deebot_mainbrush_malfunction");
        return bPrompt && bState && bTip;
    }

    public boolean sideBrushMalfunction(Map<String, String> tranMap){
        logger.info("----sideBrushMalfunction----");
        boolean bPrompt = translateMalPrompt(tranMap, "random_deebot_sidebrush_malfunction",
                "sideBrushMalfunction", false);
        boolean bState = translateMalState(tranMap, "random_deebot_state_error");
        boolean bTip = translateWarnTip(tranMap, "random_deebot_sidebrush_malfunction");
        return bPrompt && bState && bTip;
    }

    public boolean dustMalfunction(Map<String, String> tranMap){
        logger.info("----dustMalfunction----");
        boolean bPrompt = translateMalPrompt(tranMap, "random_deebot_dust_malfunction",
                "dustMalfunction", false);
        boolean bState = translateMalState(tranMap, "random_deebot_state_error");
        boolean bTip = translateWarnTip(tranMap, "random_deebot_dust_malfunction");
        return bPrompt && bState && bTip;
    }

    public boolean deebotMalfunction(Map<String, String> tranMap){
        boolean bPrompt = translateMalPrompt(tranMap, "random_deebot_suspend_malfunction",
                "deebotMalfunction", true);
        boolean bState = translateMalState(tranMap, "random_deebot_state_standby");
        boolean bTip = translateWarnTip(tranMap, "random_deebot_suspend_malfunction");
        return bPrompt && bState && bTip;
    }

    private boolean consumablePrompt(Map<String, String> tranMap, String strKey){
        String strLanguage = tranMap.get("language");
        boolean bContent = contentPrompt.getText().trim().equalsIgnoreCase
                (tranMap.get(strKey).trim());
        if (!bContent){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Consumble", contentPrompt.getText(),
                    tranMap.get(strKey), "fail");
        }
        boolean bSure = surePrompt.getText().trim().equalsIgnoreCase
                (tranMap.get("random_deebot_btn_check").trim());
        if (!bSure){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Consumble", surePrompt.getText(),
                    tranMap.get("random_deebot_btn_check"), "fail");
        }
        boolean bCancel = cancelPrompt.getText().trim().equalsIgnoreCase
                (tranMap.get("random_deebot_btn_ignore").trim());
        if (!bCancel){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Consumble", cancelPrompt.getText(),
                    tranMap.get("random_deebot_btn_ignore"), "fail");
        }
        cancelPrompt.click();
        return bContent && bSure && bCancel;
    }

    private boolean lowBatteryPrompt(Map<String, String> tranMap, String strKey){
        String strLanguage = tranMap.get("language");
        boolean bContent = contentPrompt.getText().trim().equalsIgnoreCase
                (tranMap.get(strKey).trim());
        if (!bContent){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "lowBattery", contentPrompt.getText(),
                    tranMap.get(strKey), "fail");
        }
        boolean bSure = surePrompt.getText().trim().equalsIgnoreCase
                (tranMap.get("random_deebot_confirm").trim());
        if (!bSure){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "lowBattery", surePrompt.getText(),
                    tranMap.get("random_deebot_confirm"), "fail");
        }
        boolean bCancel = cancelPrompt.getText().trim().equalsIgnoreCase
                (tranMap.get("random_deebot_cancel").trim());
        if (!bCancel){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "lowBattery", cancelPrompt.getText(),
                    tranMap.get("random_deebot_cancel"), "fail");
        }
        cancelPrompt.click();
        return bContent && bSure && bCancel;
    }

    public boolean stopCharge(Map<String, String> tranMap){
        return lowBatteryPrompt(tranMap, "random_deebot_low_battery_stop_charge");
    }

    public boolean sideBrushWillExpire(Map<String, String> tranMap){
        boolean bPrompt = consumablePrompt(tranMap, "random_deebot_sidebrush_low_hint1");
        boolean bTip = translateWarnTip(tranMap, "random_deebot_sidebrush_low_hint1");
        return bPrompt && bTip;
    }

    public boolean filterWillExpire(Map<String, String> tranMap){
        boolean bPrompt = consumablePrompt(tranMap, "random_deebot_filter_low_hint1");
        boolean bTip = translateSumWarnTip(tranMap);
        return bPrompt && bTip;
    }

    public boolean filterExpired(Map<String, String> tranMap){
        boolean bPrompt = consumablePrompt(tranMap, "random_deebot_filter_due_hint1");
        boolean bTip = translateSumWarnTip(tranMap);
        return bPrompt && bTip;
    }

    public boolean sideBrushExpired(Map<String, String> tranMap){
        boolean bPrompt = consumablePrompt(tranMap, "random_deebot_sidebrush_due_hint1");
        boolean bTip = translateSumWarnTip(tranMap);
        return bPrompt && bTip;
    }





}
