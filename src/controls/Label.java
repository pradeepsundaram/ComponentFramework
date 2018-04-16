package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;
import utils.Events;

public class Label {
	private By by;
	private WebElement lbl;
	public Events events;

	/**
	 * Label constructor
	 * 
	 * @author Pradeep Sundaram
	 * @param label
	 * @param desc
	 */
	public Label(String label, String description, ElementFinder util,
			Events events) {
		this.events = events;
		if (label.startsWith("//")) {
			lbl = util.findElementByXpath(label);
		} else if (label.startsWith("id")) {
			lbl = util.findElementByID(label);
		}
		WebPage.elementList.put(lbl, description);
	}

	/**
	 * Label constructor with By
	 * 
	 * @author Pradeep Sundaram
	 * @param label
	 * @param desc
	 */
	public Label(String label, By byOfLabel, String description,
			ElementFinder util) {
		if (label.startsWith("//")) {
			lbl = util.findElementByXpath(label);
		}
		by = byOfLabel;
		WebPage.elementList.put(lbl, description);
	}

	/**
	 * This method will return the content in the Label
	 * 
	 * @author Pradeep Sundaram
	 * @return
	 */
	public String getText() {
		return lbl.getText();
	}

	/**
	 * This method will return the By of the label
	 * 
	 * @author Pradeep Sundaram
	 * @return
	 */
	public By getBy() {
		return by;
	}

	/**
	 * This method will return the webElement of the label
	 * 
	 * @author Pradeep Sundaram
	 * @return
	 */
	public WebElement getWebElement() {
		return lbl;
	}

	/**
	 * will return boolean based on the presence of the label
	 * 
	 * @return boolean
	 */
	public boolean isDisplayed() {
		Report.log("Checking whether the field " + WebPage.elementList.get(lbl)
				+ " is displayed.<BR>");
		return lbl.isDisplayed();
	}

	/**
	 * this method will double click on the label
	 * 
	 */
	public void doubleClick() {
		events.doubleClick(lbl);
	}

	/**
	 * This method will return the tool tip of the label
	 * 
	 * @author PSubramani33
	 * @return String
	 */
	public String getToolTip() {
		Report.log("Getting the tool tip of the button "
				+ WebPage.elementList.get(lbl) + ".<BR>");
		return lbl.getAttribute("title");
	}
}
