package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	static WebDriver driver;
	static Properties prop;
	String propertiesPath = "C:\\Users\\shrut\\eclipse-workspace\\Planting Profiles\\src\\main\\java\\utils\\utils.properties";

	public Properties  initProperties() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(propertiesPath);
		prop.load(fis);
		return prop;

	}

	public  void initBrowser(String browserName) {
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase(browserName)) {
			System.setProperty("webdriver.chrome.driver", "D:\\BrowserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase(browserName)) {
			System.setProperty("webdriver.gecko.driver", "D:\\BrowserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
