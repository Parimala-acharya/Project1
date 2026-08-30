package Table;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TableMinEnrollment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		 //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
		driver.get("https://practicetestautomation.com/");
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println("getting title and url in Home Page");
		
		driver.findElement(By.id("menu-item-20")).click();
		driver.findElement(By.linkText("Test Table")).click();
		driver.findElement(By.xpath("//div[@role='button']")).click();
		driver.findElement(By.xpath("//li[normalize-space()='10,000+']")).click();
		try
		{
			//List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
			
			WebElement element = driver.findElement(By.xpath("//h5[contains(text(),'Test case 1: Language filter → Java')]"));
			new Actions(driver)
			.scrollToElement(element)
			.perform();

        System.out.println("Checking enrollment counts...\n");
        By visibleRowsLocator = By.cssSelector("tbody tr:not([style*='display: none'])");
        List<WebElement> visibleRows = driver.findElements(visibleRowsLocator);
        int rowSize = visibleRows.size();

        System.out.println("=== Table Verification ===");
        System.out.println("Total visible rows after filter: " + rowSize);
        

        // Loop through each row to extract data
        for (WebElement row : visibleRows) {
            // Get the course name (Column 2)
            String courseName = row.findElement(By.xpath("./td[2]")).getText();
            
            // Get the enrollments text (Column 5)
            String enrollmentText = row.findElement(By.xpath("./td[5]")).getText();

            // Clean the text (remove commas if any) and convert to integer
            int enrollments = Integer.parseInt(enrollmentText.replace(",", "").trim());

            // Perform the validation check
            if (enrollments > 10000) {
                System.out.println("PASS: '" + courseName + "' has " + enrollments + " enrollments (More than 10,000).");
            } else {
                System.out.println("FAIL: '" + courseName + "' only has " + enrollments + " enrollments.");
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }// finally {
    	//driver.quit();
    
    //}
		
	
	}

}
