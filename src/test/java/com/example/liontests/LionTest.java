package com.example.liontests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)

public class LionTest {

    @Mock
    Feline feline;

    @Test
        public void getKittensShouldReturnOne() throws Exception {
            //Arrange
            String sex = "Самец";
            Lion lion = new Lion(sex, feline);
            int expectedKittensAmount = 1;
            int actualKittensAmount;
            Mockito.when(feline.getKittens()).thenReturn(1);
            //Act
            actualKittensAmount = lion.getKittens();
            //Assert
            assertEquals(expectedKittensAmount, actualKittensAmount);
        }

        @Test
        public void getFoodShouldBeArgumentIsPredator() throws Exception {
            String sex = "Самец";
            String expectedAnimalKind = "Хищник";
            List<String> predatorFood = Arrays.asList("Животные", "Птицы", "Рыба");
            List<String> returnedFood;
            Lion lion = new Lion(sex, feline);
            //изолируем метод feline.getFoodShouldReturnListOfPredatorFood()
            Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(predatorFood);

            //Просто вызываем метод для проверки передаваемого аргумента внутри этого же метода
            returnedFood = lion.getFood();

            //Проверяем передаваемый аргумент в методе feline.getFoodShouldReturnListOfPredatorFood(), вызывая lion.getFoodShouldReturnListOfPredatorFood()
            Mockito.verify(feline).getFood(expectedAnimalKind);
        }

        @Test(expected = Exception.class)
        public void createLionWithInvalidSexShouldException() throws Exception {
            Lion lion = new Lion("тест", feline);
        }

        @Test
        public void createLionValidExceptionText() {
            try {
                Lion lion = new Lion(null, feline);
                fail();
            } catch (Exception exception) {
                assertEquals("Проверка текста Exception.class","Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
            }
        }


}