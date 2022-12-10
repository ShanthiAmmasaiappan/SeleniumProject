package com.Shanthi.learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegisterAccount {
	WebDriver wd;

	@BeforeMethod
	public void setUp() {

		// Basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome Drivers\\chromedriver.exe");

		// intialise webdriver instance
		wd = new ChromeDriver();

		// Launch a page
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

	}

	@Test
	public void verifyLoginTest() {
		WebElement firstNameField = wd.findElement(By.cssSelector("input#input-firstname.form-control"));
		WebElement lastNameField = wd.findElement(By.cssSelector("#input-lastname"));
		WebElement emailInputField = wd.findElement(By.cssSelector("#input-email"));
		WebElement telephoneField = wd.findElement(By.cssSelector("#input-telephone"));

		WebElement passwordInputField = wd.findElement(By.cssSelector("#input-password"));
		WebElement confirmPasswordInputField = wd.findElement(By.cssSelector("#input-confirm"));
		WebElement selectSubscribe = wd.findElement(By.cssSelector("label.radio-inline>input[value='0']"));
		WebElement selectAgreeBox = wd.findElement(By.cssSelector("div.pull-right > input[value='1']"));
		WebElement continueBtn = wd.findElement(By.cssSelector("input[type='submit']"));

		// Send a text into an input field
		firstNameField.sendKeys("Shanthi");
		lastNameField.sendKeys("Ammasaiappan");
		emailInputField.sendKeys("abcd@gmail.com");
		telephoneField.sendKeys("1234567890");
		passwordInputField.sendKeys("automation");
		confirmPasswordInputField.sendKeys("automation");
		selectSubscribe.click();
		selectAgreeBox.click();
		continueBtn.click();

	}

	@AfterMethod
	public void tearDown() {
		// closing the browser
		wd.close();
	}
}
