package tenantCreation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class DeviceSide {

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
		MobileDriver driver = new AndroidDriver(url, capabilities);
		System.out.println("Hello the app started.");
		Thread.sleep(2000);
		System.out.println(driver.findElement(text).getText());

		// Reading Data from Excel
		File excel = new File("C:\\Users\\manju\\Desktop\\besant\\Excel Handle\\Tenant Details.xlsx");
		FileInputStream FIS = new FileInputStream(excel);
		XSSFWorkbook Wb = new XSSFWorkbook(FIS);
		XSSFSheet SH = Wb.getSheet("Sheet1");
		String InputData = SH.getRow(0).getCell(0).getStringCellValue();

		Row r = SH.getRow(0);
		driver.findElement(login).sendKeys(r.getCell(0).getStringCellValue());

		// Enrolling qagm
		driver.findElement(loginbutton).click();

		Thread.sleep(40000);
		System.out.println("40 sec waited");

		// Logged in
		System.out.println(driver.findElement(FirstPermission).getText());
		driver.findElement(FirstAllow).click();
		System.out.println(driver.findElement(SecondPermission).getText());
		driver.findElement(SecondAllow).click();
		Thread.sleep(1000);

		// Knox
		try {
			System.out.println(driver.findElement(By.id("com.samsung.klmsagent:id/eula_title")).getText());
			WebElement CheckBox = driver.findElement(By.id("com.samsung.klmsagent:id/checkBox1"));
			CheckBox.click();
			Thread.sleep(1000);
			WebElement ConfirmButton = driver.findElement(By.id("com.samsung.klmsagent:id/eula_bottom_confirm_agree"));
			ConfirmButton.click();
			Thread.sleep(1000);
			System.out.println("Knox accepted");
			// add one Screen shot
		} catch (Exception e) {
			System.out.println("Knox aleady been accepted");
		}

		driver.findElement(EnableButton).click();
		Thread.sleep(1000);

		// swipe till down
		int durationMS = 4000;
		Dimension size = driver.manage().window().getSize();
		for (int i = 0; i <= 1; i++) {
			int startx = size.width / 2;
			System.out.println(size);
			int starty = (int) (size.height * 0.60);
			int endy = (int) (size.height * 0.10);
			driver.swipe(startx, starty, startx, endy, durationMS);
			System.out.println(i);
		}

		Thread.sleep(1000);
		// Turnning ON Accessibility
		driver.findElement(MobSupport).click();
		driver.findElement(ToggleButton).click();
		driver.findElement(OkButton).click();
		Thread.sleep(1000);

		// Coming back to MSM
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(1000);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(1000);

		System.out.println(driver.findElement(By.id("android:id/alertTitle")).getText());
		driver.findElement(By.id("android:id/button1")).click();

		driver.findElement(By.id("footer_devicehealth")).click();
		System.out.println("Remote Control button clicked");

		// Take RC page SS
		File MobSS1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(MobSS1, new File("D:\\Automation\\ScreenShots\\Mobile_RC.png"));
		System.out.println("Mobile RC page SS taken");

		Thread.sleep(2000);

		// Menu
		driver.findElement(By.id("breadcrumbanchor")).click();
		System.out.println("Menu button clicked");
		Thread.sleep(1000);

		driver.findElement(By.id("about")).click();
		System.out.println("About clicked");
		Thread.sleep(1000);

		// Take About page SS
		File MobSS3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(MobSS3, new File("D:\\Automation\\ScreenShots\\Mobile_About.png"));
		System.out.println("Menu page SS taken");

		Thread.sleep(2000);

		String Version = driver
				.findElement(By
						.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View/android.widget.ListView/android.view.View[1]"))
				.getText();
		System.out.println(Version);

		String BundleID = driver
				.findElement(By
						.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View/android.widget.ListView/android.view.View[2]"))
				.getText();
		System.out.println(BundleID);

		String Tenant = driver
				.findElement(By
						.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View/android.widget.ListView/android.view.View[3]"))
				.getText();
		System.out.println(Tenant);
		// Taking only the Tenant URL
		String TenantURL = Tenant.substring(9);
		System.out.println("Tenant URL is: " + TenantURL);

		String DeviceID1 = driver
				.findElement(By
						.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View/android.widget.ListView/android.view.View[4]"))
				.getText();
		System.out.println(DeviceID1);
		// Taking only the Device ID
		String DeviceIDValue = DeviceID1.substring(11);
		System.out.println("Device ID value is: " + DeviceIDValue);

		driver.findElement(By.id("breadcrumbanchor")).click();

		// Take About page SS
		File MobSS4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(MobSS4, new File("D:\\Automation\\ScreenShots\\GuideME_Page.png"));
		System.out.println("MSM landing page SS taken");

	}
}
