package Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.UUID;
public class Scopistobookstoresettings {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static void setup() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver111.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/books");
    }
    public static String navigateToHomePage(){
        driver.get("https://demoqa.com/books");
        driver.get(driver.getCurrentUrl());
        try {
            System.out.println("Viewing Landing Page");
        } catch (Exception e) {
            System.out.println("Landing Page Broken");
        }
        return driver.getCurrentUrl();
    }

    public static String register(){
        String uuid = UUID.randomUUID().toString();
        WebElement login = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]"));
        login.click();
        WebElement newuser = driver.findElement(By.xpath("//*[@id=\"newUser\"]"));
        newuser.click();
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
        firstName.sendKeys(uuid);
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"lastname\"]"));
        lastName.sendKeys(uuid);
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
        userName.sendKeys(uuid);
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("V12345a!");
        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#recaptcha-anchor > div.recaptcha-checkbox-border"))).click();
        WebElement register = driver.findElement(By.xpath("//*[@id=\"register\"]"));
        register.click();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();
        driver.quit();

        return driver.getCurrentUrl();
    }
    public static void end() {
        driver.quit();
    }
}