package com.telecom.stepdefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	@Before
	public void beforeScenario() {
		System.out.println("Before Every Scenerio");

	}
	@After
	public void afterScenario() {
		System.out.println("After Every Scenerio");

	}
}
