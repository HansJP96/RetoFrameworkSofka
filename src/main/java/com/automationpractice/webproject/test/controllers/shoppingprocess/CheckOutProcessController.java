package com.automationpractice.webproject.test.controllers.shoppingprocess;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.webproject.test.model.shoppingprocess.ProductDetail;
import com.automationpractice.webproject.test.page.CheckOutPage;
import com.automationpractice.webproject.test.page.ShoppingCartView;

import java.util.ArrayList;
import java.util.List;

import static com.automationpractice.webproject.test.helpers.Dictionary.COMMON_SCREEN_SHOT;

public class CheckOutProcessController {
    private WebAction webAction;
    private List<ProductDetail> products;

    public void setWebAction(WebAction webAction){this.webAction = webAction;}

    public List<ProductDetail> getProducts(){
        return products;
    }

    public void goToCheckOutProcess(){
        try {
            ShoppingCartView shoppingCartView = new ShoppingCartView(webAction.getDriver());
            webAction.moveTo(shoppingCartView.getShoppingCart(),10,COMMON_SCREEN_SHOT );
            webAction.click(shoppingCartView.getShoppingCart(),5,COMMON_SCREEN_SHOT );
        } catch (WebActionsException exception){
            Report.reportFailure("An error occurred while redirecting to the Checkout page.\n",exception);
        }
    }

    public void summaryCartValues(){
        try {
            CheckOutPage summary = new CheckOutPage(webAction.getDriver());

            products = new ArrayList<>();

            for (int i = 0; i < summary.getCartQuantity().size() ; i++) {
                ProductDetail productDetail = new ProductDetail();

                webAction.moveTo(summary.getProductName().get(i),10,COMMON_SCREEN_SHOT );

                productDetail.setName(webAction.getText(summary.getProductName().get(i),10,COMMON_SCREEN_SHOT ));
                productDetail.setInformation(webAction.getText(summary.getProductInformation().get(i),3,COMMON_SCREEN_SHOT )
                        .replace("Color : ","").replace("Size : ",""));
                productDetail.setQuantity(summary.getProductQuantity().get(i).getAttribute("value"));
                productDetail.setPrice(webAction.getText(summary.getProductPrice().get(i), 3,COMMON_SCREEN_SHOT ));

                products.add(productDetail);
            }

        } catch (WebActionsException exception){
            Report.reportFailure("An error occurred while getting summary data.\n",exception);
        }
    }

    public void goToSignInStep(){
        try {
            CheckOutPage checkOutPage = new CheckOutPage(webAction.getDriver());

            webAction.moveTo(checkOutPage.getSummaryCheckOutButton(), 10,COMMON_SCREEN_SHOT);
            webAction.click(checkOutPage.getSummaryCheckOutButton(),3,COMMON_SCREEN_SHOT);

        } catch (WebActionsException exception){
            Report.reportFailure("An error occurred while redirecting to Sign In step.\n",exception);
        }
    }

    public void goToShippingStep(){
        try {
            CheckOutPage checkOutPage = new CheckOutPage(webAction.getDriver());
            webAction.moveTo(checkOutPage.getAddressCheckOutButton(), 5,COMMON_SCREEN_SHOT);
            webAction.click(checkOutPage.getAddressCheckOutButton(),2,COMMON_SCREEN_SHOT);

        } catch (WebActionsException exception){
            Report.reportFailure("An error occurred while redirecting to Shipping step.\n",exception);
        }
    }

    public void goToPaymentStep(){
        try {
            CheckOutPage checkOutPage = new CheckOutPage(webAction.getDriver());

            webAction.moveTo(checkOutPage.getAgreeTerms(), 10,COMMON_SCREEN_SHOT);
            webAction.click(checkOutPage.getAgreeTerms(),3,COMMON_SCREEN_SHOT);

            webAction.moveTo(checkOutPage.getShippingCheckOutButton(), 5,COMMON_SCREEN_SHOT);
            webAction.click(checkOutPage.getShippingCheckOutButton(),2,COMMON_SCREEN_SHOT);

        } catch (WebActionsException exception){
            Report.reportFailure("An error occurred while redirecting to Payment step.\n",exception);
        }
    }

    public void goToCheckPaymentStep(){
        try {
            CheckOutPage checkOutPage = new CheckOutPage(webAction.getDriver());
            webAction.moveTo(checkOutPage.getPayByCheck(), 10,COMMON_SCREEN_SHOT);
            webAction.click(checkOutPage.getPayByCheck(),3,COMMON_SCREEN_SHOT);

        } catch (WebActionsException exception){
            Report.reportFailure("An error occurred while redirecting to Check Payment step.\n",exception);
        }
    }

    public void goToOrderConfirmation(){
        try {
            CheckOutPage checkOutPage = new CheckOutPage(webAction.getDriver());
            webAction.moveTo(checkOutPage.getConfirmOrder(), 10,COMMON_SCREEN_SHOT);
            webAction.click(checkOutPage.getConfirmOrder(),3,COMMON_SCREEN_SHOT);

        } catch (WebActionsException exception){
            Report.reportFailure("An error occurred while redirecting to Check Payment step.\n",exception);
        }
    }
}
