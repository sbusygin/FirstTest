package ru.rgs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

public class FirstTestClass {
    private ChromeDriver driver;
    private WebDriverWait driverWait;

    @Test
    public void fistTest() {
        System.setProperty("webdriver.chrome.driver", "E:\\JavaRush\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, 25, 1000);
        driver.get("https://www.rgs.ru/");
        waitAndClick("//ol[@class='nav navbar-nav navbar-nav-rgs-menu pull-left']");
        waitAndClick("//div[@class='h3 adv-analytics-navigation-line2-link' and ./a[contains(text(),'Страховой случай')]]");
        waitAndClick("//ul[@class='list-unstyled list-rgs-menu-subitems']/li/a[@href='/service/ins/dms/index.wbp']");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Добровольное медицинское страхование"));
    }

    @After
    public void afterTest() {
        driver.close();
    }

    public void waitAndClick(String s) {
        driverWait.until(ExpectedConditions.
                visibilityOf(driver.findElement(By.xpath(s)))).click();
    }
}
