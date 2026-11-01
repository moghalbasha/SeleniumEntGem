package DashboardTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import DashboardTests.loginTest;
import dashboardPages.LoginPage;
import utilis.configReader;

public class baseTest {
	
	private static ThreadLocal<WebDriver> driverThread=new ThreadLocal<>();

	
	public static WebDriver driver() {
		return driverThread.get();
		}
	@BeforeMethod
	public void setup() {
		String BrowserName=configReader.getProperty("browser");
		String Url=configReader.getProperty("url");
		if (BrowserName.equalsIgnoreCase("chrome")) {
			driverThread.set(new ChromeDriver());
		}else if (BrowserName.equalsIgnoreCase("edge")) {
			driverThread.set(new EdgeDriver());
		}
		driver().manage().window().maximize();
		driver().get(Url);
		
	}
	@AfterMethod
	public void Teardown() {
		if (driver()!=null) {
			driver().quit();
			driverThread.remove();
		}
	}
		

}
