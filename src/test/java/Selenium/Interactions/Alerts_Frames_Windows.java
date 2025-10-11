package Selenium.Interactions;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts_Frames_Windows {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		/////////switch to options
		driver.switchTo().alert();
		driver.switchTo().window("window-id");
		driver.switchTo().activeElement();// switches to focused element
		driver.switchTo().frame("index/id/web-element");
		driver.switchTo().newWindow(WindowType.WINDOW); //creates new WindowType.WINDOW or WindowType.TAB
		driver.switchTo().defaultContent(); //switches to the main content or main/first frame of the page
		driver.switchTo().parentFrame(); //switches to parent dame of the current frame
		
		//Interaction with Alerts
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.dismiss();
		alert.getText(); //gets the alert text
		alert.sendKeys("send message to aleart input box");
		
		//Interaction with frames
		driver.switchTo().frame(2); //frame index = 2
		driver.switchTo().frame("frame element name"); //finding frame using name
		driver.switchTo().frame("frame element id");	//finding frame using id
		driver.switchTo().frame(driver.findElement(By.xpath(""))); //finding frame using element itself
		driver.switchTo().parentFrame(); //switches to parent dame of the current frame
		driver.switchTo().defaultContent(); //switches to the main content or main/first frame of the page
		
		//Interaction with windows
		driver.switchTo().window("window-id");
		driver.switchTo().newWindow(WindowType.WINDOW); //creates new WINDOW
		driver.switchTo().newWindow(WindowType.TAB); //creates new TAB
		
		//--fyi
		String windowHandle = driver.getWindowHandle(); //gives the current window id
		Set<String> windowHandles = driver.getWindowHandles(); //gives set all of all opened windows and tabs by the current driver instance
		
	}
}
