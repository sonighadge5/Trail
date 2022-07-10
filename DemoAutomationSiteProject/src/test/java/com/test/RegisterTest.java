package com.test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pages.BaseClass;
import com.pages.RegisterPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterTest extends BaseClass{ 
	WebDriver driver;
	
	
  @BeforeSuite
  public void setup() {
		//System.setProperty("webdriver.chrome.driver","chromedriver98.exe" );
		WebDriverManager.chromedriver().setup();
	   	driver=new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		}
  
  @AfterSuite
	public void tearDown() {
		//driver.close();
	}
  
  @Test
  public void registerForm() throws Exception {
	  RegisterPage rp = new RegisterPage(driver);
	  rp.enterFirstName("Sonali");
	  rp.enterLastName("Ghadge");
	  rp.enterAddress("Satara");
	  rp.enterEmail("sonighadge5@gamil.com");
	  rp.enterphone("9823225355");
	  rp.selectGender("Female");
	  
	  List<String> hobbieList = new ArrayList<String>();
		hobbieList.add("cricket");
		hobbieList.add("hockey");
	  rp.SelectHobbies(hobbieList);
	  
	  List<String> languageList = new ArrayList<String>();
		languageList.add("Arabic");
		languageList.add("English");
		languageList.add("Danish");
	  rp.selectLanguages(languageList);
	  
	  rp.selectSkills("C++");
	  rp.selectCountry("India");
	  rp.selectYear("1982");
	  rp.selectMonth("June");
	  rp.selectDay("5");
	  rp.enterPassword("45626");
	  rp.enterCpassword("45626");
	  //rp.refresh();
  	}
}

