package Selenium.ActionAPI;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class KeyboardActions {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://admin-demo.nopcommerce.com");
		WebElement emailElement = driver.findElement(By.id("Email"));
		WebElement passwordElement = driver.findElement(By.id("Password"));
		emailElement.clear();
		emailElement.sendKeys("Email");
		
		//Create instance of actions class
		Actions keyboardAction = new Actions(driver);
		
		///// copy paste a text
//		keyboardAction
//			.keyDown(emailElement,Keys.CONTROL) //focuses on the element and presses the key but doesn't release automatically
//			.sendKeys("a") //if element is not passed as parameter, focuses on already focused element press key "a" to select all text
//			.sendKeys("c") //press key "c" to copy selected text
//			.pause(Duration.ofSeconds(3)) //we can pause while performing an action temporarily
//			.sendKeys("vv") //pastes the copied text twice
//			.perform(); // perform() is must for actual action to work
		
		//the above action can be done using 
		keyboardAction.keyDown(emailElement,Keys.CONTROL).sendKeys("acvv").perform(); //pastes the copied text twice
		System.out.println("Text from email field: "+ emailElement.getAttribute("value"));
		
		//copying from email field and pasting in password field
		keyboardAction.sendKeys(emailElement,"ac").sendKeys(passwordElement,"av").perform(); //since CTRL key is already in pressed state we need not press it again
		System.out.println("Text from passwordfield: "+ passwordElement.getAttribute("value"));
		
		//release the CTRL key
		keyboardAction.keyUp(Keys.CONTROL);  //only releases CTRL key
		((RemoteWebDriver) driver).resetInputState(); //resets driver input state and resets all action states to default state
		keyboardAction.sendKeys(passwordElement,"ac").sendKeys("av").perform(); //this will only send "acav" text to password field
		System.out.println("Text from password field: "+ passwordElement.getAttribute("value"));
		
		/*
		 *sendKeys() method presses and releases key automatically 
		 *keyDown()/keyUp() keeps the state until it's released manually
		 */
		
	}
}
