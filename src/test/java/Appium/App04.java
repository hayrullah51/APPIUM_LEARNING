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
public class App04 {
    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"0772625218103071");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"/Users/PC/IdeaProjects/MobileTest/src/Apps/apiDemos.apk");
        //Bu cap. app'in izinler atlayarak ana sayfada acilmasini saglar!!!
        capabilities.setCapability("noReset",true);
        capabilities.setCapability("appPackage","com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity","com.davemac327.gesture.tool.GestureBuilderActivity");



        AndroidDriver<MobileElement> driver =new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        System.out.println("App yuklendi");
        // MobileElement izingecOK = driver.findElementById("android:id/button1").click();

        System.out.println("izin verildi");

        System.out.println("Ana sayfaya geldi");
        MobileElement homeScreenTitle = driver.findElementById("android:id/title");
        Assert.assertTrue(homeScreenTitle.isDisplayed());

        MobileElement addGestureButton = driver.findElementById("com.davemac327.gesture.tool:id/addButton");
        addGestureButton.click();
        System.out.println("add gesture button tiklandi...");

        MobileElement nameTextBox = driver.findElementByClassName("android.widget.EditText");
        nameTextBox.sendKeys("Test");
        System.out.println("Test sendkeys edildi...");

        driver.hideKeyboard();
        System.out.println("klavye gizlendi...");

        MobileElement bosluk = driver.findElementById("com.davemac327.gesture.tool:id/gestures_overlay");
        bosluk.click();
        System.out.println("Bosluga tiklandi...");

        MobileElement doneButton = driver.findElementById("com.davemac327.gesture.tool:id/done");
        doneButton.click();
        System.out.println("Done button'a tiklandi...");

        Assert.assertTrue(homeScreenTitle.isDisplayed());
        System.out.println("Ana sayfaya geldigi dogrulandi...");

        MobileElement testYazisi = driver.findElementById("android:id/text1");
        Assert.assertEquals(testYazisi.getText(),"Test");
        System.out.println("Test'in eklendigi dogrulandi...");

        //sistemi kapat driver.closeApp(); da kullanilabilir
        driver.quit();


    }

}
