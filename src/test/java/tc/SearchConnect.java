package tc;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import attended.CommandLineSession;
import attended.Device;
import attended.DeviceSearch_Connect;
import attended.FileManager;

public class SearchConnect {

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		
		WebDriver driver = Device.searchConnect();
		FileManager FM = new FileManager(driver);
		DeviceSearch_Connect RC = new DeviceSearch_Connect(driver);
		CommandLineSession CL = new CommandLineSession(driver);
		FM.FMUpload();
		RC.DeviceSummary();
		RC.RCDisconnect();
		CL.CLIntial();
		driver.close();
		

	}

}