package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	
		WebDriver driver;
	
	 public void sendKeys(WebElement lm ,String value ) {
    	lm.clear();
    	try {
    		lm.sendKeys(value);
    	}
    	catch(Exception e){
    		System.out.println("null value entered");
    	}
    }
	 
	 public void sendKeys(By by,String s)
	 
	 {
		 WebElement elem=driver.findElement(by);
		 elem.clear();
		 try {
			 elem.sendKeys(s);
			 }
		 catch (IllegalArgumentException  e) {
			System.out.println("Null value Entered"); 
		}
	 }
	  
    
    public void selectRadioButton(List<WebElement> radios, String value) {
    	for(WebElement radio: radios) {
    		if(radio.getAttribute("value").equalsIgnoreCase(value)) {
    			radio.click();
    			break;
    		}
    	}
    }
    public void selectCheckbox(List<WebElement> box, List<String> values) {
    	for(String value: values) {
    		for(WebElement checkbox: box) {
    			if(checkbox.getAttribute("value").equalsIgnoreCase(value)) {
    				checkbox.click();
    				break;
    			}
    		}
    	}
    }
    
    public void multipleBox(WebDriver driver,WebElement multiselect, List<WebElement> languages,List<String> options) throws Exception {
    	multiselect.click();
    	for(String option:options) {
    	
    		for(WebElement language: languages) {
    			if (language.getText().equalsIgnoreCase(option)) {
    			   scrollToElement(driver,language);
    				language.click();   	
    			}	
    		}
    	}
    }	
	  
    public void toClick(WebElement elem) 
    {
    	elem.click();
    }
           
    public void toSubmit(WebElement elem)
    {
    	elem.submit();
    }
           
    private void scrollToElement(WebDriver driver, WebElement languages) 
    {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", languages);
	}
		
    public void selectDropDown(WebElement dropdown, String option) 
    {
        Select sc = new Select(dropdown);
        sc.selectByValue(option);
    }
        
    public void selectComboList(WebElement country, List<WebElement> select,String option) 
    {
       	country.click();
         	for(WebElement sel:select)
         	{
        		if (sel.getText().equalsIgnoreCase(option)) 
        		{
        			sel.click();
        			break;
        		}
        	}
    }
 }
