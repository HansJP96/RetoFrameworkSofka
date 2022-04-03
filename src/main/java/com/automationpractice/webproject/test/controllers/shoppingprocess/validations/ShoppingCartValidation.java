package com.automationpractice.webproject.test.controllers.shoppingprocess.validations;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.webproject.test.model.shoppingprocess.ProductDetail;
import com.automationpractice.webproject.test.page.ShoppingCartView;

import static com.automationpractice.webproject.test.helpers.Dictionary.COMMON_SCREEN_SHOT;

public class ShoppingCartValidation {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public ProductDetail getShoppingCartProduct() {
        ProductDetail productDetail = new ProductDetail();
        try {
            ShoppingCartView shoppingCartView = new ShoppingCartView(webAction.getDriver());

            webAction.moveTo(shoppingCartView.getShoppingCart(), 10, COMMON_SCREEN_SHOT);

            webAction.waitFor(shoppingCartView.getProductName(),5,COMMON_SCREEN_SHOT);
            productDetail.setName(shoppingCartView.getProductName().getAttribute("title"));

            productDetail.setQuantity(webAction.getText(shoppingCartView.getProductQuantity(), 3, COMMON_SCREEN_SHOT));
            productDetail.setInformation(webAction.getText(shoppingCartView.getProductInfo(), 3, COMMON_SCREEN_SHOT));
            productDetail.setPrice(webAction.getText(shoppingCartView.getProductPrice(), 3, COMMON_SCREEN_SHOT));

        } catch (WebActionsException exception) {
            Report.reportFailure("An error ocurred getting the validation message.\n", exception);
        }
        return productDetail;
    }
}
