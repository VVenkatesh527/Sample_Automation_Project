package com.app.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.app.FactoryManager.DriverManager;

public class BasePage extends DriverManager {

	public static By loginlocator = By.xpath("//span[text()='Log In']");
	public static By userIdlocator = By.cssSelector("input#userId");
	public static By passwordLocator = By.xpath("//input[@name='Password']");
	public static By loginButton = By.cssSelector("button#login-button");
	public static By transferMethodsLocator = By.xpath("//ul[@class='module_tabs']//li//a[text()='Transfer Methods']");

	private String user = "velurisanju@gmail.com";
	private String password = "Navaneeth@2023";

	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String loginIntoApplication(String user, String password) {

		driver().findElement(userIdlocator).sendKeys(user);
		driver().findElement(passwordLocator).sendKeys(password);
		implicityWait(loginButton, 10);
		driver().findElement(loginButton).click();
		
		return driver().getTitle();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
