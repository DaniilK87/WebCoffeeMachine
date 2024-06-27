package com.example.web.service;

import com.example.web.dto.coffeeBeansDto.CoffeeBeansCapacityDto;
import com.example.web.entity.CoffeeBeans;

public interface CoffeeBeansService {

    void addCoffeeBeans(CoffeeBeansCapacityDto coffeeBeansDTO);

    String getCoffeeBeansCapacity();
}
