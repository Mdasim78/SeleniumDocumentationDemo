package demo.automation.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	@BeforeClass
	@Parameters({"browser"})  // Allows passing browser type from testng.xml
	public void setUp(String browser) {
		if(browser.equalsIgnoreCase("chrome")) driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("edge")) driver = new EdgeDriver();
		else if(browser.equalsIgnoreCase("firefox")) driver = new FirefoxDriver();
		else {
			throw new IllegalArgumentException("invalid browser : "+browser);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
//	@AfterClass
//	public void tearDown() {
//		if(driver != null) driver.quit();
//	}
}
