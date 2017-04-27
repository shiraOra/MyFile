package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by hackeru on 3/6/2017.
 */
class DogTest {
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testBark() {
        Dog d=new Dog();
        int result=d.bark(3);
        if (result!=6)
            Assertions.fail("bark isn'f return double");

    }

}