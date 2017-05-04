package com.ecovacs.test;

import com.ecovacs.test.activity.*;
import com.ecovacs.test.common.*;
import io.appium.java_client.android.AndroidDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

//import java.io.File;

/**
 * Created by ecosqa on 16/11/30.
 * handle international app
 */
class HandleDM80i {
    private static Logger logger = LoggerFactory.getLogger(HandleDM80i.class);
    private static HandleDM80i handleDM80i = null;
    private AndroidDriver androidDriver = null;
    private Map<String, String> languageMap = null;

    private HandleDM80i(){

    }

    public static HandleDM80i getInstance(){
        if(handleDM80i == null){
            handleDM80i = new HandleDM80i();
        }
        return handleDM80i;
    }

    public void init(AndroidDriver driver){
        androidDriver = driver;
        AboutActivity.getInstance().init(androidDriver);
        ChangePassActivity.getInstance().init(androidDriver);
        ConnectGuideActivity.getInstance().init(androidDriver);
        ConsumableActivity.getInstance().init(androidDriver);
        ContinueCleanActivity.getInstance().init(androidDriver);
        CountrySelectActivity.getInstance().init(androidDriver);
        FailNetworkSettingActivity.getInstance().init(androidDriver);
        FirmVerActivity.getInstance().init(androidDriver);
        ForgetPassActivity.getInstance().init(androidDriver);
        HelpCenterActivity.getInstance().init(androidDriver);
        LanguageActivity.getInstance().init(androidDriver);
        LoginActivity.getInstance().init(androidDriver);
        MainActivity.getInstance().init(androidDriver);
        MoreActivity.getInstance().init(androidDriver);
        NetworkSettingActivity.getInstance().init(androidDriver);
        NetworkSettingActivity_ing.getInstance().init(androidDriver);
        NewScheduleActivity.getInstance().init(androidDriver);
        RegisterActivity.getInstance().init(androidDriver);
        RenameActivity.getInstance().init(androidDriver);
        RepetitionActivity.getInstance().init(androidDriver);
        RetrievePassActivity.getInstance().init(androidDriver);
        SelectDEEBOTActivity.getInstance().init(androidDriver);
        SettingActivity.getInstance().init(androidDriver);
        TimeScheduleActivity.getInstance().init(androidDriver);
        UnibotCleanActivity.getInstance().init(androidDriver);
        UserAgreeActivity.getInstance().init(androidDriver);
        WelcomeActivity.getInstance().init(androidDriver);
        WorkLogActivity.getInstance().init(androidDriver);
    }
/*
    private boolean enterRegisterActivity(){
        WelcomeActivity.getInstance().clickRegister();
        if (!RegisterActivity.getInstance().showRegisterActivity()) {
            logger.error("Can not show register activity!!!");
            return false;
        }
        logger.info("Show register activity!!!");
        return true;
    }

    /**
     * verify email
     //* @param strJar jar file
     * @param strCountry country
     //* @param strMail email
     //* @param strType handle type, ex:Register
     */
/*
    private void verifyEmail(String strJar, String strCountry, String strMail, String strType){
        String strPath = RegisterActivity.class.getResource("/").getPath();
        strPath = strPath + "../../" + strJar;
        File fileApp = new File(strPath);
        logger.info(strPath);
        Common.getInstance().executeCommand("java -jar " + fileApp.getName() + " " + strCountry + " " + strMail + " " + strType);
        logger.info("********exec command finished!!!");
    }

    boolean registerAndLogin(String strCountry, String strEmailType, String strEmail, String strPass){
        //register
        if(!enterRegisterActivity()){
            return false;
        }
        if (!RegisterActivity.getInstance().fill_Screenshot_Click(strCountry, strEmail, strPass)) {
            logger.error("Register failed!!! country--" + strCountry);
            return false;
        }
        if(!RetrievePassActivity.getInstance().ShowResisterConfirmActivity()){
            Common.getInstance().setFailType(Common.FailType.ALREADY_REGISTER);
            Common.getInstance().goBack(androidDriver, 1);
            logger.error("Not show Retrieve confirm activity!!!");
            return false;
        }
        logger.info("Show active email activity!!!");
        //verify email
        verifyEmail("VerifyEmail.one-jar.jar", strCountry, strEmailType, "Register");
        //check--login with new password
        RetrievePassActivity.getInstance().clickLogin();
        if (!loginWithoutWelcome(strCountry, strEmail, strPass)) {
            logger.info("Login failed after forget password country- " + strCountry);
            return false;
        }
        if (!logout()) {
            logger.info("Logout failed after forget password country- " + strCountry);
            Common.getInstance().goBack(androidDriver, 1);
            return false;
        }
        return true;
    }

    private boolean enterLoginAcivity(){
        WelcomeActivity.getInstance().clickLogin();
        if (!LoginActivity.getInstance().showLoginActivity()) {
            logger.info("Not show login activity!!!");
            return false;
        }
        logger.info("Show login activity!!!");
        return true;
    }

    boolean forgetPassword(String strCountry, String strEmailType, String strEmail, String strPass){
        if(!enterLoginAcivity()){
            return false;
        }
        LoginActivity.getInstance().clickForgetPass();
        logger.info("Click forget password!!!");
        if (!ForgetPassActivity.getInstance().showActivity()) {
            Common.getInstance().goBack(androidDriver, 1);
            logger.error("Not show forget password activity!!!");
            return false;
        }
        if (!ForgetPassActivity.getInstance().sendEmail(strCountry, strEmail)) {
            Common.getInstance().goBack(androidDriver, 2);
            Common.getInstance().setFailType(Common.FailType.NOT_REGISTER);
            logger.error("Not show retrieve password activity!!!");
            return false;
        }
        logger.info("Click send verify email!!!");
        if (!RetrievePassActivity.getInstance().showRetrieveConfirmActivity()) {
            logger.error("Not show retrieve password activity!!!");
            Common.getInstance().goBack(androidDriver, 2);
            return false;
            //invalid email
        }
        logger.info("Show retrieve password activity!!!");
        verifyEmail("VerifyEmail.one-jar.jar", strCountry, strEmailType, "DoFindPass");
        //check--login with new password
        RetrievePassActivity.getInstance().clickLogin();
        if (!loginWithoutWelcome(strCountry, strEmail, strPass)) {
            logger.info("Login failed after forget password country- " + strCountry);
            Common.getInstance().goBack(androidDriver, 1);
            return false;
        }
        if (!logout()) {
            logger.info("Logout failed after forget password country- " + strCountry);
            return false;
        }
        return true;
    }*/

