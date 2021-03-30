package TestPkg;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TestRunner {
    //@Test
    public void testRunnerFromMobile1() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("version", "10");
        capabilities.setCapability("deviceName", "OPPO A15");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        capabilities.setCapability("noReset", true);


        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }

    //@Test
    public void testRunnerFromMobile() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("version", "10.0");
       // capabilities.setCapability("deviceName", "YPHEIJVG4DW48HZD");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator1");
        capabilities.setCapability("appPackage", "com.coloros.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        capabilities.setCapability("orientation", "PORTRAIT");
        File file = new File("C:\\Users\\aml\\Downloads\\cal.apk");
        capabilities.setCapability("app", file.getAbsolutePath());
        capabilities.setCapability("deviceName", "OPPO A15");
        capabilities.setCapability("udid", "YPHEIJVG4DW48HZD");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("fullReset", false);

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }
    //@Test
    public void testRunner() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("version", "8.0");
        capabilities.setCapability("deviceName", "Aml");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        capabilities.setCapability("orientation", "PORTRAIT");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }
@Test
    public void RunElmotar() throws MalformedURLException, InterruptedException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("version", "8.0");
    capabilities.setCapability("deviceName", "Aml");
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("automationName", "Appium");

    capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
    capabilities.setCapability("browserName","Chrome");

    capabilities.setCapability("orientation", "PORTRAIT");
    AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    driver.get("http://automationpractice.com/index.php");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//a[@class = 'login']")).click();
    driver.findElement(By.xpath("//input[@id= 'email']")).sendKeys("ITI41@gmail.com");
    driver.findElement(By.xpath("//input[@id= 'password']")).sendKeys("ITI41");
    driver.findElement(By.xpath("//input[@id='SubmitionLogin']")).click();

}

}
