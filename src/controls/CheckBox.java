package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;
import utils.Events;

public class CheckBox {
	private WebElement checkBox;
	private By by;
	private Events events;

	/**
	 * Check box Constructor
	 * 
	 * @author Pradeep Sundaram
	 * @param checkBoxName
	 * @param description
	 * @param util
	 * @param events
	 */
	public CheckBox(String checkBoxName, String description,
			ElementFinder util, Events events) {
		this.events = events;
		if (checkBoxName.startsWith("name")) {
			checkBox = util.findElementByName(checkBoxName);
		} else if (checkBoxName.startsWith("css")) {
			checkBox = util.findElementByCss(checkBoxName);
		} else if (checkBoxName.startsWith("//")) {
			checkBox = util.findElementByXpath(checkBoxName);
		} else if (checkBoxName.startsWith("id")) {
			checkBox = util.findElementByID(checkBoxName);
		} else {
			Report.log("check box is not found");
		}
		WebPage.elementList.put(checkBox, description);
	}

	/**
	 * Check box constructor with By
	 * 
	 * @author Pradeep Sundaram
	 * @param checkBoxName
	 * @param byOfCheckBox
	 * @param description
	 * @param util
	 */
	public CheckBox(String checkBoxName, By byOfCheckBox, String description,
			ElementFinder util) {
		if (checkBoxName.startsWith("name")) {
			checkBox = util.findElementByName(checkBoxName);
		} else if (checkBoxName.startsWith("css")) {
			checkBox = util.findElementByCss(checkBoxName);
		} else if (checkBoxName.startsWith("//")) {
			checkBox = util.findElementByXpath(checkBoxName);
		} else if (checkBoxName.startsWith("id")) {
			checkBox = util.findElementByID(checkBoxName);
		} else {
			Report.log("check box is not found");
		}
		by = byOfCheckBox;
		WebPage.elementList.put(checkBox, description);
	}

	/**
	 * This method will check the check box if it is unchecked
	 * 
	 * @author Pradeep Sundaram
	 */
	public void check() {
		Report.log("Check the checkbox " + WebPage.elementList.get(checkBox));
		events.check(checkBox);

	}

	/**
	 * this method will uncheck the check box if it is checked, leaves it if the
	 * check box is not checked
	 * 
	 * @author Pradeep Sundaram
	 */
	public void unCheck() {
		Report.log("uncheck the checkbox " + WebPage.elementList.get(checkBox));
		events.unCheck(checkBox);
	}

	/**
	 * This method will return whether the Check box is checked in the page
	 * 
	 * @author Pradeep Sundaram
	 * @return
	 */
	public boolean isChecked() {
		Report.log("Checking whether the field "
				+ WebPage.elementList.get(checkBox) + " is checked.");
		return checkBox.isSelected();
	}

	/**
	 * This method will return the By for the Check Box
	 * 
	 * @author Pradeep Sundaram
	 * @return By
	 */
	public By getBy() {
		return by;
	}

	/**
	 * This method will return the webelement of the check box
	 * 
	 * @author Pradeep Sundaram
	 * @return
	 */
	public WebElement getWebElement() {
		return checkBox;
	}

	/**
	 * will return boolean based on the presence of the check box
	 * 
	 * @author Pradeep Sundaram
	 * @return boolean
	 */
	public boolean isDisplayed() {
		Report.log("Checking whether the field "
				+ WebPage.elementList.get(checkBox) + " is displayed.");
		return checkBox.isDisplayed();
	}

	/**
	 * This method will return the tool tip of the checkBox
	 * 
	 * @author PSubramani33
	 * @return String
	 */
	public String getToolTip() {
		Report.log("Getting the tool tip of the button "
				+ WebPage.elementList.get(checkBox) + ".<BR>");
		return checkBox.getAttribute("title");
	}
}
