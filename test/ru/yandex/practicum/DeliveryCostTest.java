package ru.yandex.practicum;

import ru.yandex.practicum.delivery.parcel.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DeliveryCostTest {

    @Test
    public void shouldReturn20forStandardParcelOf10Kg() {
        StandardParcel standardParcel = new StandardParcel("Кроссовки", 3, "Казань", 1);
        int expectedResult = 20;
        int actualResult = standardParcel.calculateDeliveryCost();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturn30forPerishableParcelOf10Kg() {
        PerishableParcel perishableParcel = new PerishableParcel("Молоко", 2, "Москва", 1, 5);
        int expectedResult = 15;
        int actualResult = perishableParcel.calculateDeliveryCost();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturn40forFragileParcelOf10Kg() {
        FragileParcel fragileParcel = new FragileParcel("Ваза", 3, "Тверь", 1);
        int expectedResult = 8;
        int actualResult = fragileParcel.calculateDeliveryCost();
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
