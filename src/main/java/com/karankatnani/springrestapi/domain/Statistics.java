package com.karankatnani.springrestapi.domain;


import java.util.HashMap;

public class Statistics {

    private final int inputCount;
    private final int dosageCount;
    private final HashMap<String,Integer> medsBySize;
    private final HashMap<String,Integer> countByMed;


    public Statistics(int inputCount, int dosageCount, HashMap<String, Integer> medsBySize, HashMap<String, Integer> countByMed) {
        this.inputCount = inputCount;
        this.dosageCount = dosageCount;
        this.medsBySize = medsBySize;
        this.countByMed = countByMed;
    }


    public int getInputCount() {
        return inputCount;
    }

    public int getDosageCount() {
        return dosageCount;
    }

    public HashMap<String, Integer> getMedsBySize() {
        return medsBySize;
    }

    public HashMap<String, Integer> getCountByMed() {
        return countByMed;
    }
}