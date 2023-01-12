package Library;

import Utils.AppUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AdminModule extends AppUtils
{

    String email = "admin@admin.com";
    String pwd = "123456789";

    LoginPage lp;

    @BeforeTest
    public void adminlogin()
    {
        lp = new LoginPage();
        lp.login(email,pwd);
    }


    @AfterTest
    public void adminlogout()
    {
        lp = new LoginPage();
        lp.logout();
    }





}
