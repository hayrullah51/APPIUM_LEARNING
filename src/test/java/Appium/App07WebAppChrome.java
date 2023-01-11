package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class App07WebAppChrome {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"12.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"2VN5T18607005191");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"60000");
       capabilities.setCapability("chromedriverExecutable","/Users/PC/IdeaProjects/MobileTest/src/driver/chromedriver.exe");

        AndroidDriver<MobileElement> driver =new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        System.out.println(driver.getContext());//-->App acildiginda hangi turde oldugunu gosterir

        //burda aplikasyonun hangi turleri oldugunu gormek icin getContextHandles() kullaniyoruz.
        Set<String> butunturler = driver.getContextHandles();
        for (String tur: butunturler) {
            System.out.println(tur);
            if (tur.contains("WEBVIEW_chrome")) {
                driver.context(tur);
            }
        }
        System.out.println(driver.getContext()+" Son hali");


        driver.get("https://www.amazon.com");
        Thread.sleep(7000);


        MobileElement homeScreenLogo = driver.findElementByXPath("//a[@id='nav-logo-sprites']");
        assertTrue(homeScreenLogo.isDisplayed());
        System.out.println("Amazon ana sayfada oldugumuz dogrulandi...");
        Thread.sleep(7000);

        MobileElement singInButton = driver.findElementByXPath("//a[@id='nav-logobar-greeting']");
        singInButton.click();

        Thread.sleep(7000);
        MobileElement welcomeText = driver.findElementByXPath("//div//h2[contains(text(),'Welcome')]");
        assertEquals("Welcome",welcomeText.getText());
        System.out.println("Sign in menusune girildi...");

        System.out.println("************ Finnish ************");
        System.out.println();




    }

}
