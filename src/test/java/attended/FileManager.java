package attended;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileManager {
	WebDriver driver;
	// File Manager
	By FM = By.xpath(".//*[@id='liFileManager']/a");
	By FMSession = By.xpath(".//*[@id='FM_step3_id_desc']");
	By FMWaitResponse = By.xpath(".//*[@id='FMPin_container']/div/div/p[1]");
	By FMLanding = By.xpath(".//*[@id='divExpandFMDeviceDetail']/div[1]/div/h3[2]");
	By FMDisconnect = By.xpath(".//*[@id='closeFMUI']");

	By UploadButton = By.xpath(".//*[@id='btnFileUpload_new']");
	By BrowseButton = By.xpath(".//*[@id='lblBrowse']");
	By CancelUpload = By.xpath(".//*[@id='divUpload_BrowseBtn']/div[3]/i");

	// Uploading file
	By FMWindow = By.xpath(".//*[@id='headerUpload_new']");
	By Minimize = By.xpath(".//*[@id='divUpload_new']/div/div/span/i");
	// By YetToStart =
	// By.xpath(".//*[@id='divProgressStatus_45a31e7c-3f65-c4cb-8f55-57bb53e80991']");
	By uploadingpercentage = By.xpath(".//*[@id='divProgressStatus_1e09f0d8-372a-1aa9-af7e-40dec31a46aa']");
	By Inprogress = By.xpath(".//*[@id='divUpload_new']/article/div/ul/li[1]/a/span[2]");
	By Completed = By.xpath(".//*[@id='divUpload_new']/article/div/ul/li[2]/a/span[2]");
	By Filename = By.xpath(".//*[@id='divFileName_45a31e7c-3f65-c4cb-8f55-57bb53e80991']");

	// Replace
	By Replace = By.xpath(".//*[@id='divReplacefooter']/ul/li[1]/input");
	By Replacing = By.id("divReplaceText");

	public void FMUpload() throws AWTException, InterruptedException, IOException {

		driver.findElement(FM).click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement UPButton = driver.findElement(UploadButton);
		wait.until(ExpectedConditions.visibilityOf(UPButton));
		UPButton.click();

		WebElement BButton = driver.findElement(BrowseButton);
		wait.until(ExpectedConditions.visibilityOf(BButton));
		BButton.click();
		Thread.sleep(3000);

		// Uploading file operation
		StringSelection Filename = new StringSelection(
				"C:\\Users\\VinothKumar\\Desktop\\Vinoth\\Ola\\CRN1867274627_May 24.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Filename, null);
		Robot File = new Robot();
		File.keyPress(KeyEvent.VK_CONTROL);
		File.keyPress(KeyEvent.VK_V);
		File.keyRelease(KeyEvent.VK_V);
		File.keyRelease(KeyEvent.VK_CONTROL);
		File.keyPress(KeyEvent.VK_ENTER);
		System.out.println("File selected");
		Thread.sleep(5000);

		String ReplacingFile = driver.findElement(Replacing).getText();
		System.out.println(ReplacingFile);
		if (ReplacingFile.startsWith("The")) {
			WebElement ReplaceButton = driver.findElement(Replace);
			ReplaceButton.click();
			System.out.println("Wait: Replacing file");

		} else {
			Thread.sleep(1000);
			System.out.println("Wait: New File is being uploaded");
		}

		WebElement UploadingProgress = driver.findElement(Inprogress);
		wait.until(ExpectedConditions.visibilityOf(UploadingProgress));
		String ULProgress1 = driver.findElement(Inprogress).getText();
		System.out.println("FileManager is been initiated. Your current uploading count is " + ULProgress1);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		Thread.sleep(20000);
		String ULProgress2 = driver.findElement(Inprogress).getText();
		System.out.println("FileManager is been initiated. Your current uploading count is " + ULProgress2);
		Thread.sleep(5000);
		if (ULProgress2.equalsIgnoreCase("(1)")) {
			System.out.println("File is beeing uploaded");
			String ULProgress3 = driver.findElement(Inprogress).getText();
			System.out.println("FileManager is been initiated. Your current uploading count is " + ULProgress3);

		}

		else {
			WebElement Complete = driver.findElement(Completed);
			wait.until(ExpectedConditions.visibilityOf(Complete));
			String Uploaded1 = driver.findElement(Completed).getText();
			System.out.println("Completed status is " + Uploaded1);
			if (Uploaded1.equalsIgnoreCase("(1)")) {

				System.out.println("FileUploaded completed");
				String Proccess = driver
						.findElement(By.xpath(".//*[@id='divUpload_new']/article/div/ul/li[2]/a/span[1]")).getText();
				String count = driver.findElement(By.xpath(".//*[@id='divUpload_new']/article/div/ul/li[2]/a/span[2]"))
						.getText();
				System.out.println(Proccess + " " + count);

				// Taking SS
				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("D:\\Automation\\ScreenShots\\File Upload.png"));
				System.out.println("File Upload Screen SS taken");

				driver.findElement(Minimize).click();
				System.out.println("Your FIle Upload proccess is " + Proccess + " and number of uploads are " + count);
				Thread.sleep(1000);
			}
		}

	}

	public void FMDisconnect() throws InterruptedException {
		By SureDisconnect = By.xpath(".//*[@id='divFMDisconnect']/div[1]/div[2]");
		By Button1 = By.xpath(".//*[@id='btn_disconnectcancel']");
		By Button2 = By.xpath(".//*[@id='btn_disconnectok']");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.findElement(FM).click();

		// chrome FM landing page
		WebElement FMLandingpage = driver.findElement(FMLanding);
		wait.until(ExpectedConditions.visibilityOf(FMLandingpage));
		String FMmodel = driver.findElement(FMLanding).getText();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		System.out.println("FileManager is been initiated " + FMmodel);

		driver.findElement(FMDisconnect).click();
		System.out.println(driver.findElement(SureDisconnect).getText());
		Thread.sleep(2000);
		//driver.findElement(By.linkText("OK"));
		System.out.println("Buttons available:"+driver.findElement(Button1)+"&"+driver.findElement(Button2));
		driver.findElement(Button2).click();

		
		
	}

	// creating constructor
	public FileManager(WebDriver D) {
		this.driver = D;
	}
}
