package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(css = ".complete-header")
    private WebElement confirmationMessage;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillUserDetails(String fname, String lname, String pincode) {
        type(firstNameField, fname);
        type(lastNameField, lname);
        type(postalCodeField, pincode);
    }

    public void continueCheckout() {
        click(continueButton);
    }

    public void finishCheckout() {
        click(finishButton);
    }

    public boolean isOrderConfirmed() {
        return confirmationMessage.getText().contains("Thank you");
    }
}
