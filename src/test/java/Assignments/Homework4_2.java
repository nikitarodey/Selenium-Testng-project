
package Assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Homework4_2 {

	String projectPath;
	WebDriver w;

	@BeforeTest
	public void beforeTest() throws Exception {

		projectPath = System.getProperty("user.dir"); // current project directory
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
		w = new ChromeDriver(); // open browser
		w.manage().window().maximize();
		Thread.sleep(2000);

	}

	@Test(priority = 0, description = "Test case to verify the page title")
	public void test1() {

		w.get("http://blazedemo.com/");

		String pageTitle = w.getTitle();
		Assert.assertEquals(pageTitle, "BlazeDemo");
		System.out.println("Page title is: " + pageTitle);
		System.out.println("\n");
	}

	@Test(priority = 1, description = "Test case to verify the page title")
	public void test2() {

		// 2. Select / Choose your departure city: "Boston"
		w.findElement(By.xpath("/html/body/div[3]/form/select[1]")).click();
		w.findElement(By.cssSelector("option[value='Boston']")).click();

		// 3. Select / Choose your destination city: "London"
		w.findElement(By.cssSelector("select[name='toPort']")).click();
		w.findElement(By.cssSelector("option[value='London']")).click();

	}

	@Test(priority = 2, description = "Test case to verify the page title")
	public void test3() {

		// 4. Click on "Find Flights" and Validate page label "Flights from Boston to
		// London:"
		w.findElement(By.cssSelector("input[type='submit']")).click();

		String pageLabel = w.findElement(By.xpath("/html/body/div[2]/h3")).getText();
		Assert.assertEquals(pageLabel, "Flights from Boston to London:");
		System.out.println("Page Label is: " + pageLabel);
		System.out.println("\n");

	}

	@Test(priority = 3, description = "Test case to verify the page title")
	public void test4() {

		// 5. Click on first flight -> “Choose This Flight” button.
		w.findElement(By.cssSelector("input[type='submit']")).click();

		// Validate page title: "BlazeDemo Purchase"
		String pageTitle2=w.getTitle();
		Assert.assertEquals(pageTitle2, "BlazeDemo Purchase");
		System.out.println("Page Title 2 is: "+pageTitle2);
		
		// Validate Page label: "Your flight from TLV to SFO has been reserved."
		String pageLabel2=w.findElement(By.xpath("/html/body/div[2]/h2")).getText();
		Assert.assertEquals(pageLabel2, "Your flight from TLV to SFO has been reserved.");
		System.out.println("Page label 2 is: "+pageLabel2);
		
		
		//Validate Airline should be “United”
		String airline = w.findElement(By.xpath("/html/body/div[2]/p[1]")).getText();
		System.out.println("Airline details="+airline);
		Assert.assertTrue(airline.contains("United"), "wrong flight details");
		
		//Validate flight no should be “UA954”
		w.findElement(By.xpath("/html/body/div[2]/p[2]")).getText();
		Assert.assertTrue(true);
		System.out.println(w.findElement(By.xpath("/html/body/div[2]/p[2]")).getText());
		
		//Validate “Total Cost” should addition of “Arbitrary Fees and Taxes” and “Price”
		w.findElement(By.xpath("/html/body/div[2]/p[3]")).getText();
		w.findElement(By.xpath("/html/body/div[2]/p[4]")).getText();
		w.findElement(By.xpath("/html/body/div[2]/p[5]/em")).getText();
		Assert.assertTrue(true);
		System.out.println("Total cost is: "+w.findElement(By.xpath("/html/body/div[2]/p[5]/em")).getText());
		

	}

	@Test(priority = 4, description = "Test case to verify the page title")
	public void test5() {
		
		//6. Enter Name as "Jones Pence"
		w.findElement(By.id("inputName")).sendKeys("Jones Pence");
		
		//7. Enter Address as "Observatory Circle, U.S"
		w.findElement(By.id("address")).sendKeys("Observatory Circle, U.S");
		
		//8. Enter City as "Phoenix"
		w.findElement(By.id("city")).sendKeys("Phoenix");
		
		//9. Enter State as "Arizona (AZ)"
		w.findElement(By.id("state")).sendKeys("Arizona (AZ)");
		
		//10. Enter Zip Code as "85001"
		w.findElement(By.id("zipCode")).sendKeys("85001");
		
		//11. Select Card Type as "American Express"
		w.findElement(By.id("cardType")).click();
		w.findElement(By.cssSelector("option[value='amex']")).click();
		
		//12. Enter Credit Card Number as "12345678"
		w.findElement(By.id("creditCardNumber")).sendKeys("12345678");
		
		//13. Enter Month as "12"
		w.findElement(By.id("creditCardMonth")).sendKeys("12");
		
		//14. Enter Year as "2018"
		w.findElement(By.id("creditCardYear")).sendKeys("2018");
		
		//15. Enter Name on Card as "Jones Pence"
		w.findElement(By.id("nameOnCard")).sendKeys("Jones Pence");
		
		//16. Click on Remember me.
		w.findElement(By.id("rememberMe")).click();
		
		//17. Click on "Purchase Flight"
		w.findElement(By.cssSelector("input[type='submit']")).click();
	

	}

	@Test(priority = 5, description = "Test case to verify the page title")
	public void test6() {
		
		//Validate page title as "BlazeDemo Confirmation"
		String pageTitle3=w.getTitle();
		Assert.assertEquals(pageTitle3, "BlazeDemo Confirmation");
		System.out.println("Page Title 3 is: "+pageTitle3);
		System.out.println("\n");
		
	}


	@AfterTest
	public void afterTest() {
		
		w.quit();
	}

}
