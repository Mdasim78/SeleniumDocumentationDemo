package Selenium.ActionAPI;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement contextBtn = driver.findElement(By.xpath("//span[text()='right click me']"));
		WebElement contextBtnCopy = driver.findElement(By.cssSelector(".context-menu-list>.context-menu-icon-copy"));
		WebElement exampleCodeEle = driver.findElement(By.id("example-code-simple-context-menu"));
		
		
		//Create instance of actions class
		Actions mouseAction = new Actions(driver);
		
		//click and hold
		mouseAction.clickAndHold(contextBtn).perform(); // perform() is must for actual action to work
		
		
		//Context/right Click
		mouseAction.contextClick().perform();
		
		//Click and release
		mouseAction.click(contextBtnCopy).perform();
		
		//double click
		mouseAction.doubleClick(exampleCodeEle).perform(); //here double click is done to select text
		
		//move the mouse pointer  --  element must be in the viewport or else the command will error. 
		//if the elements are outside of the viewport we must scroll to that element before performing actions else error will be thrown
		mouseAction.moveToElement(contextBtn).perform(); //move to element "contextBtn"
		mouseAction.moveByOffset(200, 300).perform(); //move to element offset
		mouseAction.moveToLocation(500, 500).perform(); //move to coordinate -- element must be in the viewport or else the command will error.
		
		//drag and drop
		driver.navigate().to("https://jqueryui.com/sortable/");
		driver.findElement(By.xpath("//a[text()='Droppable']")).click();
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		mouseAction.dragAndDrop(draggable, droppable).perform(); //PERFORM DRANG AND DROP
		
		
		driver.switchTo().defaultContent(); //switches to main content
		driver.findElement(By.xpath("//a[text()='Sortable']")).click();
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		mouseAction.clickAndHold(item1)  //clicks and holds item1
				.moveToElement(item5, 0, 10) // move the item1 to item5 and offset y coordinate by 5 pixel
				.pause(Duration.ofSeconds(2)) //pause for 2 seconds
				.release().perform(); //release() release the item1 and performs the action
		
		//drag and drop using offset
		//This method firstly performs a click-and-hold on the source element, moves to the given offset and then releases the mouse.
		mouseAction.pause(Duration.ofSeconds(2)).dragAndDropBy(item5, 40, 100).perform();
		
		
		//moving a slider by 300 pixel
		driver.navigate().to("https://jqueryui.com/themeroller/");
		WebElement sliderHandle = driver.findElement(By.cssSelector("#slider .ui-slider-handle:nth-child(2)"));
		mouseAction
				.clickAndHold(sliderHandle)
				.moveByOffset(300, 0)
				.release()
				.perform();
	}
}
