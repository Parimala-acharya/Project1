package Dropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.sun.tools.javac.util.List;

public class selectDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement drpcountryEle=driver.findElement(By.xpath("//select[@id='country']"));
		Select drpcountry=new Select(drpcountryEle);
		//Thread.sleep(3000);
		//select option from dropdown
		drpcountry.selectByVisibleText("France");
		//Thread.sleep(3000);
		drpcountry.selectByValue("japan");
		//Thread.sleep(3000);
		drpcountry.selectByIndex(2);
		//Thread.sleep(3000);
		
		
		//capture options from dropdown
		//List<WebElement> options=drpcountry.getOptions();
		System.out.println("Number of optionsin a dropdown : "+drpcountry.getOptions().size());
		
		//printing options from dropdown
		for(int i=0;i<drpcountry.getOptions().size();i++)
		{
			System.out.println(drpcountry.getOptions().get(i).getText());
		}
		
		driver.quit();
		
		
		
		
		
		

	}

}
