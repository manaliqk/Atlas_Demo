package com.qaprosoft.carina.demo.cucumber.steps.manali;

import com.qaprosoft.carina.core.foundation.cucumber.CucumberRunner;
import com.tatadigital.training.gui.CarinaDemoPagebase;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CarinaDemoStepdef extends CucumberRunner {
	CarinaDemoPagebase carina = null;
	
	@Given("^launch the app$")
	public void MainPage()
	{
		carina = initPage(getDriver(), CarinaDemoPagebase.class);
        System.out.println("Appliction launched");

	}
	@When("^click on Nextbutton$")
	public void clicknextbutton()
	{
		carina.ClickNext();
		System.out.println("clkicked on Next");
        }
	
	@Then("^Enter Name and Password$")
	public void enterdetails()
	{
		carina.clickAny();
		carina.TypeName("manju");
		carina.TypePw("manju");
		System.out.println("clkicked name and pw");

	}
	@And("^click on female and toggle$")
	public void toggles()
	{
	    carina.Clickfemale();
		carina.Clicktoggle();
		System.out.println("clkicked radio and tggle");

	}
}
