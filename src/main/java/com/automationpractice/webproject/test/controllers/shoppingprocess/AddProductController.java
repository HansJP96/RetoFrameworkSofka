package com.automationpractice.webproject.test.controllers.shoppingprocess;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.webproject.test.model.shoppingprocess.ProductDetail;
import com.automationpractice.webproject.test.page.DressesCategoryPage;

import java.util.List;

import static com.automationpractice.webproject.test.helpers.Dictionary.COMMON_SCREEN_SHOT;

public class AddProductController {

    private WebAction webAction;
    private ProductDetail productDetail;
    private List<ProductDetail> productDetails;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public void setProductDetails(List<ProductDetail> productDetails) {
        this.productDetails = productDetails;
    }

    public void addToShoppingCart() {
        try {
            DressesCategoryPage dressesCategoryPage = new DressesCategoryPage(webAction.getDriver());

            webAction.moveTo(dressesCategoryPage.getProductBox1(), 10, COMMON_SCREEN_SHOT);
            webAction.click(dressesCategoryPage.getProductAdd1(), 10, COMMON_SCREEN_SHOT);

            productDetail.setName(webAction.getText(dressesCategoryPage.getProductSelectedName(), 10, COMMON_SCREEN_SHOT));
            productDetail.setInformation(webAction.getText(dressesCategoryPage.getProductSelectedInfo(), 3, COMMON_SCREEN_SHOT));
            productDetail.setQuantity(webAction.getText(dressesCategoryPage.getProductSelectedQuantity(), 3, COMMON_SCREEN_SHOT));
            productDetail.setPrice(webAction.getText(dressesCategoryPage.getProductSelectedPrice(), 3, COMMON_SCREEN_SHOT));

        } catch (WebActionsException e) {
            Report.reportFailure("An error occurred while adding a new product.\n", e);
        }
    }

    public void addTwoProductsToShoppingCart() {
        try {
            DressesCategoryPage dressesCategoryPage = new DressesCategoryPage(webAction.getDriver());

            ProductDetail number1 = productDetails.get(0);
            ProductDetail number2 = productDetails.get(1);

            webAction.moveTo(dressesCategoryPage.getProductBox1(), 10, COMMON_SCREEN_SHOT);
            webAction.click(dressesCategoryPage.getProductAdd1(), 10, COMMON_SCREEN_SHOT);

            number1.setName(webAction.getText(dressesCategoryPage.getProductSelectedName(), 10, COMMON_SCREEN_SHOT));
            number1.setInformation(webAction.getText(dressesCategoryPage.getProductSelectedInfo(), 5, COMMON_SCREEN_SHOT));
            number1.setQuantity(webAction.getText(dressesCategoryPage.getProductSelectedQuantity(), 5, COMMON_SCREEN_SHOT));
            number1.setPrice(webAction.getText(dressesCategoryPage.getProductSelectedPrice(), 5, COMMON_SCREEN_SHOT));

            webAction.click(dressesCategoryPage.getContinueShopping(), 5, COMMON_SCREEN_SHOT);

            webAction.moveTo(dressesCategoryPage.getProductBox2(), 5, COMMON_SCREEN_SHOT);
            webAction.click(dressesCategoryPage.getProductAdd2(), 5, COMMON_SCREEN_SHOT);

            number2.setName(webAction.getText(dressesCategoryPage.getProductSelectedName(), 10, COMMON_SCREEN_SHOT));
            number2.setInformation(webAction.getText(dressesCategoryPage.getProductSelectedInfo(), 5, COMMON_SCREEN_SHOT));
            number2.setQuantity(webAction.getText(dressesCategoryPage.getProductSelectedQuantity(), 5, COMMON_SCREEN_SHOT));
            number2.setPrice(webAction.getText(dressesCategoryPage.getProductSelectedPrice(), 5, COMMON_SCREEN_SHOT));

            webAction.click(dressesCategoryPage.getContinueShopping(), 5, COMMON_SCREEN_SHOT);

        } catch (WebActionsException e) {
            Report.reportFailure("An error occurred while products.\n", e);
        }
    }
}
