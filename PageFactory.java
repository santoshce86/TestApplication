package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageFactory {
	
	@FindBy(linkText = "Droppable")
	 public static
	WebElement Dropbutton;
	
	@FindBy(xpath = "//div[@id='draggable']/p")
	 public static
	WebElement Source;
	
	@FindBy(xpath = "//div[@id='droppable']/p")
	 public static
	WebElement Target;
	
	//for the second test case
	
	@FindBy(linkText = "Selectable")
	 public static
	WebElement Selectbutton;
	
	@FindBy(xpath = "//ol[@id = 'selectable']/li[1]")
	 public static
	WebElement Firstoption;
	
	@FindBy(xpath = "//ol[@id = 'selectable']/li[3]")
	 public static
	WebElement Thirdoption;
	
	@FindBy(xpath = "//ol[@id = 'selectable']/li[7]")
	 public static
	WebElement Seventhoption;
	
	// for the third testcase
	
	@FindBy(linkText = "Controlgroup")
	 public static
	WebElement ControlButton;
	
	@FindBy(xpath = "//input[@id='horizontal-spinner']")
	 public static
	WebElement inputbox;
	
	@FindBy(xpath = "//input[@type='radio' and @id ='transmission-standard']")
	 public static
	WebElement Standardbutton;
	
	@FindBy(xpath = "//input[@type='checkbox' and @id ='insurance-v']")
	 public static
	WebElement Insurancebutton;
	
	@FindBy(xpath = "//input[@id = 'vertical-spinner']")
	 public static
	WebElement Numberinput;
	
	@FindBy(xpath = "//input[@type = 'radio' and @id = 'transmission-automatic']")
	 public static
	WebElement AutomaticButton;
	
	@FindBy(xpath = "//input[@type='checkbox' and @id ='insurance']")
	 public static
	WebElement Insurancetopbutton;
	
	@FindBy(xpath = "//select[@id = 'car-type']")
	 public static
	WebElement CartypeButton;
	
	@FindBy(xpath = "//select[@id = 'ui-id-8']")
	 public static
	WebElement Cartype2Button;
	
	
		
	

}
