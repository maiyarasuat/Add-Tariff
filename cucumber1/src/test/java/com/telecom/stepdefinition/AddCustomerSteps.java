package com.telecom.stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddCustomerSteps {
	
	static WebDriver driver;
	
	@Given("user launches demo telecom application")
	public void user_launches_demo_telecom_application() {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("http://www.demo.guru99.com/telecom/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("click on add customer button")
	public void click_on_add_customer_button() {
		driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
		
	   
	}

	@When("user enters all the fields")
	public void user_enters_all_the_fields() {
		driver.findElement(By.xpath("//label[@for='done']")).click();
		driver.findElement(By.id("fname")).sendKeys("maiyarasu");
		driver.findElement(By.id("lname")).sendKeys("s");
		driver.findElement(By.id("email")).sendKeys("maiyarasu@gmail.com");
		driver.findElement(By.name("addr")).sendKeys("salem");
		driver.findElement(By.id("telephoneno")).sendKeys("8220807375");
	    
	}

	@When("user click on submit button")
	public void user_click_on_submit_button() {
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
	   
	}

	@Then("user verify customer id is generated")
	public void user_verify_customer_id_is_generated() {
		
		WebElement pleaseNote = driver.findElement(By.xpath("(//td[@align='center'])[3]"));
		String outputText = pleaseNote.getText();
		System.out.println(outputText);
		Assert.assertEquals(outputText, "Please Note Down Your CustomerID");
		driver.quit();
	}

	@When("user enters all the fields by one dim list concept")
	public void user_enters_all_the_fields_by_one_dim_list_concept(DataTable dataTable) {
		List<String> datas = dataTable.asList(String.class);
		driver.findElement(By.xpath("//label[@for='done']")).click();
		driver.findElement(By.id("fname")).sendKeys(datas.get(0));
		driver.findElement(By.id("lname")).sendKeys(datas.get(1));
		driver.findElement(By.id("email")).sendKeys(datas.get(2));
		driver.findElement(By.name("addr")).sendKeys(datas.get(3));
		driver.findElement(By.id("telephoneno")).sendKeys(datas.get(4));
	}
	@When("user enters all the fields by one dim map concept")
	public void user_enters_all_the_fields_by_one_dim_map_concept(DataTable dataTable) {
		Map<String, String> datas = dataTable.asMap(String.class, String.class);
		driver.findElement(By.xpath("//label[@for='done']")).click();
		driver.findElement(By.id("fname")).sendKeys(datas.get("fname"));
		driver.findElement(By.id("lname")).sendKeys(datas.get("lname"));
		driver.findElement(By.id("email")).sendKeys(datas.get("mail"));
		driver.findElement(By.name("addr")).sendKeys(datas.get("address"));
		driver.findElement(By.id("telephoneno")).sendKeys(datas.get("phno"));
	}
	@When("user enters all the fields by {string},{string},{string},{string},{string}")
	public void user_enters_all_the_fields_by(String fname, String lname, String mail, String address, String phno) {
		driver.findElement(By.xpath("//label[@for='done']")).click();
		driver.findElement(By.id("fname")).sendKeys(fname);
		driver.findElement(By.id("lname")).sendKeys(lname);
		driver.findElement(By.id("email")).sendKeys(mail);
		driver.findElement(By.name("addr")).sendKeys(address);
		driver.findElement(By.id("telephoneno")).sendKeys(phno);
	}
}
	

