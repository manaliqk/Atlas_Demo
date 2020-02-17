package com.tatadigital.tcpapp.gui.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class HomePage extends AbstractPage {

	Logger LOGGER = Logger.getLogger(HomePage.class);
	
	@FindBy(xpath = "//div[text()='My Addresses']")
    private ExtendedWebElement MyAddressTab;
    
    @FindBy(xpath = "//div[text()='My Profile']")
    private ExtendedWebElement MyProfileTab;
    
    @FindBy(xpath = "//div[text()='Sign Out']")
    private ExtendedWebElement Signout;
    
    @FindBy(xpath = "//div[text()='Offers']")
    private ExtendedWebElement OffersTab;
  
    @FindBy(xpath = "//div[text()='Loyalty']")
    private ExtendedWebElement LoyaltyTab;
  
    @FindBy(xpath = "//div[text()='Payments']")
    private ExtendedWebElement PaymentTab;
  
    @FindBy(xpath = "//div[text()='Bill Payments']")
    private ExtendedWebElement BillPaymentsTab;
    
    @FindBy(xpath = "//button[text()='Back homepage']")
    private ExtendedWebElement backBtn;
    
    @FindBy(xpath = "//input[@name='firstName']")
    private ExtendedWebElement vFirstName;
    
    @FindBy(xpath = "//input[@name='lastName']")
    private ExtendedWebElement vLastName;
    
    @FindBy(xpath = "//div[text()='Add New Address']")
    private ExtendedWebElement addAddressBtn;
    
    @FindBy(xpath = "//h3[text()='Points History']")
    private ExtendedWebElement pointshistoryBtn;
    
    @FindBy(xpath = "//h3[text()='Redeem Points']")
    private ExtendedWebElement redeempointsBtn;

    @FindBy(xpath = "//P[text()='Transaction History']")
    private ExtendedWebElement transactionhistorypage;
      
  
    @FindBy(xpath = "//div[@class='btn-back']")
    private ExtendedWebElement transactionhistoryback;
     
    @FindBy(xpath = "//h1[text()='Redemptions Master']")
    private ExtendedWebElement redemptionmasterpage;
      
    @FindBy(xpath = "//*[@id='root']/div/h1/span/img")
    private ExtendedWebElement redemptionmasterback;
    
    
    @FindBy(xpath = "//h3[text()='Offers']")
    private ExtendedWebElement offersPage;
    
    	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	//signup with otp method
	public String viewUserProfileDetails(){
		String vFName="";
		MyProfileTab.click();
		vFName = vFirstName.getText().trim();
		
		vFName = vFName+","+vLastName.getText().trim();
		System.out.println("User Details "+vFName +"  ghgh");
		backBtn.click();
		return vFName;
	}
	
	public boolean viewUserAddressDetails(){
		MyAddressTab.click();
		Boolean ab = addAddressBtn.isPresent();
		
		return ab;
	}
	
	public boolean viewUserLoyaltyDetails(){
		LoyaltyTab.click();
		Boolean redeempt = redeempointsBtn.isPresent();
		return redeempt;
	}
	
	public boolean LoyaltyPointsHistoryDetails(){
		pointshistoryBtn.click();
		Boolean redeempt = transactionhistorypage.isPresent();
		transactionhistoryback.click();
		return redeempt;
		
	}
	
	public boolean LoyaltyRedeemPointsDetails(){
		redeempointsBtn.click();
		Boolean redeempt = redemptionmasterpage.isPresent();
		redemptionmasterback.click();
		return redeempt;
	} 
	
//	public boolean viewUserOffersDetails(){
//		OffersTab.click();
//		Boolean redeempt = offersPage.isPresent();
//		return redeempt;
//		
//		
//	}
	
	public void viewUserOffersDetails() {
		OffersTab.click();
        assertElementPresent(offersPage);
    }
	
	public void browserback(){
		driver.navigate().back();
	}
	
	public void signout(){
		Signout.click();
	}
	
}
