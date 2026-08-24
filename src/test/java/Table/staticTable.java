package Table;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class staticTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		int rows= driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		//int rows= driver.findElements(By.tagName("tr")).size();
		System.out.println("Number of rows :"+rows);
		
		//Total number of columns
		int cols= driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		//int cols= driver.findElements(By.tagName("th")).size();
		System.out.println("Number of columns :"+cols);
		
		//read data from specific row and column
		String Bookname=driver.findElement(By.xpath("//table[@name='BookTable']//tr[1]//th[2]")).getText();
		System.out.println(Bookname);
		
		for(int r=2;r<=rows;r++)
		{
			for(int c=1;c<=cols;c++)
			{
				String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.println(value+"\t");
			}
			System.out.println();
		}
		
		//print bookname whose author is
		
		for(int r=2;r<=rows;r++)
		{
			String authorName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			if(authorName.equals("Mukesh"))
			{
				String bookName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				System.out.println(bookName+"\t"+authorName);
			}
		}
		
		driver.quit();

	}

}
