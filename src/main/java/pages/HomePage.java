package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(css = ".title")
    private WebElement pageTitle;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(css = ".btn_inventory")
    private WebElement addToCartButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return pageTitle.getText().equals("Products");
    }

    public void addFirstProductToCart() {
        click(addToCartButton); // first product
    }

    public CartPage goToCart() {
        click(cartIcon);
        return new CartPage(driver);
    }
}
