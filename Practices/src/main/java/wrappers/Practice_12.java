package wrappers;


import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import wrappers.GenericWrappers;

public class Practice_12 extends GenericWrappers {	
	
	@BeforeMethod
	@Parameters({"browser","url","username","password"})
public void login(String browser,String url,String username,String password) throws InterruptedException, FileNotFoundException, IOException{
	launchBrowser(url,browser);
	loginUsername("username",username);
	loginPassword("password",password);
	clickByXPath("//*[@id='login']/p[3]/input");
}
	@Test
	public void createLead(){
		clickByLink("CRM/SFA");
		clickByXPath("//a[contains(text(),'Create Lead')]");
		enterById("createLeadForm_companyName","test");
		enterById("createLeadForm_firstName","test");
		enterById("createLeadForm_lastName", "test");
		clickByName("submitButton");
		
	}
	@AfterMethod(alwaysRun=true)
	public void quitBrowser(){
		quitBrowser();
	}
	
}
