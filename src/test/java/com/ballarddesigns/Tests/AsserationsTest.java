package com.ballarddesigns.Tests;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AsserationsTest {

	@Test
	public void TestGoogle() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Ballard Designs", Keys.ENTER);
		String expecetedTitle = "Ballard Designs - Google Searchh";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expecetedTitle, "Title is mismatched");
		driver.quit();
	}

	@Test
	public void TestFacebook() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("Ballard Designs", Keys.ENTER);
		Thread.sleep(5000);

		
		SoftAssert softAssert = new SoftAssert();
		
		// Title asserations
		String actualTitle = driver.getTitle();
		String expecetedTitle = "Log in to Facebook";
		softAssert.assertEquals(actualTitle, expecetedTitle, "Title is mismatched");

		// URL asserations
		String actualUrl = driver.getCurrentUrl();
		String expecetedUrl = "https://www.fb.com/";
		softAssert.assertNotEquals(actualUrl, expecetedUrl, "URL is mismatched");

		// TEXT asserations
		String actualText = driver.findElement(By.name("email")).getAttribute("value");
		String expecetedText = "";
		softAssert.assertEquals(actualText, expecetedText, "Text is mismatched");

		// BORDER asserations
		String actualBorder = driver.findElement(By.name("email")).getCssValue("border");
		String expecetedBorder = "1px solid rgb(240, 40, 73)";
		softAssert.assertEquals(actualBorder, expecetedBorder, "Border is mismatched");

		// ErrorMessage asserations
		String actualErrorMessage = driver.findElement(By.xpath("(//div[@id='email_container']/div)[last()]"))
				.getText();
		String expecetedErrorMessage = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		softAssert.assertEquals(actualErrorMessage, expecetedErrorMessage, "ErrorMessage is mismatched");

		driver.quit();
		softAssert.assertAll();

		/*
		 * boolean IsDisplayedLogo =
		 * driver.findElement(By.className("logo-anchor")).isDisplayed(); if
		 * (IsDisplayedLogo) { System.out.println("Ballard Designs LOGO IsDisplayed"); }
		 * else { System.out.println("Ballard Designs LOGO Not IsDisplayed"); }
		 * 
		 * driver.findElement(By.id("loginMyAccount")).click();
		 * 
		 * boolean WelcomeMessage =
		 * driver.findElement(By.cssSelector("#mainContent > div.data > p:nth-child(2)"
		 * )) .isDisplayed(); if (WelcomeMessage) { System.out.println(
		 * "Welcome back! To access your account, please enter your email address and password and click Sign In Is Displayed"
		 * ); } else { System.out.println(
		 * "Welcome back! To access your account, please enter your email address and password and click Sign In Is Not Displayed"
		 * ); }
		 * 
		 * driver.findElement(By.name("logonId")).sendKeys(
		 * "ikhader.itgtesting@gmail.com");
		 * driver.findElement(By.name("logonPassword")).sendKeys("b123456789");
		 * driver.findElement(By.id("logonButton")).click();
		 * System.out.println("The login process has been completed successfully");
		 * 
		 * Thread.sleep(5000);
		 */
	}
}