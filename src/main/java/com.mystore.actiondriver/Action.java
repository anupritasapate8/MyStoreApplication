package com.mystore.actiondriver;

import com.mystore.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action extends BaseClass {

    public void click(WebDriver driver, WebElement element) {

        Actions action=new Actions(driver);
        action.moveToElement(element).click().build().perform();
    }

    public boolean isDisplayed(WebDriver driver, WebElement element)
    {
        boolean flag=false;
        flag=findElement(driver, element);
        try {
            if (flag) {
                System.out.println("Element is displayed");
            } else
                System.out.println("Element is  not displayed");
        }catch(Exception e) {
            System.out.println("not found");

        }
        return flag;

    }
    public boolean findElement(WebDriver driver, WebElement element)
    {
        boolean flag=false;
        try {
            flag = element.isDisplayed();
        flag=true;
        }catch(Exception e)
        {
            flag=false;
        }finally {
            if(flag)
            {
                System.out.println("Element found");
            }
            else
                System.out.println("Unable to locate element");
        }
        return flag;
    }
    public boolean sendKeys( WebElement ele , String text)
    {
        boolean flag=false;
        try{
        flag=ele.isDisplayed();
        ele.clear();
        ele.sendKeys(text);
        flag=true;}
        catch(Exception e)
        {
            System.out.println("Send Keys failed");

        }
 return flag;
    }

}
