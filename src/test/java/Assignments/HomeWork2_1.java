package Assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class HomeWork2_1 {
	
	String projectPath;
	WebDriver w;
  
  @BeforeTest
  public void beforeTest() {
	  
	  projectPath=System.getProperty("user.dir"); //current project directory
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowseDriver\\chromedriver.exe");
	    w=new ChromeDriver(); 
		w.manage().window().maximize();
  }

  @Test(priority=0, description="Test case for page label")
  public void pagelabel() throws InterruptedException {
	  
	  w.get("https://www.policyx.com/" );
	  Thread.sleep(2000);
      //Step 1: Verify Label on page is equal to "India's Most Trusted Insurance Portal"
	  
	  String pageLabel=w.findElement(By.xpath("//*[@id=\"page1\"]/section[1]/div/div/div[2]/h1")).getText();
	  Assert.assertEquals(pageLabel, "India's Most Trusted Insurance Portal");
	  System.out.println("Page label is " +pageLabel);
	  
      //Step 2: Verify page title contains "Insurance" text
	  
	  String pageTitle=w.getTitle();
	  Assert.assertTrue(pageTitle.contains("Insurance")); 
	  System.out.println("Page title is " +pageTitle);
	  Thread.sleep(2000);
	  
  }
	  
  @Test(priority=1, description="Test case for Claim page ")
  public void claimPage() throws InterruptedException {
	 
  
	  //Step 3: On-clicking "Claim", and verify Page label is “CLAIM ASSISTANCE”
	  
	  w.findElement(By.xpath("//*[@id=\"page1\"]/header/div/div[4]/div[4]/a")).click();
	  Thread.sleep(2000);
	  String pageLabelClaim=w.findElement(By.xpath("//*[@id=\"page1\"]/div[2]/div/div/div[1]/h1")).getText();
	  Assert.assertEquals(pageLabelClaim ,"CLAIM ASSISTANCE");
	  System.out.println("Page claim label is " +pageLabelClaim);
	  
	  //Step 4: Verify page title contains "Claim Process"
	  String pageClaimTitle=w.getTitle();
	  Assert.assertTrue(pageClaimTitle.contains("Claim Process"));
	  System.out.println("Page Claim Title is :" +pageClaimTitle);
	  
  }
  
  
  @AfterTest
  public void afterTest() {
	  
	  w.quit();
  }

}
