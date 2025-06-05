package Poi_concept;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;
 

public class windowHandle
{
	static WebDriver driver;
 
	
	
	
	@Test
	public void setUpBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Asus\\Desktop\\browser\\30.5.2025\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		  driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/company/orangehrm/mycompany/']")).click();
		driver.findElement(By.xpath(" //a[@href='https://www.facebook.com/OrangeHRM/']")).click();
		driver.findElement(By.xpath(" //a[@href='https://twitter.com/orangehrm?lang=en']")).click();
		driver.findElement(By.xpath("//a[@href='https://www.youtube.com/c/OrangeHRMInc']")).click();
		
		String parentwindow=driver.getWindowHandle();
		Set<String> handles=driver.getWindowHandles();
		List<String> hList=new ArrayList<String>(handles);	
	    
		 if(switchToRightWindow("Facebook", hList))
		 {
			 System.out.println(driver.getCurrentUrl()+" : "+driver.getTitle());
		 }
		 switchTozparentwindow(parentwindow);
		System.out.println(driver.getCurrentUrl()+" : "+driver.getTitle());
		
	}
	
	public static boolean switchToRightWindow(String windowtitle,List<String> hList)
	{
		for(String e:hList)
		{
			String title=driver.switchTo().window(e).getTitle();
			if(title.contains(windowtitle))
			{
				System.out.println("found the right window...");
			}	
		}
		return true;		
	}
	
	
	public void switchTozparentwindow(String parentwindow)
	{
		driver.switchTo().window(parentwindow);
    }
	

}
