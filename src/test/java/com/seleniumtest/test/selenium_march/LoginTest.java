package com.seleniumtest.test.selenium_march;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {
		
		String projectPath=System.getProperty("user.dir"); //current project directory
		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowseDriver\\chromedriver.exe");
		
		WebDriver w=new ChromeDriver(); //open browser
		w.manage().window().maximize(); // maximize window size
		
		//Step 1: Open applicatio with url
		w.get("http://demo.testfire.net/login.jsp");
		
		//Step 2: Enter username
		w.findElement(By.id("uid")).sendKeys("admin");
		
		//Step 3: Enter pwd
		w.findElement(By.id("passw")).sendKeys("admin");
		
		//Step 4: Click Login
		w.findElement(By.name("btnSubmit")).click();
		
		//Step 5: Click Logout
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		
		w.quit(); //close browser
		

	}

}
