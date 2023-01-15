package Library;

import Utils.AppUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;

public class ProfileEdit extends AppUtils
{
    String text;
    public boolean Editprofile(String fname,String lname, String pno)
    {
        driver.findElement(By.linkText("Profile")).click();
        driver.findElement(By.linkText("Edit Profile")).click();
        driver.findElement(By.id("fname")).sendKeys(fname);
        driver.findElement(By.id("lname")).sendKeys(lname);
        driver.findElement(By.id("phone")).sendKeys(pno);
        text = driver.findElement(By.className("text-gray pl-10")).getText();
        if(text.contains(fname))
        {
            return true;
        }else
        {
            return false;
        }
    }


}
