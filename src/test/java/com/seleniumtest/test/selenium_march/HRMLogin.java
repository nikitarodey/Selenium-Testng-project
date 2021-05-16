package com.seleniumtest.test.selenium_march;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HRMLogin {

	public static void main(String[] args) throws Exception {
		
String projectPath=System.getProperty("user.dir"); //current project directory
		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
		
		WebDriver w=new ChromeDriver(); //open browser
		w.manage().window().maximize(); // maximize window size
		
		w.get("https://opensource-demo.orangehrmlive.com/");
		
		w.findElement(By.id("txtUsername")).clear();
		w.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		w.findElement(By.id("txtPassword")).clear();
		w.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		w.findElement(By.name("Submit")).click();
		
		Thread.sleep(2000);
		
		w.findElement(By.id("welcome")).click();
		Thread.sleep(2000);
		

		w.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[2]/a")).click();
		
		w.quit();
		

	}

}
