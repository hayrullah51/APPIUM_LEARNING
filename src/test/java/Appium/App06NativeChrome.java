package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class App06NativeChrome {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"2VN5T18607005191");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability("noReset",true);
        capabilities.setCapability("appPackage","com.android.chrome");
        capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");

        AndroidDriver<MobileElement> driver =new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        System.out.println(driver.getContext());
        /*
        //burda aplikasyonun hangi turleri oldugunu gorem icin getContextHandles() kullaniyoruz.
        Set<String> butunturler = driver.getContextHandles();
        for (String tur: butunturler) {
            System.out.println(tur);
            if (tur.contains("WEBVIEW_chrome")) {
                driver.context(tur);
            }
        }
         */

        driver.get("https://www.amazon.com");

        MobileElement homeScreenLogo = driver.findElementByAccessibilityId("Amazon");
        assertTrue(homeScreenLogo.isDisplayed());
        System.out.println("Amazon ana sayfada oldugumuz dogrulandi...");
        Thread.sleep(3000);

        MobileElement singInButton = driver.findElementByAccessibilityId("Sign in ›");
        singInButton.click();

        Thread.sleep(3000);
        MobileElement welcomeText = driver.findElementByXPath("//android.widget.TextView[@text='Welcome']");
        assertEquals("Welcome",welcomeText.getText());
        System.out.println("Sign in menusune girildi...");

        System.out.println("************ Finnish ************");









    }

}
