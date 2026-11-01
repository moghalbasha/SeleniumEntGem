package DashboardTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dashboardPages.LoginPage;

public class loginTest extends baseTest {
	LoginPage lp;

	
	@Test
	public void verifyLogin() {
		lp=new LoginPage(driver());
		lp.loginApp("standard_user", "secret_sauce");
		WebElement titleElement=driver().findElement(By.xpath("//span[@class='title']"));
		Assert.assertEquals(titleElement.getText(), "Products","Login failed: Dashboard title mismatched!");
	}
	

	
}
