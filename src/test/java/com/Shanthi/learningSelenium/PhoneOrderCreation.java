package com.Shanthi.learningSelenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PhoneOrderCreation {
	WebDriver wd;

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setUp() {

		// Basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome Drivers\\chromedriver.exe");

		// intialise webdriver instance
		wd = new ChromeDriver();

		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// navigate to a page
		wd.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}

	@Test
	public void verifyLoginDetails() {
		WebElement emailInputField = wd.findElement(By.cssSelector("#input-email"));
		WebElement passwordInputField = wd.findElement(By.cssSelector("#input-password"));
		WebElement loginBtn = wd.findElement(By.cssSelector("input[type='submit']"));

		emailInputField.sendKeys("ammashan@gmail.com");
		passwordInputField.sendKeys("automation");
		loginBtn.submit();

		String titleOfPage = wd.getTitle();
		System.out.println(titleOfPage);
		Assert.assertEquals(titleOfPage, "My Account", "Login  failed");

		WebElement selectPhoneandPDA = wd.findElement(By.cssSelector("div.collapse li:nth-of-type(6) a"));
		selectPhoneandPDA.click();
		titleOfPage = wd.getTitle();
		System.out.println(titleOfPage);
		Assert.assertEquals(titleOfPage, "Phones & PDAs", "Not on right page");

		WebElement selectPalmTreoPro = wd.findElement(By.cssSelector("div#product-category div.product-layout:last-of-type div.caption a"));
		selectPalmTreoPro.click();
		WebElement addToCartBtn = wd.findElement(By.cssSelector("div#product button"));
		addToCartBtn.click();
		titleOfPage = wd.getTitle();
		Assert.assertEquals(titleOfPage, "Palm Treo Pro", "Not on right page");
		sleep();
		WebElement clickItemCart = wd.findElement(By.cssSelector("button.btn.btn-inverse.btn-block.btn-lg.dropdown-toggle"));
		clickItemCart.click();
		System.out.println(clickItemCart.getText());
		WebElement clickCheckBox = wd.findElement(By.cssSelector("i.fa.fa-share"));
		clickCheckBox.click();
		titleOfPage = wd.getTitle();
		Assert.assertEquals(titleOfPage, "Checkout", "Not on right page");

		WebElement newAddressField = wd.findElement(By.cssSelector("div.radio input[value='new']"));
		newAddressField.click();

		WebElement firstNameField = wd.findElement(By.cssSelector("input#input-payment-firstname"));
		WebElement lastNameField = wd.findElement(By.cssSelector("input#input-payment-lastname"));
		WebElement address1Field = wd.findElement(By.cssSelector("input#input-payment-address-1"));
		WebElement cityField = wd.findElement(By.cssSelector("input#input-payment-city"));
		WebElement postCodeField = wd.findElement(By.cssSelector("input#input-payment-postcode"));

		firstNameField.sendKeys("Shanthi");
		lastNameField.sendKeys("Ammasaiappan");
		address1Field.sendKeys("123, Hensall road");
		cityField.sendKeys("Downtown");
		postCodeField.sendKeys("L5A3M4");
		selectElementByVisibleText(wd.findElement(By.cssSelector("select#input-payment-country")), "Canada");
		selectElementByVisibleText(wd.findElement(By.cssSelector("select#input-payment-zone")), "Nunavut");
		WebElement clickContinue1Btn = wd.findElement(By.cssSelector("input#button-payment-address.btn.btn-primary"));
		clickContinue1Btn.click();

		WebElement clickExistingAddress = wd.findElement(By.cssSelector("div.radio input[value='existing']"));
		clickExistingAddress.click();
		System.out.println(clickExistingAddress.isSelected());
		WebElement clickContinue2Btn = wd.findElement(By.cssSelector("input#button-shipping-address.btn.btn-primary"));
		clickContinue2Btn.click();

		WebElement selectFlatRate = wd.findElement(By.cssSelector("input[value='flat.flat']"));
		System.out.println(selectFlatRate.isSelected());
		WebElement writeComment = wd.findElement(By.cssSelector("textarea[name='comment']"));
		writeComment.sendKeys("I like this product.");
		WebElement clickContinue3Btn = wd.findElement(By.cssSelector("div.buttons input#button-shipping-method.btn.btn-primary"));
		clickContinue3Btn.click();

		WebElement selectCashOnDelivery = wd.findElement(By.cssSelector("div.radio input[value='cod']"));
		selectCashOnDelivery.isSelected();
		WebElement clickTermsAndCondition = wd.findElement(By.cssSelector("div.buttons input[name='agree']"));
		clickTermsAndCondition.click();
		WebElement clickContinue4Btn = wd.findElement(By.cssSelector("div.buttons input[id='button-payment-method']"));
		clickContinue4Btn.click();

		WebElement checkProductName = wd.findElement(By.cssSelector("div.table-responsive td.text-left >a"));
		sleep();
		System.out.println(checkProductName.getText());
		WebElement checkQuantity = wd.findElement(By.cssSelector("div.panel-collapse.collapse.in tbody td:nth-of-type(3)"));
		System.out.println(checkQuantity.getText());
		WebElement clickConfirmOrder = wd.findElement(By.cssSelector("input#button-confirm"));
		clickConfirmOrder.click();
		sleep();
		titleOfPage = wd.getTitle();
		Assert.assertEquals(titleOfPage, "Your order has been placed!", "Not on right page");
	}

	public void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectElementByVisibleText(WebElement element, String text) {
		Select sc = new Select(element);
		sc.selectByVisibleText(text);
	}

	@AfterMethod
	public void tearDown() {
		// closing the browser
		wd.close();
	}
}
