package tests;

import listeners.ExtentReportListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.HomePage;
import pages.CartPage;
import pages.CheckoutPage;
import utils.DriverManager;
import utils.ExcelUtils;

@Listeners(ExtentReportListener.class)
public class E2CheckoutTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @BeforeClass
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    // ✅ DataProvider (Excel driven)
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return ExcelUtils.getTestData(
                "src/test/resources/testdata/testdata.xlsx",
                "LoginData"
        );
    }

    // ✅ Login test (runs for all rows in Excel)
    @Test(priority = 1, dataProvider = "loginData")
    public void testLogin(String username, String password, String testType) {
        driver.get("https://www.saucedemo.com/");
        loginPage.login(username, password);

        if (testType.equalsIgnoreCase("positive")) {
            homePage = new HomePage(driver);
            Assert.assertTrue(homePage.isPageLoaded(),
                    "User should land on Products page after valid login");
        } else {
            Assert.assertTrue(loginPage.isErrorDisplayed(),
                    "Error message should be displayed for invalid login");
        }
    }

    // ✅ End-to-End Checkout Flow (always positive user)
    @Test(priority = 2)
    public void testE2ECheckoutFlow() {
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        homePage = new HomePage(driver);

        Assert.assertTrue(homePage.isPageLoaded(), "Login failed for standard_user");

        // Add product
        homePage.addFirstProductToCart();
        cartPage = homePage.goToCart();
        Assert.assertTrue(cartPage.isProductInCart(), "Cart should contain product");

        // Checkout
        checkoutPage = cartPage.proceedToCheckout();
        checkoutPage.fillUserDetails("John", "Doe", "411045");
        checkoutPage.continueCheckout();
        checkoutPage.finishCheckout();

        Assert.assertTrue(checkoutPage.isOrderConfirmed(),
                "Order confirmation message should appear");
    }

    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
