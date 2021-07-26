package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    Action action=new Action();
    @FindBy(xpath="//a[@title='My wishlists']")
    WebElement myWishlist;

    @FindBy(xpath="//a[@title='Orders']")
    WebElement orderHistoryAndDetails;

    public HomePage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean myWishlistIsDisplayed()
    {
        return action.isDisplayed(driver, myWishlist);
    }

    public boolean orderHistoryAndDetailsISDisplayed()
    {
        return action.isDisplayed(driver, orderHistoryAndDetails);
    }

}
