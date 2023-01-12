package Library;

import Utils.AppUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Skill extends AppUtils
{

    public boolean addSkill(String skill)
    {

        driver.findElement(By.linkText("Skills")).click();
        driver.findElement(By.linkText("Add New Skill")).click();
        driver.findElement(By.name("name")).sendKeys(skill);


        WebElement sk = driver.findElement(By.linkText("Skills"));
        List<WebElement> rows,cols;
        rows = sk.findElements(By.tagName("tr"));

        boolean isskillpresent = false;
        for(int i=1;i<rows.size();i++)
        {
            cols = rows.get(i).findElements(By.tagName("td"));
            if(cols.get(1).getText().contains(skill))
            {
                isskillpresent= true;
                break;
            }
        }
        return isskillpresent;



    }

}
