import Setup.Scopistobookstoresettings;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static Setup.Scopistobookstoresettings.driver;
import static Setup.Scopistobookstoresettings.wait;

public class SeleniumTest {
    @BeforeClass
    public void beforeclass(){
        Scopistobookstoresettings.setup();
    }
    @Test
    public void testforverificationHomepage(){
    Assert.assertEquals(Scopistobookstoresettings.navigateToHomePage(),"https://demoqa.com/books");
    }
    @Test
    public void registerFeature(){
    Assert.assertEquals(Scopistobookstoresettings.register(),"https://demoqa.com/register");
    }
    @Test
    public void loginAndLogout() {
        WebElement login = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]"));
        login.click();
        WebElement usernameField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[2]/input"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement loginButton = driver.findElement(By.id("login"));

        usernameField.sendKeys("testing");
        passwordField.sendKeys("V12345a!");
        loginButton.click();
    try {
        Thread.sleep(2000);
    } catch (Exception e) {
        e.printStackTrace();
    }
        WebElement logInUsername = driver.findElement(By.id("userName-value"));
        String expectedUsername = "Testing";
        String actualUsername = logInUsername.getText();
        Assert.assertEquals(actualUsername, expectedUsername);
        WebElement logoutButton = driver.findElement(By.id("submit"));
        logoutButton.click();
        WebElement loginlocator = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[1]/h5"));
        Assert.assertTrue(loginlocator.isDisplayed());
    }
    @Test
    public void loginSearchAndAddToCollection() {
        WebElement login = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]"));
        login.click();
        WebElement usernameField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[2]/input"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement loginButton = driver.findElement(By.id("login"));

        usernameField.sendKeys("testing");
        passwordField.sendKeys("V12345a!");
        loginButton.click();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement bookstoreLink = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/button"));
        bookstoreLink.click();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement searchInput = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/input"));
        searchInput.sendKeys("git");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement firstSearchResult = driver.findElement(By.linkText("Git Pocket Guide"));
        firstSearchResult.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement addToCollectionButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button"));
        addToCollectionButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Alert alert = driver.switchTo().alert();
        alert.getText();
        alert.accept();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement backToBookStoreButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[1]/button"));
        backToBookStoreButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement collectionLink = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]/span"));
        collectionLink.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement addedBook = driver.findElement(By.linkText("Git Pocket Guide"));
        Assert.assertTrue(addedBook.isDisplayed());
    }

    @Test
    public void deleteBookFromCollection() {
        WebElement login = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]"));
        login.click();
        WebElement usernameField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[2]/input"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement loginButton = driver.findElement(By.id("login"));

        usernameField.sendKeys("testing");
        passwordField.sendKeys("V12345a!");
        loginButton.click();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement bookstoreLink = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/button"));
        bookstoreLink.click();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement searchInput = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/input"));
        searchInput.sendKeys("git");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement firstSearchResult = driver.findElement(By.linkText("Git Pocket Guide"));
        firstSearchResult.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement addToCollectionButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button"));
        addToCollectionButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Alert alert = driver.switchTo().alert();
        alert.getText();
        alert.accept();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement backToBookStoreButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[1]/button"));
        backToBookStoreButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement collectionLink = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]/span"));
        collectionLink.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement deleteAll = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[3]/button"));
        deleteAll.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement modalbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));

        WebElement deleteOK = modalbox.findElement(By.xpath(".//*[@id=\"closeSmallModal-ok\"]"));
        deleteOK.click();
    }

    @Test
    public void deleteUser() {
        WebElement login = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]"));
        login.click();
        WebElement usernameField = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[2]/input"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement loginButton = driver.findElement(By.id("login"));

        usernameField.sendKeys("testing");
        passwordField.sendKeys("V12345a!");
        loginButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement deleteuser = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[2]/button"));
        deleteuser.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement modalbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));

        WebElement deleteOK = modalbox.findElement(By.xpath(".//*[@id=\"closeSmallModal-ok\"]"));
        deleteOK.click();
    }


  @AfterClass
    public void afterclass(){
    Scopistobookstoresettings.end();
    }

}
