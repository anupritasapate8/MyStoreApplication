package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BaseClass {
    Action act=new Action();
    @FindBy(xpath="//a[@class='login']")
    WebElement SignInLink;

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    WebElement myStoreLogo;

    @FindBy(xpath ="//input[@class='search_query form-control ac_input']")
    WebElement searchBar;
    @FindBy(name="submit_search")
    WebElement searchBarBtn;

    public IndexPage()
    {
        PageFactory.initElements(driver,this);
    }

    public LoginPage clickOnSignIn()
    {
        act.click(driver, SignInLink);
        return new LoginPage();
    }
    public String verifyTitle()
    {
        String myStoreTitle= driver.getTitle();
        return myStoreTitle;
    }
    public boolean validateLogo()
    {
        return act.isDisplayed(driver, myStoreLogo);

    }
    public SearchResultPage searchProduct(String text)
    {
        act.sendKeys(searchBar, text);
        act.click(driver, searchBarBtn);
        return new SearchResultPage();
    }
}
