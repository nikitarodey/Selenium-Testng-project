package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork1_2 {

	public static void main(String[] args) {
        String projectPath=System.getProperty("user.dir"); //current project directory
		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowseDriver\\chromedriver.exe");
		WebDriver w=new ChromeDriver(); 
		w.manage().window().maximize(); 
		w.get("http://www.testyou.in/Login.aspx");
		w.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).sendKeys("Selenium99");
		w.findElement(By.id("ctl00_CPHContainer_txtPassword")).sendKeys("Selenium99");
		w.findElement(By.id("ctl00_CPHContainer_btnLoginn")).click();
		w.findElement(By.id("ctl00_headerTopStudent_lnkbtnSignout")).click();
		
		w.quit();

	}

}
