package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

public static WebDriver driver;
//public static Logger log = LogManager.getLogger(Base.class.getName());
public static Properties prop;
static String projectPath;

public static WebDriver initializeDriver() throws IOException {
	
	 	prop= new Properties();		
	 	projectPath = System.getProperty("user.dir");
//		FileInputStream fis=new FileInputStream(projectPath+"\\src\\main\\java\\resources\\data.properties");
//		prop.load(fis);
//		String browserName = prop.getProperty("browser");
		
//		if(browserName.equalsIgnoreCase("CHROME")) {
//			WebDriverManager.chromedriver().setup();
//			driver= new ChromeDriver();
//		}
		
//		else if(browserName.equalsIgnoreCase("HEADLESS")) {
//			WebDriverManager.chromedriver().setup();
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("headless");
//			driver= new ChromeDriver(options);
//		}
//		
//		
//	else if(browserName.equalsIgnoreCase("FIREFOX")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
//		}
//		
//		else if(browserName.equalsIgnoreCase("EDGE")) {
//			WebDriverManager.edgedriver().setup();
//			driver= new EdgeDriver();
//		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
}

		public void getScreenShot(String result) throws IOException {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("D://screenshots//"+result+"_screenshot.png"));
		}
		
	

}
