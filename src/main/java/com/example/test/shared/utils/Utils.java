package com.example.test.shared.utils;

import java.security.SecureRandom;
import java.util.Random;

public class Utils {
    private final Random RANDOM = new SecureRandom();
    private static final String ALPHAPET = "ABCD...789";


    public String generateUserId(int length){
        return generateRandomString(length);
    }
    public  String generateRandomString(int length){
        StringBuilder builder = new StringBuilder();
        for(int i =0;i<length;i++){
            builder.append(ALPHAPET.charAt(RANDOM.nextInt(ALPHAPET.length())));

        }
        return new String(builder);

    }

}
