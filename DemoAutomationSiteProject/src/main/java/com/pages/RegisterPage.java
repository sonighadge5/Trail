package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BaseClass{
	WebDriver driver;

	@FindBy(xpath="//input[@ng-model='FirstName']")
	 private WebElement firstName;
	
	//By firstName=By.xpath("//input[@ng-model='FirstName']");
	
	@FindBy(xpath="//input[@ng-model='LastName']")
	 private WebElement lastName;
	@FindBy(xpath="//textarea[@ng-model='Adress']")
	 private WebElement address;
	@FindBy(xpath="//input[@ng-model='EmailAdress']")
	 private WebElement email;
	@FindBy(xpath="//input[@ng-model='Phone']")
	 private WebElement phone;
	
	@FindBy(xpath="//input[@ng-model='radiovalue']")
	 private List<WebElement> gender;
	
	@FindBy(xpath="//input[@type='checkbox']")
	 private List<WebElement> hobbies;
	
	@FindBy(xpath="//div[@id='msdd']")
	 public WebElement Singlelanguage;
	@FindBy(xpath="//a[@class='ui-corner-all']")
	private List<WebElement> multiLanguage;
	
	@FindBy(xpath="//select[@id='Skills']")
	 private WebElement skills;
	
	@FindBy(xpath="//span[@role='combobox']")
	 private WebElement combobox;
	@FindBy(xpath="//input[@type='search']")
	 private WebElement search;
	@FindBy(xpath="//li[@class='select2-results__option']")
	 private List<WebElement> selectCountry;
	
	@FindBy(xpath="//select[@id='yearbox']")
	 private WebElement year;
	@FindBy(xpath="//select[@ng-model='monthbox']")
	 private WebElement month;
	@FindBy(xpath="//select[@ng-model='daybox']")
	 private WebElement day;
	
	@FindBy(xpath="//input[@id='firstpassword']")
	 private WebElement password;
	@FindBy(xpath="//input[@id='secondpassword']")
	 private WebElement Confirmedpassword;
	
	@FindBy(xpath="//button[@id='submitbtn']")
	 private WebElement submit;
	@FindBy(xpath="//button[@id='Button1']")
	 private WebElement refresh;

           
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
		
	@Override
	public void sendKeys(WebElement lm ,String value )
	{
		Actions action=new Actions(driver);
		action.sendKeys(lm, value).perform();
		//System.out.println("override");
	}
	
	public void enterFirstName(String name)
	{		
		sendKeys(firstName,name);
	}
	
	public void enterLastName(String name)
	{
		sendKeys(lastName, name);
	}
	
	public void enterAddress(String add)
	{
		sendKeys(address, add);
	}
	
	public void enterEmail(String emailvalue)
	{
		sendKeys(email, emailvalue);
	}
	
	public void enterphone(String phonev)
	{
		sendKeys(phone,phonev);
	}
	
	public void enterPassword(String pass)
	{
		sendKeys(password,pass);
	}
	
	public void enterCpassword(String pass)
	{
		sendKeys(Confirmedpassword,pass);
	}
	
	public void selectLanguages(List<String> li) throws Exception 
	{
		multipleBox(driver, Singlelanguage, multiLanguage, li);
		toClick(phone);
	}
	
	public void selectGender(String gen)
	{
		selectRadioButton(gender,gen);
	}
	
	public void SelectHobbies(List<String> li) 
	{
		selectCheckbox(hobbies, li);
	}
	
	public void selectSkills(String skill) 
	{
		selectDropDown(skills,skill);
	}	
	
	public void selectYear(String y)
	{
		selectDropDown(year,y);
	}
	
	public void selectMonth(String m)
	{
		selectDropDown(month,m);
	}
	
	public void selectDay(String d)
	{
		selectDropDown(day,d);
	}
	
	public void selectCountry(String c) 
	{ 
		selectComboList(combobox,selectCountry,c);
	}
	 
	 public void refresh() 
	 {
		toClick(refresh);
	 }
}
