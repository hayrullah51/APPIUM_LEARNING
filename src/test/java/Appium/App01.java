package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class App01 {

    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();


        //capabilities.setCapability("platformName","Android");
        //capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android"); -> bu ucu ayni sadece importlari degisik !!!
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");

        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
        //cihazimizin android versiyonunu giriyoruz

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"0772625218103071");
        //bu adimda cihaz android isi isim cok onemli degil ama is ise terminalden abd devices yazinca cihaz isimleri geliyor!

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");

       // capabilities.setCapability(MobileCapabilityType.APP,"/Users/PC/IdeaProjects/MobileTest/src/Apps/gestureTool.apk");
        capabilities.setCapability(MobileCapabilityType.APP,"/Users/PC/IdeaProjects/MobileTest/src/Apps/apiDemos.apk");
       // C:\Users\PC\IdeaProjects\MobileTest\src\Apps\gestureTool.apk

        /*
        AndroidDriver<MobileElement>
        AndroidDriver<WebElement>
        AndroidDriver<AndroidElement>
        bu uc data turunude kabul ediyor  ama MobileElement hem android hem ios kapsar bu sebeble MobileElement kullandim!
         */

        //

       // capabilities.setCapability("appPackage","com.davemac327.gesture.tool");
       // capabilities.setCapability("appActivity","com.davemac327.gesture.tool.GestureBuilderActivity");
        capabilities.setCapability("noReset",true);
        capabilities.setCapability("appPackage","com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity","com.davemac327.gesture.tool.GestureBuilderActivity");


        //AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        AndroidDriver<MobileElement> driver =new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        // driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();


    }

}
