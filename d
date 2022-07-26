@@ -0,0 +1,36 @@
package com.frontgate.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicTest5 {
	private static final long TimeOut = 10;

	@Test(dataProvider = "loginTestData", dataProviderClass = ExcelDataSupplier.class)
	public void TestLogin(String Email, String password) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		SoftAssert softAssert = new SoftAssert(); 
		
		driver.get("https://devwcs.frontgate.com/ShoppingCartView");
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.cssSelector("#proceed-link")).click();
		driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
		driver.findElement(By.id("gwt-sign-in-modal")).sendKeys(Email);
		driver.findElement(By.id("passwordReset")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='logonButton']")).click();
		System.out.println("The login process has been completed successfully");
        driver.quit();

	}

}
