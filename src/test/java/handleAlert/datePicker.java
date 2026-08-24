package handleAlert;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class datePicker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		//switch to frame
		driver.switchTo().frame(0);
		//Method1- sendkeys
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("05/05/2025");
		
		//Method1
		String year="2025";
		String month="May";
		String date="10";
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		//select month and year
		while(true)
		{
			String currentMonth= driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear= driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
		if(currentMonth.equals(month) && currentYear.equals(year))
		{
			break;
		}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			
			//select Date
			List <WebElement> allDates=(List<WebElement>) driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
			
			for(WebElement dt:allDates)
			{
				if(dt.getText().equals(date))
				{
					dt.click();
				}
			}
		}
		
		

	}

}
