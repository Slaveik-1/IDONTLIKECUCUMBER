package framework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    public static final String dType = "remote";
    public static final String selen = "http://149.154.71.152:4444/wd/hub";
    public static final String Btype = "chrome";

    private static WebDriver webDriver = null;
    public static RemoteWebDriver rDriver;
    private WebDriverManager(){
    }

    public static void initDriver() {
        if (dType.equals("local")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            webDriver = new ChromeDriver();
        } else if (dType.equals("remote")) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setBrowserName(Btype);
            desiredCapabilities.setVersion("109.0");
            desiredCapabilities.setCapability("enableVNC", true);
            desiredCapabilities.setCapability("enableVideo", false);
            try {
                rDriver = new RemoteWebDriver(URI.create(selen).toURL(), desiredCapabilities);
            } catch (MalformedURLException exception) {
                exception.printStackTrace();
            }
        }}


        public static WebDriver getWebDriver () {
            if (webDriver == null && rDriver == null) {
                initDriver();
            }
            if (dType.equals("local"))
                return webDriver;
            if (dType.equals("remote"))
                return rDriver;
            return null;
        }

        public static void quit () {
            if (webDriver != null) {
                webDriver.quit();
                webDriver = null;
            }
            if (rDriver != null) {
                rDriver.quit();
            }
        }

    }


