package Practice.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Screenshot_code {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
		w = new ChromeDriver();
		w.manage().window().maximize();

	}

	@Test
	public void screenShot_code() throws Exception {

		String projectPath = System.getProperty("user.dir");
		String screenshotPath = projectPath + "\\Screenshot\\RegisterPage.png";

		w.get("http://demo.automationtesting.in/Register.html");
		w.findElement(By.cssSelector("input[ng-model='FirstName']")).sendKeys("abc");
		w.findElement(By.cssSelector("input[ng-model='LastName']")).sendKeys("xyz");

		TakesScreenshot ts = (TakesScreenshot) w;

		File f = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(f, new File(screenshotPath));

	}

	@AfterTest
	public void afterTest() {

		w.quit();
	}

}
