package com.vytrack.step_definitions;

import com.vytrack.pages.VYTrack_LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class VYTrack_StepDefinitions {

    VYTrack_LoginPage vyTrack_loginPage = new VYTrack_LoginPage();
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
    }
    @When("user log in as the {string}")
    public void user_log_in_as_the(String position) {

        position = position.toLowerCase().trim();
        for (int i = 0; i < position.length(); i++) {
            position=position.replaceAll(" ","");
            position=position.trim().toLowerCase();
        }

        if (position.equals("driver")){
            vyTrack_loginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("driver_username"));
            vyTrack_loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("driver_password"));
            vyTrack_loginPage.loginButton.click();
        }

        if (position.equals("salesmanager")){
            BrowserUtils.sleep(2);
            vyTrack_loginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("salesmanager_username"));
            vyTrack_loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("salesmanager_password"));
            vyTrack_loginPage.loginButton.click();
        }

        if (position.equals("storemanager")){
            vyTrack_loginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("storemanager_username"));
            vyTrack_loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("storemanager_password"));
            vyTrack_loginPage.loginButton.click();
        }

    }
    @Then("user should see the title {string}")
    public void user_should_see_the_title(String actualTitle) {
        Assert.assertEquals("Dashboard",actualTitle);
    }


    @Given("User is on the VYTrack login page")
    public void user_is_on_the_vy_track_login_page() {
        Driver.getDriver().get("https://qa3.vytrack.com/user/login");

    }
    @When("User enters valid {string} username")
    public void user_enters_valid_username(String username) {
        vyTrack_loginPage.inputUsername.sendKeys(username);
    }
    @When("User enters valid {string} password")
    public void user_enters_valid_password(String password) {
        vyTrack_loginPage.inputPassword.sendKeys(password);
    }
    @When("clicks on the login button")
    public void clicks_on_the_login_button() {
        vyTrack_loginPage.loginButton.click();
    }


    @Then("User should see the dashboard as a {string}")
    public void userShouldSeeTheDashboardAsA(String user) {
        System.out.println("Logged in as a " + user);
    }

    @When("User enters valid {string} username and  {string} password")
    public void userEntersValidUsernameAndPassword(String username, String password) {
        vyTrack_loginPage.login(username, password);
    }

}
