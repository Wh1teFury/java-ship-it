package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import ru.yandex.practicum.delivery.parcel.*;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.parcelBox.ParcelBox;

public class DeliveryParcelBoxTest {

    private static final boolean TRUE = true;
    private static final boolean FALSE = false;

    private StandardParcel standardParcel;
    private PerishableParcel perishableParcel;
    private FragileParcel fragileParcel;

    private ParcelBox<StandardParcel> standardBox;
    private ParcelBox<PerishableParcel> perishableBox;
    private ParcelBox<FragileParcel> fragileBox;

    private ParcelBox<StandardParcel> overweightStandardBox;
    private ParcelBox<PerishableParcel> overweightPerishableBox;
    private ParcelBox<FragileParcel> overweightFragileBox;

    @BeforeEach
    public void beforeEach() {
        standardParcel = new StandardParcel("Кроссовки", 3, "Казань", 1);
        perishableParcel = new PerishableParcel("Молоко", 2, "Москва", 1, 5);
        fragileParcel = new FragileParcel("Ваза", 3, "Тверь", 1);

        standardBox = new ParcelBox<>(100);
        perishableBox = new ParcelBox<>(100);
        fragileBox = new ParcelBox<>(100);

        overweightStandardBox = new ParcelBox<>(1);
        overweightPerishableBox = new ParcelBox<>(1);
        overweightFragileBox = new ParcelBox<>(1);
    }

    @Test
    public void shouldReturnTrueWhenParcelIsAddedToBox() {
        boolean actualResultForStandardParcel = standardBox.addParcel(standardParcel);
        boolean actualResultForPerishableParcel = perishableBox.addParcel(perishableParcel);
        boolean actualResultForFragileParcel = fragileBox.addParcel(fragileParcel);

        Assertions.assertEquals(TRUE, actualResultForStandardParcel);
        Assertions.assertEquals(TRUE, actualResultForPerishableParcel);
        Assertions.assertEquals(TRUE, actualResultForFragileParcel);
    }

    @Test
    public void shouldReturnFalseWhenParcelIsOverweight() {
        boolean actualResultForStandardParcel = overweightStandardBox.addParcel(standardParcel);
        boolean actualResultForPerishableParcel = overweightPerishableBox.addParcel(perishableParcel);
        boolean actualResultForFragileParcel = overweightFragileBox.addParcel(fragileParcel);

        Assertions.assertEquals(FALSE, actualResultForStandardParcel);
        Assertions.assertEquals(FALSE, actualResultForPerishableParcel);
        Assertions.assertEquals(FALSE, actualResultForFragileParcel);
    }
}