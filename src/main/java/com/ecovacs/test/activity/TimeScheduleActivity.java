package com.ecovacs.test.activity;

import com.ecovacs.test.common.Common;
import com.ecovacs.test.common.TranslateErrorReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by ecosqa on 17/2/18.
 * time schedule activity
 */
public class TimeScheduleActivity {
    private static TimeScheduleActivity timeScheduleActivity = null;
    private AndroidDriver driver;

    @FindBy(id = "com.ecovacs.ecosphere.intl:id/titleContent")
    private AndroidElement title = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")
    private AndroidElement emptyList = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/right")
    private AndroidElement textViewAddTime = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/listView")
    private AndroidElement listView = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/tv_week")
    private AndroidElement repeatDate = null;
    @FindBy(xpath = " //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.FrameLayout[1]")
    private AndroidElement newTimeSchedule = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
    private AndroidElement deleteTime = null;
    /*@FindBy(id = "com.ecovacs.ecosphere.intl:id/title")
    private MobileElement delPromptTitle = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/content")
    private MobileElement delPromptContent = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/cancel")
    private MobileElement delPromptCancel = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/sure")
    private MobileElement delPromptSure = null;*/

    private TimeScheduleActivity(){

    }

    public static TimeScheduleActivity getInstance(){
        if (timeScheduleActivity == null){
            timeScheduleActivity = new TimeScheduleActivity();
        }
        return timeScheduleActivity;
    }

    public void init(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    public boolean showActivity(){
        return Common.getInstance().showActivity(emptyList);
    }

    private boolean staticUITranslate(Map<String, String> tranMap){
        String strLanguage = tranMap.get("language");
        boolean bTitle = title.getText().equalsIgnoreCase(tranMap.get("random_deebot_appointment"));
        if (!bTitle){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "TimeSchedule", title.getText(),
                    tranMap.get("random_deebot_appointment"), "fail");
        }
        boolean bemptyList = emptyList.getText().equalsIgnoreCase(tranMap.get("random_deebot_appointment_empty"));
        if (!bemptyList){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "TimeSchedule", emptyList.getText(),
                    tranMap.get("random_deebot_appointment_empty"), "fail");
        }
        return bTitle && bemptyList;
    }

    public boolean translate(Map<String, String> tranMap){
        return staticUITranslate(tranMap);
    }

    public void clickAddSchedule(){
        textViewAddTime.click();
    }

    public void showAddedTime(){
        Common.getInstance().showActivity(repeatDate);
    }

    public boolean addOneTime(Map<String, String> tranMap, int iIndex){
        String[] weekDays = {"random_deebot_sunday", "random_deebot_monday",
                "random_deebot_Tuesday", "random_deebot_Wednesday",
                "random_deebot_Thursday", "random_deebot_Friday",
                "random_deebot_Saturday", "random_deebot_weekends",
                "random_deebot_workdays", "random_deebot_everyday",
                "random_deebot_never"};
        //select sunday
        String strLanguage = tranMap.get("language");
        Common.getInstance().showActivity(repeatDate);
        //int iIndex = Common.getInstance().getWeekIndex();
        boolean brepeatTime = repeatDate.getText().trim().equalsIgnoreCase(tranMap.get(weekDays[iIndex]));
        if(!brepeatTime){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "TimeSchedule", repeatDate.getText(),
                    tranMap.get(weekDays[iIndex]), "fail");
        }
        return brepeatTime;
    }

    public boolean addOneTime_never(Map<String, String> tranMap){
        String strLanguage = tranMap.get("language");
        Common.getInstance().showActivity(repeatDate);
        boolean brepeatTime = repeatDate.getText().trim().equalsIgnoreCase(tranMap.get("random_deebot_never"));
        if(!brepeatTime){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "TimeSchedule", repeatDate.getText(),
                    tranMap.get("random_deebot_never"), "fail");
        }
        return brepeatTime;
    }

    private void swipeNewTask(){
        //swipe
        Point point = newTimeSchedule.getLocation();
        Dimension dimension = newTimeSchedule.getSize();
        int iRectX = point.getX();
        int iRectY = point.getY();
        int iWidth = dimension.getWidth();
        int iHeight = dimension.getHeight();

        point.x = iRectX + iWidth/2;
        point.y = iRectY + iHeight/2;

        driver.swipe(point.x + iWidth/4, point.y ,
                point.x - iWidth/4, point.y, 200);
    }

    public boolean translateDel_Swipe(Map<String, String> tranMap){
        swipeNewTask();
        String strLanguage = tranMap.get("language");
        boolean bbtnDelete = deleteTime.getText().equalsIgnoreCase(tranMap.get("random_deebot_delete"));
        if (!bbtnDelete){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "TimeSchedule", deleteTime.getText(),
                    tranMap.get("random_deebot_delete"), "fail");
        }
        deleteTime.click();
        return bbtnDelete;
    }

    public void enterEditSchedule(){
        newTimeSchedule.click();
    }

    public void delAllTasks(){
        List<MobileElement> lists = listView.findElementsById("com.ecovacs.ecosphere.intl:id/tv_week");
        int i = lists.size();
        while (i != 0){
            swipeNewTask();
            deleteTime.click();
            Common.getInstance().showActivity(listView);
            i = listView.findElementsById("com.ecovacs.ecosphere.intl:id/tv_week").size();
            System.out.println("i =" + i);
        }

    }

}
