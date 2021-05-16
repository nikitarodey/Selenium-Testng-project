package com.seleniumtest.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class BasicWebObject {

	String projectPath;
	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		projectPath = System.getProperty("user.dir"); // current project directory
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
		w = new ChromeDriver();
		w.manage().window().maximize();
	}

	@Test(priority = 0, description = "Test cases fo textbox field")
	public void textBoxField() {

		w.get("http://demo.automationtesting.in/Register.html");

		w.findElement(By.cssSelector("input[ng-model='FirstName']")).clear();
		w.findElement(By.cssSelector("input[ng-model='FirstName']")).sendKeys("Nikita");

		w.findElement(By.cssSelector("input[ng-model='LastName']")).clear();
		w.findElement(By.cssSelector("input[ng-model='LastName']")).sendKeys("Rodey");

		w.findElement(By.cssSelector("textarea[ng-model='Adress']")).clear();
		w.findElement(By.cssSelector("textarea[ng-model='Adress']"))
				.sendKeys("Swapnashilp, Vinayak nagar , colony no.3");

	}

	@Test(priority = 1, description = "Test cases for radio button ")
	public void radioButton() {

		w.findElement(By.cssSelector("input[value='FeMale']")).click();

	}

	@Test(priority = 2, description = "Test cases for Check Box")
	public void checkBox() {

		w.findElement(By.id("checkbox1")).click();
		w.findElement(By.id("checkbox2")).click();
		w.findElement(By.cssSelector("input[value='Hockey']")).click();

	}

	@Test(priority = 3, description = "Test cases for Dropdown list")
	public void dropDownlist() throws InterruptedException {

		Thread.sleep(2000);

		WebElement skillsdropdown = w.findElement(By.id("Skills"));

		Select sel = new Select(skillsdropdown);
		// sel.selectByIndex(6); //Index position
		// sel.selectByValue("C");  //html option tag -> value
		sel.selectByVisibleText("Android");  //actual text from drop down list
	}

	@Test(priority = 3, description = "Test cases for Listbox ")
	public void listBox() throws InterruptedException {

		w.findElement(By.xpath("//*[@id=\"msdd\"]")).click();
		Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[1]/a")).click();
		Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[4]/a")).click();
		w.findElement(By.xpath("//*[@id=\"msdd\"]")).click();
	}

	@AfterTest
	public void afterTest() {

		// w.quit();
	}

}
