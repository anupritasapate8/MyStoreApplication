package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    Action act= new Action();
    @FindBy(id="email")
    WebElement username;

    @FindBy(id="passwd")
    WebElement password;

    @FindBy(xpath = "//button[@name='SubmitLogin']")
    WebElement SignInBtn;
    @FindBy()
    WebElement loginPage;

    @FindBy(name="email_create")
    WebElement email_address;

    @FindBy(id="SubmitCreate")
    WebElement createSubmitBtn;

    public LoginPage()
    {
        PageFactory.initElements(driver, this);
    }
    public HomePage signIn(String usernm, String passwd)
    {
        act.sendKeys(username, usernm);
        act.sendKeys(password, passwd);
        act.click(driver, SignInBtn);
        return new HomePage();

    }
    public RegistrationPage registerUser(String emailAddr)
    {
        act.sendKeys(email_address, emailAddr);
        act.click(driver, createSubmitBtn);
        return new RegistrationPage();

    }

}


