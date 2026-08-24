package Day1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstTestCase {
	
	public static void main(String[] args) {  
		
		//ChromeDriver driver=new ChromeDriver();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		String act_title=driver.getTitle();
		System.out.println(act_title);
		if(act_title.equals("OrangeHRM"))
		{
		System.out.println("Test Passed");
		}
		else 
		{
			System.out.println("Test Failed");
			
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		
		//driver.findElement(By.name("username")).sendKeys("Admin");
		WebElement usernameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("username")));
                usernameField.sendKeys("Admin");
                
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		
	
		//driver.quit();
	}

}
