package final_project;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class CommonPageObject {
    public static WebDriver edriver;
    public static WebDriverWait ewait;
    static DataField dataField;

    @FindBy(how = How.XPATH, using = "//input[@id='searchbox']")
    public WebElement searchFilter ;
    @FindBy(how = How.XPATH, using = "//input[@id='searchsubmit']")
    public WebElement btnFilter;
    @FindBy(how = How.XPATH, using = "//a[@href='/computers/351']")
    public WebElement clickComputer;
    @FindBy(how = How.XPATH, using = "//a[@href='/computers/318']")
    public WebElement clickACE;
    @FindBy(how = How.XPATH, using = "//input[@id='name']")
    public WebElement textComputerName;
    @FindBy(how = How.XPATH, using = "//input[@id='introduced']")
    public WebElement textIntroduced;
    @FindBy(how = How.XPATH, using = "//input[@id='discontinued']")
    public WebElement textDiscontinued;
    @FindBy(how = How.XPATH, using = "//select[@id='company']")
    public WebElement buttonCompany;
    @FindBy(how = How.XPATH, using = "//option[@value='3']")
    public WebElement buttonOption3;
    @FindBy(how = How.XPATH, using = "//div[@class='actions']/a")
    public WebElement buttonCancel;
    @FindBy(how = How.XPATH, using = "//a[@id='add']")
    public WebElement buttonAddComputer;
    @FindBy(how = How.XPATH, using = "//a[@href='/computers/381']")
    public WebElement clickComputer1;
    @FindBy(how = How.XPATH, using = "//input[@class='btn danger']")
    public WebElement clickdelete;

    // Button Next and Previous
    @FindBy(how = How.XPATH, using = "//li[@class='next']/a")
    public WebElement buttonNext;
    @FindBy(how = How.XPATH, using = "//li[@class='prev']/a")
    public WebElement buttonPrevious;

    //Button Sort
    @FindBy(how = How.XPATH, using = "//th[@class='col-name header headerSortUp']/a")
    public WebElement buttonSortUpName;
    @FindBy(how = How.XPATH, using = "//th[@class='col-name header headerSortDown']/a")
    public WebElement buttonSortDownName;

    //Button Create and Save
    @FindBy(how = How.XPATH, using = "//input[@type='submit']")
    public WebElement buttonCreate;

    public CommonPageObject(WebDriver driver){
        edriver = new ChromeDriver();
        PageFactory.initElements(edriver,this);
        ewait = new WebDriverWait(edriver, Duration.ofSeconds(5));
        edriver.get("https://computer-database.gatling.io/computers");
        dataField = new DataField("src/main/java/javaDemo/testClass.xlsx");
    }

    public void closeWeb(){
        edriver.close();
    }

    public void  waitUntilElementVisible(WebElement element){
        int tryTimes=0;
        while(tryTimes <2){
            try{
                ewait.until(ExpectedConditions.visibilityOf(element));
                break;
            }
            catch(StaleElementReferenceException se){
                tryTimes++;
                if(tryTimes ==2)
                    throw se;
            }
        }
    }

    public void waitUntilElementVisible(String path) throws Exception{
        int tryTimes=0;
        while(tryTimes <2){
            try{
                WebElement element = edriver.findElement(By.xpath(path));
                ewait.until(ExpectedConditions.visibilityOf(element));
                break;
            }
            catch(StaleElementReferenceException se){
                tryTimes++;
                if(tryTimes ==2)
                    throw se;
            }
        }
    }

    public void inforComputer(String name, String introduced, WebElement textComputerName
            , WebElement textIntroduced, WebElement textDiscontinued, WebElement buttonCompany
            , WebElement buttonOption3) {

        WebElement txtComputerName = textComputerName;
        txtComputerName.clear();
        txtComputerName.sendKeys(name);

        WebElement txtIntroduced = textIntroduced;
        txtIntroduced.sendKeys(introduced);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(date);

        WebElement txtDiscontinued = textDiscontinued;
        txtDiscontinued.sendKeys(formattedDate);

        WebElement btnSelectCompany = buttonCompany;
        btnSelectCompany.click();
        WebElement btnOption3 = buttonOption3;
        btnOption3.click();

    }
    public void searchInfor(String name, WebElement element1, WebElement element2) throws InterruptedException {
        WebElement searchbox = element2;
        searchbox.sendKeys(name);

        setWait(2000);

        WebElement btnFilter = element1;
        btnFilter.click();
    }
    public void setWait(int number) throws InterruptedException {
        Thread.sleep(number);
    }
    public static WebElement ListComputer(int number, @NonNull WebDriver driver){
        WebElement chuoi = driver.findElement(By.xpath("//table[@class='computers zebra-striped']/tbody/tr["+number+"]//a"));
        return chuoi;
    }
    public void printListComputer(){
        List<WebElement> myElements = edriver.findElements(By.xpath("//table[@class='computers zebra-striped']/tbody/tr//a"));
        for(WebElement e : myElements) {
            System.out.println(e.getText());
        }
    }
    public static Boolean assert_equal(String chuoi, String expected){
        if(chuoi.equals(expected)){
            return true;
        }
        return false;
    }
    public static Boolean getListComputer(String expected){
        List<WebElement> myElements = edriver.findElements(By.xpath("//table[@class='computers zebra-striped']/tbody/tr//a"));
        for(WebElement e : myElements) {
            if(assert_equal(e.getText(), expected)){
                return true;
            }
        }
        return false;
    }
    public static String getListComputerName(String expected){
        List<WebElement> myElements = edriver.findElements(By.xpath("//table[@class='computers zebra-striped']/tbody/tr//a"));
        for(WebElement e : myElements) {
            if(assert_equal(e.getText(), expected)){
                return e.getText();
            }
        }
        return "0";
    }
    public void printCheckPass(String expected){
        if(getListComputer(expected))
            System.out.println("ket qua sau khi kiem tra: Passed");
        else if (!getListComputer(expected)) {
            System.out.println("ket qua sau khi kiem tra: Failed");
        }else
            System.out.println("ket qua sau khi kiem tra: error");
    }


}
