package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class GenericWrappers implements Wrappers{
	RemoteWebDriver driver;
	//ExtentTest test;
	/*public String sHub, sPort, sUrl;
	protected static Properties prop;
	public GenericWrappers(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test=test;
	}
	public void property() throws FileNotFoundException, IOException{
		Properties prop=new Properties();
		prop.load(new FileInputStream(new File("./src/main/resorces/config.properties")));
		sHub=prop.getProperty("HUB");
		sPort=prop.getProperty("PORT");
		sUrl=prop.getProperty("URL");
	}
	public void unloadObjects() {
		prop = null;
	}*/
	@Override
	public void clickByLink(String link) {
		driver.findElementByLinkText(link).click();
		
	}
	@Override
	public void clickByXPath(String xpath){
		driver.findElementByXPath(xpath).click();
	}

	@Override
	public void loginUsername(String id, String username) {
		driver.findElementById(id).sendKeys(username);
	}
	@Override	
	public void loginPassword(String id, String password){
		driver.findElementById(id).sendKeys(password);
		
	}
	
	@Override
	public void launchBrowser(String url, String browser) {
		try{
			/*DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);
		if(bRemote){
			driver=new RemoteWebDriver(new URL("http://"+sHub+":"+sPort+"/wd/hub"), dc);
		}
		else{*/
		
		
			if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			driver=new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			}
		
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("Data Mismatch");
		}
		}
		
	
	@Override
	public void enterById(String id, String val) {
		driver.findElementById(id).sendKeys(val);
		
	}
	@Override
	public void clickByName(String name) {
		driver.findElementByName(name).click();
		
	}
	@Override
	public void quitBrowser() {
		driver.quit();
		
	}

}
