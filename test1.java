package newpack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class test1 {
	 public static void main(String[] args) {
		 
	        // Setup ChromeDriver
	        ChromeOptions options = new ChromeOptions();
	        // options.addArguments("--headless"); // Uncomment to run headless
	        WebDriver driver = new ChromeDriver(options);
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	 
	        try {
	            // 1. Navigate to SauceDemo
	            driver.get("https://www.saucedemo.com/");
	            driver.manage().window().maximize();
	 
	            // 2. Login
	            wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.cssSelector("[data-test='username']")));
	            driver.findElement(By.cssSelector("[data-test='username']"))
	                  .sendKeys("standard_user");
	            driver.findElement(By.cssSelector("[data-test='password']"))
	                  .sendKeys("secret_sauce");
	            driver.findElement(By.cssSelector("[data-test='login-button']"))
	                  .click();
	 
	            // 3. Click on product (item-4 = Sauce Labs Backpack)
	            wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.cssSelector("[data-test='item-4-title-link']")));
	            driver.findElement(By.cssSelector("[data-test='item-4-title-link']"))
	                  .click();
	 
	            // 4. Add to cart
	            wait.until(ExpectedConditions.elementToBeClickable(
	                By.cssSelector("[data-test='add-to-cart']")));
	            driver.findElement(By.cssSelector("[data-test='add-to-cart']"))
	                  .click();
	 
	            // 5. Go to cart
	            driver.findElement(By.cssSelector("[data-test='shopping-cart-link']"))
	                  .click();
	 
	            // 6. Proceed to checkout
	            wait.until(ExpectedConditions.elementToBeClickable(
	                By.cssSelector("[data-test='checkout']")));
	            driver.findElement(By.cssSelector("[data-test='checkout']"))
	                  .click();
	 
	            // 7. Fill checkout form
	            wait.until(ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//input[@id='first-name']")));
	            	  
	            driver.findElement(By.xpath("//input[@id='first-name']"))
	                  .sendKeys("yadu");
	            driver.findElement(By.cssSelector("[data-test='lastName']"))
	                  .sendKeys("krish");
	            driver.findElement(By.cssSelector("[data-test='postalCode']"))
	                  .sendKeys("68788");
	 
	            // 8. Click Continue
	            driver.findElement(By.cssSelector("[data-test='continue']"))
	                  .click();
	 
	            // 9. finish order
	            wait.until(ExpectedConditions.elementToBeClickable(
	                By.cssSelector("[data-test='cancel']")));
	            driver.findElement(By.cssSelector("[data-test='finish']"))
	                  .click();
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	 
	            System.out.println("Test completed successfully.");
	 
	        } catch (Exception e) {
	            System.err.println("Test failed: " + e.getMessage());
	            e.printStackTrace();
	        } finally {
	            driver.quit();
	        }
	    }
	}


