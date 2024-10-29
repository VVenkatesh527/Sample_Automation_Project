package PageTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.app.FactoryManager.DriverManager;
import com.app.Pages.BasePage;
import com.app.Pages.ProductPage;

public class PaymentsPageTest extends DriverManager{
	
public static WebDriver driver;
	
	@BeforeTest
	public void launch() {
		launchBrowser("chrome");
		pageInitialzation();
		
		
	}
	
	

	@Test
	public void HomePageTitleTest() {
		System.out.println(driver().getTitle());
		driver().findElement(BasePage.loginlocator).click();
		String actual = basePage.loginIntoApplication("velurisanju@gmail.com","Navaneeth@2023").trim();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actual, "Account Security");
		if(driver().findElement(ProductPage.testLocator).isDisplayed()) {
		String testText = driver().findElement(ProductPage.testLocator).getText();
		driver().findElement(ProductPage.testLocator).sendKeys(testText);
		}
		ProductPage.clickOnDashBoardFeature("Transfer Methods");
		ProductPage.selectAddTransferMethodDropdown("Add US Bank Account");
		ProductPage.selectAccountType("Personal Checking",0);
		ProductPage.addUSBankAccount();
		
		
		
	}
	
		
	@AfterTest
	public void tearDown()
	{
		destroyPageObjects();
		driver().quit();
	}
}
