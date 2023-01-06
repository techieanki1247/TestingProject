package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class AppUtils
{

    public static WebDriver driver;
    public static String url = "https://draftusadmin.arksstech.com/login";
    @BeforeSuite
    public static void launchApp()
    {

        System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
    }

    @AfterSuite
    public static void logout()
    {
        driver.close();
    }



}
