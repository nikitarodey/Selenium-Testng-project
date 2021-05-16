package com.selenium.pageobject_test;

import org.testng.annotations.Test;

import com.selenium.pageobject.Calculator;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;


@Listeners(com.selenium.pageobject.ListenersCode.class)

public class CalculatorTestCase {
	
  Calculator cl = new Calculator();
		  
  @BeforeTest
  public void beforeTest() {
	  
	  cl.openBrowser("chrome");
	  cl.exportPageobjectElements();
  }

  @Test(priority = 0, description = "Test case to verify Addition")
  public void Addition() throws Exception {
	  
	  cl.openApplication();
	  cl.textFirstNumber.sendKeys("5");
	  cl.textSecondNumber.sendKeys("5");
	  cl.dropDownListoperator.sendKeys("+");
	  cl.button.click();
	  cl.output.getText();
	  
	  cl.waitsec(2);
	  
//	  assertEquals(cl.output.getText(), "10");
	  Assert.assertEquals(cl.result(), "10");
	  System.out.println("Output is :"+ cl.result());
	  
  }  
	 @Test(priority = 1, description = "Test case to verify Substraction")
	  public void Substraction() throws Exception {
		  
		  cl.openApplication();
		  cl.textFirstNumber.sendKeys("5");
		  cl.textSecondNumber.sendKeys("2");
		  cl.dropDownListoperator.sendKeys("-");
		  cl.button.click();
		  cl.output.getText();
		  cl.waitsec(2);
		  Assert.assertEquals(cl.result(), "3");
		  System.out.println("Output is :"+ cl.result());
		  
	  }
		  @Test(priority = 2, description = "Test case to verify Multiplication")
		  public void Multiply() throws Exception {
			  
			  cl.openApplication();
			  cl.textFirstNumber.sendKeys("5");
			  cl.textSecondNumber.sendKeys("3");
			  cl.dropDownListoperator.sendKeys("*");
			  cl.button.click();
			  cl.output.getText();
			  cl.waitsec(2);
			  Assert.assertEquals(cl.result(), "15");
			  System.out.println("Output is :"+ cl.result());
			  
  }
  
		  @Test(priority = 3, description = "Test case to verify Division")
		  public void Division() throws Exception {
			  
			  cl.openApplication();
			  cl.textFirstNumber.sendKeys("4");
			  cl.textSecondNumber.sendKeys("2");
			  cl.dropDownListoperator.sendKeys("/");
			  cl.button.click();
			  cl.output.getText();
			  cl.waitsec(2);
			  Assert.assertEquals(cl.result(), "2");
			  System.out.println("Output is :"+ cl.result());
			  
		  } 
		  
		  
  @AfterTest
  public void afterTest() {
	  cl.closeApplication();
  }

}
