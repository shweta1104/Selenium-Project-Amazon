package amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MenuTest {

	public static WebDriver driver;
	
	// Setup method
	public static void setup(String path) {
		System.setProperty("webdriver.gecko.driver", path);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}
	
	// Method to open the url
	public static void launchURL(String baseUrl) {
		driver.get(baseUrl);
		
	}
	
	
	// Method to check whether webelement is visible or not
	public static boolean webElementIsDisplayed(String xPath) {
		WebElement myElement = driver.findElement(By.xpath(xPath));
		boolean isDisplayed = myElement.isDisplayed();
		return isDisplayed;		
	}
	
	// Method to check whether webelement is enabled or not
	public static boolean webElementIsEnabled(String xPath) {
		WebElement myElement = driver.findElement(By.xpath(xPath));
		boolean isEnabled = myElement.isDisplayed();
		return isEnabled;		
	}
	
	// method to click on the webelement
	public static void webElementClick(String xPath) {
		WebElement myElement = driver.findElement(By.xpath(xPath));
		System.out.println("I am executed");

		myElement.click();	
	}
	// Main method
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		setup("E:\\Automation Downloads\\geckodriver-v0.25.0-win64\\geckodriver.exe");
		launchURL("https://www.amazon.com");
		
		// clicking on the menu if the menu icon is displayed and enabled
		String xpath = "//a[@id ='nav-hamburger-menu']";
		if(webElementIsDisplayed(xpath) && webElementIsEnabled(xpath) ) {
			Thread.sleep(3000);
			 webElementClick("//div[@id = 'glow-ingress-block']");
		}
		else {
			System.out.println("The webelement is either hidden or disabled.");
		}
		
		System.out.println("My new changes in commit");
		System.out.println("My new changes in commit2");
		
		System.out.println("My new changes in commit3");
		System.out.println("My new changes in commit4");
		System.out.println("My new changes in commit5");
		

	}

}
