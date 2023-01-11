package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class App10 {

    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "0772625218103071");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/PC/IdeaProjects/MobileTest/src/Apps/apiDemos.apk");
        //Bu cap. app'in izinler atlayarak ana sayfada acilmasini saglar!!!
        capabilities.setCapability("noReset", true);
        //capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        //capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");


        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        System.out.println("App installed ");

        //API Demos buttonuna tiklayalim
        driver.findElementByXPath("android.widget.TextView").click();

        //Preference'ye tiklanir
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();




    }

}
