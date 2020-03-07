package com.karankatnani.springrestapi.service;

import java.util.concurrent.atomic.AtomicLong;

import com.karankatnani.springrestapi.data.MedicationStringData;
import com.karankatnani.springrestapi.domain.Statistics;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsService {

    @GetMapping("/statistics")
    public Statistics stats() {
        MedicationStringData m = new MedicationStringData();
        return m.statisticData();
    }
}