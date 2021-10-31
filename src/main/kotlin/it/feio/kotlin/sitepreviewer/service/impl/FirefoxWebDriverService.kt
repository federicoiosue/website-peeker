package it.feio.kotlin.sitepreviewer.service.impl

import it.feio.kotlin.sitepreviewer.service.WebDriverService
import lombok.extern.slf4j.Slf4j
import org.openqa.selenium.OutputType
import org.openqa.selenium.Point
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.File
import java.io.IOException

@Service
@Slf4j
class FirefoxWebDriverService(
    @Value("\${webdriver.gecko.driver}") private val webDriverPath: String
) : WebDriverService {

    lateinit var driver: WebDriver

    init {
        System.setProperty("webdriver.gecko.driver", webDriverPath)
        driver = FirefoxDriver()
        driver.manage().window().position = Point(-2000, 0)
    }

    @Throws(IOException::class)
    override fun peek(url: String) {
        driver.manage().deleteAllCookies()
        driver[url]
        val scrFile: File = (driver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
        println("Took Screenshot for $url and saved as $scrFile")
    }
    }
}