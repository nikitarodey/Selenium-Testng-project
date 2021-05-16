package com.selenium.pageobject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlazeDemo {
	
	public String url = "http://blazedemo.com/";
	public static WebDriver w;
	public static String projectPath = System.getProperty("user.dir");
	
	@FindBy(name="fromPort")
	public WebElement dropdownDepartureCity;
	
	@FindBy(name="toPort")
	public WebElement dropdownDestinationCity;
	
	@FindBy(xpath="/html/body/div[3]/form/div/input")
	public WebElement btnFindFlight;
	
	@FindBy(xpath="/html/body/div[2]/h3")
	public WebElement label1;
	
	@FindBy(css="input[type='submit']")
	public WebElement btChooseThisFlight;
	
	@FindBy(id="inputName")
	public WebElement name;
	
	@FindBy(id="address")
	public WebElement address;
	
	@FindBy(id="city")
	public WebElement city;
	
	@FindBy(id="state")
	public WebElement state;
	
	@FindBy(id="zipCode")
	public WebElement zipCode;
	
	@FindBy(id="cardType")
	public WebElement cardType;
	
	@FindBy(id="creditCardNumber")
	public WebElement cardNum;
	
	@FindBy(id="creditCardMonth")
	public WebElement month;
	
	@FindBy(id="creditCardYear")
	public WebElement year;
	
	@FindBy(id="nameOnCard")
	public WebElement nameOncard;
	
	@FindBy(css="label.checkbox")
	public WebElement checkRememberMe;
	
	@FindBy(css="input[type='submit']")
	public WebElement btnPurchareFlight;
	
	@FindBy(xpath="/html/body/div[2]/h2")
	public WebElement pageLabel2;
	
	@FindBy(xpath="/html/body/div[2]/p[1]")
	public WebElement airline;
	
	@FindBy(xpath="/html/body/div[2]/p[2]")
	public WebElement flightNumber;
	
	@FindBy(xpath="/html/body/div[2]/p[3]")
	public WebElement price;
	
	@FindBy(xpath="/html/body/div[2]/p[4]")
	public WebElement ArbitraryFeesandTaxes;
	
	@FindBy(xpath="/html/body/div[2]/p[5]")
	public WebElement totalCost;

	
	public void openbrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			w=new ChromeDriver();
	    }
		if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			w=new FirefoxDriver();
	    }
				
	}
	
	public void openApplication()
	{
		w.get(url);
	}
	
	public void closeBrowser() {

		w.quit();
	}
	
	public String pageTitle() {
		
		return w.getTitle();
	}
	
	
	public void handelDropdown(WebElement we, String value)
	{
		Select s = new Select(we);
		s.selectByVisibleText(value);
		
	}
	
	public void handleAlert() {
		try {
			w.switchTo().alert().accept();
		} catch (Exception e) {

		}
	}

	public void handleFrame(WebElement we) {
		w.switchTo().frame(we);
	}
	
	public void waitSec(int sec) throws Exception
	{
		sec=sec*1000;
		Thread.sleep(sec);
	}
	
	public String verifyprice(String splitPrice)
	{
		String splitPrice1[]=price.getText().split(" ");
		
		return splitPrice;
		
		//int price_int1=Integer.parseInt(splitPrice1[1]);
		
		
		
		
		
	}
	
	
	
	
	
	
	public void exportPageObjectElements() {
		
		PageFactory.initElements(w, this);
	}
	
	
	public static String takeScreenshot(ITestResult result, String status) throws Exception
	{
		String ScreenshotName= result.getMethod().getMethodName() + ".png";
				
		TakesScreenshot ts = (TakesScreenshot) w;
		File f=ts.getScreenshotAs(OutputType.FILE);
		if(status.equalsIgnoreCase("passed")) {
		FileUtils.copyDirectory(f, new File(projectPath+"\\Screenshot"+"\\BlazeDemo"+ScreenshotName));
		}
		if(status.equalsIgnoreCase("failed")) {
			FileUtils.copyDirectory(f, new File(projectPath+"\\Screenshot"+"\\BlazeDemo"+ScreenshotName));
			}
		return ScreenshotName;
	}

}
