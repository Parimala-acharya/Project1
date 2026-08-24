package Table;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TableLevelFilterBeginners {

	public static void main(String[] args) {
		
		
		WebDriver driver=new ChromeDriver();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
				driver.get("https://practicetestautomation.com/");
				driver.manage().window().maximize();
				
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());
				System.out.println("getting title and url in Home Page");
				
				driver.findElement(By.id("menu-item-20")).click();
				driver.findElement(By.linkText("Test Table")).click();
				//driver.findElement(By.xpath("//label[normalize-space()='Any']")).click();  //select "Any" Radio button
				
				By checkboxLocator = By.xpath("//input[@value='Intermediate']"); // Intermediate checkbox
		        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(checkboxLocator));

		        // 2. Safely uncheck it
		        if (checkbox.isSelected()) {
		            System.out.println("Intermediate Checkbox is currently selected. Unselecting it now...");
		            checkbox.click();
		        } else {
		            System.out.println("Intermediate Checkbox is already unselected. Skipping click step.");
		        }

		        // 3. Post-validation assertion
		        if (!checkbox.isSelected()) {
		            System.out.println("Success: Intermediate Checkbox is successfully unselected!");
		        } else {
		            System.out.println("Failure: Intermediate Checkbox is still selected.");
		        }

		       
		        
		        By checkboxLocator1 = By.xpath("//input[@value='Advanced']"); // Advanced checkbox
		        WebElement checkbox1 = wait.until(ExpectedConditions.elementToBeClickable(checkboxLocator1));

		        // 2. Safely uncheck it
		        if (checkbox1.isSelected()) {
		            System.out.println("Advanced Checkbox is currently selected. Unselecting it now...");
		            checkbox1.click();
		        } else {
		            System.out.println("Advanced Checkbox is already unselected. Skipping click step.");
		        }

		        // 3. Post-validation assertion
		        if (!checkbox1.isSelected()) {
		            System.out.println("Success: Advanced Checkbox is successfully unselected!");
		        } else {
		            System.out.println("Failure: Advanced Checkbox is still selected.");
		        }
		        

				//driver.findElement(By.xpath("//input[@value='Intermediate']")).click();
				//driver.findElement(By.xpath("//input[@value='Advanced']")).click();
				
				
				
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
		                throw new AssertionError("FAIL: The table is completely empty after selecting Beginners!");
		            }

		            boolean testFailed = false;

		            // 4. Loop through the rows using the row size to verify Column 3
		            for (int i = 1; i <= rowSize; i++) {
		                // Pinpoint Column 3 (Language) for the specific row index
		                By languageCellLocator = By.cssSelector(
		                    "table tbody tr:not([style*='display: none']):nth-child(" + i + ") td:nth-child(4)"
		                );
		                String LevelText = driver.findElement(languageCellLocator).getText().trim();

		                // Grab Column 2 (Course Name) just for cleaner test logging
		                By courseNameLocator = By.cssSelector(
		                    "table tbody tr:not([style*='display: none']):nth-child(" + i + ") td:nth-child(2)"
		                );
		                String courseNameText = driver.findElement(courseNameLocator).getText().trim();

		                // Verify Column 3 contains exactly "Java"
		                if (LevelText.equalsIgnoreCase("Beginner")) {
		                    System.out.println("✅ Row " + i + " PASSED | Course: [" + courseNameText + "] | Language is: " + LevelText);
		                } else {
		                    System.out.println("❌ Row " + i + " FAILED | Course: [" + courseNameText + "] | Found unexpected language: " + LevelText);
		                    testFailed = true;
		                }
		            }

		            // 5. Final Test Assertion Verdict
		            if (testFailed) {
		                System.out.println("\n🚨 TEST RESULT: FAILED. Non-Beginners courses were detected in Column 3.");
		            } else {
		                System.out.println("\n🎉 TEST RESULT: PASSED! 'Beginners' is successfully displayed in all " + rowSize + " rows.");
		            }
		

	}

}
