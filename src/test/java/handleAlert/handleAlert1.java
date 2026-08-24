package handleAlert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class handleAlert1 {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(1));
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());
		
		
		//second alert OK button
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());
		
		//second alert cancel button
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		System.out.println("texton Alert popup - "+ driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());
		System.out.println("Alert popup 2 is  checked");
		
		
		//third alert input and accept
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		System.out.println("texton Alert popup - "+ driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys("alert");
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());
		
		
		
		//third alert input and dismiss
//		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
//		System.out.println("texton Alert popup - "+ driver.switchTo().alert().getText());
//		driver.switchTo().alert().sendKeys("alert");
//		//driver.switchTo().alert().dismiss();
//		System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());
		System.out.println("Alert popup 3 is  checked");
		
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		System.out.println("Page ie refreshed now");
		Thread.sleep(3000);
		
		driver.close();
		

	}
	

}
