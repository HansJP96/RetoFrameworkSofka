package com.automationpractice.webproject.test.stepdefinition.shoppingprocess;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import com.automationpractice.webproject.test.controllers.openwebpage.StartBrowserWebController;
import com.automationpractice.webproject.test.controllers.register.CreateAnAccountWebController;
import com.automationpractice.webproject.test.controllers.shoppingprocess.AddProductController;
import com.automationpractice.webproject.test.controllers.shoppingprocess.CheckOutProcessController;
import com.automationpractice.webproject.test.controllers.shoppingprocess.DressesSectionController;
import com.automationpractice.webproject.test.controllers.shoppingprocess.validations.FinishedPurchaseByCheck;
import com.automationpractice.webproject.test.controllers.shoppingprocess.validations.ShoppingCartValidation;
import com.automationpractice.webproject.test.controllers.shoppingprocess.validations.SuccessfulAddedProduct;
import com.automationpractice.webproject.test.controllers.signin.SignInPageController;
import com.automationpractice.webproject.test.data.objects.TestInfo;
import com.automationpractice.webproject.test.model.Customer;
import com.automationpractice.webproject.test.model.shoppingprocess.ProductDetail;
import com.automationpractice.webproject.test.stepdefinition.setup.Setup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static com.automationpractice.webproject.test.helpers.Dictionary.*;

public class ShoppingProcessStepDefinition extends Setup {
    private WebAction webAction;
    private Customer customer = new Customer();
    private final ProductDetail productDetail = new ProductDetail();
    private final ProductDetail productDetail1 = new ProductDetail();
    private final ProductDetail productDetail2 = new ProductDetail();
    private final List<ProductDetail> productDetailList = new ArrayList<>();
    private List<ProductDetail> productResponseList;

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeatue(testInfo.getFeatureName());
        startBrowserWebController.openWebPage();
    }

    @Given("goes to Dresses section")
    public void goesToDressesSection() {
        DressesSectionController dressesSectionController = new DressesSectionController();
        dressesSectionController.setWebAction(webAction);
        dressesSectionController.goToDressesSection();
    }

    @When("he add some product to the cart")
    public void heAddSomeProductToTheCart() {
        AddProductController addProductController = new AddProductController();
        addProductController.setWebAction(webAction);
        addProductController.setProductDetail(productDetail);
        addProductController.addToShoppingCart();
    }

    @Then("he watches a message of successfully product added and his product in the cart")
    public void heWatchesAMessageOfSuccessfullyProductAddedAndHisProductInTheCart() {
        SuccessfulAddedProduct addedProduct = new SuccessfulAddedProduct();
        addedProduct.setWebAction(webAction);
        String message = addedProduct.getSuccessAddedProduct();

        ShoppingCartValidation shoppingCartValidation = new ShoppingCartValidation();
        shoppingCartValidation.setWebAction(webAction);
        ProductDetail productInCart = shoppingCartValidation.getShoppingCartProduct();

        Assert
                .Hard
                .thatString(message)
                .isEqualTo(ADDED_PRODUCT_MESSAGE);

        Assert.Soft.init();
        Assert.Soft
                .thatObject(productInCart).isEqualToComparingFieldByField(productDetail);
        Assert.Soft.finish();
    }

    @Given("the user already has an account")
    public void theUserAlreadyHasAnAccount() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeatue(testInfo.getFeatureName());
        startBrowserWebController.openWebPage();

        SignInPageController signInPageController = new SignInPageController();
        signInPageController.setWebAction(webAction);
        signInPageController.goToSignInPage();

        CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        createAnAccountWebController.createNewAccount();
        customer = createAnAccountWebController.getCustomer();

        webAction.closeBrowser();
    }

    @When("the user has some products in the shopping cart")
    public void theUserHasSomeProductsInTheShoppingCart() {
        productDetailList.add(productDetail1);
        productDetailList.add(productDetail2);

        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeatue(testInfo.getFeatureName());
        startBrowserWebController.openWebPage();

        DressesSectionController dressesSectionController = new DressesSectionController();
        dressesSectionController.setWebAction(webAction);
        dressesSectionController.goToDressesSection();

        AddProductController addProductController = new AddProductController();
        addProductController.setWebAction(webAction);
        addProductController.setProductDetails(productDetailList);
        addProductController.addTwoProductsToShoppingCart();

        CheckOutProcessController checkOutProcessController = new CheckOutProcessController();
        checkOutProcessController.setWebAction(webAction);
        checkOutProcessController.goToCheckOutProcess();

    }

    @When("he complete all check out basic process with a check payment method")
    public void heCompleteAllCheckOutBasicProcessWithACheckPaymentMethod() {
        CheckOutProcessController checkOutProcessController = new CheckOutProcessController();
        checkOutProcessController.setWebAction(webAction);
        checkOutProcessController.summaryCartValues();
        productResponseList = checkOutProcessController.getProducts();

        checkOutProcessController.goToSignInStep();

        SignInPageController signInPageController = new SignInPageController();
        signInPageController.setWebAction(webAction);
        signInPageController.setEmail(customer.getEmail());
        signInPageController.setPassword(customer.getPassword());
        signInPageController.signInProcess();

        checkOutProcessController.goToShippingStep();

        checkOutProcessController.goToPaymentStep();

        checkOutProcessController.goToCheckPaymentStep();

        checkOutProcessController.goToOrderConfirmation();

    }

    @Then("the prices are correct and successful process message appears")
    public void thePricesAreCorrectAndSuccessfulProcessMessageAppears() {
        FinishedPurchaseByCheck finishedPurchaseByCheck = new FinishedPurchaseByCheck();
        finishedPurchaseByCheck.setWebAction(webAction);

        String resultingMessage = finishedPurchaseByCheck.getOrderConfirmationMessage();
        float resultingAmonunt = finishedPurchaseByCheck.getComparableAmountPayment();

        float expectedAmount = productResponseList
                .stream()
                .map(ProductDetail::getPrice)
                .reduce(Float::sum).orElse((float) -1.0);

        Assert.Soft.init();
        Assert
                .Soft
                .thatObject(productResponseList.get(0))
                .isEqualToComparingFieldByField(productDetailList.get(0));
        Assert
                .Soft
                .thatObject(productResponseList.get(1))
                .isEqualToComparingFieldByField(productDetailList.get(1));
        Assert
                .Soft
                .thatObject(resultingMessage)
                .isEqualTo(COMPLETED_ORDER_BY_CHECK);
        Assert
                .Soft
                .thatObject(resultingAmonunt)
                .isEqualTo(expectedAmount + SHIPPING_VALUE);
        Assert.Soft.finish();
    }

    @After
    public void closeDriver() {

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** TEST HAS FINISHED ******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }
}
