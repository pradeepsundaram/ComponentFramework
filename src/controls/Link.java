package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;
import utils.Events;

public class Link {
	private WebElement link;
	private By by;
	public Events events;
	String linkName;

	/**
	 * Link Constructor
	 * 
	 * @author Pradeep Sundaram
	 * @param linkText
	 * @param byOfLink
	 * @param desc
	 */
	public Link(String linkText, String desc, ElementFinder util, Events events) {
		this.events = events;
		if (linkText.startsWith("id")) {
			link = util.findElementByID(linkText);
		}

		else if (linkText.startsWith("css")) {
			link = util.findElementByCss(linkText);
		}

		else if (linkText.startsWith("//")) {
			link = util.findElementByXpath(linkText);
		}

		else if (linkText.startsWith("link")) {
			link = util.findElementByLinkText(linkText);
		}
		WebPage.elementList.put(link, desc);
	}

	public Link(String linkText, ElementFinder util) {
		if (linkText.startsWith("id")) {
			link = util.findElementByID(linkText);
		}

		else if (linkText.startsWith("css")) {
			link = util.findElementByCss(linkText);
		}

		else if (linkText.startsWith("//")) {
			link = util.findElementByXpath(linkText);
		}

		else if (linkText.startsWith("link")) {
			link = util.findElementByLinkText(linkText);
		}
		WebPage.elementList.put(link, linkText);
	}

	public Link(String linkText, By byOfLink, ElementFinder util) {
		if (linkText.startsWith("id")) {
			link = util.findElementByID(linkText);
		}

		else if (linkText.startsWith("css")) {
			link = util.findElementByCss(linkText);
		}

		else if (linkText.startsWith("//")) {
			link = util.findElementByXpath(linkText);
		}

		else if (linkText.startsWith("link")) {
			link = util.findElementByLinkText(linkText);
		}
		by = byOfLink;
		WebPage.elementList.put(link, linkText);
	}

	/**
	 * This method will click in the link passed as argument
	 * 
	 * @author Pradeep Sundaram
	 */
	public void click() {
		events.click(link);
	}

	/**
	 * This method will return the By for the button
	 * 
	 * @author Pradeep Sundaram
	 * @param elem
	 * @return
	 */
	public By getBy() {
		return by;
	}

	/**
	 * This method will return the text displayed in the text
	 * 
	 * @author Pradeep Sundaram
	 * @return
	 */
	public String getText() {
		return link.getText();
	}

	/**
	 * This method will return the webelement of the link
	 * 
	 * @author Pradeep Sundaram
	 * @return
	 */
	public WebElement getWebElement() {
		return link;
	}

	/**
	 * will return boolean based on the presence of the link
	 * 
	 * @author Pradeep Sundaram
	 * @return boolean
	 */
	public boolean isDisplayed() {
		Report.log("Checking whether the field "
				+ WebPage.elementList.get(link) + " is displayed.<BR>");
		return link.isDisplayed();
	}

	/**
	 * This method will put the mouse over the link
	 * 
	 * @author Pradeep Sundaram
	 */
	public void mouseOver() {
		events.mouseOver(link);
	}

	/**
	 * This method will return the tool tip of the link
	 * 
	 * @author PSubramani33
	 * @return String
	 */
	public String getToolTip() {
		Report.log("Getting the tool tip of the button "
				+ WebPage.elementList.get(link) + ".<BR>");
		return link.getAttribute("title");
	}
}
