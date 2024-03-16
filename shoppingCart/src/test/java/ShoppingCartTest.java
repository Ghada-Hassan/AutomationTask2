import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ShoppingCartTest {
    WebDriver driver;
    String sauceDemo="https://www.saucedemo.com/";
    String userName="standard_user";
    By username = By.id("user-name");
    By password = By.id("password");
    By button = By.id("login-button");
    String itemName = "Sauce Labs Bolt T-Shirt";
    String buttonn="//div[text()=\"%s\"]/parent::a/parent::div/following-sibling::div/button";
    String itemButton=String.format(buttonn,itemName);
    By shoppingCart = By.id("shopping_cart_container");
    By name = By.id("item_1_title_link");
    String pass = "secret_sauce";
    String expectedProductName = "Sauce Labs Bolt T-Shirt";


    @Test
    public void fillCartSuccessfully() {
        driver = new ChromeDriver();
        driver.get(sauceDemo);
        driver.findElement(username).sendKeys(userName);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(button).click();
        driver.findElement(By.xpath(itemButton)).click();
        driver.findElement(shoppingCart).click();
        WebElement element = driver.findElement(name);
        String actualProductName = element.getText();
        Assert.assertEquals(actualProductName, expectedProductName);

    }
    @AfterClass
    public void end(){
        driver.quit();
    }
}
