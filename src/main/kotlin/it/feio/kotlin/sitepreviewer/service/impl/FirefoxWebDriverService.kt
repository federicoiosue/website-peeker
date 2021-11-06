package it.feio.kotlin.sitepreviewer.service.impl

import it.feio.kotlin.sitepreviewer.service.WebDriverService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import lombok.extern.slf4j.Slf4j
import org.openqa.selenium.Dimension
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.File


@Service
@Slf4j
class FirefoxWebDriverService(
    @Value("\${webdriver.gecko.driver}") private val webDriverPath: String
) : WebDriverService {

    lateinit var driver: WebDriver

    init {
        System.setProperty("webdriver.gecko.driver", webDriverPath)
        val firefoxOptions = FirefoxOptions()
        firefoxOptions.addArguments("--headless")
        driver = FirefoxDriver(firefoxOptions)
    }

    override fun peek(url: String, width: Int?, height: Int?) {
        driver.manage().deleteAllCookies()
        driver.manage().window().size = Dimension(width?:1024, height?:768)
        peekDelayed(url)
    }

    fun peekDelayed(url: String) = runBlocking {
        launch {
            driver[url]
            delay(2000L)
            val scrFile: File = (driver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
            println("Took Screenshot for $url and saved as $scrFile")
        }
    }
}