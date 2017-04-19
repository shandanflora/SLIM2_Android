package com.ecovacs.test.activity;

import com.ecovacs.test.common.TranslateErrorReport;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

/**
 * Created by ecosqa on 17/2/18.
 *
 */
public class RepetitionActivity {
    private static RepetitionActivity repetitionActivity = null;

    @FindBy(id = "com.ecovacs.ecosphere.intl:id/titleContent")
    private AndroidElement title = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/title_back")
    private AndroidElement back = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")
    private AndroidElement sunday = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView[1]")
    private AndroidElement monday = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.TextView[1]")
    private AndroidElement tuesday = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[5]/android.widget.TextView[1]")
    private AndroidElement wednesday = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[6]/android.widget.TextView[1]")
    private AndroidElement thursday = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[7]/android.widget.TextView[1]")
    private AndroidElement friday = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[8]/android.widget.TextView[1]")
    private AndroidElement saturday = null;

    private RepetitionActivity(){

    }

    public static RepetitionActivity getInstance(){
        if (repetitionActivity == null){
            repetitionActivity = new RepetitionActivity();
        }
        return repetitionActivity;
    }

    public void init(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickWeekOfDate(int iIndex){
        switch (iIndex){
            case 0:
                sunday.click();
                break;
            case 1:
                monday.click();
                break;
            case 2:
                tuesday.click();
                break;
            case 3:
                wednesday.click();
                break;
            case 4:
                thursday.click();
                break;
            case 5:
                friday.click();
                break;
            case 6:
                saturday.click();
                break;
            default:
                break;
        }
    }

    public void clickBack(){
        back.click();
    }

    public boolean staticUITranslation(Map<String, String> tranMap){
        String strLanguage = tranMap.get("language");
        boolean bTitle = title.getText().equalsIgnoreCase(tranMap.get("random_deebot_frequency"));
        if (!bTitle){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Repetition", title.getText(),
                    tranMap.get("random_deebot_frequency"), "fail");
        }
        boolean bsunday = sunday.getText().equalsIgnoreCase(tranMap.get("random_deebot_every_sunday"));
        if (!bsunday){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Repetition", sunday.getText(),
                    tranMap.get("random_deebot_every_sunday"), "fail");
        }
        boolean bmonday = monday.getText().equalsIgnoreCase(tranMap.get("random_deebot_every_monday"));
        if (!bmonday){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Repetition", monday.getText(),
                    tranMap.get("random_deebot_every_monday"), "fail");
        }
        boolean btuesday = tuesday.getText().equalsIgnoreCase(tranMap.get("random_deebot_every_tuesday"));
        if (!btuesday){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Repetition", tuesday.getText(),
                    tranMap.get("random_deebot_every_tuesday"), "fail");
        }
        boolean bwednesday = wednesday.getText().equalsIgnoreCase(tranMap.get("random_deebot_every_Wednesday"));
        if (!bwednesday){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Repetition", wednesday.getText(),
                    tranMap.get("random_deebot_every_Wednesday"), "fail");
        }
        boolean bthursday = thursday.getText().equalsIgnoreCase(tranMap.get("random_deebot_every_Thursday"));
        if (!bthursday){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Repetition", thursday.getText(),
                    tranMap.get("random_deebot_every_Thursday"), "fail");
        }
        boolean bfriday = friday.getText().equalsIgnoreCase(tranMap.get("random_deebot_every_Friday"));
        if (!bfriday){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Repetition", friday.getText(),
                    tranMap.get("random_deebot_every_Friday"), "fail");
        }
        boolean bsaturday = saturday.getText().equalsIgnoreCase(tranMap.get("random_deebot_every_Saturday"));
        if (!bsaturday){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Repetition", saturday.getText(),
                    tranMap.get("random_deebot_every_Saturday"), "fail");
        }
        return bTitle && bsunday && bmonday && btuesday &&
                bwednesday && bthursday && bfriday && bsaturday;
    }


}
