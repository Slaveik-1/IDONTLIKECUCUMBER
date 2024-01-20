package framework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private static WebDriver webDriver = null;

    public static void initDriver(){
        webDriver=new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

    }

    public static WebDriver getWebDriver(){
        if (webDriver == null){
            initDriver();
        }
        return webDriver;
    }

    public static void quit(){
        webDriver.quit();
    }




}
