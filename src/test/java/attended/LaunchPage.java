package attended;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaunchPage {
	WebDriver driver;
	By LaunchButton = By.id("btnLaunch");
	By MANAGEFILES = By.xpath(".//*[@id='liDLPFileManager']/div/button");
	By COMMANDLINE = By.xpath(".//*[@id='liDLPCommandLine']/div/button");

	// FM Steps
	By FMSessionStep1 = By.xpath(".//*[@id='FM_step1_id_desc']");
	By FMSessionStep2 = By.xpath(".//*[@id='FM_step2_id_desc']");
	By FMSessionStep3 = By.xpath(".//*[@id='FM_step3_id_desc']");
	By FMSessionStep4 = By.xpath(".//*[@id='FM_step4_id_desc']");
	By FMSessionMessage = By.xpath(".//*[@id='FMPin_container']/div/div/p[1]");
	By AllowUser = By.xpath(".//*[@id='FMPin_container']/div/div/p[2]");

	// File Manager
	By FMLanding = By.xpath(".//*[@id='divExpandFMDeviceDetail']/div[1]/div/h3[2]");

	// Device Information
	By AboutDevice = By.xpath(".//*[@id='dlp_device']/header/div[2]/h3");
	By ModelNumer = By.xpath(".//*[@id='dlp_header_section']/ul/li/h3");
	By AndroidOS = By.xpath(".//*[@id='dlp_header_section']/ul/li/p");

	// Decline
	By Decline = By.xpath(".//*[@id='disconnectvalue']");

	public void Launch() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement InitiateLaunch = driver.findElement(LaunchButton);
		wait.until(ExpectedConditions.visibilityOf(InitiateLaunch));
		InitiateLaunch.click();
		System.out.println("Launch button clicked");
		Thread.sleep(10000);

		String Modelis = driver.findElement(ModelNumer).getText();
		System.out.println("Launch Page: ModelNumer is " + Modelis);

		String OSis = driver.findElement(AndroidOS).getText();
		System.out.println("Launch Page: OS Version is " + OSis);

	}

	public void InitiateFM() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement FMButton = driver.findElement(MANAGEFILES);
		wait.until(ExpectedConditions.visibilityOf(FMButton));
		FMButton.click();
		Thread.sleep(7000);

		WebElement FMStep1 = driver.findElement(FMSessionStep1);
		wait.until(ExpectedConditions.visibilityOf(FMStep1));
		String Message1 = FMStep1.getText();
		System.out.println("Step 1 is " + Message1);
		Thread.sleep(3000);

		WebElement FMStep2 = driver.findElement(FMSessionStep2);
		wait.until(ExpectedConditions.visibilityOf(FMStep2));
		String Message2 = FMStep2.getText();
		System.out.println("Step 2 is " + Message2);
		Thread.sleep(3000);

		WebElement FMStep3 = driver.findElement(FMSessionStep3);
		wait.until(ExpectedConditions.visibilityOf(FMStep3));
		String Message3 = FMStep3.getText();
		System.out.println("Step 3 is " + Message3);

		WebElement FMStep4 = driver.findElement(FMSessionStep4);
		wait.until(ExpectedConditions.visibilityOf(FMStep4));
		String Message4 = FMStep4.getText();
		System.out.println("Step 4 is " + Message4);

		WebElement FMStep5 = driver.findElement(FMSessionMessage);
		wait.until(ExpectedConditions.visibilityOf(FMStep5));
		String Message5 = FMStep5.getText();
		System.out.println(Message5);

		WebElement FMStep6 = driver.findElement(AllowUser);
		wait.until(ExpectedConditions.visibilityOf(FMStep6));
		String Message6 = FMStep6.getText();
		System.out.println(Message6);

		WebElement FMLandingpage = driver.findElement(FMLanding);
		wait.until(ExpectedConditions.visibilityOf(FMLandingpage));
		String FMmodel = driver.findElement(FMLanding).getText();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		System.out.println("FileManager is been initiated " + FMmodel);

	}

	// creating constructor
	public LaunchPage(WebDriver D) {
		this.driver = D;
	}
}
