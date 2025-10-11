package Selenium.Interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://selenium.dev"); //opens a given url
		driver.navigate().to("https://selenium.dev");
		driver.navigate().refresh();
		driver.navigate().forward();
		driver.navigate().back();
		
		/*
		 * Use driver.get() for initial page loads (starting your test).
			Use driver.navigate().to() when you want to move between pages during navigation (like back() and forward())
				without calling a method multiple times for example if you want need to call back() method two times to 
				navigate to page at that time you can use navigate().to("url") to get to that page.
		 */
		
	}
}
