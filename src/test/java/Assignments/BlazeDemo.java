package Assignments;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class BlazeDemo {

	String projectPath;
	WebDriver w;
	Select sel;

	@BeforeTest
	public void preCondition() {

		projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
		w = new ChromeDriver();
		w.manage().window().maximize();

	}

	@Test(priority = 0, description = "Test to verify BlazedemoTest functioanlity")
	public void Blazedemo() throws Exception {

		w.get("https://blazedemo.com/");
		w.findElement(By.name("fromPort")).click();

		WebElement dropdown_fromPort = w.findElement(By.name("fromPort"));
		sel = new Select(dropdown_fromPort);
		sel.selectByVisibleText("Boston");

		WebElement dropdown_toPort = w.findElement(By.name("toPort"));
		sel = new Select(dropdown_toPort);
		sel.selectByVisibleText("London");

		w.findElement(By.xpath("//input[@value='Find Flights']")).click();
		Thread.sleep(2000);
		w.findElement(By.cssSelector("input[value='Choose This Flight']")).click();
		Thread.sleep(2000);

		// verify 'Airline'

		String airline = w.findElement(By.xpath("/html/body/div[2]/p[1]")).getText(); // (Airline: United)
		Assert.assertTrue(airline.contains("United"));

		// or

		String airlineValue[] = airline.split(" ");
		System.out.println(airlineValue[0]);
		System.out.println(airlineValue[1]);

		
		
		// verify 'flight Number'

		String flightNo = w.findElement(By.xpath("/html/body/div[2]/p[2]")).getText(); // (Flight Number: UA954)
		Assert.assertTrue(flightNo.contains("UA954"));

		// or

		String flightNoValue[] = flightNo.split(" ");
		System.out.println(flightNoValue[0]);
		System.out.println(flightNoValue[1]);
		System.out.println(flightNoValue[2]);

		Assert.assertEquals(flightNoValue[2], "UA954");
		
/*********************************************************************************************/
	
		String totalCost=w.findElement(By.xpath("/html/body/div[2]/p[5]/em")).getText();
		
/*********************************************************************************************/
		
		
		  String price=w.findElement(By.xpath("/html/body/div[2]/p[3]")).getText();		  
		  System.out.println("Price -> "+price);		  
		  String splitPrice[]=price.split(" ");	
		  
		  
		  //Converting String value to int
		  int price_int=Integer.parseInt(splitPrice[1]);
		  
		  
		  
		  String fees_tax=w.findElement(By.xpath("/html/body/div[2]/p[4]")).getText();
		  System.out.println("fees_tax -> "+fees_tax);
		  
		  String splitfees_tax[]=fees_tax.split(" ");		  

		  //Converting String value to double
		  double  fees_tax_double=Double.parseDouble(splitfees_tax[4]);
		  
		  //Addition
		  double total_of_price_feesTax=price_int + fees_tax_double;
		  
		  
		  //Converting double value to String
		  String totalCost_Validation=String.valueOf(total_of_price_feesTax);
		  
		  Assert.assertEquals(totalCost, totalCost_Validation);
		  
		  
		  System.out.println("Total cost after addition : "+total_of_price_feesTax);
		  
		  

		  

	}

	@AfterTest
	public void postCondition() {

	w.quit();
	}

}
