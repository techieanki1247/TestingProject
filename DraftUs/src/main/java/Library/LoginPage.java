package Library;

import Utils.AppUtils;
import org.openqa.selenium.By;

public class LoginPage extends AppUtils
{

    public void login(String email,String pwd)
    {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(pwd);
        driver.findElement(By.className("btn btn-primary")).click();
    }

    public boolean isAdminmoduleDisplayed()
    {
        try
        {
            driver.findElement(By.linkText("admin")).isDisplayed();
            return true;
        }catch(Exception e)
        {
            return false;
        }
    }

    public boolean logout()
    {
        driver.findElement(By.className("dropdown-toggle")).click();
        driver.findElement(By.className("adminNav2")).click();
        if (driver.findElement(By.className("btn btn-primary")).isDisplayed())
        {
            return true;
        }else
        {
            return false;
        }
    }
    public boolean isErrmsgDisplayed()
    {
            String errmsg = driver.findElement(By.linkText("These credentials do not match our records.")).getText().toLowerCase();
            if (errmsg.contains("do not match"))
            {
                return true;
            }else
            {
                return false;
            }
    }

}
