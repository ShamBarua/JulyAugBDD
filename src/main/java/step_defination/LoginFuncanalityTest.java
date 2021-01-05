package step_defination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFuncanalityTest {
	WebDriver driver;
	
	@Given ("^user is in homePage$")
	public void user_is_in_homePage() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sbaru\\Desktop\\Transfotech\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/newtours/index.php");
	}

	@When ("^user provides valid username and valid password$")
	public void user_provides_valid_username_and_valid_password () {
		
		driver.findElement(By.name("userName")).sendKeys("test123");
		driver.findElement(By.name("password")).sendKeys("123");	
	}
	
	@And ("^user clicks submit button$")
	public void user_clicks_submit_button () {
		driver.findElement(By.name("submit")).click();	
	}
	
	@Then ("^login should happen and login success message should be displayed$")
	public void login_should_happen_and_login_success_message_should_be_displayed () {
		String actualLoginSuccessMsg = driver.findElement(By.
				xpath("//h3[text()='Login Successfully']")).getText(); 
		String expectedLoginSuccessMsg = "Login Successfully";
		Assert.assertEquals(expectedLoginSuccessMsg, actualLoginSuccessMsg);
		driver.close();
	}
	
	@When("user provides invalid username and invalid password")
	public void user_provides_invalid_username_and_invalid_password() {
		driver.findElement(By.name("userName")).sendKeys("Tom1");
		driver.findElement(By.name("password")).sendKeys("1234");	    
	}

	@Then("login should not happen  and error message should be displayed")
	public void login_should_not_happen_and_error_message_should_be_displayed() {
		String actualErrorMsg = driver.findElement(By.xpath("//span[contains(text(),"
				+ "'Enter your userName and password correct')]")).getText().trim();
		Assert.assertEquals(actualErrorMsg, "Enter your userName and password correct");
		driver.close();
	}

	
}
