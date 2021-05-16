package Assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Homework4_1 {

	String projectPath;
	WebDriver w;

	@BeforeTest
	public void beforeTest() throws Exception {

		projectPath = System.getProperty("user.dir"); // current project directory
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowseDriver\\chromedriver.exe");
		w = new ChromeDriver(); // open browser
		w.manage().window().maximize();
		Thread.sleep(2000);
		w.get("https://juliemr.github.io/protractor-demo/");
		System.out.println("\n");
	}

	@Test(priority = 0, description = "Test case to verify Addition1")
	public void sum1() throws Exception {

		// 1. Enter 5, Select +, Enter 5 -> Click "Go" button
		w.findElement(By.cssSelector("input[ng-model='first']")).sendKeys("5");
		w.findElement(By.cssSelector("select[ng-model='operator']")).click();
		w.findElement(By.cssSelector("option[value='ADDITION']")).click();
		w.findElement(By.cssSelector("input[ng-model='second']")).sendKeys("5");
		w.findElement(By.id("gobutton")).click();
		Thread.sleep(2000);

		// Verify "10" value get display
		String sum = w.findElement(By.xpath("/html/body/div/div/form/h2")).getText();
		Assert.assertEquals(sum, "10");
		System.out.println("Addition is: " + sum);

	}

	@Test(priority = 1, description = "Test case to verify Substraction")
	public void sub() throws Exception {

		// 2. Enter 5, Select - , Enter 2 -> Click "Go" button
		w.findElement(By.cssSelector("input[ng-model='first']")).sendKeys("5");
		w.findElement(By.cssSelector("select[ng-model='operator']")).click();
		w.findElement(By.cssSelector("option[value='SUBTRACTION']")).click();
		w.findElement(By.cssSelector("input[ng-model='second']")).sendKeys("2");
		w.findElement(By.id("gobutton")).click();
		Thread.sleep(2000);

		// Verify "3" value get display.
		String sub = w.findElement(By.xpath("/html/body/div/div/form/h2")).getText();
		Assert.assertEquals(sub, "3");
		System.out.println("\n");
		System.out.println("Substraction is: " + sub);
	}

	@Test(priority = 2, description = "Test case to verify Multiplication")
	public void multiply() throws Exception {

		// 3. Enter 3, Select * , Enter 3 -> Click "Go" button
		w.findElement(By.cssSelector("input[ng-model='first']")).sendKeys("3");
		w.findElement(By.cssSelector("select[ng-model='operator']")).click();
		w.findElement(By.cssSelector("option[value='MULTIPLICATION']")).click();
		w.findElement(By.cssSelector("input[ng-model='second']")).sendKeys("3");
		w.findElement(By.id("gobutton")).click();
		Thread.sleep(2000);

		// Verify "9" value get display.
		String mul = w.findElement(By.xpath("/html/body/div/div/form/h2")).getText();
		Assert.assertEquals(mul, "9");
		System.out.println("\n");
		System.out.println("Multiplication is: " + mul);

	}

	@Test(priority = 3, description = "Test case to verify Division")
	public void dividion() throws Exception {

		// 4. Enter 4, Select / , Enter 2 -> Click "Go" button
		w.findElement(By.cssSelector("input[ng-model='first']")).sendKeys("4");
		w.findElement(By.cssSelector("select[ng-model='operator']")).click();
		w.findElement(By.cssSelector("option[value='DIVISION']")).click();
		w.findElement(By.cssSelector("input[ng-model='second']")).sendKeys("2");
		w.findElement(By.id("gobutton")).click();
		Thread.sleep(2000);

		// Verify "2" value get display
		String div = w.findElement(By.xpath("/html/body/div/div/form/h2")).getText();
		Assert.assertEquals(div, "2");
		System.out.println("\n");
		System.out.println("Division is: " + div);
		System.out.println("\n");

	}

	@AfterTest
	public void afterTest() {

		w.quit();
	}

}
