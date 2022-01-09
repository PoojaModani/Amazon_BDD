package StepDefination;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Defination {
	
	
	public WebDriver driver;
	//Before hook − Set up the webdriver and other prerequisites to run the test.
	@Before public void setUp(){ 
		WebDriverManager.chromedriver().setup();
		driver =  new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Given("i should open the browser and navigate to the login page of amazon.com")
	public void i_should_open_the_browser_and_navigate_to_the_login_page_of_amazon_com() throws InterruptedException {
		driver.get("https://www.amazon.com");
		
		
		
		//login 
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys("asfiya.sultana@moolya.com");
		driver.findElement(By.xpath("//*[@id='continue']")).click();	
		driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys("Asfiya@123");
		driver.findElement(By.xpath("//*[@id='signInSubmit']")).click();
		 String name = driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
		    System.out.println(name);
		    Assert.assertEquals(name, "Hello, AFIYA");
		    Thread.sleep(3000);

		}  
	
//AddToCart
		@When("Click on Product displayed on homepage")
		public void click_on_product_displayed_on_homepage() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//*[@class='nav-input nav-progressive-attribute']")).sendKeys("Mobile");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("SAMSUNG Galaxy S20")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("add-to-cart-button")).click();
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot,new File("C:\\Users\\user\\Documents\\images\\addtocart.png"));
		}
		
		


//Payemnts
	
	
	@When("Click on Add to cart button")
	public void click_on_add_to_cart_button() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//*[@class='nav-input nav-progressive-attribute']")).sendKeys("Mobile");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("SAMSUNG Galaxy S20")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("add-to-cart-button")).click();
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot,new File("C:\\Users\\user\\Documents\\images\\payment.png"));
		
		
		}
	
	@When("Click on check out button")
	public void click_on_check_out_button() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.className("a-button-input")).click();
	} 
	
		
	@When("Click on dilver to this address")
	public void click_on_dilver_to_this_address() throws InterruptedException, IOException {
	Thread.sleep(3000);
	driver.findElement(By.linkText("Deliver to this address")).click();
	Thread.sleep(3000);
	driver.navigate().back();
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,200)");
	Thread.sleep(3000);
	WebElement link = driver.findElement(By.className("a-dropdown-prompt"));
	link.click();
	Thread.sleep(3000);
	WebElement element = driver.findElement(By.linkText("India"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	element.click();
	Thread.sleep(3000);
	WebElement fname = driver.findElement(By.xpath("//*[@id='address-ui-widgets-enterAddressFullName']"));
	fname.sendKeys("TomJerry");
	fname.click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id='address-ui-widgets-enterAddressPhoneNumber']")).sendKeys("8217698190");
	Thread.sleep(3000);
	JavascriptExecutor js1 = (JavascriptExecutor)driver;
	js1.executeScript("window.scrollBy(0,200)");
	driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("585103");
	Thread.sleep(3000);
	driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("Plot no 39");
	Thread.sleep(3000);
	driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("Shakti Nagar");
	Thread.sleep(3000);
	driver.findElement(By.id("address-ui-widgets-landmark")).sendKeys("Behind central bus strand");
	Thread.sleep(3000);
	js.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@class='a-section a-spacing-base adddress-ui-widgets-form-field-container address-ui-widgets-desktop-form-field']")).click();
	Thread.sleep(3000);
	driver.findElement(By.partialLinkText("Home ")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("address-ui-widgets-form-submit-button")).click();
	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshot,new File("C:\\Users\\user\\Documents\\images\\address.png"));
	
	
}


		
//After hook − Close the webdriver and do the cleanup process
@After public void cleanUp() throws InterruptedException{ 
	 Thread.sleep(3000);
      driver.close(); 
   }
		
	

}
	

