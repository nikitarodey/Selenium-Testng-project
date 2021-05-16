package Assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HomeWork3 {

	String projectPath;
	WebDriver w;

	@BeforeTest
	public void beforeTest() throws Exception {

		projectPath = System.getProperty("user.dir"); // current project directory
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowseDriver\\chromedriver.exe");
		w = new ChromeDriver(); // open browser
		w.manage().window().maximize();
		Thread.sleep(2000);
		w.get("https://www.business-standard.com/personal-finance/financial-tools/emi-calculator");
		System.out.println("\n");
	}

	@Test(priority = 1, description = "Test case to verify Test Scenario 1")
	public void testScenario1() {

		// 1. Enter Loan Amount (Rs) as "100000"
		w.findElement(By.id("amount")).sendKeys("100000");

		// 2. Rate of Interest (%) as "9"
		w.findElement(By.id("rate")).sendKeys("9");

		// 3. Period (Years) as "2"
		w.findElement(By.id("years")).sendKeys("2");

		// Click on "Submit" button
		w.findElement(By.cssSelector("input[name='calculate']")).click();

		// Verify / Validate below value under "EMI CALCULATOR REPORT”:

		String emiCalReport1 = w.findElement(By.xpath("//*[@id=\"hpcontentbox\"]/div[5]/div[1]/div[1]/div[4]/div/div[1]")).getText();
		Assert.assertTrue(true);
		System.out.println("\n");
		System.out.println("EMI CALCULATOR REPORT 1: " + "\n" + emiCalReport1);

	}

	@Test(priority = 0, description = "Test case to verify Test Scenario 2")
	public void testScenario2() {

		// 1. Enter Loan Amount (Rs) as "400000"
		w.findElement(By.id("amount")).sendKeys("400000");

		// 2. Rate of Interest (%) as "6"
		w.findElement(By.id("rate")).sendKeys("6");

		// 3. Period (Years) as "4"
		w.findElement(By.id("years")).sendKeys("4");

		// Click on "Submit" button
		w.findElement(By.cssSelector("input[name='calculate']")).click();

		// Verify / Validate below value under "EMI CALCULATOR REPORT”:

		String emiCalReport2 = w.findElement(By.xpath("//*[@id=\"hpcontentbox\"]/div[5]/div[1]/div[1]/div[4]/div/div[1]")).getText();
		Assert.assertTrue(true);
		System.out.println("\n");
		System.out.println("EMI CALCULATOR REPORT 2: " + "\n" + emiCalReport2);

	}

	@Test(priority = 2, description = "Test case to verify Test Scenario 3")
	public void testScenario3() {

		// 1. Enter Loan Amount (Rs) as "800000"
		w.findElement(By.id("amount")).sendKeys("800000");

		// 2. Rate of Interest (%) as "10"
		w.findElement(By.id("rate")).sendKeys("10");

		// 3. Period (Years) as "2"
		w.findElement(By.id("years")).sendKeys("2");

		// Click on "Submit" button
		w.findElement(By.cssSelector("input[name='calculate']")).click();

		// Verify / Validate below value under "EMI CALCULATOR REPORT”:

		String emiCalReport3 = w.findElement(By.xpath("//*[@id=\"hpcontentbox\"]/div[5]/div[1]/div[1]/div[4]/div/div[1]")).getText();
		Assert.assertTrue(true);
		System.out.println("\n");
		System.out.println("EMI CALCULATOR REPORT 3: " + "\n" + emiCalReport3);
		System.out.println("\n");

	}

	@AfterTest
	public void afterTest() {

		w.quit();
	}

}
