package TestCases;

import Library.*;
import Utils.AppUtils;
import Utils.XLUtils;
import org.testng.annotations.Test;
import java.io.IOException;

public class DraftUSTest extends AppUtils
{
    String keywordfile = "/Users/ankitaloni/Desktop/Keywords DraftUs.xlsx";

    String tcsheet = "TestCases";
    String tssheet = "TestSteps";
    String tcexeflag,tcid,tstcid,keyword;
    String email,pwd;
    String fname,lname,gender,dob,address,country,state,city,pcode,psword,role,pno;
    String phone,Oldpwd,newpd,name,descrpt,videolink,company,phno,mssg,stepres,tcres;

    @Test
    public void DraftUS() throws IOException,InterruptedException
    {

        int tccount  = XLUtils.getRowCount(keywordfile,tcsheet);
        int tscount  = XLUtils.getRowCount(keywordfile,tssheet);

        boolean res = false;

        LoginPage lp = new LoginPage();
        Curriculum cu = new Curriculum();
        Skill sk = new Skill();
        ContactUS cs = new ContactUS();
        Subscriber sc = new Subscriber();
        User us = new User();
        ProfileEdit pe = new ProfileEdit();
        ChangePassword cp = new ChangePassword();


        for (int i=1;i<=tccount;i++)
        {
            tcexeflag = XLUtils.getStringCellData(keywordfile, tcsheet, i, 2);
            if (tcexeflag.equalsIgnoreCase("y"))
            {
                tcid = XLUtils.getStringCellData(keywordfile, tcsheet, i, 0);
                for (int j = 1; j < tscount; j++)
                {
                    tstcid = XLUtils.getStringCellData(keywordfile, tssheet, j, 0);
                    if (tstcid.equalsIgnoreCase(tcid))
                    {
                        keyword = XLUtils.getStringCellData(keywordfile, tssheet, j, 4);
                        switch (keyword.toLowerCase())
                        {
                            case "adminlogin":
                                email = XLUtils.getStringCellData(keywordfile, tssheet, j, 5);
                                pwd = String.valueOf(XLUtils.getNumericCellData(keywordfile, tssheet, j, 6));
                                lp.login(email, pwd);
                                res = lp.isAdminmoduleDisplayed();
                                break;
                            case "logout":
                                res = lp.logout();
                                break;
                            case "newteamreg":
                            case "newcoachreg":
                            case "newathletereg":
                                fname = XLUtils.getStringCellData(keywordfile, tssheet, j, 5);
                                lname = XLUtils.getStringCellData(keywordfile, tssheet, j, 6);
                                email = XLUtils.getStringCellData(keywordfile, tssheet, j, 7);
                                phone = String.valueOf(XLUtils.getNumericCellData(keywordfile, tssheet, j, 8));
                                gender = XLUtils.getStringCellData(keywordfile, tssheet, j, 9);
                                dob = String.valueOf(XLUtils.getNumericCellData(keywordfile, tssheet, j, 10));
                                address = XLUtils.getStringCellData(keywordfile, tssheet, j, 11);
                                country = XLUtils.getStringCellData(keywordfile, tssheet, j, 12);
                                state = XLUtils.getStringCellData(keywordfile, tssheet, j, 13);
                                city = XLUtils.getStringCellData(keywordfile, tssheet, j, 14);
                                pcode = String.valueOf(XLUtils.getNumericCellData(keywordfile, tssheet, j, 15));
                                psword = XLUtils.getStringCellData(keywordfile, tssheet, j, 16);
                                role = XLUtils.getStringCellData(keywordfile, tssheet, j, 18);
                                us.addUser(fname,lname,email,phone,gender,dob,address,country,state,city,pcode,psword,role);
                                break;
                            case "invalidlogin":
                                email = XLUtils.getStringCellData(keywordfile, tssheet, j, 5);
                                pwd   = XLUtils.getStringCellData(keywordfile, tssheet, j, 6);
                                lp.login(email, pwd);
                                res = lp.isErrmsgDisplayed();
                                break;
                            case "profileedit":
                                fname = XLUtils.getStringCellData(keywordfile, tssheet, j, 5);
                                lname = XLUtils.getStringCellData(keywordfile, tssheet, j, 6);
                                pe.Editprofile(fname, lname, pno);
                                break;
                            case "newskillreg":
                                name = XLUtils.getStringCellData(keywordfile, tssheet, j, 5);
                                sk.addSkill(name);
                                break;
                            case "newcurrireg":
                                name = XLUtils.getStringCellData(keywordfile, tssheet, j, 5);
                                descrpt = XLUtils.getStringCellData(keywordfile, tssheet, j, 6);
                                videolink = XLUtils.getStringCellData(keywordfile, tssheet, j, 7);
                                cu.addCurriculum(name,descrpt,videolink);
                                break;
                            case "new contactus":
                                name = XLUtils.getStringCellData(keywordfile, tssheet, j, 5);
                                company = XLUtils.getStringCellData(keywordfile, tssheet, j, 6);
                                phno = XLUtils.getStringCellData(keywordfile, tssheet, j, 7);
                                email = XLUtils.getStringCellData(keywordfile, tssheet, j, 8);
                                mssg = XLUtils.getStringCellData(keywordfile, tssheet, j, 9);
                                cs.addCustumerSupport(name,company,phno,email,mssg);
                                break;
                            case "new subscriber":
                                email = XLUtils.getStringCellData(keywordfile, tssheet, j, 5);
                                sc.addSubscriber(email);
                                break;
                            case "changepassword":
                                Oldpwd = XLUtils.getStringCellData(keywordfile, tssheet, j, 5);
                                newpd = XLUtils.getStringCellData(keywordfile, tssheet, j, 6);
                                cp.ChangePassword(Oldpwd,pwd);
                                lp.login(email, newpd);
                                break;
                        }
                        // code to update the Step Result
                        if (res) {
                            stepres = "Pass";
                            XLUtils.setCellData(keywordfile, tssheet, j, 3, stepres);
                            XLUtils.fillGreenColor(keywordfile, tssheet, j, 3);
                        } else {
                            stepres = "Fail";
                            XLUtils.setCellData(keywordfile, tssheet, j, 3, stepres);
                            XLUtils.fillRedColor(keywordfile, tssheet, j, 3);
                        }

                        // Code to update the TestCase Result
                        tcres = XLUtils.getStringCellData(keywordfile, tcsheet, i, 3);
                        if (tcres.equalsIgnoreCase("fail")) {
                            XLUtils.setCellData(keywordfile, tcsheet, i, 3, stepres);
                        }

                        // code to fill TestCase Result Colors
                        tcres = XLUtils.getStringCellData(keywordfile, tcsheet, i, 3);
                        if (tcres.equalsIgnoreCase("pass")) {
                            XLUtils.fillGreenColor(keywordfile, tcsheet, i, 3);
                        } else {
                            XLUtils.fillRedColor(keywordfile, tcsheet, i, 3);
                        }

                    }

                }
            } else
            {
                XLUtils.setCellData(keywordfile,tcsheet,i,3,"blocked");
                XLUtils.fillRedColor(keywordfile,tcsheet,i,3);
            }
        }





    }

}
