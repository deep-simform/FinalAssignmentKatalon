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

WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.URL, false)

assert WebUI.getWindowTitle() == 'Cogmento CRM'

WebUI.click(findTestObject('Object Repository/cogmento/updateContact/Page_Cogmento CRM/i_Calendar_users icon'))

WebUI.mouseOver(findTestObject('cogmento/createContact/i_Free account_settings icon'))

WebUI.click(findTestObject('Object Repository/cogmento/updateContact/Page_Cogmento CRM/a_Kunj Prafulkumar Kaneria'))

WebUI.click(findTestObject('Object Repository/cogmento/updateContact/Page_Cogmento CRM/i_Kunj Kaneria_edit icon'))

WebUI.click(findTestObject('Object Repository/cogmento/updateContact/Page_Cogmento CRM/button_Public'))

WebUI.click(findTestObject('Object Repository/cogmento/updateContact/Page_Cogmento CRM/button_Save'))

WebUI.verifyTextPresent("Only you can see this record.", false)

@com.kms.katalon.core.annotation.SetUp
void login() {
    WebUI.navigateToUrl(GlobalVariable.URL)

    String username_object = 'Object Repository/cogmento/createContact/input_Login_email'

    String password_object = 'Object Repository/cogmento/createContact/input_Login_password'

    String loginBtn_object = 'Object Repository/cogmento/createContact/div_Login'

    CustomKeywords.'com.LoginCogmento.Login'(username_object, password_object, loginBtn_object, GlobalVariable.username, 
        GlobalVariable.password)
}

@com.kms.katalon.core.annotation.TearDown
void logout() {
    try {
        WebUI.waitForPageLoad(5)

        WebUI.click(findTestObject('Object Repository/cogmento/createContact/i_Free account_settings icon'))

        WebUI.click(findTestObject('Object Repository/cogmento/createContact/span_Log Out'))

        WebUI.waitForPageLoad(5)

        WebUI.verifyTextPresent('Forgot your password?', false)
    }
    catch (Exception e) {
        WebUI.click(findTestObject('Object Repository/cogmento/createContact/i_Free account_settings icon'))

        WebUI.click(findTestObject('Object Repository/cogmento/createContact/span_Log Out'))

        WebUI.verifyTextPresent('Forgot your password?', false)
    } 
}

