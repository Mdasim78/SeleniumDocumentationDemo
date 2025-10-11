package Selenium.Interactions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cookies {
	
	/*
	 * A cookie is a small piece of data that is sent from a website and stored in your computer. 
	 * Cookies are mostly used to recognize the user and load the stored information.
	 * This way we can skip login through UI and login with different user and saved data for each user
	 */
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		//step1 - open url with correct domain name
		driver.get("https://admin-demo.nopcommerce.com");
		
		//step2 - Add cookie - It is used to add a cookie to the current browsing context.
		Cookie cookie = new Cookie(".Nop.Authentication", "CfDJ8O73OK6O-apCqOqBSd3cxtqdmOpijtRC83AzEWdmb8R529nQYVcLq9Z2i8TlNj27W-f8e3yUlyUg392RsT94rDTgzGkVy1UCUup-X0P-TW7HkEArpGok9PmrUyWW6U0_nuOomcYGGlJwMkpxbKxC-HFVaZfApNaM7mNgKBsRqOaVMO6uH7CrrdIyaCsQd7Fk9_qb0oyh9I7mNCDD1LAoALD7qyGMyDI7-WIPpgmSRMWeJm3HGD7OdFrgy4qW6KMVxCr43lZLdQhrKHY7xv9HKFGAZOkeQST52elkG9e_rcQg3mFVm5KjL2l3jzC5oygYO_hYSsCArsjt5b5iC90DmxX6qXzFZzqWsF1IWX1cORxbOdvavnDEswBZ52V15K1e6U2D67mCZPke4SNXsXpX1l5NAIOwhwzW3sxzXf1cTh9noqqEJG9XkrPw60kRBWScdo4u-n1C8y9IxQ812kdTNUxBSB8CWUfVz0wu9o4CzWezVTqhgMKdIoZIni_dhJz54E99UGw2MkFbkp1QNDCHZpDR1t23BqII0YEjEahauHYIkbehVq4kNUAogCAf66X6fQ");
		driver.manage().addCookie(cookie);
		
		//step3 - navigate to the "after login page"
		driver.navigate().to("https://admin-demo.nopcommerce.com/admin/");
		if(driver.findElement(By.cssSelector(".card-body h4")).getText().contains("Welcome to your store!")) 
				System.out.println("Successfully logged in using Cookies");
		else System.out.println("Not able to login");
		
		
		//getting all the cookies
		Set<Cookie> cookies = driver.manage().getCookies();
		for(Cookie c : cookies) {
			System.out.println("CookieName: "+c.getName() +" | "+"CookieValue: "+c.getValue());
			System.out.println(c.getDomain());
		}
		
		//getting cookie using cookie name
		System.out.println(driver.manage().getCookieNamed(".Nop.Customer"));
		
		//delete cookie using cookie object
		driver.manage().deleteCookie(cookie);
		
		//delete cookie using cookie name
		driver.manage().deleteCookieNamed(".Nop.Customer");
		
		//delete all cookies
		driver.manage().deleteAllCookies();
		
		
		///// FYI -- Other manage options/////
		//driver.manage().window() - for driver window management
		driver.manage().window().getPosition(); //get the point object with x,y coordinate from top right corner
		driver.manage().window().fullscreen(); //makes the current window fullscreen
		driver.manage().window().getSize(); //get the window dimension as dimentsion object
		driver.manage().window().setSize(new Dimension(600, 600));
		driver.manage().window().maximize();
		driver.manage().window().minimize();
		driver.manage().window().setPosition(new Point(550, 200));
		
		//driver.manage().timeouts() - for timeout management
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
		
		
	}
}
