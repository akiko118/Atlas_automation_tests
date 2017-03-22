package com.backroads.webdriver.pageobjectsfactory.pageobject;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddActPage extends BasePageObject {

	@FindBy(id = "cboActivityCode")
	WebElement actCodeDropDown;
	@FindBy(id = "cboTripDeparture")
	WebElement tripDropDown;
	@FindBy(id = "cboArea")
	WebElement areaDropDown;
	@FindBy(id = "txtNotes")
	WebElement notesField;
	@FindBy(id = "txtAuthorizedBy")
	WebElement authByField;
	@FindBy(id = "txtFromDate1")
	WebElement date1Field;
	@FindBy(id = "txtFromDate2")
	WebElement date2Field;
	@FindBy(id = "txtFromDate3")
	WebElement date3Field;
	@FindBy(css = "#Table1 > tbody > tr:nth-child(10) > td:nth-child(2) > table > tbody > tr:nth-child(1) > td:nth-child(2) > a")
	WebElement date1CalButton;
	@FindBy(css = "#Table1 > tbody > tr:nth-child(10) > td:nth-child(2) > table > tbody > tr:nth-child(2) > td:nth-child(2) > a")
	WebElement date2CalButton;
	@FindBy(css = "#Table1 > tbody > tr:nth-child(10) > td:nth-child(2) > table > tbody > tr:nth-child(3) > td:nth-child(2) > a")
	WebElement date3CalButton;
	@FindBy(id = "txtQty1")
	WebElement date1HourField;
	@FindBy(id = "txtQty2")
	WebElement date2HourField;
	@FindBy(id = "txtQty3")
	WebElement date3HourField;
	@FindBy(id = "txtTips1")
	WebElement tipField;
	@FindBy(id = "txtNotes1")
	WebElement tipNotesField;
	@FindBy(id = "cmdUpdate")
	WebElement backToPayrollButton;	
	@FindBy(id = "cmdUpdate2")
	WebElement saveAddNotherActButton;
	
	//Calendar Window
	@FindBy(linkText = "1")
	WebElement firstDay;
	@FindBy(linkText = "2")
	WebElement secondDay;
	@FindBy(linkText = "3")
	WebElement thirdDay;
	
	
	public AddActPage(WebDriver driver) {
		super(driver);
	}
	
	public TimesheetPage fillDataAndSubmitTripUnrelatedAct(String activity, String area, String notes, String authBy, String [] dates, double [] hours){
		int numDates = dates.length;
		int numHours = hours.length;
		
		if (numDates != numHours && (numDates > 3 || numDates < 1 || numHours > 3 || numHours <1)) {
        	System.out.println("the number of dates/hours has to be 1 to 3 and the numbers of the array elements should be the same.");
        	return null;
        } 
		
		Select select = new Select(actCodeDropDown);
		select.selectByVisibleText(activity);
		select = new Select(areaDropDown);
		select.selectByVisibleText(area);
		notesField.sendKeys(notes);
		authByField.sendKeys(authBy);
		
		WebElement[] dateFields = {date1Field, date2Field, date3Field};
		WebElement[] hoursFields = {date1HourField, date2HourField, date3HourField};
		
		for (int i = 0; i < numDates; i++){
			dateFields[i].clear();
			dateFields[i].sendKeys(dates[i]);
			hoursFields[i].clear();
			hoursFields[i].sendKeys(String.valueOf(hours[i]));
			if(i != numDates-1){
				saveAddNotherActButton.click();
			}
		}
		backToPayrollButton.click();
		driver.switchTo().alert().accept();
		return PageFactory.initElements(driver, TimesheetPage.class);	}
}