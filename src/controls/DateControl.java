package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;
import utils.Events;

public class DateControl {
	private WebElement dateControl;
	private By by;
	private Events events;

	/**
	 * 
	 * @param dateControlName
	 * @param description
	 * @param util
	 * @param events
	 */
	public DateControl(String dateControlName, String description,
			ElementFinder util, Events events) {
		this.events = events;
		if (dateControlName.startsWith("name")) {
			dateControl = util.findElementByName(dateControlName);
		} else if (dateControlName.startsWith("css")) {
			dateControl = util.findElementByCss(dateControlName);
		} else if (dateControlName.startsWith("//")) {
			dateControl = util.findElementByXpath(dateControlName);
		} else if (dateControlName.startsWith("id")) {
			dateControl = util.findElementByID(dateControlName);
		} else {
			Report.log("date control is not found");
		}
		WebPage.elementList.put(dateControl, description);
	}

	/**
	 * This method will select a date in Date controls
	 * 
	 * @author Pradeep Sundaram
	 */
	public void click() {
		events.click(dateControl);
	}

	/**
	 * This method will return By of the dateControl
	 * 
	 * @author Pradeep Sundaram
	 * @return
	 */
	public By getBy() {
		return by;
	}

	/**
	 * This method will return the webelement for date control
	 * 
	 * @author Pradeep Sundaram
	 * @return
	 */
	public WebElement getWebElement() {
		return dateControl;
	}

	/**
	 * This method will return the tool tip of the dateControl
	 * 
	 * @author PSubramani33
	 * @return String
	 */
	public String getToolTip() {
		Report.log("Getting the tool tip of the button "
				+ WebPage.elementList.get(dateControl) + ".<BR>");
		return dateControl.getAttribute("title");
	}
}
