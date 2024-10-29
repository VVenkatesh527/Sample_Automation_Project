package com.app.Pages;

import java.util.ArrayList;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.app.FactoryManager.DriverManager;

public class ProductPage extends DriverManager {

	public static By ElementTitle = By.xpath("//h1[text()='Payments']");
	public static By paymentsLocator = By.xpath("//nav[contains(@class,'adminOwner')]//a[text()='Payments']");
	public static By testLocator = By.cssSelector("label.stackedLabel");
	public static By list = By.cssSelector("select#accountType option[value='']");
	public static By accountHolderNameLocator = By.xpath("//label[contains(text(),'Account Holder')]//following-sibling::input");
	public static By routingNumberLocator = By.xpath("//label[contains(text(),'Routing')]//following-sibling::input[@type='text']");
	public static By accountNumberLocator = By.xpath("//label[text()='Account Number']//following-sibling::input[@type='text']");
	public static By confirmAccountNumberLocator = By.xpath("//label[text()='Confirm Account Number']//following-sibling::input[@type='text']");
	public static By phoneLocatoor = By.xpath("//input[@type='tel']");
	public static By uploadFileLocator = By.xpath("//div[contains(@class,'c-fileUpload')]//button[contains(@class,'secondary_btn')]//following-sibling::button");
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	
	public static void clickOnDashBoardFeature(String input) {
		try {
			implicityWait(ElementTitle, 5);
			
			WebElement element = driver().findElement(By.xpath("//nav[contains(@class,'adminOwner')]//a[text()='" + input + "']"));
			element.click();
			
		} catch (ElementClickInterceptedException e) {
			System.out.println(e.getLocalizedMessage());
		}

	}
	public static void selectAddTransferMethodDropdown(String value) {
		if(!value.isBlank()&&!value.isEmpty()) {
			driver().findElements(By.xpath("//ul[@class='module_list dropdown-menu']//li//a[contains(text(),'"+value+"')]"));
		}else {
			System.out.println("value should not be empty");
		}
		
	}
	
	public static void selectAccountType(String input,int value) {
		int accountTypeSize =driver().findElements(list).size();
		ArrayList<String> accountTypes = new ArrayList<>();
		for(int i = 0 ;i<accountTypeSize ; i++) {
			accountTypes.add(driver().findElements(By.cssSelector("select#accountType option[value='"+value+"']")).get(i).getText());
			if(accountTypes.get(i)==input) {
				driver().findElements(By.cssSelector("select#accountType option[value='"+value+"']")).get(i).click();
			}
		}
	}
	
	public static void addUSBankAccount() {
		
		ArrayList<String> details = new ArrayList<>();
		details.add("Account Holder Name");
		details.add("Routing Number");
		details.add("Account Number");
		details.add("Confirm Account Number");
		
		int len = driver().findElements(By.cssSelector("div.inputChunk")).size();
		for(int i = 0 ; i<len ;i++) {
			String accNum ="200"+RandomStringUtils.randomNumeric(8);
			String value = driver().findElements(By.xpath("//label[text()='"+details.get(i)+"']//following-sibling::input")).get(i).getText();
			if(value=="Account Holder Name") {
				String name ="Test"+RandomStringUtils.randomAlphabetic(8);
				driver().findElement(ProductPage.accountHolderNameLocator).sendKeys(name);
				break;
			}
			else if(value=="Routing Number") {
				String num ="0"+RandomStringUtils.randomNumeric(8);
				driver().findElement(ProductPage.routingNumberLocator).sendKeys(num);
				break;
			}
			
			else if(value=="Account Number") {
				
				driver().findElement(ProductPage.accountNumberLocator).sendKeys(accNum);
				break;
			}
			else if(value=="Confirm Account Number") {
				
				driver().findElement(ProductPage.confirmAccountNumberLocator).sendKeys(accNum);
				break;
			}
			
			driver().findElement(phoneLocatoor).sendKeys(RandomStringUtils.randomNumeric(10));
			
			driver().findElement(uploadFileLocator).
			
		}
		
	}
	
	
	

}
