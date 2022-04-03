package com.automationpractice.webproject.test.helpers;

public class Dictionary {
    public static final String STATE_BY_DEFAULT_FLORIDA = "Florida";

    public static final boolean COMMON_SCREEN_SHOT = true;
    public static final String EMPTY_STRING = "";
    public static final String SPACE_STRING = " ";
    public static final String MONEY_SYMBOL = "$";

    public static final String CODE_LANGUAGE = "en";
    public static final String COUNTRY_CODE = "US";

    public static final String EMAIL_DOMAIN = "@testemail.com";
    public static final String CONTACT_US_DONE_MESSAGE = "Your message has been successfully sent to our team.";
    public static final String CONTACT_US_ERROR_SUBJECT_HEADING = "Please select a subject from the list provided.";
    public static final String ADDED_PRODUCT_MESSAGE = "Product successfully added to your shopping cart";
    public static final String COMPLETED_ORDER_BY_CHECK = "Your order on My Store is complete.";
    public static final float SHIPPING_VALUE = (float) 2.0;

    public static final String FILE_EVIDENCE_PROPERTY = "files.evidence";
    public static final String APP_URL_PROPERTY = "app.url";

    private static final String PROPERTIES_FILE_BASE_PATH = "src/main/resources/properties/";

    public static final String CONFIGURATION_PROPERTIES_FILE = System.getProperty("user.dir") +
            "/" +
            PROPERTIES_FILE_BASE_PATH + "configuration.properties";

    public static final String MAIL_PROPERTIES_FILE = System.getProperty("user.dir") +
            "/" +
            PROPERTIES_FILE_BASE_PATH + "mail.properties";
}
