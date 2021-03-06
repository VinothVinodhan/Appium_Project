package attended;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
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
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;


public class Device {
	static WebDriver driver;
	static By login = By.id("loginUser");
	static By text = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]");
	static By loginbutton = By.id("login_btn");
	static By FirstPermission = By.id("com.android.packageinstaller:id/permission_message");
	static By FirstAllow = By.id("com.android.packageinstaller:id/permission_allow_button");
	static By SecondPermission = By.id("com.android.packageinstaller:id/permission_message");
	static By SecondAllow = By.id("com.android.packageinstaller:id/permission_allow_button");

	static By AccessibilityTitle = By.id("android:id/alertTitle");
	static By AccessibilityText = By.id("com.aetherpal.enterprise:id/dialogText");
	static By EnableButton = By.id("android:id/button1");

	// Accessibility page
	static By MobSupport = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView[1]");
	static By ToggleButton = By.id("com.android.settings:id/switch_widget");
	static By OkButton = By.id("android:id/button1");

	static By IMEI = By.id("txtadddevice");
	static By Search = By.xpath(".//*[@id='btnAddDevice']");
	static By DeviceID = By.xpath(".//*[@id='searchPhoneNumber']");
	static By Searchbutton = By.xpath(".//*[@id='btnSearch']");
	static By ModelName = By.xpath(".//*[@id='Search_70fd0a4e-f04e-426a-a385-f5f6675fc988']/div/div[1]/label[3]");
	static By LastSync = By.xpath(".//*[@id='Search_70fd0a4e-f04e-426a-a385-f5f6675fc988']/div/div[3]/label");
	static By Connect = By.xpath(".//*[@id='btnConnect']");

	// RC steps
	static By SessionStep1 = By.xpath(".//*[@id='step1_id_desc']");
	static By SessionStep2 = By.xpath(".//*[@id='step2_id_desc']");
	static By SessionStep3 = By.xpath(".//*[@id='step3_id_desc']");

	// PIN Screen
	// By PINMessage = By.xpath(".//*[@id='txtInstructionalMessage']");
	static By PINMessage = By.id("txtInstructionalMessage");

	// Landing page
	static By DeviceName = By.xpath(".//*[@id='spansummarytooltip']");
	static By DeviceSummary = By.xpath(".//*[@id='Device_Summary_SideBar']/div[2]/h4");
	static By AndroidVersion = By.xpath(".//*[@id='divsoftwareinfo']/ul/li[1]/div[2]");
	static By Model = By.xpath(".//*[@id='divsoftwareinfo']/ul/li[2]/div[2]");
	static By AVersion = By.xpath(".//*[@id='divsoftwareinfo']/ul/li[1]/div[2]");
	static By FM = By.xpath(".//*[@id='liFileManager']/a");
	static By FMSession = By.xpath(".//*[@id='FM_step3_id_desc']");
	static By FMWaitResponse = By.xpath(".//*[@id='FMPin_container']/div/div/p[1]");
	static By FMLanding = By.xpath(".//*[@id='divExpandFMDeviceDetail']/div[1]/div/h3[2]");

	// Command Line
	static By CommandLine = By.xpath(".//*[@id='liCommandLine']/a");
	static By CLStep1 = By.xpath(".//*[@id='CL_step3_id_desc']");
	static By CLStep2 = By.xpath(".//*[@id='CL_step4_id_desc']");
	static By CLWaitResponse = By.xpath(".//*[@id='CLPin_container']/div/div/p[1]");
	static By cmddisplay = By.xpath(".//*[@id='CL_Cmd_display']/section[2]/span");
	static By cmdfield = By.xpath(".//*[@id='CL_Cmd_display']");
	static By CLdisconnect = By.xpath(".//*[@id='cl_footer_disconect']");

	public static WebDriver searchConnect() throws InterruptedException, IOException {

		// Mobile
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		capabilities.setCapability("deviceName", "LGH931391140be");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("version", "8.0.0");
		capabilities.setCapability("noReset", false);
		capabilities.setCapability("fullReset", false);
		capabilities.setCapability("appPackage", "com.aetherpal.enterprise");
		capabilities.setCapability("appWaitActivity", "com.aetherpal.smartcare.ValetScueActivity");
		capabilities.setCapability("appActivity", "com.aetherpal.smartcare.ValetScueActivity");
		capabilities.setCapability("dontStopAppOnReset", false);
		capabilities.setCapability("newCommandTimeout", 0);
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		MobileDriver driver1 = new AndroidDriver(url, capabilities);
		
		System.out.println("Hello the app started.");
		Thread.sleep(2000);
		System.out.println(driver1.findElement(text).getText());

		// below code is to get tenant details from excel
		// Reading Data from Excel
		File excel = new File("C:\\Users\\manju\\Desktop\\besant\\Excel Handle\\Tenant Details.xlsx");
		FileInputStream FIS = new FileInputStream(excel);
		XSSFWorkbook Wb = new XSSFWorkbook(FIS);
		XSSFSheet SH = Wb.getSheet("Sheet1");
		String InputData = SH.getRow(0).getCell(0).getStringCellValue();
		for (int i = 0; i <= SH.getLastRowNum(); i++) {
			Row r = SH.getRow(i);
			// passing the value to login field
			driver1.findElement(login).sendKeys(r.getCell(0).getStringCellValue());
		}

		// driver1.findElement(login).sendKeys("gmqars");

		// Enrolling qagm
		driver1.findElement(loginbutton).click();

		Thread.sleep(25000);
		System.out.println("25 sec waited");

		// Logged in
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
			System.out.println("Knox accepted");
			// add one Screen shot
		} catch (Exception e) {
			System.out.println("Knox aleady been accepted");
		}

		// System.out.println(driver1.findElement(AccessibilityTitle).getText());
		// System.out.println(driver1.findElement(AccessibilityText).getText());
		driver1.findElement(EnableButton).click();
		Thread.sleep(1000);

		// swipe till down
		System.out.println("Swipe down to turn ON accessibility");
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

		driver1.findElement(By.id("footer_devicehealth")).click();
		System.out.println("Remote Control button clicked");
		Thread.sleep(1000);

		// Take RC page SS
		File MobSS1 = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(MobSS1, new File("D:\\Automation\\ScreenShots\\Mobile_GuideMe.png"));
		System.out.println("Mobile GuideMe page SS taken");

		Thread.sleep(2000);

		// Menu
		driver1.findElement(By.id("breadcrumbanchor")).click();
		System.out.println("Menu button clicked");
		Thread.sleep(1000);

		driver1.findElement(By.id("about")).click();
		System.out.println("About clicked");
		Thread.sleep(1000);

		// Take About page SS
		File MobSS3 = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(MobSS3, new File("D:\\Automation\\ScreenShots\\Mobile_About.png"));
		System.out.println("About page SS taken");

		Thread.sleep(2000);

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
		driver1.findElement(By.id("footer_devicehealth")).click();
		Thread.sleep(1000);

		// Take About page SS
		File MobSS4 = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(MobSS4, new File("D:\\Automation\\ScreenShots\\MobileRC_Page.png"));
		System.out.println("RC page SS taken");

		// Chrome
		// initializing Chrome driver
		System.setProperty("webdriver.chrome.driver",
				"C://Users//manju//Desktop//Selenium//Selenium//Software//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Below code is to search by device id and get PIN number in chrome
		driver.get(TenantURL);
		driver.findElement(By.id("txtUserName")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("aetherpal@1");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("searchPhoneNumber")).sendKeys(DeviceIDValue);
		driver.findElement(By.id("btnSearch")).click();
		Thread.sleep(2000);

		// Taking SS
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\Automation\\ScreenShots\\Search BLock.png"));
		System.out.println("Search Block SS taken");

		// below code is to get Model name from search block
		try {
			System.out.println("Search completed and land on Search box");
			String Model = driver.findElement(ModelName).getText();
			System.out.println("Your are searching: " + Model);
		} catch (Exception e) {
			System.out.println("Could not take device model from Search block");
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
		try {
			WebElement PINInstruction = driver.findElement(PINMessage);
			wait.until(ExpectedConditions.visibilityOf(PINInstruction));
			String PINInst = PINInstruction.getText();
			System.out.println("PIN Instruction is " + PINInst);

			WebElement PINValue;
			String pinnumber;

			System.out.println("Waiting to get pin number");
			PINValue = driver.findElement(By.id("pinvalue"));
			pinnumber = PINValue.getText();
			System.out.println(pinnumber);

			// Below code is to Enter PIN value in mobile
			driver1.findElement(By.id("com.aetherpal.enterprise:id/editPin")).sendKeys(pinnumber);

			// Take PIN page SS
			File MobSS5 = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(MobSS5, new File("D:\\Automation\\ScreenShots\\Mobile_PIN.png"));
			System.out.println("PIN SS taken");

			driver1.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
			Thread.sleep(5000);
			System.out.println("Waited for 5 seconds");
			((AndroidDriver) driver1).pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(1000);
			driver1.findElement(By.id("com.aetherpal.enterprise:id/buttonAccept")).click();

			// Take PIN page SS
			File MobSS6 = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(MobSS6, new File("D:\\Automation\\ScreenShots\\Mobile_RCToast.png"));
			System.out.println("After accepting PIN taking SS");
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Your are running Unattended Tenant");
		}
		// Device Model
		WebElement LandingPage = driver.findElement(DeviceName);
		wait.until(ExpectedConditions.visibilityOf(LandingPage));
		String Devicemodel = driver.findElement(DeviceName).getText();
		System.out.println("Connected device is " + Devicemodel);

		// Taking SS
		File src1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, new File("D:\\Automation\\ScreenShots\\RC Landing Page.png"));
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
		Thread.sleep(1000);

		// below code is to give permission for FM in mob
		driver1.findElement(By.id("com.aetherpal.enterprise:id/buttonYes")).click();
		System.out.println("Clicked allow from Device");

		// Take FM permission page SS in Device
		File MobSS7 = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(MobSS7, new File("D:\\Automation\\ScreenShots\\Mobile_FM_Permission.png"));
		System.out.println("FM permission SS taken");

		// chrome landing page
		WebElement FMLandingpage = driver.findElement(FMLanding);
		wait.until(ExpectedConditions.visibilityOf(FMLandingpage));
		String FMmodel = driver.findElement(FMLanding).getText();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		System.out.println("FileManager is been initiated " + FMmodel);

		// Taking SS
		File src2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src2, new File("D:\\Automation\\ScreenShots\\FM Landing Page.png"));
		System.out.println("FM landing page SS taken");

		// Bellow code is to initiate CL
		try {
			driver.findElement(CommandLine).click();
			System.out.println("FileManager session initiated");

			// Step1
			WebElement CLFirststep = driver.findElement(CLStep1);
			wait.until(ExpectedConditions.visibilityOf(CLFirststep));
			String Step1 = driver.findElement(CLStep1).getText();
			System.out.println("First Step: " + Step1);

			// Step2
			WebElement CLSecondstep = driver.findElement(CLStep2);
			wait.until(ExpectedConditions.visibilityOf(CLSecondstep));
			String Step2 = driver.findElement(CLStep2).getText();
			System.out.println("Second Step: " + Step2);

			// User response time
			WebElement CLRespose = driver.findElement(CLWaitResponse);
			wait.until(ExpectedConditions.visibilityOf(CLRespose));
			String UserResp = driver.findElement(CLWaitResponse).getText();
			System.out.println(UserResp);
			Thread.sleep(1000);

			// below code is to give permission for CL in mob
			driver1.findElement(By.id("com.aetherpal.enterprise:id/buttonAccept")).click();

			// Take CL permission page SS
			File MobSS8 = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(MobSS8, new File("D:\\Automation\\ScreenShots\\Mobile_CL_Permission.png"));
			System.out.println("CL permission SS taken");

			// CL landing page
			WebElement CLLandingPage = driver.findElement(cmddisplay);
			wait.until(ExpectedConditions.visibilityOf(CLLandingPage));
			String cmd = driver.findElement(cmddisplay).getText();
			System.out.println(cmd);

			// Taking SS
			File src3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src3, new File("D:\\Automation\\ScreenShots\\CL Landing Page.png"));
			System.out.println("CL landing page SS taken");
		} catch (Exception e) {
			System.out.println("Command Line feature is not available");
		}
		return driver;

	}

}
