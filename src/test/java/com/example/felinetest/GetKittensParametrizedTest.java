package com.example.felinetest;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class GetKittensParametrizedTest {

    private final int argumentKittensCount;
    private final int expectedKittensCount;


    public GetKittensParametrizedTest(int argumentKittensCount, int expectedKittensCount) {
        this.argumentKittensCount = argumentKittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }


    @Parameterized.Parameters
    public static Object[][] getData() {
    return new Object[][] {
            {1,1},
            {2,2},
            {Integer.MAX_VALUE,Integer.MAX_VALUE},
            {0,0},
            {-1,-1},
            {Integer.MIN_VALUE,Integer.MIN_VALUE}
    };
    }

    @Test
    public void getKittensShouldReturnExpectedValue() {
        Feline feline = new Feline();

        assertEquals("Количество котят соответствует введенному", expectedKittensCount, feline.getKittens(argumentKittensCount));
    }
}