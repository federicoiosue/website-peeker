package it.feio.kotlin.sitepreviewer.service.impl

import it.feio.kotlin.sitepreviewer.service.WebDriverService
import it.feio.kotlin.sitepreviewer.utils.fixUrl
import kotlinx.coroutines.delay
import lombok.extern.slf4j.Slf4j
import org.openqa.selenium.Dimension
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Service
import org.springframework.util.FileCopyUtils
import java.io.BufferedInputStream
import java.io.File
import java.io.InputStream


@Service
@Slf4j
class FirefoxWebDriverService(
    @Value("\${webdriver.gecko.driver}") private val webDriverPath: String
) : WebDriverService {

    @Value("classpath:static/notfound.png")
    var notFoundImage: Resource? = null

    lateinit var driver: WebDriver

    init {
        System.setProperty("webdriver.gecko.driver", webDriverPath)
        val firefoxOptions = FirefoxOptions()
        firefoxOptions.addArguments("--headless")
        driver = FirefoxDriver(firefoxOptions)
    }

    override suspend fun peek(url: String, width: Int?, height: Int?): File {
        openSite(width, height, url)
        return takeScreenshot()?: notFoundImage!!.file
    }

    private fun openSite(width: Int?, height: Int?, url: String) {
        driver.manage().deleteAllCookies()
        driver.manage().window().size = Dimension(width ?: 1024, height ?: 768)
        driver[fixUrl(url)]
    }

    private suspend fun takeScreenshot(): File? {
        delay(2000L)
        return (driver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
    }

}