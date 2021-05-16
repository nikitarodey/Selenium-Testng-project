package Practice.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class KeyboardHandle {
	
	WebDriver w;
  
  @BeforeTest
  public void beforeTest() {
	  
	  String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
	    w = new ChromeDriver();
		w.manage().window().maximize();	
  }

  @Test
  public void keyboardEvent() throws InterruptedException {
	  
	  Actions a = new Actions(w);
	  
	  w.get("https://www.facebook.com/");
	  
	  w.findElement(By.id("email")).sendKeys("abcd");
	  
	  Thread.sleep(3000);
	  a.sendKeys(Keys.BACK_SPACE).build().perform();
	  
	  a.sendKeys(Keys.TAB).build().perform();
	  
	  a.sendKeys(Keys.ENTER).build().perform();
	  
	  
  }
  
  @AfterTest
  public void afterTest() {
	  
	  //w.quit();
  }

}
