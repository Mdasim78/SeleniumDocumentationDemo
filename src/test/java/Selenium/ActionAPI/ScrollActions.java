package Selenium.ActionAPI;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

public class ScrollActions {
	// Unlike traditional click and send keys methods, the actions class does not automatically scroll the target element into view, 
	//so this method will need to be used if elements are not already inside the viewport.
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/themeroller/");
		
		Actions scrollAction = new Actions(driver);
		WebElement sliderHandle = driver.findElement(By.cssSelector("#slider .ui-slider-handle:nth-child(2)"));
		WebElement toolTip = driver.findElement(By.id("tooltip"));
		WebElement tab = driver.findElement(By.id("tabs"));
		
		//scroll to element
		//Regardless of whether the element is above or below the current viewscreen, the viewport will be scrolled so the bottom of the element is at the bottom of the screen.
		scrollAction.scrollToElement(sliderHandle).perform();
		
		//Scroll by given amount
		scrollAction.pause(Duration.ofSeconds(2)).scrollToElement(toolTip).scrollByAmount(0, 500).perform(); //we can use this to keep the element in middle while scrolling.
		
		//Scroll from an element by a given amount -- it's combination of scrollToElement & scrollByAmount
		WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(tab); //getting scroll origin
		scrollAction.pause(Duration.ofSeconds(2)).scrollFromOrigin(scrollOrigin, 0, 400).perform();
		
	}
}
