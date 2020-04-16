package attended;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeviceSearch_Connect {
	WebDriver driver;
	String PINVal;

	By IMEI = By.id("txtadddevice");
	By Search = By.xpath(".//*[@id='btnAddDevice']");
	By DeviceID = By.xpath(".//*[@id='searchPhoneNumber']");
	By Searchbutton = By.xpath(".//*[@id='btnSearch']");
	By ModelName = By.xpath(".//*[@id='Search_71db449c-5e61-4fa7-8a98-7252ac8c7ee9']/div/div[1]/label[3]");
	By LastSync = By.xpath(".//*[@id='Search_71db449c-5e61-4fa7-8a98-7252ac8c7ee9']/div/div[3]/label");
	By Connect = By.xpath(".//*[@id='btnConnect']");

	// RC steps
	By SessionStep1 = By.xpath(".//*[@id='step1_id_desc']");
	By SessionStep2 = By.xpath(".//*[@id='step2_id_desc']");
	By SessionStep3 = By.xpath(".//*[@id='step3_id_desc']");

	// PIN Screen
	// By PINMessage = By.xpath(".//*[@id='txtInstructionalMessage']");
	By PINMessage = By.id("txtInstructionalMessage");
	By PINValue = By.xpath(".//*[@id='pinvalue']");
	// Landing page
	By DeviceName = By.xpath(".//*[@id='spansummarytooltip']");
	By DeviceSummary = By.xpath(".//*[@id='Device_Summary_SideBar']/div[2]/h4");
	By AndroidVersion = By.xpath(".//*[@id='divsoftwareinfo']/ul/li[1]/div[2]");
	By Model = By.xpath(".//*[@id='divsoftwareinfo']/ul/li[2]/div[2]");
	By AVersion = By.xpath(".//*[@id='divsoftwareinfo']/ul/li[1]/div[2]");

	// RC Disconnect
	By RC = By.xpath(".//*[@id='LI_Display']/a");
	By Disconnect = By.xpath(".//*[@id='footer_toolbar']/ul/li[13]");
	By DisconnectBottom = By.xpath(".//*[@id='footer_toolbar']/ul/li[13]");
	// By Disconnect = By.xpath(".//*[@id='close_icon']/i");

	// File Manager
	By FM = By.xpath(".//*[@id='liFileManager']/a");
	By FMSession = By.xpath(".//*[@id='FM_step3_id_desc']");
	By FMWaitResponse = By.xpath(".//*[@id='FMPin_container']/div/div/p[1]");
	By FMLanding = By.xpath(".//*[@id='divExpandFMDeviceDetail']/div[1]/div/h3[2]");
	By UploadButton = By.xpath(".//*[@id='btnFileUpload_new']");
	By BrowseButton = By.xpath(".//*[@id='lblBrowse']");
	By CancelUpload = By.xpath(".//*[@id='divUpload_BrowseBtn']/div[3]/i");

	// Uploading file
	By FMWindow = By.xpath(".//*[@id='headerUpload_new']");
	// By YetToStart =
	// By.xpath(".//*[@id='divProgressStatus_45a31e7c-3f65-c4cb-8f55-57bb53e80991']");
	By uploadingpercentage = By.xpath(".//*[@id='divProgressStatus_1e09f0d8-372a-1aa9-af7e-40dec31a46aa']");
	By Inprogress = By.xpath(".//*[@id='divUpload_new']/article/div/ul/li[1]/a/span[2]");
	By Completed = By.xpath(".//*[@id='divUpload_new']/article/div/ul/li[2]/a/span[2]");
	By Filename = By.xpath(".//*[@id='divFileName_45a31e7c-3f65-c4cb-8f55-57bb53e80991']");

	// Replace
	By Replace = By.xpath(".//*[@id='divReplacefooter']/ul/li[1]/input");

	public void DeviceSummary() {
		WebDriverWait wait = new WebDriverWait(driver, 60);

		driver.findElement(RC).click();
		
		// Device Model
		WebElement LandingPage = driver.findElement(DeviceName);
		wait.until(ExpectedConditions.visibilityOf(LandingPage));
		String Devicemodel = driver.findElement(DeviceName).getText();
		System.out.println("Connected device is: " + Devicemodel);

		// OS Version
		WebElement Version = driver.findElement(AndroidVersion);
		wait.until(ExpectedConditions.visibilityOf(Version));
		String OSVersion = driver.findElement(AndroidVersion).getText();
		System.out.println("Connected device OS version: " + OSVersion);
	}

	public void RCDisconnect() throws InterruptedException {

		By SureDisconnect = By.xpath(".//*[@id='divDisonnectConfirmBox']/div/div[2]");
		//By Button1 = By.id("btn_disconnectcancel");
		By Button1 = By.xpath(".//*[@id='btn_disconnectok']");
		By Button2 = By.id("btn_disconnectok");
		By Disconnect = By.xpath(".//*[@id='footer_toolbar']/ul/li[13]");
		driver.findElement(RC).click();
		WebDriverWait wait = new WebDriverWait(driver, 60);

		// Device Model
		WebElement LandingPage = driver.findElement(DeviceName);
		wait.until(ExpectedConditions.visibilityOf(LandingPage));
		String Devicemodel = driver.findElement(DeviceName).getText();
		System.out.println("Connected device is " + Devicemodel);
		Thread.sleep(2000);
	
		// below code is to disconnect by clicking the disconnect button at the bottom
		driver.findElement(DisconnectBottom).click();
		Thread.sleep(2000);
		
		// below try catch is to click x button and get popup then disconnect
/*		
		try {
			driver.findElement(Disconnect).click();

			System.out.println(driver.findElement(SureDisconnect).getText());
			System.out.println("Buttons available: " + driver.findElement(Button1).getText() + " & "
					+ driver.findElement(Button2).getText());

			driver.findElement(Button2).click();
			System.out.println("Xpath element failed");
		} catch (Exception e) {
			driver.findElement(Disconnect).click();
			System.out.println("RC Disconnected by tapping on Disconnect button");
		}
*/
	}

	// creating constructor
	public DeviceSearch_Connect(WebDriver D) {
		this.driver = D;
	}

}
