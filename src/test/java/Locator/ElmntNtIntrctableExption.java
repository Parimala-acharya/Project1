package Locator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElmntNtIntrctableExption {

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
					driver.findElement(By.linkText("Test Exceptions")).click();
					System.out.println("member navigated to exception page");
					System.out.println(driver.getTitle());
					System.out.println(driver.getCurrentUrl());
					driver.findElement(By.id("add_btn")).click();
					
					driver.findElement(By.xpath("//div[@id='row2']//input[@type='text']")).sendKeys("idli");
					driver.findElement(By.name("Save")).click();
					driver.findElement(By.id("edit_btn")).click();
	}

}
