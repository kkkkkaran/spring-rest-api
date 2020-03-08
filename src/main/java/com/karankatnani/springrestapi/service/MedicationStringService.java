package com.karankatnani.springrestapi.service;

import com.karankatnani.springrestapi.data.MedicationStringData;
import com.karankatnani.springrestapi.domain.MedicationString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@RestController
public class MedicationStringService {

    @PostMapping("/input")
    public ResponseEntity< String > stringHandler(@RequestBody String json) {
        MedicationStringService ms = new MedicationStringService();
        boolean status = ms.parseJson(json);
        if(status){
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        //if invalid JSON
        else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

    }

    private boolean parseJson(String json){
        ObjectMapper mapper = new ObjectMapper();
        try {

            Map<String, Object> map = mapper.readValue(json, Map.class); //JSON string to Map using Jackson JSON parser
            if (map.containsKey("medicationStrings")){
                String[] medicationStrings;
                if(map.get("medicationStrings") instanceof ArrayList) {
                    ArrayList arr = (ArrayList) map.get("medicationStrings");
                    Object[] objNames = arr.toArray();
                    medicationStrings = Arrays.copyOf(objNames, objNames.length, String[].class);
                }
                else if (map.get("medicationStrings") instanceof String){
                    String str = (String) map.get("medicationStrings");
                    medicationStrings = str.split(";");
                }
                else{
                    return false;
                }
                boolean successFlag = false;

                //TODO Implement Unit of Work to ensure that data is committed only after transaction is completed, rollback otherwise

                for (String medicationString : medicationStrings){
                    String[] split = medicationString.split("_");
                    if(split.length == 3) {
                        String[] sizes = {"S","M","L","XL","XXL","NA"};
                        if(split[0].length()<21 && Arrays.asList(sizes).contains(split[1])  && split[2].matches("\\d{4}")){
                            MedicationString m = new MedicationString(split[0],split[1],Integer.parseInt(split[2]));
                            MedicationStringData msd = new MedicationStringData();
                            msd.storeStringData(m);
                            successFlag = true;
                        }
                    }
                }
                //TODO UoW
                if(successFlag){
                    return true;
                }
            }
        } //TODO
        catch (IOException e) {
        }
        return false;
    }
}
