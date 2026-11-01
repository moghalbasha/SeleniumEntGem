package dashboardPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	private By UserNameInput=By.id("user-name");
	private By userPasswordInput=By.xpath("//input[@aria-label='Password' and  @type='password']");
	private By loginButton=By.id("login-button");
	//actionMethods
	public void enterUsername(String Username) {
		driver.findElement(UserNameInput).sendKeys(Username);
	}
	public void enterPassword(String Userpass) {
		driver.findElement(userPasswordInput).sendKeys(Userpass);
	}
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
	public void loginApp(String Username,String Userpass) {
		enterUsername(Username);
		enterPassword(Userpass);
		clickLogin();
	}
}
