package com.example.web.service;


import com.example.web.dto.coffeeDto.AllCoffeeInfoDto;
import com.example.web.dto.coffeeDto.CoffeeDto;

import java.util.List;

public interface CoffeeService {

    CoffeeDto getAmericano();

    CoffeeDto getLatte();

    CoffeeDto getEspresso();

    List<AllCoffeeInfoDto> getAllInfoCoffee();

    List<CoffeeDto> getCoffeeByDate(String date);
}
