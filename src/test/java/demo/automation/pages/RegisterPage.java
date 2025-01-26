package demo.automation.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import demo.automation.elements.RegisterPageElements;

public class RegisterPage {
	private WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterFirstName(String firstName) {
		driver.findElement(RegisterPageElements.firstName_field).sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		driver.findElement(RegisterPageElements.lastName_field).sendKeys(lastName);
	}

	public void enterAddress(String address) {
		driver.findElement(RegisterPageElements.address_field).sendKeys(address);
	}

	public void enterEmail(String email) {
		driver.findElement(RegisterPageElements.email_field).sendKeys(email);
	}

	public void enterPhone(String phone) {
		driver.findElement(RegisterPageElements.phone_field).sendKeys(phone);
	}

	public void selectGender(String gender) {
		if(gender.equalsIgnoreCase("male")) driver.findElement(RegisterPageElements.male_raioBtn).click();
		else if(gender.equalsIgnoreCase("female")) driver.findElement(RegisterPageElements.female_raioBtn).click();
	}

	public void selectHobbies(String... Hobbies) {
		for(String hobby : Hobbies) {
			try {
				driver.findElement(RegisterPageElements.getHubbyCheckBox(hobby)).click();
			}
			catch(NotFoundException e) {
				System.out.println("hobby not found");
			}
		}
	}

	public void selectLanguages(String... languages) {
		driver.findElement(RegisterPageElements.languages_msdropDown).click();
		for(String language : languages) {
			try {
				driver.findElement(RegisterPageElements.getLanguageOption(language)).click();
			}
			catch(NotFoundException e) {
				System.out.println("language not found");
			}
		}
	}

	public void selectSkill(String skill) {
		Select selectSkill = new Select(driver.findElement(RegisterPageElements.skills_dropDown));
		selectSkill.selectByValue(skill.substring(0,1).toUpperCase()+skill.substring(1).toLowerCase());
	}
	
	
	public void selectCountry(String country) {
		try {
			driver.findElement(RegisterPageElements.country_dropDown).click();
			driver.findElement(RegisterPageElements.country_searchField).sendKeys(country);
			driver.findElement(RegisterPageElements.country_searchField).sendKeys(Keys.ENTER);
			//new Actions(driver).keyDown(Keys.ENTER);
		}
		catch (NotFoundException e) {
			System.out.println("country not found");
		}
	}

	public void selectDOByear(String year) {
		Select selectDOByear = new Select(driver.findElement(RegisterPageElements.dob_year_dropDown));
		selectDOByear.selectByValue(year);
	}

	public void selectDOBmonth(String month) {
		Select selectDOBmonth = new Select(driver.findElement(RegisterPageElements.dob_month_dropDown));
		selectDOBmonth.selectByValue(month);
	}

	public void selectDOBdate(String date) {
		Select selectDOBdate = new Select(driver.findElement(RegisterPageElements.dob_day_dropDown));
		selectDOBdate.selectByValue(date);
	}

	public void setPassword(String password) {
		driver.findElement(RegisterPageElements.pswd_field).sendKeys(password);
	}

	public void confirmPassword(String password) {
		driver.findElement(RegisterPageElements.confirm_pswd_field).sendKeys(password);
	}

	public void save() {
		driver.findElement(RegisterPageElements.save_btn).click();
	}
}
