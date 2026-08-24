package Locator;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDay1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
WebDriver driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://practicetestautomation.com/");
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println("getting title and url in Home Page");
		
		driver.findElement(By.id("menu-item-20")).click();
		driver.findElement(By.linkText("Test Login Page")).click();
		System.out.println("member navigated to login page");
		driver.findElement(By.id("username")).sendKeys("studentt");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.xpath("//button[@id='submit']")).click(); 
		//driver.findElement(By.xpath("//div[@id='error']")).getText();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.xpath("//button[@id='submit']")).click(); 
		driver.findElement(By.linkText("Log out")).click();
		
		driver.findElement(By.id("menu-item-20")).click();
		driver.findElement(By.linkText("Test Exceptions")).click();
		System.out.println("member navigated to exception page");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.id("add_btn")).click();
		
		driver.findElement(By.xpath("//div[@id='row2']//input[@type='text']")).sendKeys("idli");
		driver.findElement(By.xpath("(//button[@id='save_btn'])[2]")).click();
		driver.findElement(By.id("edit_btn")).click();
		
		   //WebElement textInputElement = driver.findElement(By.xpath("//div[@id='row2']//input[@type='text']"));
	      // String actualText = textInputElement.getText();

	        // Verify the text matches the expected value
	        //String expectedText = "idli";
	      // Assert.assertEquals(actualText, expectedText, "Content does not match!");
	       
	       //Thread.sleep(5000);
	       driver.close();
		

	}

}
