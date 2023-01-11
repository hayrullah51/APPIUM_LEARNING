package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

//com.davemac327.gesture.tool:id/addButton
public class App08UiSelector {
    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"12");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"0772625218103071");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"/Users/PC/IdeaProjects/MobileTest/src/Apps/apiDemos.apk");
        //Bu cap. app'in izinler atlayarak ana sayfada acilmasini saglar!!!
        capabilities.setCapability("noReset",true);
        capabilities.setCapability("appPackage","com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity","com.davemac327.gesture.tool.GestureBuilderActivity");



        AndroidDriver<MobileElement> driver =new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        //resourceId ile locate alma (AndroidUIAutomator de )
        //driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\")").click();

        //indexle beraber kullanimi
        //driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").index(0)").click();

        //text beraber kullanimi
        //driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"Test\")").click();

        //driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").textStartsWith(\"Te\")").click();

        System.out.println(driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/done\").enabled(false)").getAttribute("enabled"));

        //sistemi kapat driver.closeApp(); da kullanilabilir
        driver.quit();


    }

}
