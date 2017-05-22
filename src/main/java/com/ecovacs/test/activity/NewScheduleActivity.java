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

//import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * Created by ecosqa on 17/2/18.
 * new schedule activity
 */
public class NewScheduleActivity {
    private static NewScheduleActivity newScheduleActivity = null;
    private AndroidDriver driver = null;
    //private static Logger logger = LoggerFactory.getLogger(NewScheduleActivity.class);

    @FindBy(id = "com.ecovacs.ecosphere.intl:id/titleContent")
    private AndroidElement title = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/right")
    private AndroidElement confirmAdd = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/title_back")
    private AndroidElement cancel = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/repeathint")
    private AndroidElement repeat = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/repeatText")
    private AndroidElement repeatValue = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/btn_delete")
    private MobileElement btnDelSchedule = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.TimePicker[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.NumberPicker[1]")
    private MobileElement pickerH = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TimePicker[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.NumberPicker[1]")
    private MobileElement pickerH_M88 = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.TimePicker[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.NumberPicker[2]")
    private MobileElement pickerM = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/content")
    private MobileElement overPromptContent = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/sure")
    private MobileElement overPromptSure = null;

    private NewScheduleActivity(){

    }

    public static NewScheduleActivity getInstance(){
        if (newScheduleActivity == null){
            newScheduleActivity = new NewScheduleActivity();
        }
        return newScheduleActivity;
    }

    public void init(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    private boolean staticUITranslation(Map<String, String> tranMap){
        String strLanguage = tranMap.get("language");
        boolean bTitle = title.getText().equalsIgnoreCase(tranMap.get("random_deebot_appointment_add"));
        if (!bTitle){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "NewSchedule", title.getText(),
                    tranMap.get("random_deebot_appointment_add"), "fail");
        }
        boolean brepeat = repeat.getText().equalsIgnoreCase(tranMap.get("random_deebot_frequency"));
        if (!brepeat){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "NewSchedule", repeat.getText(),
                    tranMap.get("random_deebot_frequency"), "fail");
        }
        String[] weekDays = {"random_deebot_sunday", "random_deebot_monday",
                "random_deebot_Tuesday", "random_deebot_Wednesday",
                "random_deebot_Thursday", "random_deebot_Friday",
                "random_deebot_Saturday"};
        int iIndex = Common.getInstance().getWeekIndex();
        boolean brepeatValue = repeatValue.getText().trim().equalsIgnoreCase(tranMap.get(weekDays[iIndex]).trim());
        if (!brepeatValue){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "NewSchedule", repeatValue.getText().trim(),
                    tranMap.get(weekDays[iIndex]).trim(), "fail");
        }
        return bTitle && brepeat && brepeatValue;
    }

    public void clickRepeat(){
        repeat.click();
    }

    public void clickCancel(){
        cancel.click();
    }

    public void clickDelete(){
        btnDelSchedule.click();
    }

    public boolean translateWeekend(Map<String, String> tranMap){
        RepetitionActivity.getInstance().clickWeekOfDate(0);
        RepetitionActivity.getInstance().clickWeekOfDate(Common.getInstance().getWeekIndex());
        RepetitionActivity.getInstance().clickWeekOfDate(6);
        RepetitionActivity.getInstance().clickBack();
        boolean brepeatValue= repeatValue.getText().equalsIgnoreCase(tranMap.get("random_deebot_weekends"));
        if (!brepeatValue){
            TranslateErrorReport.getInstance().insetNewLine(
                    tranMap.get("language"), "NewSchedule", repeatValue.getText(),
                    tranMap.get("random_deebot_weekends"), "fail");
        }
        return brepeatValue;
    }

    public boolean translateWorkday(Map<String, String> tranMap){
        for(int i = 1; i < 6; i++){
            RepetitionActivity.getInstance().clickWeekOfDate(i);
        }
        int iIndex = Common.getInstance().getWeekIndex();
        if (iIndex != 1){
            RepetitionActivity.getInstance().clickWeekOfDate(iIndex);
        }
        RepetitionActivity.getInstance().clickBack();
        boolean brepeatValue = repeatValue.getText().equalsIgnoreCase(tranMap.get("random_deebot_workdays"));
        if (!brepeatValue){
            TranslateErrorReport.getInstance().insetNewLine(
                    tranMap.get("language"), "NewSchedule", repeatValue.getText(),
                    tranMap.get("random_deebot_workdays"), "fail");
        }
        return brepeatValue;
    }

    public boolean translateEveryday(Map<String, String> tranMap){
        for(int i = 0; i < 7; i++){
            RepetitionActivity.getInstance().clickWeekOfDate(i);
        }
        RepetitionActivity.getInstance().clickWeekOfDate(Common.getInstance().getWeekIndex());
        RepetitionActivity.getInstance().clickBack();
        boolean brepeatValue= repeatValue.getText().equalsIgnoreCase(tranMap.get("random_deebot_everyday"));
        if (!brepeatValue){
            TranslateErrorReport.getInstance().insetNewLine(
                    tranMap.get("language"), "NewSchedule", repeatValue.getText(),
                    tranMap.get("random_deebot_everyday"), "fail");
        }
        return brepeatValue;
    }

    public boolean translateSelectWeekOfDate(Map<String, String> tranMap){
        String[] weekDays = {"random_deebot_sunday", "random_deebot_monday",
                "random_deebot_Tuesday", "random_deebot_Wednesday",
                "random_deebot_Thursday", "random_deebot_Friday",
                "random_deebot_Saturday"};
        boolean brepeatValue[] = new boolean[7];
        //click week of date
        int iOldIndex = Common.getInstance().getWeekIndex();
        for(int i = 0; i < 7; i++){
            //click repeat
            repeat.click();
            //click new
            RepetitionActivity.getInstance().clickWeekOfDate(i);
            //click pre date
            RepetitionActivity.getInstance().clickWeekOfDate(iOldIndex);
            RepetitionActivity.getInstance().clickBack();
            brepeatValue[i]= repeatValue.getText().trim().equalsIgnoreCase(tranMap.get(weekDays[i]));
            if (!brepeatValue[i]){
                TranslateErrorReport.getInstance().insetNewLine(
                        tranMap.get("language"), "NewSchedule", repeatValue.getText().trim(),
                        tranMap.get(weekDays[i]), "fail");
            }
            //recovery
            iOldIndex = i;
        }

        return brepeatValue[0] && brepeatValue[1] && brepeatValue[2] && brepeatValue[3] &&
                brepeatValue[4] && brepeatValue[5] && brepeatValue[6];
    }

    public void addTime_M88(){
        Common.getInstance().setStartTime(driver, pickerH_M88);
        repeatValue.click();
    }

    public void addTime(){
        Common.getInstance().setStartTime(driver, pickerH);
        repeat.click();
    }

    public void setStartTime(){
        Common.getInstance().setStartTime(driver, pickerH);
    }

    public void setStartTimeNight(){
        Common.getInstance().setStartTimeNight(driver, pickerH, pickerM);
    }

    public boolean repeatTimeSchedule(Map<String, String> tranMap){
        String strLanguage = tranMap.get("language");
        boolean bpromptContent = overPromptContent.getText().trim().equalsIgnoreCase(tranMap.get("random_deebot_appointment_limit_time"));
        if(!bpromptContent){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "TimeSchedule", overPromptContent.getText(),
                    tranMap.get("random_deebot_appointment_limit_time"), "fail");
        }
        boolean bpromptSure = overPromptSure.getText().trim().equalsIgnoreCase(tranMap.get("random_deebot_btn_known"));
        if(!bpromptSure){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "TimeSchedule", overPromptSure.getText(),
                    tranMap.get("random_deebot_btn_known"), "fail");
        }
        overPromptSure.click();
        return bpromptContent && bpromptSure;
    }

    public void confirmAdd(){
        confirmAdd.click();
    }

    public boolean delSchedule(Map<String, String> tranMap){
        String strLanguage = tranMap.get("language");
        boolean btitle = title.getText().equalsIgnoreCase(tranMap.get("random_deebot_appointment_edit"));
        if (!btitle){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "NewSchedule", title.getText(),
                    tranMap.get("random_deebot_appointment_edit"), "fail");
        }
        boolean bdelSchedule = btnDelSchedule.getText().equalsIgnoreCase(tranMap.get("random_deebot_appointment_delete"));
        if (!bdelSchedule){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "NewSchedule", btnDelSchedule.getText(),
                    tranMap.get("random_deebot_appointment_delete"), "fail");
        }
        return bdelSchedule && btitle;
    }

    public boolean translateOverTen(Map<String, String> tranMap){
        String strLanguage = tranMap.get("language");
        boolean boverPromptContent = overPromptContent.getText().trim().equalsIgnoreCase(tranMap.get("random_deebot_over_max").trim());
        if (!boverPromptContent){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "NewSchedule", overPromptContent.getText().trim(),
                    tranMap.get("random_deebot_over_max").trim(), "fail");
        }
        boolean boverPromptSure = overPromptSure.getText().equalsIgnoreCase(tranMap.get("random_deebot_btn_known").trim());
        if (!boverPromptSure){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "NewSchedule", overPromptSure.getText(),
                    tranMap.get("random_deebot_btn_known").trim(), "fail");
        }
        overPromptSure.click();
        return boverPromptContent && boverPromptSure;
    }

    public boolean translate(Map<String, String> tranMap){
        return staticUITranslation(tranMap);
    }



}
