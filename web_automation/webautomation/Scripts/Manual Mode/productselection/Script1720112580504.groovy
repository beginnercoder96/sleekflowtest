import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def websites = [[('name') : 'Amazon', ('url') : 'https://www.tokopedia.com/']]

def websites2 = [[('name') : 'lazada', ('url') : 'https://www.lazada.co.id/']]

// define exact word to be search
def searchWord = 'iphone 15 pro'

// define action to open browser, perform search, and extract information
def results = []

websites.each({ def site ->
        WebUI.openBrowser('')

        DriverFactory.getWebDriver().manage().window().maximize()

        WebUI.navigateToUrl(site.url)

		WebUI.waitForPageLoad(5)

        // Search for the product
        WebUI.setText(findTestObject('Object Repository/Page_Situs Jual Beli Online Terlengkap, Mud_c2d1e5/input_Kategori_css-3017qm exxxdg63'), 
    'iphone 15 pro')

		WebUI.sendKeys(findTestObject('Object Repository/Page_Situs Jual Beli Online Terlengkap, Mud_c2d1e5/input_Kategori_css-3017qm exxxdg63'), 
    Keys.chord(Keys.ENTER))

		WebUI.click(findTestObject('Object Repository/Page_Promo (IBOX) Apple iPhone 15 Pro 1TB 5_18c873/div_Rp17.836.000'))

        // Extract relevant information
        def productName = WebUI.click(findTestObject('Object Repository/Page_Jual iphone 15 pro  Tokopedia/span_(IBOX) Apple iPhone 15 Pro 1TB 512GB 2_0c88ab'))
        def productPrice = WebUI.click(findTestObject('Object Repository/Page_Promo (IBOX) Apple iPhone 15 Pro 1TB 5_18c873/div_Rp17.836.000'))
        def productUrl = DriverFactory.getWebDriver().getCurrentUrl()
		
        // Store results
        results.add([('website') : site.name, ('productName') : productName, ('productPrice') : productPrice, ('productUrl') : productUrl])

        WebUI.closeBrowser()
    })

websites2.each({ def site ->
        WebUI.openBrowser('')

        DriverFactory.getWebDriver().manage().window().maximize()

        def productUrl = WebUI.navigateToUrl(site.url)

        WebUI.enableSmartWait()

        // Search for the product
        WebUI.setText(findTestObject('Object Repository/Page_Lazada.co.id  Jual Beli Online Terbaik_b46a9c/input_Logout_q'), 
            'iphone 15 pro')

        WebUI.click(findTestObject('Object Repository/Page_Lazada.co.id  Jual Beli Online Terbaik_b46a9c/a_Cari'))

        WebUI.click(findTestObject('Object Repository/Page_Jual Iphone 15 Pro Terbaru - Jul 2024  Lazada/a_Apple iPhone 15 Pro'))

        def productPrice = WebUI.click(findTestObject('Object Repository/Page_Apple iPhone 15 Pro  Lazada Indonesia/span_Rp19.249.000'))

        // Extract relevant information
        def productName = WebUI.click(findTestObject('Object Repository/Page_Apple iPhone 15 Pro  Lazada Indonesia/span_Rp19.249.000'))

        results.add([('website') : site.name, ('productName') : productName, ('productPrice') : productPrice, ('productUrl') : productUrl])

        // Sort results by productPrice (assuming it's a numeric value)
//        results.sort({ def productUrl = a, def productUrl = b->
//                a.productPrice1.toFloat() <=> b.productPrice2.toFloat()
//            })

        // Display results
        results.each({ def result ->
                println("Website: $result.website")

                println("Product: $result.productName")

                println("Price: $result.productPrice")

                println("URL: $result.productUrl")

                println('')
            })
    })

end

//WebUI.openBrowser('')
//
//WebUI.navigateToUrl('https://www.tokopedia.com/')
//
//WebUI.setText(findTestObject('Object Repository/Page_Situs Jual Beli Online Terlengkap, Mud_c2d1e5/input_Kategori_css-3017qm exxxdg63'), 
//    'iphone 15 pro')
//
//WebUI.click(findTestObject('Object Repository/Page_Situs Jual Beli Online Terlengkap, Mud_c2d1e5/svg_Kategori_unf-icon'))
//
//WebUI.click(findTestObject('Object Repository/Page_Situs Jual Beli Online Terlengkap, Mud_c2d1e5/svg_Kategori_unf-icon'))
//
//WebUI.sendKeys(findTestObject('Object Repository/Page_Situs Jual Beli Online Terlengkap, Mud_c2d1e5/input_Kategori_css-3017qm exxxdg63'), 
//    Keys.chord(Keys.ENTER))
//
//WebUI.setText(findTestObject('Object Repository/Page_Situs Jual Beli Online Terlengkap, Mud_c2d1e5/input_Kategori_css-3017qm exxxdg63'), 
//    'iphone 15 pro')
//
//WebUI.click(findTestObject('Object Repository/Page_Jual iphone 15 pro  Tokopedia/span_(IBOX) Apple iPhone 15 Pro 1TB 512GB 2_0c88ab'))
//
//WebUI.click(findTestObject('Object Repository/Page_Promo (IBOX) Apple iPhone 15 Pro 1TB 5_18c873/div_Rp17.836.000'))
//
//WebUI.closeBrowser()



