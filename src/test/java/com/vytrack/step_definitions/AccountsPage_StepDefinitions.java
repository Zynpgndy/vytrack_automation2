package com.vytrack.step_definitions;

import com.vytrack.pages.AccountPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class AccountsPage_StepDefinitions {

    AccountPage page = new AccountPage();
    @Given("User is on the VYTrack log-in page")
    public void user_login_as_a_store_manager() {
        Driver.getDriver().get("https://qa3.vytrack.com/user/login");
    }
    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        page.inputUsername.sendKeys("storemanager85");
        page.inputPassword.sendKeys("UserUser123");
        page.loginButton.click();
    }
    @When("User clicks to the accounts page")
    public void user_clicks_to_the_accounts_page() {
        page.accounts.click();
    }
    @When("User is on the Accounts page")
    public void user_is_on_the_accounts_page() {
        BrowserUtils.verifyTitle("All - Accounts - Customers");

    }
    @Then("User sees below options under View Per Page dropdown")
    public void user_sees_below_options_under_view_per_page_dropdown(List<String> expectedOptions) {
        List<String> actualOptions = BrowserUtils.dropdownOptions_as_STRING(page.viewPerPage);

    }
}
