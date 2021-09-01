package org.selenium.pom.utils;

import com.github.javafaker.Faker;

public class FakerUtils {

    public static String getRandomEmail(){
        Faker faker = new Faker();
        return "useremail"+faker.number().randomNumber()+"@test.com";
    }


}
