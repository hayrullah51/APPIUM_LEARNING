package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class App05 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"0772625218103071");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"/Users/PC/IdeaProjects/MobileTest/src/Apps/Calculator.apk");
        //Bu cap. app'in izinler atlayarak ana sayfada acilmasini saglar!!!
        capabilities.setCapability("noReset",true);
        capabilities.setCapability("appPackage","com.google.android.calculator");
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");

        /*
        Name: Hesap Makinesi
Package: com.google.android.calculator
Signature: af:24:b7:f3:ef:f9:d9:7a:e6:d8:a8:46:64:e0:e9:88:88:63:61:10
Version name: 7.8 (271241277)
 Version Code: 78000303
 com.android.calculator2.Calculator - Hesap Makinesi
 com.google.android.gms.common.api.GoogleApiActivity - Hesap Makinesi
         */



        AndroidDriver<MobileElement> driver =new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        Thread.sleep(5000);

        MobileElement num1 = driver.findElementById("com.google.android.calculator:id/digit_1");
        MobileElement num2 = driver.findElementById("com.google.android.calculator:id/digit_2");
        MobileElement num3 = driver.findElementById("com.google.android.calculator:id/digit_3");
        MobileElement num4 = driver.findElementById("com.google.android.calculator:id/digit_4");
        MobileElement num5 = driver.findElementById("com.google.android.calculator:id/digit_5");
        MobileElement num6 = driver.findElementById("com.google.android.calculator:id/digit_6");
        MobileElement num7 = driver.findElementById("com.google.android.calculator:id/digit_7");
        MobileElement num8 = driver.findElementById("com.google.android.calculator:id/digit_8");
        MobileElement num9 = driver.findElementById("com.google.android.calculator:id/digit_9");
        MobileElement num0 = driver.findElementById("com.google.android.calculator:id/digit_0");
        MobileElement add = driver.findElementById("com.google.android.calculator:id/op_add");
        MobileElement sub = driver.findElementById("com.google.android.calculator:id/op_sub");
        MobileElement mull = driver.findElementById("com.google.android.calculator:id/op_mul");
        MobileElement div = driver.findElementById("com.google.android.calculator:id/op_div");
        MobileElement equals = driver.findElementById("com.google.android.calculator:id/eq");
        MobileElement result = driver.findElementById("com.google.android.calculator:id/result_preview");
       // MobileElement resultFinal = driver.findElementById("com.google.android.calculator:id/result_final");

        num6.click();
        num1.click();
        add.click();
        num7.click();
        num1.click();
        String exceptedResult = result.getText();
        equals.click();
        MobileElement resultFinal = driver.findElementById("com.google.android.calculator:id/result_final");
        Assert.assertEquals(resultFinal.getText(),exceptedResult);
        driver.quit();



    }

}
