package demo.automation.base;

import org.testng.annotations.Optional;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	protected WebDriver driver;
	protected WebDriverWait wait;
	

	@BeforeClass
	@Parameters({"browser","url"})  // Allows passing browser type from testng.xml
	public void setUp(@Optional("chrome") String browser,@Optional("'https://demo.automationtesting.in/Register.html'") String url) {
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			System.out.println("Adding ad block extension to chrome driver");
			options.addExtensions(new File("src/test/Resources/AdBlockerLite.crx"));
			driver = new ChromeDriver(options);	
		}
		else if(browser.equalsIgnoreCase("edge")) driver = new EdgeDriver();
		else if(browser.equalsIgnoreCase("firefox")) driver = new FirefoxDriver();
		else {
			throw new IllegalArgumentException("invalid browser : "+browser);
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
//	@AfterClass
//	public void tearDown() {
//		if(driver != null) driver.quit();
//	}
}
