package com.karankatnani.springrestapi.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

@RestController
public class MedicationStringService {

    @PostMapping("/input")
    public ResponseEntity< String > stringHandler(@RequestBody String json) {
        System.out.println(json);
        MedicationStringService ms = new MedicationStringService();
        ms.parseJson(json);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    public void parseJson(String json){
        ObjectMapper mapper = new ObjectMapper();
        try {
            // convert JSON string to Map
            Map<String, String> map = mapper.readValue(json, Map.class);
            if (map.containsKey("medicationStrings")){
                System.out.println("nice");
            }

        } catch (IOException e) {
            //e.printStackTrace();
        }
        try {
            // convert JSON string to Map
            Map<String, String[]> map = mapper.readValue(json, Map.class);
            if (map.containsKey("medicationStrings")){
                System.out.println("nicer");
            }

        } catch (IOException e) {
           // e.printStackTrace();
        }

    }
}
