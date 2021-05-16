package com.selenium.pageobject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calculator {

	public String url = "https://juliemr.github.io/protractor-demo/";
	public static WebDriver w;
	public static String projectPath = System.getProperty("user.dir");
    
    
	// WebElement lastName =
	// w.findElement(By.cssSelector("input[ng-model='first']"));

	@FindBy(css = "input[ng-model='first']")
	public WebElement textFirstNumber;

	@FindBy(css = "input[ng-model='second']")
	public WebElement textSecondNumber;

	@FindBy(css = "select[ng-model='operator']")
	public WebElement dropDownListoperator;

	

	@FindBy(id = "gobutton")
	public WebElement button;

	@FindBy(xpath = "/html/body/div/div/form/h2")
	public WebElement output;

	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
			w = new ChromeDriver();
			w.manage().window().maximize();
			w.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			w = new FirefoxDriver();
			w.manage().window().maximize();
			w.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	public String result()
	{
		return output.getText();
	}
	
	
	public void openApplication() {
		w.get(url);
	}

	public void closeApplication() {
		w.quit();
	}

	
	
	public void handleDropdownList(WebElement we, String value) {
		Select s = new Select(we);
		s.selectByVisibleText(value);
	}

	public void handleAlert() {
		try {
			w.switchTo().alert().accept();
		} catch (Exception e) {
		}
	}

	public void handleFrames(WebElement we) {
		w.switchTo().frame(we);
	}

	public void waitsec(int sec) throws Exception {
		sec = sec * 1000;
		Thread.sleep(sec);
	}

	public void takeScreenshot(String fileName) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) w;
		File f = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File(projectPath + "\\Screenshot" + fileName));

	}
	
	public void exportPageobjectElements()
	{
		PageFactory.initElements(w, this);
		
	}

public static String takeScreenShotListenerClass(ITestResult result, String status) throws Exception {
		
		String ScreenshotName = result.getMethod().getMethodName() + ".png";

		TakesScreenshot ts = (TakesScreenshot) w;
		File f = ts.getScreenshotAs(OutputType.FILE);

		if (status.equalsIgnoreCase("passed")) {
			FileUtils.copyFile(f, new File(projectPath + "\\Screenshot\\CalculatorSS\\" + ScreenshotName));
		} else if (status.equalsIgnoreCase("failed")) {
			FileUtils.copyFile(f, new File(projectPath + "\\Screenshot\\CalculatorSS\\" + ScreenshotName));
	}
		return ScreenshotName;
		
		


	
}

		
	}

