package com.telecom.stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class AddTariffPlan {

	static WebDriver driver;
	@Given("user launches demo telecom applications")
	public void user_launches_demo_telecom_applications() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.demo.guru99.com/telecom/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
	}

	@Given("click on add tariff plans")
	public void click_on_add_tariff_plans() {
		driver.findElement(By.xpath("//a[text()='Add Tariff Plan']")).click();
	}

	@When("user enters all the field")
	public void user_enters_all_the_field() {
		driver.findElement(By.name("rental")).sendKeys("400");
		driver.findElement(By.name("local_minutes")).sendKeys("500");
		driver.findElement(By.id("inter_minutes")).sendKeys("450");
		driver.findElement(By.name("sms_pack")).sendKeys("300");
		driver.findElement(By.name("minutes_charges")).sendKeys("1");
		driver.findElement(By.name("inter_charges")).sendKeys("2");
		driver.findElement(By.id("sms_charges")).sendKeys("1");
	}

	@When("user click on submit buttons")
	public void user_click_on_submit_buttons() {
		driver.findElement(By.xpath("//input[@value='submit']")).click();
	}

	@Then("user verify tariff plan is generated")
	public void user_verify_tariff_plan_is_generated() {
		WebElement texT  = driver.findElement(By.xpath("//*[text()='Congratulation you add Tariff Plan']"));
		 String equal = texT.getText();
		 System.out.println(equal);

	}
	
	@When("user click the all fileds by using one dim list")
	public void user_click_the_all_fileds_by_using_one_dim_list(DataTable dataTable) {
		List<String> datas = dataTable.asList(String.class);
		driver.findElement(By.name("rental")).sendKeys(datas.get(0));
		driver.findElement(By.name("local_minutes")).sendKeys(datas.get(1));
		driver.findElement(By.id("inter_minutes")).sendKeys(datas.get(2));
		driver.findElement(By.name("sms_pack")).sendKeys(datas.get(3));
		driver.findElement(By.name("minutes_charges")).sendKeys(datas.get(4));
		driver.findElement(By.name("inter_charges")).sendKeys(datas.get(5));
		driver.findElement(By.id("sms_charges")).sendKeys(datas.get(6));
	}
	
	@When("user click the all fileds by using one dim map")
	public void user_click_the_all_fileds_by_using_one_dim_map(DataTable dataTable) {
	   Map<String,String> datas = dataTable.asMap(String.class,String.class);
		driver.findElement(By.name("rental")).sendKeys(datas.get("rental"));
		driver.findElement(By.name("local_minutes")).sendKeys(datas.get("local_minutes"));
		driver.findElement(By.id("inter_minutes")).sendKeys(datas.get("inter_minutes"));
		driver.findElement(By.name("sms_pack")).sendKeys(datas.get("sms_pac"));
		driver.findElement(By.name("minutes_charges")).sendKeys(datas.get("minutes_charges"));
		driver.findElement(By.name("inter_charges")).sendKeys(datas.get("inter_charges"));
		driver.findElement(By.id("sms_charges")).sendKeys(datas.get("sms_charges"));
	}

}
	
