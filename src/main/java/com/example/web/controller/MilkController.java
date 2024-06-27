package com.example.web.controller;


import com.example.web.config.SwaggerConfig;
import com.example.web.dto.milkDto.MilkCapacityDto;
import com.example.web.service.MilkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Api(tags = {SwaggerConfig.MILK_TAG})
public class MilkController {

    private final MilkService milkService;

    @PostMapping("/addMilk")
    @ApiOperation("добавить молоко в кофемашину")
    public void addCoffeeBeans(@RequestBody MilkCapacityDto milkCapacityDto) {
        milkService.addMilk(milkCapacityDto);
    }

    @GetMapping("/getMilkCapacity")
    @ApiOperation("получить информацию об остатке молока в кофемашине")
    public String getCoffeeBeansCapacity() {
        return milkService.getMilkCapacity();
    }
}
