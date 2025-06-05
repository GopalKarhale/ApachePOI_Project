package Poi_concept;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class CrossBrowser {
   WebDriver driver;
   
	@BeforeMethod
	@Parameters("browser")
	public void launchBrowser(@Optional("chrome")String browser)
	{
		if(browser.equalsIgnoreCase("chrome")) {
			 System.setProperty("webdriver.chrome.driver","C:\\Users\\Asus\\Desktop\\browser\\30.5.2025\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		      WebDriver driver=new ChromeDriver();
			 
		}
		else if(browser.equalsIgnoreCase("mdedge"))
		{
			System.setProperty("webdriver.edgrdriver.driver","C:\\Users\\Asus\\Desktop\\browser\\edge\\edgedriver_win64\\msedgedriver.exe");
		driver=new EdgeDriver();
		}		 
		}
	
		@Test
		public void loginUser()
		{
         driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
         System.out.println(driver.getTitle());
		}
}
