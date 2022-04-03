package com.automationpractice.webproject.test.helpers.contactus;

import com.automationpractice.webproject.test.model.contactus.ContactUsForm;
import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

import static com.automationpractice.webproject.test.helpers.Dictionary.*;

public class ContactUsHelper {

    private ContactUsHelper(){}

    public static ContactUsForm generateRequiredNewMessageInfo(String language, String country, String emailDomain){
        Faker faker =  Faker.instance(
                new Locale(language, country),
                new Random()
        );

        ContactUsForm contactUsForm = new ContactUsForm();

        contactUsForm.setSubjectHeading(String.valueOf(faker.number().numberBetween(1,2)));
        contactUsForm.setEmail(faker.name().username().concat(emailDomain).replace(SPACE_STRING, EMPTY_STRING));
        contactUsForm.setMessage(faker.lorem().paragraph());

        return contactUsForm;
    }
}
