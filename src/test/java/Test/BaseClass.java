package Test;

import Page.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseClass {
    static WebDriver driver;
    protected static PageFactory pageFactory;

    @Parameters("browserName")
    @BeforeClass
    public static void Setup(String browserName) throws MalformedURLException {
        if (browserName.equalsIgnoreCase("chrome")) {
            String Node = "http://192.168.18.98:4444";
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setBrowserName("chrome");
            driver = new RemoteWebDriver(new URL(Node), cap);
            driver.get("https://admin-demo.nopcommerce.com");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            pageFactory = new PageFactory(driver);
            driver.manage().window().maximize();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            String Node = "http://192.168.18.98:4444";
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setBrowserName("chrome");
            driver = new RemoteWebDriver(new URL(Node), cap);
            driver.get("https://admin-demo.nopcommerce.com");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            pageFactory = new PageFactory(driver);
            driver.manage().window().maximize();
        }
    }

    @AfterClass
    public static void Logout() {
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
        driver.close();
    }

}