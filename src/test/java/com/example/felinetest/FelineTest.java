package com.example.felinetest;

import com.example.Feline;
import org.junit.Test;
import static org.junit.Assert.*;

public class FelineTest {

    @Test
    public void getFamilyShouldReturnValidValue() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";
        String actualFamily;

        actualFamily = feline.getFamily();

        assertEquals(expectedFamily,actualFamily);
    }

    @Test
    public void eatMeatShouldBeReturnGetFood() throws Exception {
        Feline feline = new Feline();
        String animalKind = "Хищник";

        assertEquals(feline.eatMeat(), feline.getFood(animalKind));
    }

    @Test
    public void getKittensWithoutArgumentsShouldReturnOne() {
        Feline feline = new Feline();
        int expectedKittensCount = 1;
        int actualKittensCount;

        actualKittensCount = feline.getKittens();

        assertEquals("Должен вернуться 1 котенок",expectedKittensCount,actualKittensCount);
    }

    @Test
    public void getFoodReturnExceptionText() {
        String expectedExceptionText = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        Exception exception;
        Feline feline = new Feline();
        exception = assertThrows(Exception.class, () -> feline.getFood("invalid animalKind"));
        assertEquals(expectedExceptionText, exception.getMessage());

    }
}