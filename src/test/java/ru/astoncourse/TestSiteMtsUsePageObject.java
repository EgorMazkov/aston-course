package ru.astoncourse;


import org.junit.jupiter.api.*;
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
    @DisplayName("Проверка названия блока")
    void verifyNameBlock() {
        String nameBlock = "Онлайн пополнение без комиссии";
        Assertions.assertEquals(nameBlock, homePage.getNameBlockLocator());
    }

    @Test
    @DisplayName("Проверка отображения логотипов платежных систем ")
    void verifyPaymentLogosPresence() {
        for (int i = 0; i < 5; i++) {
            Assertions.assertTrue(homePage.getLinkSrcLogo(i));
        }
    }

    @Test
    @DisplayName("Проверка работы ссылки \"Подробнее о сервисе\"")
    void verifyMoreAboutServiceLink() {
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", homePage.clickLinkAboutTheServiceLocator());
    }

    @Test
    @DisplayName("Заполнение блока оплаты и переход на frame оплаты")
    void FillingOutTheCommunicationServiceForm() {
        // неиспользовано необязательное поле Email
//        homePage.fillFieldsAndVerifyContinueButton(LocatorsHomePage.numberPhone, LocatorsHomePage.sum);
        // использовано необязательное поле Email
        homePage.fillFieldsAndVerifyContinueButton(LocatorsHomePage.numberPhone, LocatorsHomePage.sum, LocatorsHomePage.email);
    }

    @Test
    @DisplayName("Проверка надписей в незаполненых полях")
    void checkLabelsInEmptyFieldsForPaymentMethods() {
        Assertions.assertTrue(homePage.checkLabelCommunicationServices());
        Assertions.assertTrue(homePage.checkLabelInternetHome());
        Assertions.assertTrue(homePage.checkLabelInstalment());
        Assertions.assertTrue(homePage.checkLabelArrears());
    }

    @Test
    @DisplayName("Блок оплаты")
    void verifyPhoneServicesPaymentFlow() {
        homePage.fillFieldsAndVerifyContinueButton(LocatorsHomePage.numberPhone, LocatorsHomePage.sum, LocatorsHomePage.email);
        driver.switchTo().frame(driver.findElement(LocatorsHomePage.framePaymentLocator));
        Assertions.assertEquals(LocatorsHomePage.sum, homePage.getTitleFrameTextOrSubmitButtonText(0));
        Assertions.assertEquals(LocatorsHomePage.sum, homePage.getTitleFrameTextOrSubmitButtonText(9));
        Assertions.assertEquals("375" + LocatorsHomePage.numberPhone, homePage.getNumberPhoneText());
        Assertions.assertTrue(homePage.checkDisabledDynamicLogoCards());
        Assertions.assertTrue(homePage.checkDisabledStatLogoCards());
        Assertions.assertTrue(homePage.validateEmptyCardInputFieldTexts());
    }

    @AfterEach
    void closeBrowser() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
