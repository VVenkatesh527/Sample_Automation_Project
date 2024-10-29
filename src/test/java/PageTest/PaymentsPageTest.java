package PageTest;

import org.openqa.selenium.ElementNotInteractableException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.app.FactoryManager.DriverManager;
import com.app.Pages.BasePage;
import com.app.Pages.ProductPage;

public class PaymentsPageTest extends DriverManager{

	SoftAssert softAssert = new SoftAssert();
	
	@BeforeTest
	public void launch() {
		launchBrowser("chrome");
		pageInitialzation();
		
	}
	
	@Test
	public void addUsBankAccountTest() {
		System.out.println(driver().getTitle());
		driver().findElement(BasePage.loginlocator).click();
		String actual = basePage.loginIntoApplication("velurisanju@gmail.com","Navaneeth@2023").trim();
		
		softAssert.assertEquals(actual, "Account Security");
		if(driver().findElement(ProductPage.testLocator).isDisplayed()) {
		String testText = driver().findElement(ProductPage.testLocator).getText();
		driver().findElement(ProductPage.testLocator).sendKeys(testText);
		}
		ProductPage.clickOnDashBoardFeature("Payments");
		ProductPage.selectAddTransferMethodDropdown("Add US Bank Account");
		ProductPage.selectAccountType("Personal Checking",0);
		ProductPage.addUSBankAccount();
		ProductPage.clickOnPaymentsFeature("Cash Account");
		
		
	}
	
	@Test
	public void cashAccountTest() {
		System.out.println(driver().getTitle());
		driver().findElement(BasePage.loginlocator).click();
		String actual = basePage.loginIntoApplication("velurisanju@gmail.com","Navaneeth@2023").trim();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actual, "Account Security");
		if(driver().findElement(ProductPage.testLocator).isDisplayed()) {
		String testText = driver().findElement(ProductPage.testLocator).getText();
		driver().findElement(ProductPage.testLocator).sendKeys(testText);
		}
		ProductPage.clickOnDashBoardFeature("Payments");
		ProductPage.clickOnPaymentsFeature("Cash Account");
		
		ProductPage.clickOnElement(ProductPage.withdrawLocator,5);
			if(driver().findElement(ProductPage.withdrawFundsHeaderLocator).isDisplayed()){
				try {
					explictWait(ProductPage.noteLocator, 5);
					if(driver().findElement(ProductPage.noteLocator).isDisplayed()) {
						driver().findElement(ProductPage.clickHereLocator).click();
					}
					else {
						System.out.println("WebElement not found"); 
					}
			}
			catch(ElementNotInteractableException e) {
				System.out.println("Element not Interactable   "+ e.getMessage());
			}
		}
		softAssert.assertTrue(driver().findElement(ProductPage.addNonUSBankAccountLocator).isDisplayed(), "Add a Non-US Bank Account");
			
	}
	
		
	@AfterTest
	public void tearDown()
	{
		destroyPageObjects();
		driver().quit();
	}
}
