package Library;

import Utils.AppUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactUS extends AppUtils
{

    public boolean addCustumerSupport(String name,String company,String phno,String email,String mssg)
    {
        driver.findElement(By.linkText("ContactUs Request")).click();
        driver.findElement(By.className("btn btn-info createButton")).click();
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.linkText("Company Name ")).sendKeys(company);
        driver.findElement(By.linkText("Phone ")).sendKeys(phno);
        driver.findElement(By.linkText("Email ")).sendKeys(email);
        driver.findElement(By.linkText("Message ")).sendKeys(mssg);



        WebElement contact =  driver.findElement(By.linkText("Contact Us"));

        List<WebElement> rows,cols;
        rows = contact.findElements(By.tagName("tr"));

        boolean isuserpresent = false;
        for(int i=1;i<rows.size();i++)
        {
            cols = rows.get(i).findElements(By.tagName("td"));
            if(cols.get(1).getText().contains(name))
            {
                isuserpresent = true;
                break;
            }
        }
        return isuserpresent;

    }
}
