package com.selenium.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.selenium.listeners.TestListeners;

public class GoogleLogin {
	

	@Test
	public void googleLogin() {

		Assert.assertTrue(true);
		
		System.out.println("googleLogin test case has passed");

	}

	@Test
	public void googleProfile() {

		Assert.assertTrue(true);
		System.out.println("googleProfile test case has passed");
	}

	@Test
	public void googleAdmin() {

		Assert.assertTrue(true);
		System.out.println("googleAdmin test case has passed");
	}

}
