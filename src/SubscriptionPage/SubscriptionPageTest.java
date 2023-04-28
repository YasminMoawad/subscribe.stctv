package SubscriptionPage;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class SubscriptionPageTest {

WebDriver driver;

@BeforeClass
public void setUp() {

//System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://subscribe.stctv.com/");
}

@Test
public void testSubscriptionPackages() {
// Validate the Subscription Packages – Type & Price and Currency for all Countries (SA / Kuwait and Bahrain)
SubscriptionPage subscriptionPage = new SubscriptionPage(driver);

subscriptionPage.selectCountry("kw");
subscriptionPage.validateSubscriptionPackages("دينار كويتي/شهر","2.5");
subscriptionPage.ValidateLightPackage("دينار كويتي/شهر","1.2");
subscriptionPage.ValidatepremiumPackage("دينار كويتي/شهر","4.8");


subscriptionPage.selectCountry("bh");
subscriptionPage.validateSubscriptionPackages("دينار بحريني/شهر","3");
subscriptionPage.ValidateLightPackage("دينار بحريني/شهر","2");
subscriptionPage.ValidatepremiumPackage("دينار بحريني/شهر","6");

subscriptionPage.selectCountry("sa");
subscriptionPage.validateSubscriptionPackages("ريال سعودي/شهر","25");
subscriptionPage.ValidateLightPackage("ريال سعودي/شهر","15");
subscriptionPage.ValidatepremiumPackage("ريال سعودي/شهر","60");


}

@AfterClass
public void tearDown() {
	driver.quit();

}



public class SubscriptionPage {

private WebDriver driver;

public SubscriptionPage(WebDriver driver)
{
this.driver = driver;
}

public void selectCountry(String country) {

// Validate Country 
driver.findElement(By.xpath("//*[@id=\"country\"]")).click();
driver.findElement(By.xpath("//*[@id=\""+country+"-contry-lable\"]")).click();

}

public void validateSubscriptionPackages(String Expectedresult , String ExpectedPrice) {
// Validate Main Packages – Price and Currency for all Countries (SA / Kuwait and Bahrain)
List<WebElement> packages = driver.findElements(By.xpath("//*[@id=\"name-الأساسية\"]"));
for (WebElement PK : packages) 
{

String packageCurrency = PK.findElement(By.xpath("//*[@id=\"currency-الأساسية\"]/i")).getText();
driver.manage().timeouts();
String PackagePrice = PK.findElement(By.xpath("//*[@id=\"currency-الأساسية\"]/b")).getText();


if(Expectedresult.equalsIgnoreCase(packageCurrency)& ExpectedPrice.equalsIgnoreCase(PackagePrice))
System.out.println(" The expected result for the main package "+ExpectedPrice+ Expectedresult + " is same as actual Result " +PackagePrice+ packageCurrency );
else 
	System.out.println(" The expected result for the main package "+ ExpectedPrice + Expectedresult +" is Not same as actual Result " + PackagePrice + packageCurrency );


}
}
public void ValidateLightPackage(String Expectedresult , String ExpectedPrice) {
	// Validate light Packages – Price and Currency for all Countries (SA / Kuwait and Bahrain)
	List<WebElement> packages = driver.findElements(By.xpath("//*[@id=\"name-لايت\"]"));
	for (WebElement PK : packages) 
	{

	String packageCurrency = PK.findElement(By.xpath("//*[@id=\"currency-لايت\"]/i")).getText();
	driver.manage().timeouts();
	String PackagePrice = PK.findElement(By.xpath("//*[@id=\"currency-لايت\"]/b")).getText();


	if(Expectedresult.equalsIgnoreCase(packageCurrency)& ExpectedPrice.equalsIgnoreCase(PackagePrice))
	System.out.println(" The expected result for light package "+ExpectedPrice+ Expectedresult + " is same as actual Result " +PackagePrice+ packageCurrency );
	else 
		System.out.println(" The expected result for the light package "+ ExpectedPrice + Expectedresult +" is Not same as actual Result " + PackagePrice + packageCurrency );


	}
	}
 public void ValidatepremiumPackage(String Expectedresult , String ExpectedPrice) {
	// Validate premium Packages – Price and Currency for all Countries (SA / Kuwait and Bahrain)
	List<WebElement> packages = driver.findElements(By.xpath("//*[@id=\"name-بريميوم\"]"));
	for (WebElement PK : packages) 
	{

	String packageCurrency = PK.findElement(By.xpath("//*[@id=\"currency-بريميوم\"]/i")).getText();
	driver.manage().timeouts();
	String PackagePrice = PK.findElement(By.xpath("//*[@id=\"currency-بريميوم\"]/b")).getText();


	if(Expectedresult.equalsIgnoreCase(packageCurrency)& ExpectedPrice.equalsIgnoreCase(PackagePrice))
	System.out.println(" The expected result for premium package "+ExpectedPrice+ Expectedresult + " is same as actual Result " +PackagePrice+ packageCurrency );
	else 
		System.out.println(" The expected result for the premium package "+ ExpectedPrice + Expectedresult +" is Not same as actual Result " + PackagePrice + packageCurrency );


	}
	}


}
}

