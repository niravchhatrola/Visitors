package com.chhatrola.visitors;

import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by niv214 on 22/9/18.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class Testing {

//    @Test
    @Test
    public void testone(){
        System.out.println("Hello how are you");
    }
}
