package ru.astoncourse;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestSiteMtsUsePageObject {

    private static WebDriver driver;
    private static HomePage homePage;

    @BeforeEach
    void connectionDriver() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver);
        homePage.clickCookieLocator();

    }

    @Test
    void verifyNameBlock() {
        String nameBlock = "Онлайн пополнение без комиссии";
        Assertions.assertEquals(nameBlock, homePage.getNameBlockLocator());
    }

    @Test
    void verifyPaymentLogosPresence() {
        for (int i = 0; i < 5; i++) {
            Assertions.assertNotEquals(homePage.getLinkSrcLogo(i), null);
        }
    }

    @Test
    void verifyMoreAboutServiceLink() {
        Assertions.assertEquals(homePage.clickLinkAboutTheServiceLocator(), "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/");
    }

    @Test
    void FillingOutTheCommunicationServiceForm() {
        // неиспользовано необязательное поле Email
//        homePage.fillFieldsAndVerifyContinueButton(LocatorsHomePage.numberPhone, LocatorsHomePage.sum);
        // использовано необязательное поле Email
        homePage.fillFieldsAndVerifyContinueButton(LocatorsHomePage.numberPhone, LocatorsHomePage.sum, LocatorsHomePage.email);
    }

    @Test
    void checkLabelsInEmptyFieldsForPaymentMethods() {
        Assertions.assertEquals(true, homePage.checkLabelCommunicationServices());
        Assertions.assertEquals(true, homePage.checkLabelInternetHome());
        Assertions.assertEquals(true, homePage.checkLabelInstalment());
        Assertions.assertEquals(true, homePage.checkLabelArrears());
    }

    @Test
    void verifyPhoneServicesPaymentFlow() {
        homePage.fillFieldsAndVerifyContinueButton(LocatorsHomePage.numberPhone, LocatorsHomePage.sum, LocatorsHomePage.email);
        driver.switchTo().frame(driver.findElement(LocatorsHomePage.framePaymentLocator));
        Assertions.assertEquals(LocatorsHomePage.sum, homePage.getTitleFrameText());
        Assertions.assertEquals(LocatorsHomePage.sum, homePage.getSubmitButtonText());
        Assertions.assertEquals("375" + LocatorsHomePage.numberPhone, homePage.getNumberPhoneText());
        Assertions.assertEquals(true, homePage.checkDisabledDinamicLogoCards());
        Assertions.assertEquals(true, homePage.checkDisabledStatLogoCards());
        Assertions.assertEquals(true, homePage.validateEmptyCardInputFieldTexts());
    }

    @AfterEach
    void closeBrowser() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
