package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.


        // Press Shift+F10 or click the green arrow button in the gutter to run the code.

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://computer-database.gatling.io/");
        Thread.sleep(5000);

        WebElement chu1 = driver.findElement(By.xpath("//table[@class='computers zebra-striped']/tbody/tr[1]//a"));
        chu1.getText();
        WebElement chu2 = driver.findElement(By.xpath("//table[@class='computers zebra-striped']/tbody/tr[2]//a"));
        chu2.getText();
        WebElement chu3 = driver.findElement(By.xpath("//table[@class='computers zebra-striped']/tbody/tr[3]//a"));
        chu3.getText();
        WebElement chu4 = driver.findElement(By.xpath("//table[@class='computers zebra-striped']/tbody/tr[4]//a"));
        chu4.getText();
        WebElement chu5 = driver.findElement(By.xpath("//table[@class='computers zebra-striped']/tbody/tr[5]//a"));
        chu5.getText();
        WebElement chu6 = driver.findElement(By.xpath("//table[@class='computers zebra-striped']/tbody/tr[6]//a"));
        chu6.getText();
        WebElement chu7 = driver.findElement(By.xpath("//table[@class='computers zebra-striped']/tbody/tr[7]//a"));
        chu7.getText();
        WebElement chu8 = driver.findElement(By.xpath("//table[@class='computers zebra-striped']/tbody/tr[8]//a"));
        chu8.getText();
        WebElement chu9 = driver.findElement(By.xpath("//table[@class='computers zebra-striped']/tbody/tr[9]//a"));
        chu9.getText();
        WebElement chu10 = driver.findElement(By.xpath("//table[@class='computers zebra-striped']/tbody/tr[10]//a"));
        chu10.getText();

        System.out.println(chu1.getText());
        System.out.println(chu2.getText());
        System.out.println(chu3.getText());
        System.out.println(chu4.getText());
        System.out.println(chu5.getText());
        System.out.println(chu6.getText());
        System.out.println(chu7.getText());
        System.out.println(chu8.getText());
        System.out.println(chu9.getText());
        System.out.println(chu10.getText());

        WebElement button = driver.findElement(By.xpath("//li[@class='next']/a"));
        button.click();
        WebElement gmail = driver.findElement(By.xpath("//input[@name='f']"));
        gmail.sendKeys("Canon Cat");
        WebElement gmail2 = driver.findElement(By.xpath("//input[@type='submit']"));
        gmail2.click();

        System.out.println(button);
        System.out.println(gmail);
        System.out.println(gmail2);


    }
}