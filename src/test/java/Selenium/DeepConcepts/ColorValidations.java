package Selenium.DeepConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ColorValidations {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/animate/");
		
		Color colorAnimationDemo_bgColor = Color.fromString("#aa0000");  //extracts the color from the string can extract rgb/rgba/hex
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		driver.findElement(By.id("button")).click();
		new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.attributeToBe(By.id("effect"), "width", "500px"));  //waiting for width to be 500px
		Color actualColor = Color.fromString(driver.findElement(By.id("effect")).getCssValue("background-color")); //extracts the color from css style
		Assert.assertEquals(actualColor, colorAnimationDemo_bgColor);
	}

}
