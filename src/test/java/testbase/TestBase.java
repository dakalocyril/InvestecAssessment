package testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static String baseURL;
	
	@BeforeClass
	public void setUp() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\testbase\\data.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browserName");
		baseURL = prop.getProperty("url");
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	
    public void waitForClickable(WebElement e){
        
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    	wait.until(ExpectedConditions.elementToBeClickable(e));
    }

	public void javaScriptClick(WebElement element){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView();",element );
		executor.executeScript("arguments[0].click();", element);
	}

	public static void verifyEquals(String expected, String actual)
	{
		try
		{
			Assert.assertEquals(expected, actual);
		}

		catch (Exception e)
		{
			e.getCause();
		}
	}
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}
	
	
}
