package Library;

import Utils.AppUtils;
import org.openqa.selenium.By;

public class ChangePassword extends AppUtils
{
    public void ChangePassword(String Oldpwd,String newpwd)
    {
        driver.findElement(By.linkText("Profile")).click();
        driver.findElement(By.linkText("Change Password")).click();
        driver.findElement(By.id("old_password")).sendKeys(Oldpwd);
        driver.findElement(By.id("password")).sendKeys(newpwd);
        driver.findElement(By.id("password-confirm")).sendKeys(newpwd);
        driver.findElement(By.id("submitbtn")).click();
    }

}
