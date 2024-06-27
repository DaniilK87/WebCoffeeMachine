package com.example.web.service;


import com.example.web.dto.milkDto.MilkCapacityDto;

public interface MilkService {

    void addMilk(MilkCapacityDto milkCapacityDto);

    String getMilkCapacity();
}
