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

public class updatecontact {

	String calander_icon_object = 'Object Repository/cogmento/updateContact/Page_Cogmento CRM/i_Calendar_users icon'
	String setting_icon_object = 'cogmento/createContact/i_Free account_settings icon'
	String profile_click_object = 'Object Repository/cogmento/updateContact/Page_Cogmento CRM/a_Kunj Prafulkumar Kaneria'
	String edit_btn_object = 'Object Repository/cogmento/updateContact/Page_Cogmento CRM/i_Kunj Kaneria_edit icon'
	String public_btn_object = 'Object Repository/cogmento/updateContact/Page_Cogmento CRM/button_Public'
	String save_btn_object = 'Object Repository/cogmento/updateContact/Page_Cogmento CRM/button_Save'

	@Keyword
	public updateForm() {
		WebUI.click(findTestObject(calander_icon_object))
		WebUI.mouseOver(findTestObject(setting_icon_object))
		WebUI.mouseOver(findTestObject(setting_icon_object))
		WebUI.click(findTestObject(profile_click_object))
		WebUI.click(findTestObject(edit_btn_object))
		WebUI.click(findTestObject(public_btn_object))
		WebUI.click(findTestObject(save_btn_object))
		WebUI.verifyTextPresent("Only you can see this record.", false)
	}
}

