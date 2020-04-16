package appium;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class RunServer {
	private AppiumDriverLocalService service;
	private AppiumServiceBuilder builder;
	private DesiredCapabilities cap;
	
	public void startServer(){
		// Build Appium Server
		builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(4723);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		
		// Start 
		service = AppiumDriverLocalService.buildService(builder);
		service.start();
		System.out.println("Appium Server Started");
	}
	public void stopServer(){
		service.stop();
		System.out.println("Appium Server Stopped");
	}
	
	public static void main (String [] args){
		RunServer runServer = new RunServer();
		runServer.startServer();
		runServer.stopServer();
	}

}
