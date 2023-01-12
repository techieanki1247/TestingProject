package Library;

import Utils.AppUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class User extends AppUtils
{

    public boolean addUser(String fname,String lname,String email, String phno,String Address,String Pcode,String pword,String dob,String Role,
                           String Country,String State,String City,String Gender) throws InterruptedException
    {
        driver.findElement(By.linkText("User Management")).click();
        driver.findElement(By.linkText("Add New User")).click();

        driver.findElement(By.name("fname")).sendKeys(fname);
        driver.findElement(By.name("lname")).sendKeys(lname);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("phone")).sendKeys(phno);

        Select gender = new Select(driver.findElement(By.name("gender")));
        gender.selectByVisibleText(Gender);

        driver.findElement(By.id("datepicker")).sendKeys(dob);
        driver.findElement(By.name("address")).sendKeys(Address);

        Select country = new Select(driver.findElement(By.name("country_id")));
        country.selectByVisibleText(Country);

        Select state = new Select(driver.findElement(By.name("state_id")));
        state.selectByVisibleText(State);

        Select city  = new Select(driver.findElement(By.name("city_id")));
        city.selectByVisibleText(City);

        driver.findElement(By.name("postal_code")).sendKeys(Pcode);
        driver.findElement(By.name("password")).sendKeys(pword);
        driver.findElement(By.name("c_password")).sendKeys(pword);

        Thread.sleep(2000);
        Select role = new Select(driver.findElement(By.name("role")));
        role.selectByVisibleText(Role);

        driver.findElement(By.className("btn btn-info pull-right")).click();
        WebElement usertable = driver.findElement(By.linkText("Users"));

        List<WebElement> rows,cols;
        rows = usertable.findElements(By.tagName("tr"));

        boolean isuserpresent = false;
        for(int i=1;i<rows.size();i++)
        {
            cols = rows.get(i).findElements(By.tagName("td"));
            if(cols.get(1).getText().contains(fname))
            {
                isuserpresent = true;
                break;
            }
        }
        return isuserpresent;

    }






}
