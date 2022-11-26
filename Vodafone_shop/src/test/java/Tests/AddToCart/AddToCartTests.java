package Tests.AddToCart;

import Pages.HomePage;
import Pages.ProductPage;
import Pages.ShoppingCartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.retry.support.RetryTemplate;
import org.testng.Assert;


public class AddToCartTests extends AddToCartRunner {
    private static final long waitInterval = 3000;
    private static final RetryTemplate retryTemplate = RetryTemplate.builder()
            .maxAttempts(3)
            .fixedBackoff(waitInterval)
            .retryOn(java.lang.AssertionError.class)
            .build();
    HomePage homePage = new HomePage(browser);
    ProductPage productPage= new ProductPage(browser);
    ShoppingCartPage shoppingCartPage= new ShoppingCartPage(browser);

    @Given("Navigated successfully to URL")
    public void navigatedSuccessfullyToURL() {
        Assert.assertTrue(browser.getCurrentUrl().contains("https://eshop.vodafone.com.eg/shop/"));
    }

    @When("User adds first product to the basket")
    public void userAddsFirstProductToTheBasket() {
        homePage.navigateToFirstProduct();
        productPage.addToBasket();
        shoppingCartPage.navigateToHomePage();
    }

    @When("User adds second product to the basket")
    public void userAddsSecondProductToTheBasket() {
        homePage.navigateToSecondProduct();
        productPage.addToBasket();
        shoppingCartPage.navigateToHomePage();
    }

    @When("User adds first search product to the basket")
    public void userAddsFirstSearchProductToTheBasket() {
        homePage.navigateToFirstSearchProduct("watch");
        productPage.addToBasket();
    }

    @Then("All products should be added to basket successfully")
    public void allProductsShouldBeAddedToBasketSuccessfully() {
        retryTemplate.execute(retryContext -> {
            productPage.navigateToShoppingBasket();
            Assert.assertEquals(shoppingCartPage.getBasketItemsCount(), 3);
            return null;
        });
    }
}
