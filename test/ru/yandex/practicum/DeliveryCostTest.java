package ru.yandex.practicum;

import org.junit.jupiter.api.BeforeEach;
import ru.yandex.practicum.delivery.parcel.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DeliveryCostTest {

    private static final int EXPECTED_STANDARD_RESULT = 20;
    private static final int EXPECTED_PERISHABLE_RESULT = 15;
    private static final int EXPECTED_FRAGILE_RESULT = 8;

    private StandardParcel standardParcel;
    private PerishableParcel perishableParcel;
    private FragileParcel fragileParcel;

    @BeforeEach
    public void beforeEach() {
        standardParcel = new StandardParcel("Кроссовки", 3, "Казань", 1);
        perishableParcel = new PerishableParcel("Молоко", 2, "Москва", 1, 5);
        fragileParcel = new FragileParcel("Ваза", 3, "Тверь", 1);
    }

    @Test
    public void shouldReturn20forStandardParcelOf10Kg() {
        int actualResult = standardParcel.calculateDeliveryCost();
        Assertions.assertEquals(EXPECTED_STANDARD_RESULT, actualResult);
    }

    @Test
    public void shouldReturn30forPerishableParcelOf10Kg() {
        int actualResult = perishableParcel.calculateDeliveryCost();
        Assertions.assertEquals(EXPECTED_PERISHABLE_RESULT, actualResult);
    }

    @Test
    public void shouldReturn40forFragileParcelOf10Kg() {
        int actualResult = fragileParcel.calculateDeliveryCost();
        Assertions.assertEquals(EXPECTED_FRAGILE_RESULT, actualResult);
    }
}
