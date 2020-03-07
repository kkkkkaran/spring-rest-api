package com.karankatnani.springrestapi.domain;

public class MedicationString {
    private final String id;
    private final String bottleSize;
    private final int dosageCount;

    public MedicationString(String id, String bottleSize, int dosageCount) {
        this.id = id;
        this.bottleSize = bottleSize;
        this.dosageCount = dosageCount;
    }

    public String getId() {
        return id;
    }

    public String getBottleSize() {
        return bottleSize;
    }

    public int getDosageCount() {
        return dosageCount;
    }
}
