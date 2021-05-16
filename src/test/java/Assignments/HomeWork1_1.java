package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork1_1 {

	public static void main(String[] args) throws InterruptedException {
		
        String projectPath=System.getProperty("user.dir"); //current project directory
		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowseDriver\\chromedriver.exe");
		WebDriver w=new ChromeDriver(); 
		w.manage().window().maximize(); 
		
		w.get("http://www.google.com");
		
		//step 1: search for "Snapdeal" keyword on google
		w.findElement(By.name("q")).sendKeys("snapdeal");
		Thread.sleep(2000);
	    w.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/ul/li[1]/div/div[2]")).click();
	    
	   //step 2: Click on "Wikipdedia" link from right.
		w.findElement(By.xpath("//*[@id=\"kp-wp-tab-overview\"]/div[1]/div/div/div/div/div[1]/div/div/div/span[2]/a")).click();
		
	   //step 3: Under "Search Wikipdedia" -> Enter "News" and Click on search icon	
		w.findElement(By.id("searchInput")).sendKeys("news");
		
		w.findElement(By.id("searchButton")).click();
		
	   //step 4: Click on "View history" link	
		//w.findElement(By.xpath("//*[@id=\"ca-history\"]/a")).click();
		w.findElement(By.linkText("View history")).click();  //using Linktext Locator (Actual text on webpage)
		
		
		
		
		
		   
		
		
		//step 2: Click on "Wikipedia" link from right
		//step 3: under search wikipedia ->Enter "News" and click on search icon
		//step 4: click on "view history" link
		
	}

}
