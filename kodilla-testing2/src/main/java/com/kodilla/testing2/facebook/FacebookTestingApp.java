package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FacebookTestingApp {

    public static final String XPATH_ACCEPT_COOKIES = "//button[2]";
    public static final String XPATH_NEW_USER = "//div[@class='_6ltg']/a[@data-testid='open-registration-form-button']";
    public static final String XPATH_MONTH = "//div[contains(@class, \"5k_5\")]/span/span/select[1]";
    public static final String XPATH_DAY = "//div[contains(@class, \"5k_5\")]/span/span/select[2]";
    public static final String XPATH_YEAR = "//div[contains(@class, \"5k_5\")]/span/span/select[3]";


    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://facebook.com/");

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath(XPATH_ACCEPT_COOKIES)).click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath(XPATH_NEW_USER)).click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Select day = new Select(driver.findElement(By.xpath(XPATH_DAY)));
        day.selectByValue("10");
        Select month = new Select(driver.findElement(By.xpath(XPATH_MONTH)));
        month.selectByValue("10");
        Select year = new Select(driver.findElement(By.xpath(XPATH_YEAR)));
        year.selectByValue("2010");
    }
}
