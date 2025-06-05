package Poi_concept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class getAllLinks
{
	@BeforeMethod
	public void setUpBrowser()
	{
		System.setProperty("webdriver.chrome.driver","");
		WebDriver driver=new ChromeDriver();
		driver.get("");
	
	}

}
