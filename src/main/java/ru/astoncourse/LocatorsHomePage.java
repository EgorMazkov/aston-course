package ru.astoncourse;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocatorsHomePage {
    public static final String numberPhone = "297777777";
    public static final String sum = "10.5";
    public static final String email = "test@test.com";

    public static final By enterCookieLocator = By.xpath("//*[@id=\"cookie-agree\"]");
    public static final By blockLocator = By.xpath("//*[@class=\"pay__wrapper\"]/h2");
    public static final String[] listNameLogo = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
    public static final By linkAboutTheServiceLocator = By.xpath("//*[@class=\"pay__wrapper\"]/a");
    public static final By enterNumberPhoneLocator = By.xpath("//*[@id=\"connection-phone\"]");
    public static final By enterSumLocator = By.xpath("//*[@id=\"connection-sum\"]");
    public static final By enterEmailLocator = By.xpath("//*[@id=\"connection-email\"]");
    public static final By buttonResumeLocator = By.xpath("//*[@id=\"pay-connection\"]/button");
    public static final By openFormLocator = By.xpath("//*[@class=\"pay-form opened\"]");

    public static final List<By> listInternetLocator = new ArrayList<>(Arrays.asList(
            By.xpath("//*[@id=\"internet-phone\"]"),
            By.xpath("//*[@id=\"internet-sum\"]"),
            By.xpath("//*[@id=\"internet-email\"]")
    ));
    public static final List<By> listInstalmentLocator = new ArrayList<>(Arrays.asList(
            By.xpath("//*[@id=\"score-instalment\"]"),
            By.xpath("//*[@id=\"instalment-sum\"]"),
            By.xpath("//*[@id=\"instalment-email\"]")
    ));
    public static final List<By> listArrearsLocator = new ArrayList<>(Arrays.asList(
            By.xpath("//*[@id=\"score-arrears\"]"),
            By.xpath("//*[@id=\"arrears-sum\"]"),
            By.xpath("//*[@id=\"arrears-email\"]")
    ));

    public static final By framePaymentLocator = By.xpath("//*[@class=\"bepaid-iframe\"]");
    public static final By frameSumLocator = By.xpath("//span[contains(normalize-space(.), 'BYN')]");
    public static final By frameButtonSumLocator = By.xpath("//*[@class=\"colored disabled\"]");
    public static final By frameNumberPhoneLocator = By.xpath("//*[@class=\"pay-description__text\"]/span");

    public static final By frameLogoVisaLocator = By.xpath("//img[@class=\"ng-tns-c891095944-0 ng-star-inserted\"][1]");
    public static final By frameLogoMastercardLocator = By.xpath("//img[@class=\"ng-tns-c891095944-0 ng-star-inserted\"][2]");
    public static final By frameLogoBelkartLocator = By.xpath("//img[@class=\"ng-tns-c891095944-0 ng-star-inserted\"][3]");
    public static final By frameLogoMaestroLocator = By.xpath("//img[contains(@class, \"ng-trigger-randomCardState\")][1]");
    public static final By frameLogoMirLocator = By.xpath("//img[contains(@class, \"ng-trigger-randomCardState\")][2]");

    public static final By frameNumberCardLocator = By.xpath("//*[contains(@class, \"ng-tns-c2312288139-1\")]/label");
    public static final By frameValidityPeriodCardLocator = By.xpath("//*[contains(@class, \"ng-tns-c2312288139-4\")]/label");
    public static final By frameCVCCardLocator = By.xpath("//*[contains(@class, \"ng-tns-c2312288139-5\")]/label");
    public static final By frameFirstAndLastNameCardLocator = By.xpath("//*[contains(@class, \"ng-tns-c2312288139-3\")]/label");


}
