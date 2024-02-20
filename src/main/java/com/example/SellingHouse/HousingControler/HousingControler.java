package com.example.SellingHouse.HousingControler;

import com.example.SellingHouse.HousingService.HousingService;
import com.example.SellingHouse.Model.HousingData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
// Home controler
import java.util.List;

@RestController
@RequestMapping("House")
public class HousingControler {
    @Autowired
    HousingService housingService;
   @PostMapping("/add")
    public List<HousingData> addHouse(@RequestBody   List<HousingData> housingData)
   {
    return housingService.addHouse(housingData);
   }
   @GetMapping("/avgPrize")
    public String avgPrize()
   {
       return housingService.avgPrize();
   }
   @GetMapping("/avgPrizebyLocation")
    public String avrPrizebyLocation(@RequestParam String Location)
   {
       return housingService.avgPrizebyLocation(Location);
   }
   @GetMapping("/maxSalePrize")
    public String maxSalePrize(){
       return housingService.maxSalePrize();
   }
    @GetMapping("/minSalePrize")
    public String minSalePrize(){
        return housingService.minSalePrize();
    }
}
