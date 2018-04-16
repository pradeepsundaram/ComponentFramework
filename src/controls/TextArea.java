package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;
import utils.Events;

public class TextArea {
	private WebElement textArea;
	private By by;
	private Events events;

	/**
	 * Text Area Constructor
	 * 
	 * @author Pradeep Sundaram
	 * @param textAreaName
	 * @param byOfTextArea
	 * @param description
	 */
	public TextArea(String textAreaName, String description,
			ElementFinder util, Events events) {
		this.events = events;
		if (textAreaName.startsWith("name")) {
			textArea = util.findElementByName(textAreaName);
		} else if (textAreaName.startsWith("css")) {
			textArea = util.findElementByCss(textAreaName);
		} else if (textAreaName.startsWith("//")) {
			textArea = util.findElementByXpath(textAreaName);
		} else if (textAreaName.startsWith("id")) {
			textArea = util.findElementByID(textAreaName);
		} else {
			Report.log("Text ares is not found");
		}
		WebPage.elementList.put(textArea, description);
	}

	/**
	 * Constructor for text area when By of the text area is required
	 * 
	 * @author Pradeep Sundaram
	 * @param textAreaName
	 * @param byOfTextArea
	 * @param description
	 */
	public TextArea(String textAreaName, By byOfTA, String description,
			ElementFinder util, Events events) {
		this.events = events;
		if (textAreaName.startsWith("name")) {
			textArea = util.findElementByName(textAreaName);
		} else if (textAreaName.startsWith("css")) {
			textArea = util.findElementByCss(textAreaName);
		} else if (textAreaName.startsWith("//")) {
			textArea = util.findElementByXpath(textAreaName);
		} else if (textAreaName.startsWith("id")) {
			textArea = util.findElementByID(textAreaName);
		}
		by = byOfTA;
		WebPage.elementList.put(textArea, description);
	}

	/**
	 * This method will type the passed text in TextArea
	 * 
	 * @author Pradeep Sundaram
	 * @param text
	 */
	public void type(String text) {
		events.type(textArea, text);
	}

	/**
	 * This method will return the By for the Text Area
	 * 
	 * @author Pradeep Sundaram
	 * @param elem
	 * @return
	 */
	public By getBy() {
		return by;
	}

	/**
	 * This method will return the webelement of the textarea
	 * 
	 * @author Pradeep Sundaram
	 * @return
	 */
	public WebElement getWebElement() {
		return textArea;
	}

	/**
	 * will return boolean based on the presence of the text area
	 * 
	 * @return boolean
	 */
	public boolean isDisplayed() {
		Report.log("Checking whether the field "
				+ WebPage.elementList.get(textArea) + " is displayed.<BR>");
		return textArea.isDisplayed();
	}

	/**
	 * will return true when enabled and false on reverse case
	 * 
	 * @return
	 */
	public boolean isEnabled() {
		Report.log("Checking whether the field "
				+ WebPage.elementList.get(textArea) + " is displayed.<BR>");
		return textArea.isEnabled();
	}

	/**
	 * This method will return the tool tip of the checkBox
	 * 
	 * @author PSubramani33
	 * @return String
	 */
	public String getToolTip() {
		Report.log("Getting the tool tip of the button "
				+ WebPage.elementList.get(textArea) + ".<BR>");
		return textArea.getAttribute("title");
	}
}
