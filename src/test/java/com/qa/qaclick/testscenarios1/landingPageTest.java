package com.qa.qaclick.testscenarios1;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.qaClickAccademy.object_repository.HomePage;

import utilities.Base;

public class landingPageTest extends Base {
	
	public HomePage hp;
	
	@BeforeTest
	public void initialize_driver() throws IOException {
		driver=initializeDriver();
		
	}
	@Test
	public void check_If_Featured_Courses_Text_is_Present() {
		 hp = new HomePage(driver);
		driver.get("http://www.qaclickacademy.com/");
		String textIsPresent = hp.featuredCoursesText().getText();
		System.out.println(textIsPresent);
		
	}
}
