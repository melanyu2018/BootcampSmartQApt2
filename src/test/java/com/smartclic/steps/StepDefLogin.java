package com.smartclic.steps;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefLogin {

    static WebDriver driver;
    static int TIME_OUT = 10;
    static JavascriptExecutor js;

    @BeforeAll
    public static void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_OUT));
        driver.manage().window().maximize();
        js = (JavascriptExecutor)driver;
    }


    /**Scenario 1 ***/


    @Given("user is on Home Page")
    public void user_is_on_home_page() {
        driver.get("https://demo.nopcommerce.com/");
    }

    @When("user navigate to login page")
    public void user_navigate_to_login_page() {
        driver.findElement(By.linkText("Log in")).click();
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        driver.findElement(By.id("Email")).sendKeys("melany.meylin04@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("melany.meylin04@gmail.com");
        //driver.findElement(By.xpath("//button[text()='Log in']")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();
    }

    @Then("user can see a logout link")
    public void user_can_see_a_logout_link() {
        WebElement linkLogout = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT))
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log out")));
    }


    /**Scenario 2**/

    @When("user navigate on {string}")
    public void user_navigate_on(String url) {
        driver.navigate().to(url);
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String user, String pass) {
        driver.findElement(By.id("Email")).sendKeys(user);
        driver.findElement(By.id("Password")).sendKeys(pass);
        driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();

        js.executeScript("window.scrollTo(0, 200)");
    }


    @After
    public void takeScreen(Scenario scenario) {

        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

    }

    @AfterAll
    public  static void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }

}
