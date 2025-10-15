package Selenium.DeepConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConceptualQuestions {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://admin-demo.nopcommerce.com");
		WebElement emailElement = driver.findElement(By.id("Email"));
		
		emailElement.clear(); //clears the text field
		emailElement.sendKeys("Asim123@email.com"); //enters any value
		
		//difference between getDOMAttribute, getAttribute,getText
		System.out.println("Text from email field using getText(): "+emailElement.getText()); //fetches text inside a tag example <h1>text<h1>
		System.out.println("Text from email field using getDomAttribute(\"value\"): "+emailElement.getDomAttribute("value")); //gives the default value of the field when the page get loaded
		System.out.println("Text from email field using getAttribute(\"value\"): "+emailElement.getAttribute("value")); //gives the current value of the field after making changes
		System.out.println("Text from email field using getDomProperty(\"value\"): "+emailElement.getDomProperty("value")); //same as getAttribute
	}
}
