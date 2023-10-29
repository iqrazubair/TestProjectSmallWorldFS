package com.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.DriverFactory.DriverFactory;


public class Login {
	
	private WebDriver driver;

	
	
	By u_Name=By.id("user-name");
	By pswd=By.id("password");
	By Login_Btn=By.id("login-button");
	By Open_ShoppingCart=By.xpath("//a[@class='shopping_cart_link']");
	By CheckOut_Btn=By.id("checkout");
	By F_Name=By.id("first-name");
	By L_Name=By.id("last-name");
	By zipCode=By.id("postal-code");
	By Continue_Btn=By.id("continue");
	By ErrorMsg=By.xpath("//div[@class=\"error-message-container error\"]//h3");
	By GetAllPrice=By.xpath("//div[@class=\"inventory_item_price\"]");
	By TotalAmount=By.xpath("//div[@class=\"summary_info_label summary_total_label\"]");
	By SalesTax=By.xpath("//div[@class=\"summary_tax_label\"]");
	
	
	String Fname_Error="Error: First Name is required";
	String Lname_Error="Error: Last Name is required";
	String ZipCode_Error="Error: Postal Code is required";
	double totalPrice = 0;
	
	public Login(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUsernameAndPassword(String Username,String Password) throws InterruptedException {
		driver.findElement(u_Name).clear();
		
		    driver.findElement(u_Name).sendKeys(Username);
		    Thread.sleep(2000);
		    driver.findElement(pswd).clear();
			driver.findElement(pswd).sendKeys(Password);
			 Thread.sleep(2000);
			driver.findElement(Login_Btn).click();
			
	}
	
	public void addToCart(String LineItemNo) throws InterruptedException {
	    By AddToCart = By.xpath("//div/div[" + LineItemNo + "]/div[2]/div[@class=\"pricebar\"]/button");
	    driver.findElement(AddToCart).click();
	    Thread.sleep(2000);
	}
			
	
	public void viewShoppingCart() throws InterruptedException {
		driver.findElement(Open_ShoppingCart).click();	
		 Thread.sleep(2000);
	}
	
	public void removeItems(String LineItemNo) throws InterruptedException {
		By Removeitems=By.xpath("//div/div[" + LineItemNo + "]/div[2]/div[@class=\"item_pricebar\"]/button");
		  driver.findElement(Removeitems).click();
		    Thread.sleep(2000);
	}

	public void clickOnCheckOutBtn() throws InterruptedException {
		driver.findElement(CheckOut_Btn).click();
		Thread.sleep(2000);
	}
	
	public void checkingValidationOfCheckoutForm(String Fname,String Lname,String Zipcode) throws InterruptedException {
		
		driver.findElement(Continue_Btn).click();
		Thread.sleep(2000);
      String GettingErrorMsgForFirstname= driver.findElement(ErrorMsg).getText();
		Assert.assertEquals(GettingErrorMsgForFirstname,Fname_Error,"Wrong error Msg appeared"+ErrorMsg);	
		driver.findElement(F_Name).sendKeys(Fname);
		
		driver.findElement(Continue_Btn).click();
		String GettingErrorMsgForLastName= driver.findElement(ErrorMsg).getText();
		Assert.assertEquals(GettingErrorMsgForLastName,Lname_Error,"Wrong error Msg appeared"+ErrorMsg);	
		driver.findElement(L_Name).sendKeys(Lname);
		
		driver.findElement(Continue_Btn).click();
		String GettingErrorMsgForZipCode= driver.findElement(ErrorMsg).getText();
		Assert.assertEquals(GettingErrorMsgForZipCode,ZipCode_Error,"Wrong error Msg appeared"+ErrorMsg);	
		driver.findElement(zipCode).sendKeys(Zipcode);
		
		Thread.sleep(2000);
		driver.findElement(Continue_Btn).click();
		
	}
    public void CheckOutInfo() {
    	 List<WebElement> priceElements = driver.findElements(GetAllPrice);

         for (int i = 0; i < priceElements.size(); i++) {
             String priceText = priceElements.get(i).getText().replaceAll("[^\\d.]", "");
             double price = Double.parseDouble(priceText);
             System.out.println("Item " + (i + 1) + " Price: $" + price);
             totalPrice += price;
             
     
         }
         String GetSalesTax=driver.findElement(SalesTax).getText();
         String GetTotalAmount=driver.findElement(TotalAmount).getText();
         double totalsalesTax = Double.parseDouble(GetSalesTax.replaceAll("[^\\d.]", ""));
         double totalAmount = Double.parseDouble(GetTotalAmount.replaceAll("[^\\d.]", ""));
         
         double TotalAmountIncludingTax=totalPrice+totalsalesTax;
         
         Assert.assertEquals(TotalAmountIncludingTax, totalAmount, "Total Amount and Calculated Total Amount are not the same");
     }

	
}
