package Assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HomeWork2_2 {
	
	String projectPath;
	WebDriver w;
  
  @BeforeTest
  public void beforeTest() {
	  
	    projectPath = System.getProperty("user.dir"); //current project directory
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowseDriver\\chromedriver.exe");
	    w=new ChromeDriver(); //open browser
		w.manage().window().maximize();
  }
  
  @Test(priority=0, description="Test case to verify Software Testing page label")
  public void softwareTesting() throws Exception {
	  
	  //1. Verify Label on page is "Do you want to test and develop software better?"
	  w.get("https://compendiumdev.co.uk/");
	  Thread.sleep(2000);
	  
	  String pageLabel1=w.findElement(By.xpath("//*[@id=\"pagebody\"]/div[1]/div/h1")).getText();
	  Assert.assertEquals(pageLabel1, "Do you want to test and develop software better?");
	  System.out.println("Page label 1 is: "+pageLabel1 );
	  
	  //2. Verify Page Title contains "Software Testing"
	  String pageTitle1=w.getTitle();
	  Assert.assertTrue(pageTitle1.contains("Software Testing"), "tilte does not contains 'software testing' ");
	  System.out.println("Page title 1 is: "+pageTitle1);
	  
	  
  }
  
  @Test(priority=1, description="Test case to verify Consultancy page label")
  public void consultancy() throws Exception {
	  
	  //3. Click "hire me" and verify page title is equal to "Consultancy" and page label as contains "Consultancy"
	  w.findElement(By.linkText("Hire Me")).click();
	  Thread.sleep(2000);
	  
	  String consultancyPageTitle=w.getTitle();
	  Assert.assertEquals(consultancyPageTitle, "Consultancy");
	  System.out.println("Page title 2 is: "+consultancyPageTitle);
	  
	  String consultancyPageLabel=w.findElement(By.xpath("//*[@id=\"pagebody\"]/div[1]/h1")).getText();
	  Assert.assertTrue(consultancyPageLabel.contains("Consultancy"), "doest not contains 'Consultancy' ");
	  System.out.println("Page label 2 is: "+consultancyPageLabel);
	    
  }
  
  
  @Test(priority=4, description="Test case to verify Online Training page label")
  public void onlineTraining() throws Exception {
	  
	  //4. Click "e-training" and verify page title contains "Online Training" and page label as "Online Training"
	  w.findElement(By.xpath("//*[@id=\"cssmenu\"]/ul/li[2]/a")).click();
	  Thread.sleep(2000);
	  
	  String pageTitle3=w.getTitle();
	  Assert.assertTrue(pageTitle3.contains("Online Training"));
	  System.out.println("Page title 3 is: "+pageTitle3);
	  
	  String pageLabel3=w.findElement(By.xpath("//*[@id=\"pagebody\"]/div[1]/h1")).getText();
	  Assert.assertTrue(pageLabel3.contains("Online Training"));
	  System.out.println("Page label 3 is: "+pageLabel3);
	  
	 
  }
  
  @Test(priority=3, description="Test case to verify Books page label")
  public void books() throws Exception{
	  
	  //5. Click "books" and verify page title is equal to "Our Books" and page label contains "Books"
	  w.findElement(By.linkText("Books")).click();
	  Thread.sleep(2000);
	  
	  String pageTitle4=w.getTitle();
	  Assert.assertEquals(pageTitle4, "Our Books");
	  System.out.println("Page title 4 is: "+pageTitle4);
	  
	  String pagelabel4=w.findElement(By.cssSelector("h1.pageTitle")).getText();
	  Assert.assertTrue(pagelabel4.contains("Books"));
	  System.out.println("Page label 4 is: "+pagelabel4);

  }
  
  @Test(priority=2, description="Test case to verify Training page label")
  public void training() throws Exception {
	  
	  //6. Click "face to face" and verify page title "Training" and page label as "Training"
	  w.findElement(By.xpath("//*[@id=\"cssmenu\"]/ul/li[4]/a")).click();
	  Thread.sleep(2000);
	
	  String pageTitle5=w.getTitle();
	  Assert.assertEquals(pageTitle5, "Training");
	  System.out.println("Page title 5 is: "+pageTitle5);
	  
	  String pageLabel5=w.findElement(By.cssSelector("h1.pageTitle")).getText();
	  Assert.assertTrue(pageLabel5.contains("Training"));
	  System.out.println("Page Label 5 is: "+pageLabel5);
	  
  }

  
  @AfterTest
  public void afterTest() {
	  
	  w.quit();
  }

}
