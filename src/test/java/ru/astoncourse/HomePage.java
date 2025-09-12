package ru.astoncourse;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //куки
    public HomePage clickCookieLocator() {
        WebElement cookie = driver.findElement(LocatorsHomePage.enterCookieLocator);
        if (cookie.isDisplayed()) {
            cookie.click();
        }
        return this;
    }

    @Step("Отправка названия блока")
    public String getNameBlockLocator() {
        return driver.findElement(LocatorsHomePage.blockLocator).getAccessibleName();
    }

    @Step("Проверка отображения платежных систем")
    public boolean getLinkSrcLogo(int index) {
        return driver.findElement(By.xpath("//img[@alt=\"" + LocatorsHomePage.listNameLogo[index] + "\"]")).isDisplayed();
    }

    @Step("Нажатие по ссылке \"Подробнее о сервисе\"")
    public String clickLinkAboutTheServiceLocator() {
        driver.findElement(LocatorsHomePage.linkAboutTheServiceLocator).click();
        return driver.getCurrentUrl();
    }

    @Step("Проверка/переход что/на выбрано/пункт \"Услуги связи\"")
    private HomePage verifyFormCommunicationServices() {
        String idForm = driver.findElement(LocatorsHomePage.openFormLocator).getAttribute("id");
        if (!idForm.equals("pay-connection")) {
            driver.findElement(By.xpath("//*[@class=\"select__wrapper\"]")).click();
            driver.findElement(By.xpath("//*[@class=\"select__list\"]/li[1]")).click();
        }
        return this;
    }

    @Step("Запись в поле номер телефона {0}")
    private void enterNumberPhone(String number) {
        driver.findElement(LocatorsHomePage.enterNumberPhoneLocator).sendKeys(number);
    }

    @Step("Запись в поле суммы {0}")
    private void enterSumPhone(String sum) {
        driver.findElement(LocatorsHomePage.enterSumLocator).sendKeys(sum);
    }

    @Step("Запись в поле Email {0}")
    public void enterEmail(String email) {
        driver.findElement(LocatorsHomePage.enterEmailLocator).sendKeys(email);
    }

    @Step("Проверка и ввод данных в поля (кроме E-mail)")
    public void fillFieldsAndVerifyContinueButton(String number, String sum) {
        verifyFormCommunicationServices();
        enterNumberPhone(number);
        enterSumPhone(sum);
        driver.findElement(LocatorsHomePage.buttonResumeLocator).click();
    }

    @Step("Проверка категории и ввод данных в поля")
    public void fillFieldsAndVerifyContinueButton(String number, String sum, String email) {
        verifyFormCommunicationServices();
        enterNumberPhone(number);
        enterSumPhone(sum);
        enterEmail(email);
        driver.findElement(LocatorsHomePage.buttonResumeLocator).click();
    }

    @Step("Проверка окна оплаты на правильное отображение суммы")
    public String getTitleFrameTextOrSubmitButtonText(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> {
            String text = driver.findElement(LocatorsHomePage.frameSumLocator).getText().trim();
            return !text.isEmpty();
        });
        String sum = "";
        if (index == 0) {
            sum = driver.findElement(LocatorsHomePage.frameSumLocator).getText();
        } else {
            sum = driver.findElement(LocatorsHomePage.frameButtonSumLocator).getText();
        }
        char[] lines = sum.toCharArray();
        sum = "";
        for (int i = index; i < lines.length; i++) {
            if (lines[i] == '.' && lines[i + 1] == '0' && lines[i + 2] == '0') {
                break;
            }
            if (lines[i] == '.' && lines[i + 2] == '0') {
                sum += lines[i];
                sum += lines[i + 1];
                break;
            }
            if (lines[i] == ' ') {
                break;
            }
            sum += lines[i];
        }
        return sum;
    }

    @Step("Проверка правильного отображения номера телефона")
    public String getNumberPhoneText() {
        String line = driver.findElement(LocatorsHomePage.frameNumberPhoneLocator).getText();
        char[] lines = line.toCharArray();
        line = "";
        for (int i = lines.length - 1, j = LocatorsHomePage.numberPhone.length() + 3; j != 0; i--, j--) {
            line += lines[i];
        }
        return reverseString(line);
    }

    private String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    @Step("Проверка отображения иконок платежных систем")
    public boolean checkDisabledStatLogoCards() {
        if (driver.findElement(LocatorsHomePage.frameLogoVisaLocator).isDisplayed()) {
            if (driver.findElement(LocatorsHomePage.frameLogoMastercardLocator).isDisplayed()) {
                if (driver.findElement(LocatorsHomePage.frameLogoBelkartLocator).isDisplayed()) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Step("Проверка отображения двух иконок поочереди раз в 3 сек.")
    public boolean checkDisabledDynamicLogoCards() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if (wait.until(ExpectedConditions.visibilityOfElementLocated(LocatorsHomePage.frameLogoMaestroLocator)).isDisplayed()) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LocatorsHomePage.frameLogoMirLocator));
            return true;
        }
        return false;
    }

    @Step("Проверка надписей в полях ввода данных карты")
    public boolean validateEmptyCardInputFieldTexts() {
        String[] texts = {"Номер карты", "Срок действия", "CVC", "Имя и фамилия на карте"};
        String[] receivedTexts = new String[texts.length];
        receivedTexts[0] = driver.findElement(LocatorsHomePage.frameNumberCardLocator).getText();
        receivedTexts[1] = driver.findElement(LocatorsHomePage.frameValidityPeriodCardLocator).getText();
        receivedTexts[2] = driver.findElement(LocatorsHomePage.frameCVCCardLocator).getText();
        receivedTexts[3] = driver.findElement(LocatorsHomePage.frameFirstAndLastNameCardLocator).getText();

        for (int i = 0; i < texts.length; i++) {
            if (!receivedTexts[i].equals(texts[i])) {
                return false;
            }
        }
        return true;
    }
    @Step("Надписи в блоке \"Услуги связи\"")
    public boolean checkLabelCommunicationServices() {
        String numberText = "Номер телефона";
        String sumText = "Сумма";
        String emailText = "E-mail для отправки чека";

        return driver.findElement(LocatorsHomePage.enterNumberPhoneLocator).getAttribute("placeholder").equals(numberText)
                && driver.findElement(LocatorsHomePage.enterSumLocator).getAttribute("placeholder").equals(sumText)
                && driver.findElement(LocatorsHomePage.enterEmailLocator).getAttribute("placeholder").equals(emailText);
    }
    @Step("Надписи в блоке \"Домашний интернет\"")
    public boolean checkLabelInternetHome() {
        String numberText = "Номер абонента";
        String sumText = "Сумма";
        String emailText = "E-mail для отправки чека";

        return driver.findElement(LocatorsHomePage.listInternetLocator.get(0)).getAttribute("placeholder").equals(numberText)
                && driver.findElement(LocatorsHomePage.listInternetLocator.get(1)).getAttribute("placeholder").equals(sumText)
                && driver.findElement(LocatorsHomePage.listInternetLocator.get(2)).getAttribute("placeholder").equals(emailText);
    }
    @Step("Надписи в блоке \"Рассрочка\"")
    public boolean checkLabelInstalment() {
        String numberText = "Номер счета на 44";
        String sumText = "Сумма";
        String emailText = "E-mail для отправки чека";

        return driver.findElement(LocatorsHomePage.listInstalmentLocator.get(0)).getAttribute("placeholder").equals(numberText)
                && driver.findElement(LocatorsHomePage.listInstalmentLocator.get(1)).getAttribute("placeholder").equals(sumText)
                && driver.findElement(LocatorsHomePage.listInstalmentLocator.get(2)).getAttribute("placeholder").equals(emailText);
    }
    @Step("Надписи в блоке \"Задолженность\"")
    public boolean checkLabelArrears() {
        String numberText = "Номер счета на 2073";
        String sumText = "Сумма";
        String emailText = "E-mail для отправки чека";

        return driver.findElement(LocatorsHomePage.listArrearsLocator.get(0)).getAttribute("placeholder").equals(numberText)
                && driver.findElement(LocatorsHomePage.listArrearsLocator.get(1)).getAttribute("placeholder").equals(sumText)
                && driver.findElement(LocatorsHomePage.listArrearsLocator.get(2)).getAttribute("placeholder").equals(emailText);
    }
}
