package com.automationpractice.webproject.test.model.shoppingprocess;

import static com.automationpractice.webproject.test.helpers.Dictionary.EMPTY_STRING;
import static com.automationpractice.webproject.test.helpers.Dictionary.MONEY_SYMBOL;

public class ProductDetail {
    private String name;
    private String information;
    private String quantity;
    private float price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPrice(String price) {
        this.price = Float.parseFloat(price.replace(MONEY_SYMBOL,EMPTY_STRING));
    }

}
