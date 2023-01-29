package com.example.cattests;

import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundShouldReturnValidValue() {
        Cat cat = new Cat(feline);
        String expectedSound = "Мяу";
        String actualSound;

        actualSound = cat.getSound();

        assertEquals(expectedSound, actualSound);
    }

    @Test
    public void getFoodShouldReturnListOfPredatorFood() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualList;
        Mockito.when(feline.eatMeat()).thenReturn(expectedList);

        actualList = cat.getFood();

        assertEquals(expectedList,actualList);
    }
}