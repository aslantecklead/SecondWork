package com.example.secondwork.dao;

import com.example.secondwork.model.Deal;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DealDAO {

    private static int DEAL_COUNT = 0;
    private List<Deal> deals;
    {
        deals = new ArrayList<>();

        deals.add(new Deal(++DEAL_COUNT, "Apartment in City X", 250000.0, new Date()));
        deals.add(new Deal(++DEAL_COUNT, "House in City Y", 450000.0, new Date()));
        deals.add(new Deal(++DEAL_COUNT, "Office Space in City Z", 800000.0, new Date()));
        deals.add(new Deal(++DEAL_COUNT, "Villa in City A", 1200000.0, new Date()));
        deals.add(new Deal(++DEAL_COUNT, "Warehouse in City B", 600000.0, new Date()));
    }

    public List<Deal> index() {
        return deals;
    }

    public Deal show(long id) {
        return deals.stream().filter(deal -> deal.getId() == id).findFirst().orElse(null);
    }
}
