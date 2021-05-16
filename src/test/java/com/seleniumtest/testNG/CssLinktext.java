package com.seleniumtest.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class CssLinktext {
	
	String projectPath;
	WebDriver w;
 
  @BeforeTest
  public void beforeTest() {
	  
	  projectPath=System.getProperty("user.dir"); //current project directory
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
	    w=new ChromeDriver(); //open browser
		w.manage().window().maximize();
  }
  
  @Test
  public void css() throws Exception {
	  
	  w.get("https://opensource-demo.orangehrmlive.com/");
	  
	  //css with id
	  
	  //w.findElements(By.cssSelector(projectPath));
	  w.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
	  
	  //css with name
	  w.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("admin123");
	  
	  //css with classname
	  w.findElement(By.cssSelector("input.button")).click();
	  
	  Thread.sleep(2000);
	  
	  //linktext
	  w.findElement(By.linkText("Logout")).click();
	  
	  Thread.sleep(2000);
	  
	  
  }

  
  
  @AfterTest
  public void afterTest() {
	  
	  w.quit();
  }

}
