package com.karankatnani.springrestapi.domain;

public class MedicationString {
    private final int id;
    private final String bottleSize;
    private final int dosageCount;

    public MedicationString(int id, String bottleSize, int dosageCount) {
        this.id = id;
        this.bottleSize = bottleSize;
        this.dosageCount = dosageCount;
    }

    public int getId() {
        return id;
    }

    public String getBottleSize() {
        return bottleSize;
    }

    public int getDosageCount() {
        return dosageCount;
    }
}
