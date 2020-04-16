package attended;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommandLineSession {
	WebDriver driver;

	// Command Line
	By CommandLine = By.xpath(".//*[@id='liCommandLine']/a");
	By CLStep1 = By.xpath(".//*[@id='CL_step3_id_desc']");
	By CLStep2 = By.xpath(".//*[@id='CL_step4_id_desc']");
	By CLWaitResponse = By.xpath(".//*[@id='CLPin_container']/div/div/p[1]");
	By cmddisplay = By.xpath(".//*[@id='CL_Cmd_display']/section[2]/span");
	By cmdfield = By.xpath(".//*[@id='CL_Cmd_display']");
	By CLdisconnect = By.xpath(".//*[@id='cl_footer_disconect']");

	public void CLIntial() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try {
			driver.findElement(CommandLine).click();
			System.out.println("FileManager session initiated");

			// CL landing page
			WebElement LandingPage = driver.findElement(cmddisplay);
			wait.until(ExpectedConditions.visibilityOf(LandingPage));
			String cmd = driver.findElement(cmddisplay).getText();
			System.out.println(cmd);
		} catch (Exception e) {
			System.out.println("Command Line feature is not available");
		}
	}

	public void cmd() {
		WebElement LandingPage = driver.findElement(cmdfield);
		LandingPage.sendKeys("adb shell");

	}

	public void CL_disconnect() {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.findElement(CommandLine).click();
		System.out.println("CL Opened");

		WebElement Disconnect = driver.findElement(CLdisconnect);
		Disconnect.click();
		System.out.println("Your CL Session is been disconnected");
	}

	// creating constructor
	public CommandLineSession(WebDriver D) {
		this.driver = D;
	}
}
