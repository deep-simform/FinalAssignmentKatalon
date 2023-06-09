import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL as GLOBAL
import com.kms.katalon.core.annotation.BeforeTestSuite as BeforeTestSuite
import com.kms.katalon.core.annotation.SetUp as SetUp
import com.kms.katalon.core.annotation.TearDown as TearDown
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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.URL, false)

assert WebUI.getWindowTitle() == 'Cogmento CRM'

String doNotTextObject = 'Object Repository/cogmento/test/Page_Cogmento CRM/label_Do not Text'
String doNotMailObject = 'Object Repository/cogmento/test/Page_Cogmento CRM/label_Do not Email'
String doNotCallObject = 'Object Repository/cogmento/test/Page_Cogmento CRM/Page_Cogmento CRM/label_Do not Call'

WebUI.click(findTestObject('Object Repository/cogmento/createContact/i_Calendar_users icon'))

WebUI.click(findTestObject('Object Repository/cogmento/createContact/button_Create'))

WebUI.setText(findTestObject('Object Repository/cogmento/createContact/input_First Name_first_name'), FirstName)

WebUI.setText(findTestObject('Object Repository/cogmento/createContact/input_Last Name_last_name'), LastName)

WebUI.setText(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/input_Middle Name(s)_middle_name'), MiddleName)

WebUI.setText(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/input_Email_value'), Email)

CustomKeywords.'com.LoginCogmento.DoNotText'(doNotCallObject,Call,'Do not Call')
CustomKeywords.'com.LoginCogmento.DoNotText'(doNotTextObject,Text,'Do not Text')
CustomKeywords.'com.LoginCogmento.DoNotText'(doNotMailObject,DoEmail,'Do not Mail')


WebUI.setText(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/input_Birthday_day'), BirthDay)

WebUI.click(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/div_October JanuaryFebruaryMarchAprilMayJun_aa3d2b'))

WebUI.click(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/span_December', [('EmpMonth') : BirthMonth]))

WebUI.setText(findTestObject('Object Repository/cogmento/test/Page_Cogmento CRM/input_December_year'), BirthYear)

WebUI.click(findTestObject('Object Repository/cogmento/createContact/button_Save'))

try {
	WebUI.mouseOver(findTestObject('cogmento/createContact/i_Free account_settings icon'))
	
    WebUI.verifyTextPresent((FirstName + ' ') + LastName, false)
	
    WebUI.verifyTextPresent(MiddleName, false)
	
	WebUI.verifyTextPresent(Email, false)
	
	WebUI.verifyTextPresent(BirthDay+' '+BirthMonth+' '+BirthYear, false)
	
}
catch (Exception e) {
    WebUI.refresh()
	WebUI.mouseOver(findTestObject('cogmento/createContact/i_Free account_settings icon'))
    WebUI.verifyTextPresent((FirstName + ' ') + LastName, false)
	
	WebUI.verifyTextPresent(MiddleName, false)
	
	WebUI.verifyTextPresent(Email, false)
	
	WebUI.verifyTextPresent(BirthDay+' '+BirthMonth+' '+BirthYear, false)
	
} 

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