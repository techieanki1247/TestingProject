package Library;

import Utils.AppUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Curriculum extends AppUtils
{
    public boolean addCurriculum(String name, String Descript, String videolink)
    {
        driver.findElement(By.linkText("Curriculum")).click();
        driver.findElement(By.linkText("Add New Curriculum")).click();
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.name("description")).sendKeys(Descript);
        driver.findElement(By.name("video_link")).sendKeys(videolink);
        driver.findElement(By.className("btn btn-info pull-right")).click();


        WebElement curriculum = driver.findElement(By.linkText("Curriculum"));

        List<WebElement> rows,cols;
        rows = curriculum.findElements(By.tagName("tr"));

        boolean isuserpresent = false;
        for(int i=1;i<rows.size();i++)
        {
            cols = rows.get(i).findElements(By.tagName("td"));
            if(cols.get(2).getText().contains(Descript))
            {
                isuserpresent = true;
                break;
            }
        }
        return isuserpresent;


    }




}
