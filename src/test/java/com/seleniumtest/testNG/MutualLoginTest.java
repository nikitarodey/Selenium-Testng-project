package com.seleniumtest.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class MutualLoginTest {
	
	String projectPath;
	WebDriver w;
	
	
	@BeforeTest
	  public void beforeTest() {
	    projectPath=System.getProperty("user.dir"); //current project directory
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
	    w=new ChromeDriver(); //open browser
		w.manage().window().maximize(); // maximize window size
	  }
	
  @Test(priority=0,description="Test case to verify 'Admin' login functionality",groups="Login")
  public void login_Admin() throws InterruptedException {

	w.get("http://demo.testfire.net/login.jsp");
	w.findElement(By.id("uid")).sendKeys("admin");
	w.findElement(By.id("passw")).sendKeys("admin");
	w.findElement(By.name("btnSubmit")).click();
	Thread.sleep(2000);
	w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
	
	//System.out.println("Admin login successfull !! ");
	Reporter.log("Admin login successfull !!", true);
	
  }
  
 /*@Test(priority=2,description="Test case to verify 'jsmith' login functionality",dependsOnMethods="login_Admin",groups="Login",invocationCount=2)
  public void login_jsmith() throws InterruptedException {

		w.get("http://demo.testfire.net/login.jsp");
		w.findElement(By.id("uid")).sendKeys("jsmith");
		w.findElement(By.id("passw")).sendKeys("Demo1234");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		
  }
  
  @Test(priority=1,description="Test case to verify 'sspeed' login functionality",dependsOnMethods="login_Admin",groups="Login")
  public void login_sspeed() throws InterruptedException {

	   w.get("http://demo.testfire.net/login.jsp");
	   w.findElement(By.id("uid")).sendKeys("sspeed");
	   w.findElement(By.id("passw")).sendKeys("Demo1234");
	   w.findElement(By.name("btnSubmit")).click();
	   Thread.sleep(2000);
	   w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();	
	   
  }
		
	@Test(priority=3,description="Test case to verify 'tuser' login functionality",dependsOnMethods="login_Admin",groups="Login")
    public void login_tuser() throws InterruptedException {

		w.get("http://demo.testfire.net/login.jsp");
		w.findElement(By.id("uid")).sendKeys("tuser");
		w.findElement(By.id("passw")).sendKeys("tuser");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
  } */
  
  @AfterTest
  public void afterTest() {

		w.quit(); //close browser
  }

}