    private boolean loginWithoutWelcome(String strCountry, String strEmail, String strPass){
        if(!LoginActivity.getInstance().showLoginActivity()){
            logger.error("Can not show login activity!!!");
            return false;
        }
        logger.info("Show login activity!!!");
        LoginActivity.getInstance().clickCountry();
        if(!CountrySelectActivity.getInstance().selectCountry(strCountry)){
            return false;
        }
        logger.info("Finished to select country!!!");
        LoginActivity.getInstance().fillInfoAndClick(strEmail, strPass);
        logger.info("Finished to click login!!!");
        if(!MainActivity.getInstance().showActivity()){
            logger.info("Can not show robot list activity!!!");
            return false;
        }
        logger.info("login successfully country- " + strCountry);
        return true;
    }

    private boolean login(String strCountry, String strEmail, String strPass){
        if(!WelcomeActivity.getInstance().showWelcomeActivity()){
            logger.error("Can not show welcome activity!!!");
            return false;
        }
        WelcomeActivity.getInstance().clickLogin();
        logger.info("Click login in welcome activity!!!");
        return loginWithoutWelcome(strCountry, strEmail, strPass);
    }

    private boolean logout(){
        MainActivity.getInstance().clickMore();
        if(!MoreActivity.getInstance().showMoreActivity()){
            logger.info("Can not show more activity!!!");
            return false;
        }
        MoreActivity.getInstance().clickLogout();
        MoreActivity.getInstance().clickConfirm();
        return WelcomeActivity.getInstance().showWelcomeActivity();
    }

