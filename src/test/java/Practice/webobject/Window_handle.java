package Practice.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.testng.annotations.AfterTest;

public class Window_handle {
  
	WebDriver w;
	
  @BeforeTest
  public void beforeTest() {

			String projectPath=System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
		    w = new ChromeDriver();
			w.manage().window().maximize();	
  }

  @Test
  public void f() throws IOException {
	  
	  
	  ((SafariDriver) w.switchTo()).newWindow(WindowType.WINDOW);

	  Set<String> handles=w.getWindowHandles();

	  Iterator<String> it=handles.iterator();

	  String parentWindowId = it.next();

	  String childWindow =it.next();

	  w.switchTo().window(childWindow);

	  w.get("https://rahulshettyacademy.com/");

	  String courseName = w.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))

	  .get(1).getText();

	  w.switchTo().window(parentWindowId);

	  WebElement name=w.findElement(By.cssSelector("[name='name']"));

	  name.sendKeys(courseName);

	  //Screenshot

	  File file=name.getScreenshotAs(OutputType.FILE);

	  FileUtils.copyFile(file, new File("logo.png"));

	  //driver.quit();

	  //GEt Height & Width

	  System.out.println(name.getRect().getDimension().getHeight());

	  System.out.println(name.getRect().getDimension().getWidth());
	 
  }
  
  @AfterTest
  public void afterTest() {
  }

}
