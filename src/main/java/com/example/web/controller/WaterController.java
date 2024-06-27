package com.example.web.controller;

import com.example.web.config.SwaggerConfig;
import com.example.web.dto.waterDto.WaterCapacityDto;
import com.example.web.service.WaterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Api(tags = {SwaggerConfig.WATER_TAG})
public class WaterController {

    private final WaterService waterService;

    @PostMapping("/addWater")
    @ApiOperation("добавить воду в кофемашину")
    public void addWater(@RequestBody WaterCapacityDto waterCapacityDto) {
        waterService.addWater(waterCapacityDto);
    }

    @GetMapping("/getWaterCapacity")
    @ApiOperation("получить информацию об остатке воды в кофемашине")
    public String getCoffeeBeansCapacity() {
        return waterService.getWaterCapacity();
    }
}
