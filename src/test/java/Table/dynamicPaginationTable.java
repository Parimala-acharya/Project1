package Table;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamicPaginationTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.opencart.com/index.php?route=cms/demo");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='https://demo.opencart.com/TlbeVW/']")).click();
		
		WebElement username= driver.findElement(By.xpath("//input[@id='input-username']"));
		username.clear();
		username.sendKeys("demo");
		
		WebElement password= driver.findElement(By.xpath("//input[@id='input-password']"));
		password.clear();
		password.sendKeys("demo");
		
		
		if(driver.findElement(By.xpath("//button[normalize-space()='Login']")).isDisplayed());
		{
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		}
		
		//blocked as page is not loading.
		

	}

}
