package com.testinium.setup;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
    public static WebDriver driver;
    // i.e. I am using brave for this reason i provide its path.
    public static final String customBrowserPath = "C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe";
    public static final String mainPageUrl = "https://www.kitapyurdu.com";
    // making non-static logger is expensive. for this reason, logger is static.
    public static Logger logger;

    @BeforeAll
    public static void initializeTestBase() {
        logger = LogManager.getLogger(TestBase.class);
        // fetches proper appropriate chromedriver for chrome
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions() {{
            // Sets the browser to be used
            // if chrome is being used then comment out the line below
            setBinary(customBrowserPath);
            addArguments("--disable-notifications");
            addArguments("--disable-gpu");
            addArguments("--disable-popup-blocking");
        }};
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        logger.info("Connected to browser.");
    }

    @BeforeEach
    public void navigateToMainPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(mainPageUrl);
        logger.info("Navigated to main page.");
    }

    @AfterAll
    public static void terminate() {
        if(driver != null) {
            driver.close();
            driver.quit();
            logger.info("Browser connection closed.");
        }
    }
}
