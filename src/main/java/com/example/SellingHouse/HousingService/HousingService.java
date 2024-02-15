package com.example.SellingHouse.HousingService;

import com.example.SellingHouse.HousingRepositry.HousingRepositry;
import com.example.SellingHouse.Model.HousingData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class HousingService {
    @Autowired
    HousingRepositry housingRepositry;

    public List<HousingData> addHouse(List<HousingData> housingData) {
        return housingRepositry.saveAll(housingData);
    }

    public String avgPrize() {
            double avgPrize = 0;
            int totalHouse = 0;
        try {
            List<HousingData> housingDataList = housingRepositry.findAll();
            for (HousingData temp : housingDataList) {
                avgPrize += temp.getSalePrice();
                if (temp.getSalePrice() != 0) {
                    totalHouse++;
                }
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.err.println("An unexpected error occurred : "+e);
        }
        return "Average Prize is : " + (int) avgPrize / totalHouse;
    }


    public String avgPrizebyLocation(String location) {

            List<HousingData> housingDataList = housingRepositry.findAll();
            double avgPrize = 0;
            int totalHouseBylocation = 0;
            try{
            for (HousingData temp : housingDataList) {
                if (Objects.equals(temp.getLocation(), location)) {
                    avgPrize += temp.getSalePrice();
                    totalHouseBylocation++;
                }
            }
        }
          catch (Exception e)
        {
            e.printStackTrace();
            System.err.println("An unexpected error occurred : "+e);
        }
        return "Average prize is : "+(int)avgPrize/totalHouseBylocation+" in ("+location+") Location.";
    }

    public String maxSalePrize() {
        List<HousingData> housingDataList = housingRepositry.findAll();
        double maxPrize = 0;
        HousingData maxHousingData = null;
        try{
        for (HousingData temp : housingDataList) {
            if (temp.getSalePrice() > maxPrize) {
                maxPrize = temp.getSalePrice();
                maxHousingData = temp;
            }
        }
    }
           catch (Exception e)
        {
            e.printStackTrace();
            System.err.println("An unexpected error occurred : "+e);
        }
        return "Max sale prize is : "+maxPrize+"and House number is : "+maxHousingData.getHouseNumber();
    }

    public String minSalePrize() {
        List<HousingData> housingDataList = housingRepositry.findAll();
        double minPrize = Integer.MAX_VALUE;
        HousingData maxHousingData = null;
        try{
        for (HousingData temp : housingDataList) {
            if (temp.getSalePrice() < minPrize && temp.getSalePrice() != 0) {
                minPrize = temp.getSalePrice();
                maxHousingData = temp;
            }
        }
    }
           catch (Exception e)
        {
            e.printStackTrace();
            System.err.println("An unexpected error occurred : "+e);
        }
        return "Min sale prize is : "+minPrize+" and House number is : "+maxHousingData.getHouseNumber();
    }
}
