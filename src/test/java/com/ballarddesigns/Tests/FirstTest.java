package com.ballarddesigns.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

	@Test
	public void TestBallardDesigns() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://devwcs.ballarddesigns.com/");
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.cssSelector("#proceed-link")).click();
		Thread.sleep(5000);
		
		boolean IsDisplayedLogo = driver.findElement(By.className("logo-anchor")).isDisplayed();
		if (IsDisplayedLogo) {
			System.out.println("Ballard Designs LOGO IsDisplayed");
		} else {
			System.out.println("Ballard Designs LOGO Not IsDisplayed");
		}
		
		driver.findElement(By.id("loginMyAccount")).click();

		boolean WelcomeMessage = driver.findElement(By.cssSelector("#mainContent > div.data > p:nth-child(2)"))
				.isDisplayed();
		if (WelcomeMessage) {
			System.out.println(
					"Welcome back! To access your account, please enter your email address and password and click Sign In Is Displayed");
		} else {
			System.out.println(
					"Welcome back! To access your account, please enter your email address and password and click Sign In Is Not Displayed");
		}

		driver.findElement(By.name("logonId")).sendKeys("ikhader.itgtesting@gmail.com");
		driver.findElement(By.name("logonPassword")).sendKeys("b123456789");
		driver.findElement(By.id("logonButton")).click();
		System.out.println("The login process has been completed successfully");

		Thread.sleep(5000);
		driver.quit();
	}

}
