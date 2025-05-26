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

public class cogmento {

	String username_object = 'Object Repository/cogmento/createContact/input_Login_email'
	String password_object = 'Object Repository/cogmento/createContact/input_Login_password'
	String loginBtn_object = 'Object Repository/cogmento/createContact/div_Login'
	String setting_btn_object = 'Object Repository/cogmento/createContact/i_Free account_settings icon'
	String logout_btn_object = 'Object Repository/cogmento/createContact/span_Log Out'
	@Keyword
	void logout() {
		try {
			WebUI.waitForPageLoad(5)
			WebUI.click(findTestObject(setting_btn_object))
			WebUI.click(findTestObject(logout_btn_object))
			WebUI.verifyTextPresent('Forgot your password?', false)
		}
		catch (Exception e) {
			WebUI.click(findTestObject(setting_btn_object))
			WebUI.click(findTestObject(logout_btn_object))
			WebUI.verifyTextPresent('Forgot your password?', false)
		}
	}
	@Keyword
	void Login(String username,String password) {
		WebUI.setText(findTestObject(username_object), username)
		WebUI.setText(findTestObject(password_object), password)
		WebUI.click(findTestObject(loginBtn_object))
	}
}