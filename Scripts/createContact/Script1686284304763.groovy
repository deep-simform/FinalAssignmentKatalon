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

CustomKeywords.'com.CreateContact.enterbasicdetails'(FirstName, LastName, MiddleName, Email)
CustomKeywords.'com.CreateContact.setDND'(Call,Text,DoEmail)
CustomKeywords.'com.CreateContact.setBirthDate'(BirthDay, BirthMonth, BirthYear)
CustomKeywords.'com.CreateContact.submitForm'()

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
//	CustomKeywords.'com.CreateContact.Login'(GlobalVariable.username, GlobalVariable.password)
	CustomKeywords.'com.cogmento.Login'(GlobalVariable.username, GlobalVariable.password)
}

@com.kms.katalon.core.annotation.TearDown
void logout() {
//	CustomKeywords.'com.CreateContact.logout'()
	CustomKeywords.'com.cogmento.logout'()
}