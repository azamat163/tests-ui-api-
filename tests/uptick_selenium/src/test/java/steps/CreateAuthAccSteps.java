package steps;

import PageObject.CreateAuthAccPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.JsonParseUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by azamat on 20.03.17.
 */
public class CreateAuthAccSteps {
private  String baseUrl = "https://testkk-crm2.azurewebsites.net/signup";
private WebDriver driver;
 CreateAuthAccPage createAuthAccPage = new CreateAuthAccPage(driver);
    JsonParseUtils jsonParse = new JsonParseUtils();


    @Given("^I open create Page$")
    public void gotoUptick() throws Throwable{
        try {
            jsonParse.jsonParseUtils();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().setSize(new Dimension(1920,1080));
            driver.get(baseUrl);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("^I enter first name: \"([^\"]*)\"$")
    public void enter_first_name(String text) throws Throwable{
        try{
            WebElement webElement = (new WebDriverWait(driver,6000)).until(ExpectedConditions.visibilityOfElementLocated(createAuthAccPage.first_name));
            webElement.sendKeys(text);
        }catch(Throwable e){
            e.printStackTrace();
        }
    }

    @And("^I enter last name: \"([^\"]*)\"$")
    public void enter_last_name(String text) throws Throwable{
        try{
            WebElement webElement = (new WebDriverWait(driver,6000)).until(ExpectedConditions.visibilityOfElementLocated(createAuthAccPage.last_name));
            webElement.sendKeys(text);
        }catch(Throwable e){
            e.printStackTrace();
        }
    }

    @And("^I enter company: \"([^\"]*)\"$")
    public void enter_company(String text) throws Throwable{
        try{
            WebElement webElement = (new WebDriverWait(driver,6000)).until(ExpectedConditions.visibilityOfElementLocated(createAuthAccPage.company));
            webElement.sendKeys(text);
        }catch(Throwable e){
            e.printStackTrace();
        }
    }

    @And("^I enter email: \"([^\"]*)\"$")
    public void enter_email(String text) throws Throwable{
        try{
            WebElement webElement = (new WebDriverWait(driver,6000)).until(ExpectedConditions.visibilityOfElementLocated(createAuthAccPage.email));
            webElement.sendKeys(text);
        }catch(Throwable e){
            e.printStackTrace();
        }
    }

    @And("^I enter mobile phone: \"([^\"]*)\"$")
    public void enter_phone(String text) throws Throwable{
        try{
            WebElement webElement = (new WebDriverWait(driver,6000)).until(ExpectedConditions.visibilityOfElementLocated(createAuthAccPage.phone));
            webElement.sendKeys(text);
        }catch(Throwable e){
            e.printStackTrace();
        }
    }

    @And("^I enter password: \"([^\"]*)\"$")
    public void enter_password(String text) throws Throwable{
        try{
            WebElement webElement = (new WebDriverWait(driver,6000)).until(ExpectedConditions.visibilityOfElementLocated(createAuthAccPage.password));
            webElement.sendKeys(text);
        }catch(Throwable e){
            e.printStackTrace();
        }
    }

    @And("^I enter confirm password: \"([^\"]*)\"$")
    public void enter_confirm_password(String text) throws Throwable{
        try{
            WebElement webElement = (new WebDriverWait(driver,6000)).until(ExpectedConditions.visibilityOfElementLocated(createAuthAccPage.confirmPassword));
            webElement.sendKeys(text);
        }catch(Throwable e){
            e.printStackTrace();
        }
    }

    @When("^I click button with name Create Account$")
    public void click_create_acc() throws Throwable{
    try{
        Thread.sleep(10000);
        WebDriverWait wait = new WebDriverWait(driver,6000);
        wait.until(ExpectedConditions.presenceOfElementLocated(createAuthAccPage.create_acc)).click();
    }catch (Throwable e){
        e.printStackTrace();
      }
    }

    @And("^I click button with name Load Demo data$")
    public void click_load_demo() throws Throwable{
    try{
        WebDriverWait wait = new WebDriverWait(driver,6000);
        wait.until(ExpectedConditions.elementToBeClickable(createAuthAccPage.load_demo_data)).click();
    }catch (Throwable e){
        e.printStackTrace();
    }
    }

    @And("^I click button on menu profile$")
    public void click_button_user_avatar() throws Throwable{
    try{
        WebDriverWait wait = new WebDriverWait(driver,6000);
        wait.until(ExpectedConditions.elementToBeClickable(createAuthAccPage.user_avatar)).click();
    }catch (Throwable e){
        e.printStackTrace();
        }
    }

    @And("^I click button with name Sign Out$")
    public void click_button_sign_out() throws Throwable{
        try{
            WebDriverWait wait = new WebDriverWait(driver,6000);
            wait.until(ExpectedConditions.elementToBeClickable(createAuthAccPage.sign_out)).click();
        }catch (Throwable e){
            e.printStackTrace();
        }
    }

    @Then("^I should be see button with name Sign In$")
    public void assert_sign_in() throws Throwable{
        try{
            createAuthAccPage.Asserttext("Sign In");
        }catch(Throwable e){
            e.printStackTrace();
        }
    }
    @After
     public void tearDown() throws Throwable {
         driver.close();
    }

    }
