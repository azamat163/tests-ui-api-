package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

/**
 * Created by azamat on 20.03.17.
 */
public class CreateAuthAccPage {
    private WebDriver driver;

    public CreateAuthAccPage(WebDriver driver){
        this.driver = driver;
    }

    public By first_name = By.xpath("//input[@id = 'firstName']");
    public By last_name = By.xpath("//input[@id = 'lastName']");
    public By company = By.xpath("//input[@id = 'company']");
    public By email = By.xpath("//input[@id = 'email']");
    public By phone = By.xpath("//input[@id = 'phone']");
    public By password = By.xpath("//input[@id = 'password']");
    public By confirmPassword = By.xpath("//input[@id = 'confirmPassword']");
    public By create_acc = By.xpath("//button[@id = 'submit']");
    public By load_demo_data = By.xpath("//button[@id = 'c']");
    public By user_avatar = By.xpath("//div[@id = 'user-avatar']");
    public By sign_out = By.xpath("//span[text() = ' Sign Out']");
    public By sign_in_assert_text = By.xpath("//button[text() = 'Sign In']");

    public CreateAuthAccPage sendKeys(By element,String text){
        driver.findElement(element).sendKeys(text);
        return new CreateAuthAccPage(driver);
    }

    public CreateAuthAccPage click(By element){
        driver.findElement(element).click();
        return new CreateAuthAccPage(driver);
    }

    public CreateAuthAccPage  Asserttext(String text){
        assertEquals("error", driver.findElement(sign_in_assert_text).getText(),text);
        return new CreateAuthAccPage(driver);
    }

}
