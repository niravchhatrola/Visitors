package com.chhatrola.visitors.util;

import java.util.UUID;

public class GeneratorUtil {

    public static String generateUuid(){
        return UUID.randomUUID().toString();
    }

}
