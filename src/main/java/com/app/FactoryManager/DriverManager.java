package com.app.FactoryManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.app.Pages.BasePage;
import com.app.Pages.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private static ThreadLocal<WebDriver> tldriver =new ThreadLocal<WebDriver>();
	protected static ProductPage  productSearch = null;
	protected static BasePage  basePage = null;
	
	
	public static  WebDriver driver() {
		return tldriver.get();
				
	}
	
	public static void pageInitialzation() {
		
	productSearch = new ProductPage(driver());
	basePage = new BasePage(driver());
	}

	
	public static ThreadLocal<WebDriver> launchBrowser(String browser)
	{
		
		switch(browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
			
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			tldriver.set(new EdgeDriver());
			break;
		}
		driver().manage().deleteAllCookies();
		driver().manage().window().maximize();
		driver().get("https://qa.guru.com/");
		return tldriver;
	}
	
	public static void destroyPageObjects() {
		
		productSearch =null;
		basePage = null;
	}
	
	public static void implicityWait(By locator,int i) {
		
		if(!driver().findElement(locator).isDisplayed()) {
		
		driver().manage().timeouts().implicitlyWait(Duration.ofSeconds(i));
		driver().findElement(locator).click();
		
		}
		else {
			System.out.println("The Given locator not found");
		}
		
	}
	
}
