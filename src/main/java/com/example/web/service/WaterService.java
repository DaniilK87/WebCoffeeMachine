package com.example.web.service;


import com.example.web.dto.waterDto.WaterCapacityDto;

public interface WaterService {

    void addWater(WaterCapacityDto waterCapacityDto);

    String getWaterCapacity();
}
