package com.example.SellingHouse.HousingRepositry;

import com.example.SellingHouse.Model.HousingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousingRepositry extends JpaRepository<HousingData,Long> {
}
