package appium;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Server {
	private AppiumDriverLocalService service;
	private AppiumServiceBuilder builder;
	private DesiredCapabilities cap;

	public static void main(String[] args) {
		AppiumServer app = new AppiumServer();
		Boolean port = app.checkIfServerIsRunnning(4723);
		if (!port) {
			app.startServer();
			app.stopServer();
		} else {
			System.out.println("Port is already in use.");
		}
	}

}
