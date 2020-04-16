package whatsapp_Automation;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import consoles.Afcsushi;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;

public class Message {
	MobileDriver driver;

	@Test
	public void messageApp() throws MalformedURLException, InterruptedException {
		// Mobile
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		capabilities.setCapability("deviceName", "LGH931391140be");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("version", "8.0.0");
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("fullReset", false);
		capabilities.setCapability("appPackage", "com.android.messaging");
		capabilities.setCapability("appWaitActivity", ".ui.conversationlist.ConversationListActivity");
		capabilities.setCapability("appActivity", ".ui.conversationlist.ConversationListActivity");
		// capabilities.setCapability("dontStopAppOnReset", false);
		capabilities.setCapability("newCommandTimeout", 0);
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(url, capabilities);
		System.out.println("Hello the app started.");
		Thread.sleep(2000);

		// clicking on search button
		driver.findElement(By.id("com.android.messaging:id/action_search")).click();

		// typing
		driver.findElement(By.id("com.android.messaging:id/search_src_text")).sendKeys("AX-HDFCBK");
		Thread.sleep(2000);

		// clicking on + symbol
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Start new conversation']")).click();

		// searching name from contact list
		driver.findElement(By.id("com.android.messaging:id/recipient_text_view")).sendKeys("selenium");
		driver.findElement(By
				.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]"))
				.click();
	}

}
