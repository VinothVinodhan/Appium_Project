package finalDemo;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class ProdR3_Samsung {
	// static WebDriver driver;
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

	@Test
	public void Device() throws InterruptedException, IOException {

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

		// Tenant
		driver1.findElement(login).sendKeys("prodr3");

		// Enrolling qagm

		driver1.findElement(loginbutton).click();
		Thread.sleep(50000);
		System.out.println("20 sec waited");

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
			// add one Screen shot
		} catch (Exception e) {
			System.out.println("Knox aleady been accepted");
		}

		System.out.println(driver1.findElement(AccessibilityTitle).getText());
		System.out.println(driver1.findElement(AccessibilityText).getText());
		driver1.findElement(EnableButton).click();
		Thread.sleep(1000);

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

		driver1.findElement(By.id("footer_devicehealth")).click();
		System.out.println("Remote Control button clicked");
		Thread.sleep(2000);

		// Menu
		driver1.findElement(By.id("breadcrumbanchor")).click();
		System.out.println("Menu button clicked");
		Thread.sleep(1000);

		driver1.findElement(By.id("about")).click();
		System.out.println("About clicked");
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

		// below code is to get Model name from search block
		System.out.println("Search completed and land on Search box");
		// String Model = driver.findElement(ModelName).getText();
		// System.out.println("Your Device Model is " + Model);

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
		driver1.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		Thread.sleep(5000);
		System.out.println("Waited for 5 seconds");
		((AndroidDriver) driver1).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(1000);
		driver1.findElement(By.id("com.aetherpal.enterprise:id/buttonAccept")).click();
		Thread.sleep(2000);

		// Device Model
		WebElement LandingPage = driver.findElement(DeviceName);
		wait.until(ExpectedConditions.visibilityOf(LandingPage));
		String Devicemodel = driver.findElement(DeviceName).getText();
		System.out.println("Connected device is " + Devicemodel);

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
		System.out.println("Clicked allow from Device");

		// chrome landing page
		WebElement FMLandingpage = driver.findElement(FMLanding);
		wait.until(ExpectedConditions.visibilityOf(FMLandingpage));
		String FMmodel = driver.findElement(FMLanding).getText();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		System.out.println("FileManager is been initiated " + FMmodel);
		
		
		driver.close();
		

	}
}
