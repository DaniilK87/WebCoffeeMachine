package com.example.web.dto.coffeeDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeDto {
    private int id;
    private String coffeeType;
    private String date;
}
