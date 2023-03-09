package Webriver;

import java.awt.Window;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Timeouts;
import org.testng.annotations.Test;


import okio.Timeout;

@Test
public class Topic_05_Selenium_WebDriver_WebElement {
	//Note: This class introduces about the definition of function related to Web Driver & Web Element
	//Note: //** (mean the functions usually to use)
	WebDriver driver;
	
	public void TC_01_Fuction_Webdriver() {
		//Close Single Window
		driver.close();
		//Close all Window
		driver.quit(); //**
		
		//Navigate to url
		driver.get(""); //**
		
		//Return current URL with type = String
		driver.getCurrentUrl();
		
		//Return the Title of current page with type = String
		driver.getTitle();
	
		
		driver.getWindowHandle();
		driver.getWindowHandles();
		
		//Cookie-Cache
		Options otp = driver.manage();
		//Save Cookie
		otp.getCookies();
		//Set Cookie
		otp.logs();
		
		//Timeout
		Timeouts time = otp.timeouts();
		//Implicitly Wait - the time wait the element visible
		time.implicitlyWait(5, TimeUnit.SECONDS); //**
		time.implicitlyWait(5000, TimeUnit.MILLISECONDS);
		//The time wait the page is loading
		time.pageLoadTimeout(5, TimeUnit.SECONDS);
		
		//Web - API - Javascript Executor
		//The time wait until the script is executed
		time.setScriptTimeout(5, TimeUnit.SECONDS);
		
		org.openqa.selenium.WebDriver.Window window = otp.window();
		window.fullscreen();
		window.maximize(); //**
		
		//Direction on Browser
		Navigation nav = driver.navigate();
		nav.back();
		nav.forward();
		nav.refresh();
		nav.to("URL");
		
		
		TargetLocator tar = driver.switchTo();
		//Web API - Alert (Alert Library)
		tar.alert(); //**
		///Web API - Frame / IFrame (Frame Library)
		tar.frame(""); //**
		//Web API - Windows/Tabs
		tar.window(""); //**
		
		//Get ID of Window / Tab as driver is standing
		String loginWindowID = driver.getWindowHandle();
		
		//Get ID of all Windows / Tabs
		Set<String> allID = driver.getWindowHandles();
	}
	
	public void TC_02_Fuction_WebElement() {
		
	}
}
