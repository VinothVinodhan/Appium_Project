package consoles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;


public class Afcsushi {
	WebDriver driver;
	MobileDriver driver1;

	By login = By.id("loginUser");
	By text = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]");
	By loginbutton = By.id("login_btn");
	By FirstPermission = By.id("com.android.packageinstaller:id/permission_message");
	By FirstAllow = By.id("com.android.packageinstaller:id/permission_allow_button");
	By SecondPermission = By.id("com.android.packageinstaller:id/permission_message");
	By SecondAllow = By.id("com.android.packageinstaller:id/permission_allow_button");

	By AccessibilityTitle = By.id("android:id/alertTitle");
	By AccessibilityText = By.id("com.aetherpal.enterprise:id/dialogText");
	By EnableButton = By.id("android:id/button1");
	By DisableButton = By.id("android:id/button2");

	// Accessibility page
	By MobSupport = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView[1]");
	By ToggleButton = By.id("com.android.settings:id/switch_widget");
	By OkButton = By.id("android:id/button1");

	By IMEI = By.id("txtadddevice");
	By Search = By.xpath(".//*[@id='btnAddDevice']");
	By DeviceID = By.xpath(".//*[@id='searchPhoneNumber']");
	By Searchbutton = By.xpath(".//*[@id='btnSearch']");
	By ModelName = By.xpath(".//*[@id='Search_70fd0a4e-f04e-426a-a385-f5f6675fc988']/div/div[1]/label[3]");
	By LastSync = By.xpath(".//*[@id='Search_70fd0a4e-f04e-426a-a385-f5f6675fc988']/div/div[3]/label");
	By Connect = By.xpath(".//*[@id='btnConnect']");

	// RC steps
	By SessionStep1 = By.xpath(".//*[@id='step1_id_desc']");
	By SessionStep2 = By.xpath(".//*[@id='step2_id_desc']");
	By SessionStep3 = By.xpath(".//*[@id='step3_id_desc']");

	// PIN Screen
	// By PINMessage = By.xpath(".//*[@id='txtInstructionalMessage']");
	By PINMessage = By.id("txtInstructionalMessage");

	// Landing page
	By DeviceName = By.xpath(".//*[@id='spansummarytooltip']");
	By DeviceSummary = By.xpath(".//*[@id='Device_Summary_SideBar']/div[2]/h4");
	By AndroidVersion = By.xpath(".//*[@id='divsoftwareinfo']/ul/li[1]/div[2]");
	By Model = By.xpath(".//*[@id='divsoftwareinfo']/ul/li[2]/div[2]");
	By AVersion = By.xpath(".//*[@id='divsoftwareinfo']/ul/li[1]/div[2]");
	By FM = By.xpath(".//*[@id='liFileManager']/a");
	By FMSession = By.xpath(".//*[@id='FM_step3_id_desc']");
	By FMWaitResponse = By.xpath(".//*[@id='FMPin_container']/div/div/p[1]");
	By FMLanding = By.xpath(".//*[@id='divExpandFMDeviceDetail']/div[1]/div/h3[2]");

	// Command Line
	By CommandLine = By.xpath(".//*[@id='liCommandLine']/a");
	By CLStep1 = By.xpath(".//*[@id='CL_step3_id_desc']");
	By CLStep2 = By.xpath(".//*[@id='CL_step4_id_desc']");
	By CLWaitResponse = By.xpath(".//*[@id='CLPin_container']/div/div/p[1]");
	By cmddisplay = By.xpath(".//*[@id='CL_Cmd_display']/section[2]/span");
	By cmdfield = By.xpath(".//*[@id='CL_Cmd_display']");
	By CLdisconnect = By.xpath(".//*[@id='cl_footer_disconect']");

	@BeforeTest
	public void extendReport() {
	  	ExtentReports report = new ExtentReports("D:\\Automation\\ScreenShots\\afcsushi\\Afcsushi_Report.html");

	}

	@Test
	public void healCheck() throws InterruptedException, IOException {

		// Mobile
	 	DesiredCapabilities capabilities = DesiredCapabilities.android();
		capabilities.setCapability("deviceName", "LGH931391140be");
		 capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("version", "8.0.0");
		capabilities.setCapability("noReset", false);
		capabilities.setCapability("fullReset", false);
		capabilities.setCapability("appPackage", "com.aetherpal.enterprise");
		capabilities.setCapability("appWaitActivity" , "com.aetherpal.smartcare.ValetScueActivity");
		capabilities.setCapability("appActivity", "com.aetherpal.smartcare.ValetScueActivity");
		capabilities.setCapability("dontStopAppOnReset", false);
		capabilities.setCapability("newCommandTimeout", 0);
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver1 = new AndroidDriver(url, capabilities);
		Logger log = Logger.getLogger(Afcsushi.class);
		log.info("**Hello the app started**");
 		System.out.println("Hello the app started.");
		Thread.sleep(2000);
		System.out.println(driver1.findElement(text).getText());

		// Reading Data from Excel
		File excel = new File("D:\\Automation\\Excel Data\\Tenant Details.xlsx");
		FileInputStream FIS = new FileInputStream(excel);
		XSSFWorkbook Wb = new XSSFWorkbook(FIS);
		XSSFSheet SH = Wb.getSheet("afcsushi");
		String InputData = SH.getRow(0).getCell(0).getStringCellValue();
		for (int i = 0; i <= SH.getLastRowNum(); i++) {
			Row r = SH.getRow(i);
			driver1.findElement(login).sendKeys(r.getCell(0).getStringCellValue());
		}

		// Enrolling qagm

		driver1.findElement(loginbutton).click();
		Thread.sleep(50000);
		System.out.println("50 sec waited");

		// Logged in and Pemissions
		System.out.println(driver1.findElement(FirstPermission).getText());
		driver1.findElement(FirstAllow).click();
		System.out.println(driver1.findElement(SecondPermission).getText());
		driver1.findElement(SecondAllow).click();
		Thread.sleep(1000);

		// Knox
		try {
			System.out.println(driver1.findElement(By.id("com.samsung.klmsagent:id/eula_title")).getText());
			WebElement CheckBox = driver1.findElement(By.id("com.samsung.klmsagent:id/checkBox1"));
			CheckBox.click();
			Thread.sleep(1000);
			WebElement ConfirmButton = driver1.findElement(By.id("com.samsung.klmsagent:id/eula_bottom_confirm_agree"));
			ConfirmButton.click();
			Thread.sleep(1000);
			// add one Screen shot
		} catch (Exception e) {
			System.out.println("Knox aleady been accepted");
		}
		System.out.println(driver1.findElement(AccessibilityTitle).getText());
		System.out.println(driver1.findElement(AccessibilityText).getText());
		driver1.findElement(EnableButton).click();

		Thread.sleep(2000);

		// swipe till down
		int durationMS = 4000;
		Dimension size = driver1.manage().window().getSize();
		for (int i = 0; i <= 1; i++) {
			int startx = size.width / 2;
			System.out.println(size);
			int starty = (int) (size.height * 0.60);
			int endy = (int) (size.height * 0.10);
			driver1.swipe(startx, starty, startx, endy, durationMS);
			System.out.println(i);
		}

		Thread.sleep(1000);
		// Turnning ON Accessibility
		driver1.findElement(MobSupport).click();
		driver1.findElement(ToggleButton).click();
		driver1.findElement(OkButton).click();
		Thread.sleep(1000);

		// Coming back to MSM
		((AndroidDriver) driver1).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(1000);
		((AndroidDriver) driver1).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(1000);

		System.out.println(driver1.findElement(By.id("android:id/alertTitle")).getText());
		driver1.findElement(By.id("android:id/button1")).click();
		Thread.sleep(1000);

		// Take GuideMe page SS
		File MobSS1 = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(MobSS1, new File("D:\\Automation\\ScreenShots\\afcsushi\\Mobile_GuideMe.png"));
		System.out.println("Mobile GuideMe page SS taken");

		// Menu
		driver1.findElement(By.id("breadcrumbanchor")).click();
		System.out.println("Menu button clicked");
		Thread.sleep(1000);

		driver1.findElement(By.id("about")).click();
		System.out.println("About clicked");
		Thread.sleep(2000);

		// Take About page SS
		File MobSS3 = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(MobSS3, new File("D:\\Automation\\ScreenShots\\afcsushi\\Mobile_About.png"));
		System.out.println("Mobile About page SS taken");

		String Version = driver1
				.findElement(By
						.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View/android.widget.ListView/android.view.View[1]"))
				.getText();
		System.out.println(Version);

		String BundleID = driver1
				.findElement(By
						.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View/android.widget.ListView/android.view.View[2]"))
				.getText();
		System.out.println(BundleID);

		String Tenant = driver1
				.findElement(By
						.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View/android.widget.ListView/android.view.View[3]"))
				.getText();
		System.out.println(Tenant);
		// Taking only the Tenant URL
		String TenantURL = Tenant.substring(9);
		System.out.println("Tenant URL is: " + TenantURL);

		String DeviceID1 = driver1
				.findElement(By
						.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View/android.widget.ListView/android.view.View[4]"))
				.getText();
		System.out.println(DeviceID1);
		// Taking only the Device ID
		String DeviceIDValue = DeviceID1.substring(11);
		System.out.println("Device ID value is: " + DeviceIDValue);

		driver1.findElement(By.id("breadcrumbanchor")).click();

		// RC Page
		driver1.findElement(By.id("footer_devicehealth")).click();
		System.out.println("Remote Control button clicked");
		Thread.sleep(2000);
		// Take RC page SS
		File MobSS2 = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(MobSS2, new File("D:\\Automation\\ScreenShots\\afcsushi\\Mobile_RC.png"));
		System.out.println("Mobile RC page SS taken");

		// Chrome

		System.setProperty("webdriver.chrome.driver",
				"C://Users//VinothKumar//Desktop//Vinoth//Selenium//Driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Below code is to search by device id and get PIN number in chrome
		driver.get(TenantURL);
		driver.findElement(By.id("txtUserName")).sendKeys("administrator");
		driver.findElement(By.id("txtPassword")).sendKeys("aetherpal@1");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("searchPhoneNumber")).sendKeys(DeviceIDValue);
		driver.findElement(By.id("btnSearch")).click();
		Thread.sleep(2000);

		// Taking SS
		File ConsoleSS1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ConsoleSS1, new File("D:\\Automation\\ScreenShots\\afcsushi\\Search BLock.png"));
		System.out.println("Search Block SS taken");

		// below code is to get Model name from search block
		System.out.println("Search completed and land on Search box");
		try {
			String Model = driver.findElement(ModelName).getText();
			System.out.println("Your Device Model is " + Model);
		} catch (Exception e) {
			System.out.println("Device modes not taken from Search BLock");
		}

		WebDriverWait wait = new WebDriverWait(driver, 60);
		// Click connect button
		driver.findElement(Connect).click();
		System.out.println("Wait to get connected");
		Thread.sleep(5000);

		WebElement RCStep1 = driver.findElement(SessionStep1);
		wait.until(ExpectedConditions.visibilityOf(RCStep1));
		String Message1 = RCStep1.getText();
		System.out.println(Message1);

		WebElement RCStep2 = driver.findElement(SessionStep2);
		wait.until(ExpectedConditions.visibilityOf(RCStep2));
		String Message2 = RCStep2.getText();
		System.out.println(Message2);

		WebElement RCStep3 = driver.findElement(SessionStep3);
		wait.until(ExpectedConditions.visibilityOf(RCStep3));
		String Message3 = RCStep3.getText();
		System.out.println(Message3);

		// below code is related to PIN Number

		WebElement PINInstruction = driver.findElement(PINMessage);
		wait.until(ExpectedConditions.visibilityOf(PINInstruction));
		String PINInst = PINInstruction.getText();
		System.out.println("PIN Instruction is " + PINInst);

		// Taking SS
		File ConsoleSS2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ConsoleSS2, new File("D:\\Automation\\ScreenShots\\afcsushi\\Console PIN.png"));
		System.out.println("Console side PIN page SS taken");

		WebElement PINValue;
		String pinnumber;

		System.out.println("Waiting to get pin number");
		PINValue = driver.findElement(By.id("pinvalue"));
		pinnumber = PINValue.getText();
		System.out.println(pinnumber);

		// Below code is to Enter PIN value in mobile
		driver1.findElement(By.id("com.aetherpal.enterprise:id/editPin")).sendKeys(pinnumber);
		driver1.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		Thread.sleep(5000);

		System.out.println("Waited for 5 seconds");
		((AndroidDriver) driver1).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(1000);
		driver1.findElement(By.id("com.aetherpal.enterprise:id/buttonAccept")).click();

		try {
			System.out.println("Remote Control button clicked after entering PIN");
			Thread.sleep(2000);
			// Take RC page SS
			File MobSS6 = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(MobSS6, new File("D:\\Automation\\ScreenShots\\afcsushi\\Mobile_RC_Disconnect.png"));
			System.out.println("Mobile RC with Disconnect page SS taken");
		} catch (Exception e) {
			System.out.println("AFter allowing permisson, focus not went to app");
		}
		// Device Model
		WebElement LandingPage = driver.findElement(DeviceName);
		wait.until(ExpectedConditions.visibilityOf(LandingPage));
		String Devicemodel = driver.findElement(DeviceName).getText();
		System.out.println("Connected device is " + Devicemodel);
		Thread.sleep(2000);
		// Taking SS
		File src1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, new File("D:\\Automation\\ScreenShots\\afcsushi\\RC Landing Page.png"));
		System.out.println("RC landing page SS taken");

		// below steps are to initiate FM
		Thread.sleep(2000);

		driver.findElement(FM).click();
		WebElement FMStep = driver.findElement(FMSession);
		wait.until(ExpectedConditions.visibilityOf(FMStep));
		String FMStep1 = driver.findElement(FMSession).getText();
		System.out.println("FileManager session initiated");
		System.out.println(FMStep1);

		WebElement Respose = driver.findElement(FMWaitResponse);
		wait.until(ExpectedConditions.visibilityOf(Respose));
		String Userresp = driver.findElement(FMWaitResponse).getText();
		System.out.println(Userresp);

		// below code is to give permission for FM in mob
		driver1.findElement(By.id("com.aetherpal.enterprise:id/buttonYes")).click();
		Thread.sleep(1000);
		System.out.println("Clicked allow from Device");
		// Take FM permission page SS in Device
		File MobSS7 = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(MobSS7, new File("D:\\Automation\\ScreenShots\\afcsushi\\Mobile_FMToast.png"));
		System.out.println("FM Toast SS taken");

		// chrome landing page
		WebElement FMLandingpage = driver.findElement(FMLanding);
		wait.until(ExpectedConditions.visibilityOf(FMLandingpage));
		String FMmodel = driver.findElement(FMLanding).getText();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		System.out.println("FileManager is been initiated " + FMmodel);

		// Taking SS
		File ConsoleSS3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ConsoleSS3, new File("D:\\Automation\\ScreenShots\\afcsushi\\FM Landing Page.png"));
		System.out.println("FM landing page SS taken");

		try {
			driver.findElement(CommandLine).click();
			System.out.println("Command Line session initiated");

			// CL landing page
			WebElement CLLandingPage = driver.findElement(cmddisplay);
			wait.until(ExpectedConditions.visibilityOf(CLLandingPage));
			String cmd = driver.findElement(cmddisplay).getText();
			System.out.println(cmd);
		} catch (Exception e) {
			System.out.println("Command Line feature is not available");
		}
		driver.close();
		System.out.println("Afcsushi check is Completed. Now closing the console");
	}

	public void ScreenShot(ITestResult res) throws IOException {
		if (!res.isSuccess()) {
			// Taking Screenshot of Console side on Failures
			File Console = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Console, new File("D:\\Automation\\ScreenShots\\afcsushi\\Afcsushi_Failed_Console.png"));
			System.out.println("Console page SS taken, Since acript failed");

			// Taking Screenshot of Device side on Failures
			File Device = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Device, new File("D:\\Automation\\ScreenShots\\afcsushi\\Afcsushi_Failed_Device.png"));
			System.out.println("Device page SS taken, Since script failed");

		}

	}

}
