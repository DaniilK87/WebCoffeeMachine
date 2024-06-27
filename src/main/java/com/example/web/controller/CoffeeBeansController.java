package com.example.web.controller;

import com.example.web.config.SwaggerConfig;
import com.example.web.dto.coffeeBeansDto.CoffeeBeansCapacityDto;
import com.example.web.service.CoffeeBeansService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Api(tags = {SwaggerConfig.COFFEE_BEANS_TAG})
public class CoffeeBeansController {

    private final CoffeeBeansService coffeeBeansService;

    @PostMapping("/addCoffeeBeans")
    @ApiOperation("добавить кофейные зёрна в кофемашину")
    public void addCoffeeBeans(@RequestBody CoffeeBeansCapacityDto coffeeBeansDTO) {
        coffeeBeansService.addCoffeeBeans(coffeeBeansDTO);
    }

    @GetMapping("/getCoffeeBeansCapacity")
    @ApiOperation("получить информацию об остатке кофейных зёрен в кофемашине")
    public String getCoffeeBeansCapacity() {
        return coffeeBeansService.getCoffeeBeansCapacity();
    }
}
