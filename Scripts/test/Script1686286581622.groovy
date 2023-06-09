import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://ui.cogmento.com/')

WebUI.setText(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/input_Login_email'), 'deep.p@simformsolutions.com')

WebUI.setEncryptedText(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/input_Login_password'), 'X+O2c+GJfKA5hvqzBcswpg==')

WebUI.sendKeys(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/input_Login_password'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/i_Contacts_plus inverted icon'))

WebUI.setText(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/input_First Name_first_name'), 'Deep')

WebUI.setText(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/input_Last Name_last_name'), 'Patel')

WebUI.setText(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/input_Middle Name(s)_middle_name'), 'Rakeshbhai')

WebUI.setText(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/input_Email_value'), 'deep@gmail.com')

WebUI.click(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/label_Do not Call'))

WebUI.click(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/label_Do not Text'))

WebUI.click(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/label_Do not Email'))

WebUI.setText(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/input_Birthday_day'), '22')

WebUI.click(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/div_Month JanuaryFebruaryMarchAprilMayJuneJ_b508fe'))

WebUI.click(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/div_October'))

WebUI.click(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/div_October JanuaryFebruaryMarchAprilMayJun_aa3d2b'))

WebUI.click(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/span_December'))

WebUI.setText(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/input_December_year'), '2002')

WebUI.click(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/button_Save'))

WebUI.closeBrowser()