    /*public boolean loginAndLogout(String strCountry, String strEmail, String strPass){
        if(!login(strCountry, strEmail, strPass)){
            logger.info("login failed country- " + strCountry);
            return false;
        }
        if(!logout()){
            logger.info("logout successfully country- " + strCountry);
            return false;
        }
        return true;
    }*/

    void changeLanguage(String strLanguage){
        //return deebot clean
        //Common.getInstance().goBack(androidDriver, 1);
        //return main
        //Common.getInstance().goBack(androidDriver, 1);
        /*if(!login("Japan", PropertyData.getProperty("hotmail_email"), PropertyData.getProperty("login_pass"))){
            logger.error("login failed!!!");
            return;
        }*/
        MainActivity.getInstance().showActivity();
        MainActivity.getInstance().clickMore();
        MoreActivity.getInstance().clickLanguage();
        LanguageActivity.getInstance().selectLanguage(strLanguage);
        //return main
        Common.getInstance().goBack(androidDriver, 1);
        MainActivity.getInstance().showActivity();
        if(!logout()){
            logger.info("logout failed!!!");
        }
    }

    void translateErrorReport_init(){
        List<String> list = JsonParse.getJsonParse().readDataFromJson("country.json", "sheets");
        TranslateErrorReport.getInstance().init(list);
    }

    void translate_init(String strColNameCommon, String strColName){
        Map<String, String> tranMapCommon = TranslateIntl.getInstance().readExcel("Translate.xlsx", strColNameCommon);
        if(tranMapCommon.isEmpty()){
            logger.error("The language map is empty!!!");
            return;
        }
        Map<String, String> tranMap = TranslateIntl.getInstance().readExcel("SLIM2.xlsx", strColName);
        if(tranMap.isEmpty()){
            logger.error("The language map is empty!!!");
            return;
        }
        tranMap.putAll(tranMapCommon);
        languageMap = tranMap;
    }

    boolean translateWelcome(){
        return WelcomeActivity.getInstance().translate(languageMap);
    }

    boolean translateLogin(){
        WelcomeActivity.getInstance().clickLogin();
        LoginActivity.getInstance().showLoginActivity();
        return LoginActivity.getInstance().translate(languageMap);
    }

    boolean translateCountryRegion(){
        WelcomeActivity.getInstance().clickRegister();
        RegisterActivity.getInstance().showRegisterActivity();
        RegisterActivity.getInstance().clickCountryRegion();
        boolean bRes = CountrySelectActivity.getInstance().translate(languageMap);
        Common.getInstance().goBack(androidDriver, 2);
        return bRes;
    }

    boolean translateRegister(){
        WelcomeActivity.getInstance().clickRegister();
        RegisterActivity.getInstance().showRegisterActivity();
        return RegisterActivity.getInstance().translate(languageMap);
    }

    boolean translateForget(){
        //*****del********
        //WelcomeActivity.getInstance().clickLogin();
        //LoginActivity.getInstance().showLoginActivity();
        //**************
        LoginActivity.getInstance().clickForgetPass();
        ForgetPassActivity.getInstance().showActivity();
        return ForgetPassActivity.getInstance().translate(languageMap);
    }

    boolean translateMain(){
        login("Japan", PropertyData.getProperty("hotmail_email"), PropertyData.getProperty("login_pass"));
        //
        MainActivity.getInstance().showActivity();
        //
        return MainActivity.getInstance().translate(languageMap);
    }

    boolean translateSelectDEEBOT(){
        MainActivity.getInstance().clickAdd();
        boolean bRes = SelectDEEBOTActivity.getInstance().translate(languageMap);
        SelectDEEBOTActivity.getInstance().clickBack();
        return bRes;
    }

    boolean translateNetworkSetting(){
        MainActivity.getInstance().showActivity();
        MainActivity.getInstance().clickAdd();
        SelectDEEBOTActivity.getInstance().selectDevice(PropertyData.getProperty("SLIM2"));
        NetworkSettingActivity.getInstance().showActivity();
        boolean bRes = NetworkSettingActivity.getInstance().translate(languageMap);
        NetworkSettingActivity.getInstance().clickBack();
        SelectDEEBOTActivity.getInstance().clickBack();
        return bRes;
    }

