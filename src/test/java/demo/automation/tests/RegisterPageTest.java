package demo.automation.tests;

import org.testng.annotations.Test;

import demo.automation.base.BaseTest;
import demo.automation.elements.RegisterPageElements;
import demo.automation.pages.RegisterPage;

public class RegisterPageTest extends BaseTest{
	
	
	@Test
	public void testUserRegistration() {
		
		System.setProperty("driver.chrome.driver", "C:\\Users\\skmoh\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver.get("https://demo.automationtesting.in/Register.html");
		RegisterPage registrationPage = new RegisterPage(driver);
		
		registrationPage.enterFirstName("Mohammed");
		registrationPage.enterLastName("Asim");
		registrationPage.enterAddress("demo address");
		registrationPage.enterEmail("demo@asim.com");
		registrationPage.enterPhone("1234567890");
		registrationPage.selectGender("male");
		registrationPage.selectHobbies("movies","Cricket");
		registrationPage.selectLanguages("English","Hindi");
		registrationPage.selectSkill("Java");
		driver.findElement(RegisterPageElements.country_dropDown1).click();
		registrationPage.selectCountry("India");
		registrationPage.selectDOByear("1997");
		registrationPage.selectDOBmonth("May");
		registrationPage.selectDOBdate("30");
		registrationPage.setPassword("Password@123");
		registrationPage.confirmPassword("Password@123");
		registrationPage.save();
	}
}
