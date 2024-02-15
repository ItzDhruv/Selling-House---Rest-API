package com.example.SellingHouse.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class HousingData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long HouseNumber;
    private int Bedrooms;
    private float Bathrooms;
    private float SquareFootage;
    private String Location;
    private double SalePrice;
    public HousingData() {
    }
}
