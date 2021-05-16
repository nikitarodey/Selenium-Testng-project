package com.selenium.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class BrowserCode {

	String url = "https://www.google.com/";
	WebDriver w;
	String projectPath;

	@BeforeTest
	public void beforeTest() {
		projectPath = System.getProperty("user.dir");

	}

	@Test(priority = 0, description = "Open chrome browser.")
	public void chrome() throws Exception {

		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
		w = new ChromeDriver();
		w.get(url);
		Thread.sleep(2000);

	}

	@Test(priority = 1, description = "Open firefox browser.")
	public void firefox() throws Exception {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\BrowserDriver\\geckodriver.exe");
		w = new FirefoxDriver();
		w.get(url);
		Thread.sleep(2000);

	}

	@Test(priority = 2, description = "Open edge browser.")
	public void edge() throws Exception {

		System.setProperty("webdriver.edge.driver", projectPath + "\\BrowserDriver\\msedgedriver.exe");
		w = new EdgeDriver();
		w.get(url);
		Thread.sleep(2000);

	}

	@AfterTest
	public void afterTest() {
		w.quit();
	}

}
