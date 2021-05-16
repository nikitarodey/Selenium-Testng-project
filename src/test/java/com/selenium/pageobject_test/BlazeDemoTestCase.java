package com.selenium.pageobject_test;

import org.testng.annotations.Test;

import com.selenium.pageobject.BlazeDemo;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

@Listeners(com.selenium.pageobject.ListenersCode.class)
public class BlazeDemoTestCase {

	BlazeDemo b;

	@BeforeTest
	public void beforeTest() {

		b = new BlazeDemo();
		b.openbrowser("chrome");
		b.exportPageObjectElements();

	}

	@Test(priority=0, description="Test case to verify BlazeDemo")
	public void Blazedemo() throws Exception {
		
		b.openApplication();
		b.handelDropdown(b.dropdownDepartureCity, "Boston");
		b.handelDropdown(b.dropdownDestinationCity, "London");
		b.btnFindFlight.click();
		
		Assert.assertEquals(b.label1.getText(), "Flights from Boston to London:");
		System.out.println("Label on page is :"+b.label1.getText() );
		
		b.waitSec(2);
		b.btChooseThisFlight.click();
		
		Assert.assertEquals(b.pageTitle(), "BlazeDemo Purchase");
		System.out.println("Page Title is: "+ b.pageTitle());
		
		Assert.assertEquals(b.pageLabel2.getText(), "Your flight from TLV to SFO has been reserved.");
		System.out.println("Page label is: "+b.pageLabel2.getText() );
		
		Assert.assertTrue(b.airline.getText().contains("United"), "not true");
		System.out.println("Airline :"+b.airline.getText());
		
		Assert.assertTrue(b.flightNumber.getText().contains("UA954"), "not true");
		System.out.println("Flight number :"+b.flightNumber.getText());
		
		b.verifyprice(null);
		
		
		
		b.name.sendKeys("Jones Pence");
		b.address.sendKeys("Observatory Circle, U.S");
		b.city.sendKeys("Phoenix");
		b.state.sendKeys("Arizona (AZ)");
		b.zipCode.sendKeys("85001");
		b.cardType.sendKeys("American Express");
		b.cardNum.sendKeys("12345678");
		b.month.sendKeys("12");
		b.year.sendKeys("2018");
		b.nameOncard.sendKeys("Jones Pence");
		b.checkRememberMe.click();
		b.btnPurchareFlight.click();

		
		
	}

	@AfterTest
	public void afterTest() {
		//b.closeBrowser();
	}

}