    boolean translateConnectGuide(){
        MainActivity.getInstance().showActivity();
        MainActivity.getInstance().clickAdd();
        SelectDEEBOTActivity.getInstance().selectDevice(PropertyData.getProperty("SLIM2"));
        NetworkSettingActivity.getInstance().showActivity();
        NetworkSettingActivity.getInstance().clickNext();
        boolean bRes = ConnectGuideActivity.getInstance().translate(languageMap);
        ConnectGuideActivity.getInstance().clickBack();
        NetworkSettingActivity.getInstance().clickBack();
        SelectDEEBOTActivity.getInstance().clickBack();
        return bRes;
    }

    boolean translateNetworkSettingActivity_ing(){
        MainActivity.getInstance().showActivity();
        MainActivity.getInstance().clickAdd();
        SelectDEEBOTActivity.getInstance().selectDevice(PropertyData.getProperty("SLIM2"));
        NetworkSettingActivity.getInstance().showActivity();
        NetworkSettingActivity.getInstance().clickNext();
        ConnectGuideActivity.getInstance().clickNext();
        boolean bRes = NetworkSettingActivity_ing.getInstance().translate(languageMap);
        NetworkSettingActivity.getInstance().clickBack();
        SelectDEEBOTActivity.getInstance().clickBack();
        return bRes;
    }

    boolean translateFailNetworkSetting(){
        MainActivity.getInstance().showActivity();
        MainActivity.getInstance().clickAdd();
        SelectDEEBOTActivity.getInstance().selectDevice(PropertyData.getProperty("SLIM2"));
        NetworkSettingActivity.getInstance().showActivity();
        NetworkSettingActivity.getInstance().clickNext();
        ConnectGuideActivity.getInstance().clickNext();
        Common.getInstance().waitForSecond(1000 * 60 * 2);
        FailNetworkSettingActivity.getInstance().showActivity();
        boolean bRes = FailNetworkSettingActivity.getInstance().translate(languageMap);
        FailNetworkSettingActivity.getInstance().clickBack();
        NetworkSettingActivity.getInstance().clickBack();
        SelectDEEBOTActivity.getInstance().clickBack();
        return bRes;
    }

    boolean translateMore(){
        MainActivity.getInstance().showActivity();
        MainActivity.getInstance().clickMore();
        return MoreActivity.getInstance().translate(languageMap);
    }

    boolean translateChangePass(){
        //MainActivity.getInstance().clickMore();
        MoreActivity.getInstance().clickChangePass();
        ChangePassActivity.getInstance().showActivity();
        boolean bTrans =  ChangePassActivity.getInstance().translate(languageMap);
        Common.getInstance().goBack(androidDriver, 2);
        return bTrans;
    }

    boolean translateAbout(){
        //MainActivity.getInstance().clickMore();
        MoreActivity.getInstance().clickAbout();
        boolean bTrans =  AboutActivity.getInstance().staticUITranslate(languageMap);
        Common.getInstance().goBack(androidDriver, 1);
        return bTrans;
    }

    boolean translateUserAgree(){
        //MainActivity.getInstance().clickMore();
        MoreActivity.getInstance().clickAbout();
        AboutActivity.getInstance().clickUserAgree();
        boolean bTrans =  UserAgreeActivity.getInstance().staticUITranslate(languageMap);
        //back to more
        Common.getInstance().goBack(androidDriver, 2);
        return bTrans;
    }

    boolean translateLanguage(){
        //MainActivity.getInstance().clickMore();
        MoreActivity.getInstance().clickLanguage();
        boolean bLang = LanguageActivity.getInstance().staticUITranslation(languageMap);
        LanguageActivity.getInstance().clickBack();
        return bLang;

    }

    boolean translateHelpCenter(){
        MoreActivity.getInstance().clickHelp();
        HelpCenterActivity.getInstance().showActivity();
        boolean bRes = HelpCenterActivity.getInstance().translate(languageMap);
        HelpCenterActivity.getInstance().clickBack();
        return bRes;
    }

    boolean translateUnibotClean(){
        MainActivity.getInstance().showActivity();
        MainActivity.getInstance().clickDevice("SLIM2");
        UnibotCleanActivity.getInstance().showActivity();
        UnibotCleanActivity.getInstance().showText("-");
        boolean bResult = UnibotCleanActivity.getInstance().translate(languageMap);
        //only for work log
        UnibotCleanActivity.getInstance().clickAuto7();
        return bResult;
    }

