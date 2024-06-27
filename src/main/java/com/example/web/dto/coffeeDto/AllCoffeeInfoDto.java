package com.example.web.dto.coffeeDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllCoffeeInfoDto {

    private String coffeeType;
    private String date;
    private int coffeeBeansPortion;
    private int waterPortion;

}
