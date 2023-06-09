package com
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

public class CreateContact {
	String doNotTextObject = 'Object Repository/cogmento/test/Page_Cogmento CRM/label_Do not Text'
	String doNotMailObject = 'Object Repository/cogmento/test/Page_Cogmento CRM/label_Do not Email'
	String doNotCallObject = 'Object Repository/cogmento/test/Page_Cogmento CRM/Page_Cogmento CRM/label_Do not Call'
	String username_object = 'Object Repository/cogmento/createContact/input_Login_email'
	String password_object = 'Object Repository/cogmento/createContact/input_Login_password'
	String loginBtn_object = 'Object Repository/cogmento/createContact/div_Login'
	String Calender_icon_object = 'Object Repository/cogmento/createContact/i_Calendar_users icon'
	String Button_Create_object = 'Object Repository/cogmento/createContact/button_Create'
	String first_name_object = 'Object Repository/cogmento/createContact/input_First Name_first_name'
	String last_name_object = 'Object Repository/cogmento/createContact/input_Last Name_last_name'
	String middle_name_object = 'Object Repository/cogmento/test/Page_Cogmento CRM/input_Middle Name(s)_middle_name'
	String email_object = 'Object Repository/cogmento/test/Page_Cogmento CRM/input_Email_value'
	String birth_day_object = 'Object Repository/cogmento/test/Page_Cogmento CRM/input_Birthday_day'
	String birth_month_object = 'Object Repository/cogmento/test/Page_Cogmento CRM/div_October JanuaryFebruaryMarchAprilMayJun_aa3d2b'
	String birth_month_text_object = 'Object Repository/cogmento/test/Page_Cogmento CRM/span_December'
	String birth_year_object = 'Object Repository/cogmento/test/Page_Cogmento CRM/input_December_year'
	String submit_object = 'Object Repository/cogmento/createContact/button_Save'
	String setting_btn_object = 'Object Repository/cogmento/createContact/i_Free account_settings icon'
	String logout_btn_object = 'Object Repository/cogmento/createContact/span_Log Out'

	@Keyword
	void enterbasicdetails(fname,lname,mname,email) {
		WebUI.click(findTestObject(Calender_icon_object))
		WebUI.click(findTestObject(Button_Create_object))
		WebUI.setText(findTestObject(first_name_object), fname)
		WebUI.setText(findTestObject(last_name_object), lname)
		WebUI.setText(findTestObject(middle_name_object), mname)
		WebUI.setText(findTestObject(email_object), email)
	}
	@Keyword
	void setDND(dndcall,dndtext,dndemail) {
		DND(doNotCallObject,dndcall,'Do not Call')
		DND(doNotTextObject,dndtext,'Do not Text')
		DND(doNotMailObject,dndemail,'Do not Mail')
	}
	@Keyword
	void setBirthDate(day,month,year) {
		WebUI.setText(findTestObject(birth_day_object), day)
		WebUI.click(findTestObject(birth_month_object))
		WebUI.click(findTestObject(birth_month_text_object, [('EmpMonth') : month]))
		WebUI.setText(findTestObject(birth_year_object), year)
	}

	@Keyword
	void submitForm() {
		WebUI.click(findTestObject(submit_object))
	}

	public DND(object,flag,text) {
		if(flag=='true') {
			WebUI.click(findTestObject(object,[('text') : text]))
		}
	}
}