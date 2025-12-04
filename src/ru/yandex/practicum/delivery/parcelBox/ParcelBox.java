package ru.yandex.practicum.delivery.parcelBox;

import ru.yandex.practicum.delivery.parcel.Parcel;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox <T extends Parcel>{
    private ArrayList<T> parcels;
    private int maxWeight;
    private int currentWeight;

    public ParcelBox(int maxWeight) {
        parcels = new ArrayList<>();
        this.maxWeight = maxWeight;
        currentWeight = 0;
    }

    public boolean addParcel(T parcel) {
        if (currentWeight + parcel.getWeight() <= maxWeight) {
            parcels.add(parcel);
            currentWeight += parcel.getWeight();
            return true;
        } else {
            System.out.println("Невозможно добавить посылку. Причина: превышен вес");
            return false;
        }
    }

    public List<T> getAllParcels() {
        return parcels;
    }

    public boolean isEmpty() {
        return parcels.isEmpty();
    }


}
