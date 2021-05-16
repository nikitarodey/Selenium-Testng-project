package com.seleniumtest.testNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SoftAssertCode {
	String projectPath;
	WebDriver w;
	SoftAssert st;
	
 @BeforeTest
 public void beforeTest() {
	 
	 projectPath=System.getProperty("user.dir"); //current project directory
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
	    w=new ChromeDriver(); //open browser
		w.manage().window().maximize();
  }
	
  @Test(priority=1, description="Test to verify login page functionality")
  public void loginPage() throws InterruptedException {
	  
	  SoftAssert st = new SoftAssert();
	  
	  w.get("http://demo.testfire.net/login.jsp");
	  Thread.sleep(2000);
	  //verify page title "Altoro Login"
	  String loginPageTitle=w.getTitle();
	  st.assertEquals(loginPageTitle, "Altoro Mutual");
	  //.assertEquals - match
	  
	  String pageURL=w.getCurrentUrl();
	  st.assertTrue(pageURL.contains("login.jsp"), "URL is wrong");
	  //http://demo.testfire.net/login.jsp - (assertEquals)
	  
	  //verify page label should have "Login"
	  WebElement loginPageLable=w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
	  String LoginLable=loginPageLable.getText();
	  //Assert.assertEquals(LoginLable, "Login");
	  st.assertTrue(LoginLable.contains("Login"), "Lable is different as expectred");


		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		
		st.assertAll();
  } 
  
  @Test(priority=1, description="Test to verify logout page functionality", dependsOnMethods="loginPage")
  public void logoutPage()
  {
	  SoftAssert st = new SoftAssert();
	  
	  String homePageTitle=w.getTitle();
	  st.assertEquals(homePageTitle, "Altoro Mutual");
	  
	  WebElement homePageLable=w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1"));
	  String homeLable=homePageLable.getText();
	  st.assertTrue(homeLable.contains("Admin"));
	  
	  w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
	  
	  st.assertAll();
  }

  @AfterTest
  public void afterTest() {
	  
	  w.quit();
  }

}

