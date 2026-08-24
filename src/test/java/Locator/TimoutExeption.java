package Locator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimoutExeption {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));  
				
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
				 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

		            // 2. Wait until the element is visible on the page
		            By elementLocator = By.xpath("//div[@id='row2']//input[@type='text']"); 
		            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));

		            // 3. Verify it is displayed
		            if (element.isDisplayed()) {
		                System.out.println("Success: Element is visible within 3 seconds.");
		            }
				driver.findElement(By.xpath("//div[@id='row2']//input[@type='text']")).sendKeys("idli");
				
	}

}
