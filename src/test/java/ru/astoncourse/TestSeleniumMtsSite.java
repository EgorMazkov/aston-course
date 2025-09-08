package ru.astoncourse;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestSeleniumMtsSite {

    private static WebDriver driver;

    @BeforeAll
    static void connectionDriver() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement cookie = driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]"));
        if (cookie.isEnabled()) {
            cookie.click();
        }
    }

    @Test
    void verifyTitleBlock() {
        String title = "Онлайн пополнение без комиссии";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String titleFromSite =  driver.findElement(By.xpath("//*[@class=\"pay__wrapper\"]/h2")).getAccessibleName();
        Assertions.assertEquals(title, titleFromSite);
    }

    @Test
    void verifyPaymentLogosPresence() {
        String[] listNameAlt = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        for (int i = 0; i < listNameAlt.length; i++) {
            String srcLogoNotNull = driver.findElement(By.xpath("//img[@alt=\"" + listNameAlt[i] + "\"]")).getAttribute("src");
            Assertions.assertNotEquals(srcLogoNotNull, null);
        }
    }

    @Test
    void verifyMoreAboutServiceLink() {
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@class=\"pay__wrapper\"]/a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/");
    }

    @Test
    void fillFieldsAndVerifyContinueButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String idForm = driver.findElement(By.xpath("//*[@class=\"pay-form opened\"]")).getAttribute("id");
        if (!idForm.equals("pay-connection")) {
            driver.findElement(By.xpath("//*[@class=\"select__header\"]")).click();
            driver.findElement(By.xpath("//*[@class=\"select__list\"]/li[1]")).click();

        }
        driver.findElement(By.xpath("//*[@id=\"connection-phone\"]")).sendKeys("297777777");
        driver.findElement(By.xpath("//*[@id=\"connection-sum\"]")).sendKeys("10");
        driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@class=\"bepaid-iframe\"]")).isEnabled(), true);
        driver.navigate().refresh();

    }

    @AfterAll
    static void quitDriver() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
