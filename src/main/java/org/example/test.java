package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class test {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.driver", "driver\\chromedriver.exe");


//        options.addArguments("start-maximized");
//
////        options.addArguments("--headless");
////        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
//        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        WebDriverManager web = WebDriverManager.chromedriver();
        web.setup();
        ChromeOptions options = new ChromeOptions();
//        EdgeOptions options = new EdgeOptions();
//        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);


        driver.get("http://omayo.blogspot.com/p/page7.html?utm_source=zalo&utm_medium=zalo&utm_campaign=zalo");

        driver.findElement(By.linkText("ZIP file")).click();

        Thread.sleep(5000);
        driver.close();
    }
}
