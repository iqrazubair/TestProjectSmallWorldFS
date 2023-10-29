package StepDefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.DriverFactory.DriverFactory;
import com.pages.Login;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class LoginPage_test {
	
	private Login login = new Login(DriverFactory.getDriver());
	 
	
	@Given("Open the application")
	public void open_the_application() {
	
		DriverFactory.getDriver().get("https://www.saucedemo.com/"); 
	}

 
	@Then("test the login functionality and verify the validation msg")
	public void test_the_login_functionality_and_verify_the_validation_msg(DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> listdata = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> mapdata : listdata) {
		login.enterUsernameAndPassword(mapdata.get("UserName"), mapdata.get("Password"));
	
	}
		Thread.sleep(3000);
	}

	@Then("Verify user successfully login to the home page")
	public void verify_user_successfully_login_to_the_home_page() throws InterruptedException {
		Thread.sleep(2000);
		String ExpectedUrl="https://www.saucedemo.com/inventory.html";
		String Actualurl = DriverFactory.getDriver().getCurrentUrl();
		
		Assert.assertEquals(Actualurl, ExpectedUrl);		
		
	}

	@Then("Verify the add items Functionality")
	public void verify_the_add_items_functionality(DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> listdata = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> mapdata : listdata) {

			login.addToCart(mapdata.get("LineItemNo"));
		}
	}
	
	@Then("Verify the remove items Functionality")
	public void verify_the_remove_items_functionality(DataTable dataTable) throws InterruptedException {
		login.viewShoppingCart();
		List<Map<String, String>> listdata = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> mapdata : listdata) {
			
		   login.removeItems(mapdata.get("LineItemNo"));
		
	}
}
    @Then("click on the Checkout Button")
    public void click_on_the_Checkout_Button() throws InterruptedException {
    	login.clickOnCheckOutBtn();
    		
    	}
    
    @Then("check the validations of checkout information form and get all the price of items and verify the total amount")
    public void check_the_validations_of_checkout_information_form_and_get_all_the_price_of_items_and_verify_the_total_amount(DataTable dataTable) throws InterruptedException {
    	List<Map<String, String>> listdata = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> mapdata : listdata) {
		 Thread.sleep(2000);
		login.checkingValidationOfCheckoutForm(mapdata.get("Fname"),mapdata.get("Lname"),mapdata.get("Zipcode"));
       Thread.sleep(2000);
    	login.CheckOutInfo();
    	 Thread.sleep(2000);
    	 DriverFactory.getDriver().quit();
		}
    }
	
}
