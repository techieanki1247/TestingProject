package Library;

import Utils.AppUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Subscriber extends AppUtils
{

    public boolean addSubscriber(String email)
    {
        driver.findElement(By.linkText("Subscribers")).click();
        driver.findElement(By.className("btn btn-info createButton")).click();
        driver.findElement(By.name("email")).sendKeys(email);




        WebElement subs = driver.findElement(By.linkText("Subscriber"));
        List<WebElement> rows,cols;
        rows = subs.findElements(By.tagName("tr"));

        boolean isuserpresent = false;
        for(int i=1;i<rows.size();i++)
        {
            cols = rows.get(i).findElements(By.tagName("td"));
            if(cols.get(1).getText().contains(email))
            {
                isuserpresent = true;
                break;
            }
        }
        return isuserpresent;

    }



}
