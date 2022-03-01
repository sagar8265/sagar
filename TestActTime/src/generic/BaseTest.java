

package generic;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	
	static WebDriver driver;
	
	public void openBrowser() throws IOException
	{
		Flib flib = new Flib();
		String browserValue = flib.readPropertyData("./Data/config.properties","browser");
		String url = flib.readPropertyData("./Data/config.properties", "url");
		
		if(browserValue.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url);
		}
		else if(browserValue.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.get(url);
			
		}
		else 
		{
			System.out.println("invalid option");
		}
		}
		public void closeBrowser()
		{
			driver.quit();
		}
			
			
		
		
	}






