package Practice.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class JavaScriptTest {
  
	WebDriver w;
	
  @BeforeTest
  public void beforeTest() {
	  
	    String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
		w = new ChromeDriver();
		w.manage().window().maximize();
  }

  @Test
  public void JavaScriptExecutor_Test() throws InterruptedException {
	  
	  w.get("http://demo.automationtesting.in/Register.html");
	  
	  WebElement firstname = w.findElement(By.cssSelector("input[ng-model='FirstName']"));
	  WebElement lastname = w.findElement(By.cssSelector("input[ng-model='LastName']"));
	  
	  JavascriptExecutor js = (JavascriptExecutor) w ;  //create JavascriptExecutor
	  
	  //Enter Value..
	  
	  js.executeScript("arguments[0].value='Abc'", firstname);
	  js.executeScript("arguments[0].value='xyz'", lastname);
	  
	  Thread.sleep(2000);
	  //create alert by JavascriptExecutor
	  
	  js.executeScript("alert('Login Page...!')");  
	  
	  Thread.sleep(2000);
	  
	  try {
	  w.switchTo().alert().accept();    //accept alert...
	  System.out.println("Alert Found...!");
	  }
	  catch (NoAlertPresentException a) {System.out.println("Alert not found");};
	  
	  //Refresh
	  
	  Thread.sleep(2000);
	  js.executeScript("history.go(0)");
	  
	  
	  //Get Title of a WebPage
	  
	  String getTitle = js.executeScript("return document.title").toString();
	  System.out.println(getTitle);
	  
	  //Page scroll down and up
	  
	  //Scroll down
	  Thread.sleep(1000);
	  js.executeScript("window.scrollBy(0,300)");
	  
	  //Scroll up
	  Thread.sleep(1000);
	  js.executeScript("window.scrollBy(0,-300)");
	  
	  Thread.sleep(1000);
	  js.executeScript("window.scrollBy(0,800)");
	  
	  //Perform Click on button 
	  
	  WebElement button = w.findElement(By.id("submitbtn"));
	  
	  Thread.sleep(2000);
	  js.executeScript("arguments[0].click()", button);
	  
	  
  }
  
  @AfterTest
  public void afterTest() {
  }

}
