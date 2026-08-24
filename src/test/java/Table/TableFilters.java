package Table;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TableFilters {

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
				driver.findElement(By.linkText("Test Table")).click();
				//driver.findElement(By.xpath("//label[normalize-space()='Any']")).click();  //select "Any" Radio button
				
				driver.findElement(By.xpath("//label[normalize-space()='Java']")).click();   // select "Java" Radio button
				
				WebElement element = driver.findElement(By.xpath("//h5[contains(text(),'Test case 1: Language filter → Java')]"));
				new Actions(driver)
				.scrollToElement(element)
				.perform();
				
				
			      By visibleRowsLocator = By.cssSelector("tbody tr:not([style*='display: none'])");
		            List<WebElement> visibleRows = driver.findElements(visibleRowsLocator);
		            int rowSize = visibleRows.size();

		            System.out.println("=== Table Verification ===");
		            System.out.println("Total visible rows after filter: " + rowSize);
			        
			        if (rowSize == 0) {
		                throw new AssertionError("FAIL: The table is completely empty after selecting Java!");
		            }

		            boolean testFailed = false;

		            // 4. Loop through the rows using the row size to verify Column 3
		            for (int i = 1; i <= rowSize; i++) {
		                // Pinpoint Column 3 (Language) for the specific row index
		                By languageCellLocator = By.cssSelector(
		                    "table tbody tr:not([style*='display: none']):nth-child(" + i + ") td:nth-child(3)"
		                );
		                String languageText = driver.findElement(languageCellLocator).getText().trim();

		                // Grab Column 2 (Course Name) just for cleaner test logging
		                By courseNameLocator = By.cssSelector(
		                    "table tbody tr:not([style*='display: none']):nth-child(" + i + ") td:nth-child(2)"
		                );
		                String courseNameText = driver.findElement(courseNameLocator).getText().trim();

		                // Verify Column 3 contains exactly "Java"
		                if (languageText.equalsIgnoreCase("Java")) {
		                    System.out.println("✅ Row " + i + " PASSED | Course: [" + courseNameText + "] | Language is: " + languageText);
		                } else {
		                    System.out.println("❌ Row " + i + " FAILED | Course: [" + courseNameText + "] | Found unexpected language: " + languageText);
		                    testFailed = true;
		                }
		            }

		            // 5. Final Test Assertion Verdict
		            if (testFailed) {
		                System.out.println("\n🚨 TEST RESULT: FAILED. Non-Java courses were detected in Column 3.");
		            } else {
		                System.out.println("\n🎉 TEST RESULT: PASSED! 'Java' is successfully displayed in all " + rowSize + " rows.");
		            }
		
		

	}

}
