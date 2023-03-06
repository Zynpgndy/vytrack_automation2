package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VYTrack_LoginPage {

    public VYTrack_LoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "_username")
    public WebElement inputUsername;

    @FindBy(name = "_password")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[.='Log in']")
    public WebElement loginButton;

    public void login(String user, String pass){
        this.inputUsername.sendKeys(user);
        this.inputPassword.sendKeys(pass);
        this.loginButton.click();
    }

}
