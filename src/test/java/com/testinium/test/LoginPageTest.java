package com.testinium.test;

import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.testinium.pages.LoginPage;
import com.testinium.setup.TestBase;

public class LoginPageTest extends TestBase {
    
    static LoginPage loginPage;

    @BeforeAll
    public static void initializeLoginPage() {
        loginPage = new LoginPage();
    }

    @Test
    public void loginTest() {
        loginPage.navigateToLoginScreen();
        loginPage.sendLoginInfo();
        loginPage.verifyUserLoggedIn();
    }
}