    boolean translateUnibotSetting(){
        //will delete
        //MainActivity.getInstance().clickDevice("SLIM2");
        //
        UnibotCleanActivity.getInstance().clickSetting();
        /*SettingActivity.getInstance().showActivity();
        SettingActivity.getInstance().showFirmVersion();*/
        return SettingActivity.getInstance().staticUiTranslate(languageMap);
    }

    boolean translateWorkLog(){
        //after check return to setting
        SettingActivity.getInstance().clickWorkLog();
        WorkLogActivity.getInstance().showActivity();
        boolean bResult = WorkLogActivity.getInstance().translate(languageMap);
        Common.getInstance().goBack(androidDriver, 1);
        return bResult;
    }

    boolean translateContinueClean(){
        //after check return to setting
        SettingActivity.getInstance().clickContinuedClean();
        boolean bResult = ContinueCleanActivity.getInstance().translate(languageMap);
        Common.getInstance().goBack(androidDriver, 1);
        return bResult;

    }

    boolean translateContinueClean_Status(){
        //after check return to setting
        SettingActivity.getInstance().clickContinuedClean();
        ContinueCleanActivity.getInstance().clickSwitch();
        ContinueCleanActivity.getInstance().showStartTime();
        Common.getInstance().goBack(androidDriver, 1);
        boolean bResult = SettingActivity.getInstance().checkDisturbStatus(languageMap);
        //recover
        SettingActivity.getInstance().clickContinuedClean();
        ContinueCleanActivity.getInstance().clickSwitch();
        Common.getInstance().goBack(androidDriver, 1);
        return bResult;
    }

    boolean translateSameContinueTime(){
        SettingActivity.getInstance().clickContinuedClean();
        ContinueCleanActivity.getInstance().clickSwitch();
        ContinueCleanActivity.getInstance().showStartTime();
        ContinueCleanActivity.getInstance().setTime();
        ContinueCleanActivity.getInstance().clickBack();
        boolean bResult = ContinueCleanActivity.getInstance().translateSameTime(languageMap);
        ContinueCleanActivity.getInstance().clickSwitch();
        //return to settings
        Common.getInstance().goBack(androidDriver, 1);
        return bResult;
    }

    boolean translateRename(){
        //after check return to setting
        SettingActivity.getInstance().clickRename();
        boolean bResult = RenameActivity.getInstance().translate(languageMap);
        Common.getInstance().goBack(androidDriver, 1);
        return bResult;
    }

    boolean translateFirmVer(){
        SettingActivity.getInstance().clickFirmware();
        boolean bResult = FirmVerActivity.getInstance().staticUITranslation(languageMap);
        Common.getInstance().goBack(androidDriver, 1);
        return bResult;
    }

    boolean translateConsumable(){
        SettingActivity.getInstance().clickConsumable();
        boolean bResult = ConsumableActivity.getInstance().translate(languageMap);
        ConsumableActivity.getInstance().clickBack();
        return bResult;
    }

    boolean translateNewSchedule(){
        //SettingActivity.getInstance().clickTimeSchedule();
        //TimeScheduleActivity.getInstance().showActivity();
        TimeScheduleActivity.getInstance().clickAddSchedule();
        boolean bResult = NewScheduleActivity.getInstance().translate(languageMap);
        NewScheduleActivity.getInstance().clickCancel();
        return bResult;
    }

    private boolean translateAddTimeSchedule(int iDate){
        TimeScheduleActivity.getInstance().clickAddSchedule();
        NewScheduleActivity.getInstance().addTime();
        RepetitionActivity.getInstance().clickWeekOfDate(iDate);
        RepetitionActivity.getInstance().clickWeekOfDate(Common.getInstance().getWeekIndex());
        RepetitionActivity.getInstance().clickBack();
        NewScheduleActivity.getInstance().confirmAdd();
        boolean bRes = TimeScheduleActivity.getInstance().addOneTime(languageMap, iDate);
        TimeScheduleActivity.getInstance().enterEditSchedule();
        NewScheduleActivity.getInstance().clickDelete();
        TimeScheduleActivity.getInstance().showActivity();
        return bRes;
    }

