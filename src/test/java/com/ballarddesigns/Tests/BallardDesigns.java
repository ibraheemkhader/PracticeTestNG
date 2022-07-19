package com.ballarddesigns.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BallardDesigns {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@AfterTest
	public void afterTest() {
		System.out.println("The Test was Successfully Completed");
		driver.quit();

	}

	@Test(priority=1)
	public void LaunchApp() {
		driver.get("https://devwcs.ballarddesigns.com/");
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.cssSelector("#proceed-link")).click();

	}

	@Test(priority=2)
	public void VerifyTheLogoIsDisplayed() {
		System.out.println(driver.findElement(By.className("logo-anchor")).isDisplayed());
	}

	@Test(priority=3)
	public void VerifySignIn_RegisterIconIsDisplayed() {
		System.out.println(driver.findElement(By.id("loginMyAccount")).isDisplayed());
	}

	@Test(priority=4)
	public void NavigateToSignIn_Register() {
		driver.findElement(By.id("loginMyAccount")).click();
	}

	@Test(priority=5)
	public void VerifyTheuserNavigatedToSignIN() {
		System.out
				.println(driver.findElement(By.cssSelector("#mainContent > div.data > p:nth-child(2)")).isDisplayed());
	}

	@Test(priority=6)
	public void EnterLoginDetails()  {
		
		driver.findElement(By.xpath("//input[@id='logonId']")).sendKeys("ikhader.itgtesting@gmail.com");
		driver.findElement(By.xpath("//input[@id='logonPassword']")).sendKeys("b123456789");
		driver.findElement(By.xpath("//button[@id='logonButton']")).click();
		
		System.out.println(driver.findElement(By.xpath("//div[@id='myAccount']")).isDisplayed());

	}
	


}