package demo.automation.elements;

import org.openqa.selenium.By;

public class RegisterPageElements {
	
	public static final By firstName_field = By.cssSelector("input[placeholder='First Name']");
	public static final By lastName_field = By.cssSelector("input[placeholder='Last Name']");
	public static final By address_field = By.xpath("//textarea[@ng-model='Adress']");
	public static final By email_field = By.xpath("//input[@ng-model='EmailAdress']");
	public static final By phone_field = By.xpath("//input[@type='tel']");
	public static final By male_raioBtn = By.xpath("//input[@value='Male']");
	public static final By female_raioBtn = By.xpath("//input[@value='FeMale']");
	public static final By languages_msdropDown = By.id("msdd");
	public static final By skills_dropDown = By.id("Skills");
	public static final By country_dropDown1 = By.id("countries");
	public static final By country_dropDown = By.xpath("//span[@aria-labelledby='select2-country-container']");
	public static final By country_searchField = By.xpath("//input[@class='select2-search__field']");
	public static final By dob_year_dropDown = By.id("yearbox");
	public static final By dob_month_dropDown = By.xpath("//select[@ng-model='monthbox']");
	public static final By dob_day_dropDown = By.id("daybox");
	public static final By pswd_field = By.id("firstpassword");
	public static final By confirm_pswd_field = By.id("secondpassword");
	public static final By save_btn = By.id("submitbtn");
	public static final By refresh_btn = By.id("Button1");
	
	public static By getHubbyCheckBox(String hobby) {
		String hobbies = hobby.substring(0,1).toUpperCase()+hobby.substring(1).toLowerCase();
		return By.xpath("//input[@value='"+hobbies+"']");
	}
	
	public static By getLanguageOption(String language) {
		String languages = language.substring(0,1).toUpperCase()+language.substring(1).toLowerCase();
		return By.xpath("//a[text()='"+languages+"']");
	}
	
}