    boolean translateAddTimeSchedule_sun(){
        return translateAddTimeSchedule(0);
    }

    boolean translateAddTimeSchedule_mon(){
        return translateAddTimeSchedule(1);
    }

    boolean translateAddTimeSchedule_tues(){
        return translateAddTimeSchedule(2);
    }

    boolean translateAddTimeSchedule_wed(){
        return translateAddTimeSchedule(3);
    }

    boolean translateAddTimeSchedule_thurs(){
        return translateAddTimeSchedule(4);
    }

    boolean translateAddTimeSchedule_fri(){
        return translateAddTimeSchedule(5);
    }

    boolean translateAddTimeSchedule_sat(){
        return translateAddTimeSchedule(6);
    }

    boolean translateAddTimeSchedule_weekends(){
        TimeScheduleActivity.getInstance().clickAddSchedule();
        NewScheduleActivity.getInstance().addTime();
        RepetitionActivity.getInstance().clickWeekOfDate(0);
        RepetitionActivity.getInstance().clickWeekOfDate(6);
        RepetitionActivity.getInstance().clickWeekOfDate(Common.getInstance().getWeekIndex());
        RepetitionActivity.getInstance().clickBack();
        NewScheduleActivity.getInstance().confirmAdd();
        boolean bRes = TimeScheduleActivity.getInstance().addOneTime(languageMap, 7);
        TimeScheduleActivity.getInstance().enterEditSchedule();
        NewScheduleActivity.getInstance().clickDelete();
        TimeScheduleActivity.getInstance().showActivity();
        return bRes;
    }

    boolean translateAddTimeSchedule_workday(){
        TimeScheduleActivity.getInstance().clickAddSchedule();
        NewScheduleActivity.getInstance().addTime();
        for (int i = 1; i < 6; i++){
            RepetitionActivity.getInstance().clickWeekOfDate(i);
        }
        RepetitionActivity.getInstance().clickWeekOfDate(Common.getInstance().getWeekIndex());
        RepetitionActivity.getInstance().clickBack();
        NewScheduleActivity.getInstance().confirmAdd();
        boolean bRes = TimeScheduleActivity.getInstance().addOneTime(languageMap, 8);
        TimeScheduleActivity.getInstance().enterEditSchedule();
        NewScheduleActivity.getInstance().clickDelete();
        TimeScheduleActivity.getInstance().showActivity();
        return bRes;
    }

    boolean translateAddTimeSchedule_everyday(){
        TimeScheduleActivity.getInstance().clickAddSchedule();
        NewScheduleActivity.getInstance().addTime();
        for (int i = 0; i < 7; i++){
            RepetitionActivity.getInstance().clickWeekOfDate(i);
        }
        RepetitionActivity.getInstance().clickWeekOfDate(Common.getInstance().getWeekIndex());
        RepetitionActivity.getInstance().clickBack();
        NewScheduleActivity.getInstance().confirmAdd();
        return TimeScheduleActivity.getInstance().addOneTime(languageMap, 9);
        /*TimeScheduleActivity.getInstance().enterEditSchedule();
        NewScheduleActivity.getInstance().clickDelete();
        TimeScheduleActivity.getInstance().showActivity();
        return bRes;*/
    }

    boolean translateAddTimeSchedule_never(){
        TimeScheduleActivity.getInstance().clickAddSchedule();
        NewScheduleActivity.getInstance().setStartTime();
        NewScheduleActivity.getInstance().confirmAdd();
        return TimeScheduleActivity.getInstance().addOneTime_never(languageMap);
    }

