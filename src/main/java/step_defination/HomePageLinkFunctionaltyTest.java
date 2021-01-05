package step_defination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageLinkFunctionaltyTest {
	WebDriver driver;
	
	@Given("user is already in homePage")
	public void user_is_already_in_home_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sbaru\\Desktop\\Transfotech\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/newtours/index.php");
	}

	@When("user clicks register link")
	public void user_clicks_register_link() {
		driver.findElement(By.linkText("REGISTER")).click();
	}
	
	@Then("Register page should open")
	public void register_page_should_open() {
		 Assert.assertEquals(driver.getTitle(), "Register: Mercury Tours");
		    driver.close();
	}



	@When("user click flight link")
	public void user_click_flight_link() {
		driver.findElement(By.linkText("Flights")).click();
	    
	}

	@Then("Flight finder page should open")
	public void flight_finder_page_should_open() {
		Assert.assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
	    driver.close();
	}
		
	}


