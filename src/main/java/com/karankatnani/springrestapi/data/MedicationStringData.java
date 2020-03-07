package com.karankatnani.springrestapi.data;

import com.karankatnani.springrestapi.domain.*;
import java.util.HashMap;

public class MedicationStringData {
    private static int inputCount;
    private static int dosageCount;
    private static HashMap<Integer,Integer> countByMed = new HashMap<Integer,Integer>();
    private static HashMap<String,Integer> medsBySize = new HashMap<String,Integer>();

    static{
        medsBySize.put("S",0);
        medsBySize.put("M",0);
        medsBySize.put("L",0);
        medsBySize.put("XL",0);
        medsBySize.put("XXL",0);
        medsBySize.put("NA",0);
        inputCount = 0;
        dosageCount = 0;
    }

    public void storeStringData(MedicationString m){
       inputCount++;
       dosageCount = dosageCount + m.getDosageCount();
       medsBySize.put(m.getBottleSize(),medsBySize.get(m.getBottleSize())+1);
       if (countByMed.containsKey(m.getId())){
           countByMed.put(m.getId(),countByMed.get(m.getId())+1);
       }
       else{
           countByMed.put(m.getId(),1);
       }

    }
    public Statistics statisticData(){
        Statistics s = new Statistics(inputCount,dosageCount,medsBySize,countByMed);
        return s;
    }
}