    boolean translateAddTimeSchedule_repeat(){
        logger.info("add time schedule 1!!!");
        TimeScheduleActivity.getInstance().clickAddSchedule();
        NewScheduleActivity.getInstance().setStartTimeNight();
        NewScheduleActivity.getInstance().confirmAdd();
        TimeScheduleActivity.getInstance().showAddedTime();
        logger.info("add time schedule 2!!!");
        TimeScheduleActivity.getInstance().clickAddSchedule();
        NewScheduleActivity.getInstance().setStartTimeNight();
        NewScheduleActivity.getInstance().confirmAdd();
        boolean bRepeat = NewScheduleActivity.getInstance().repeatTimeSchedule(languageMap);
        NewScheduleActivity.getInstance().clickCancel();
        TimeScheduleActivity.getInstance().enterEditSchedule();
        NewScheduleActivity.getInstance().clickDelete();
        return bRepeat;
    }

    boolean translateDelSchedule_edit(){
        TimeScheduleActivity.getInstance().enterEditSchedule();
        boolean bRes = NewScheduleActivity.getInstance().delSchedule(languageMap);
        NewScheduleActivity.getInstance().clickCancel();
        return bRes;
    }

    boolean translateDelSchedule_swipe(){
        return TimeScheduleActivity.getInstance().translateDel_Swipe(languageMap);
    }

    boolean translateOverTimeSchedule(){
        TimeScheduleActivity.getInstance().showActivity();
        for (int i = 0; i < 7; i++){
            TimeScheduleActivity.getInstance().clickAddSchedule();
            NewScheduleActivity.getInstance().setStartTime();
            NewScheduleActivity.getInstance().clickRepeat();
            if (i >= 7){
                RepetitionActivity.getInstance().clickWeekOfDate(i - 7);
            }else {
                RepetitionActivity.getInstance().clickWeekOfDate(i);
            }
            RepetitionActivity.getInstance().clickWeekOfDate(Common.getInstance().getWeekIndex());
            RepetitionActivity.getInstance().clickBack();
            NewScheduleActivity.getInstance().confirmAdd();
            TimeScheduleActivity.getInstance().showAddedTime();
            logger.info("i = " + i);
        }
        TimeScheduleActivity.getInstance().clickAddSchedule();
        NewScheduleActivity.getInstance().confirmAdd();
        boolean bRes = NewScheduleActivity.getInstance().translateOverTen(languageMap);
        NewScheduleActivity.getInstance().clickCancel();
        TimeScheduleActivity.getInstance().delAllTasks();
        //return settings
        Common.getInstance().goBack(androidDriver, 1);
        return bRes;
    }


    boolean translateRepetition(){
        TimeScheduleActivity.getInstance().clickAddSchedule();
        NewScheduleActivity.getInstance().clickRepeat();
        boolean bRes = RepetitionActivity.getInstance().staticUITranslation(languageMap);
        RepetitionActivity.getInstance().clickBack();
        NewScheduleActivity.getInstance().clickCancel();
        return bRes;
    }

    boolean translateSelectWeekOfDate(){
        TimeScheduleActivity.getInstance().clickAddSchedule();
        boolean bResult = NewScheduleActivity.getInstance().translateSelectWeekOfDate(languageMap);
        NewScheduleActivity.getInstance().clickCancel();
        return bResult;
    }

    boolean translateSelectWeekend(){
        TimeScheduleActivity.getInstance().clickAddSchedule();
        NewScheduleActivity.getInstance().clickRepeat();
        boolean bResult = NewScheduleActivity.getInstance().translateWeekend(languageMap);
        NewScheduleActivity.getInstance().clickCancel();
        return bResult;
    }

    boolean translateSelectWorkday(){
        TimeScheduleActivity.getInstance().clickAddSchedule();
        NewScheduleActivity.getInstance().clickRepeat();
        boolean bResult = NewScheduleActivity.getInstance().translateWorkday(languageMap);
        NewScheduleActivity.getInstance().clickCancel();
        return bResult;
    }

    boolean translateSelectEveryday(){
        TimeScheduleActivity.getInstance().clickAddSchedule();
        NewScheduleActivity.getInstance().clickRepeat();
        boolean bResult = NewScheduleActivity.getInstance().translateEveryday(languageMap);
        NewScheduleActivity.getInstance().clickCancel();
        return bResult;
    }

    boolean translateNoTimeSchedule(){
        SettingActivity.getInstance().clickTimeSchedule();
        TimeScheduleActivity.getInstance().showActivity();
        return TimeScheduleActivity.getInstance().translate(languageMap);
    }

}
