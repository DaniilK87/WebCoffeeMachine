package com.example.web.controller;

import com.example.web.config.SwaggerConfig;
import com.example.web.dto.coffeeDto.AllCoffeeInfoDto;
import com.example.web.dto.coffeeDto.CoffeeDto;
import com.example.web.service.CoffeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Api(tags = {SwaggerConfig.COFFEE_TAG})
public class CoffeeController {

    private final CoffeeService coffeeService;

    @GetMapping("/getAmericano")
    @ApiOperation("выбрать кофе Американо")
    public CoffeeDto getAmericano() {
        return coffeeService.getAmericano();
    }

    @GetMapping("/getLatte")
    @ApiOperation("выбрать кофе Латте")
    public CoffeeDto getLatte() {
        return coffeeService.getLatte();
    }

    @GetMapping("/getEspresso")
    @ApiOperation("выбрать кофе Эспрессо")
    public CoffeeDto getEspresso() {
        return coffeeService.getEspresso();
    }

    @GetMapping("/allCoffeeInfo")
    @ApiOperation("получить информацию по приготовленному кофе за всё время")
    public List<AllCoffeeInfoDto> getAllInfoCoffee() {
        return coffeeService.getAllInfoCoffee();
    }

    @GetMapping("/allCoffeeInfo/{date}")
    @ApiOperation("получить информацию по приготовленному кофе за день, date вводится в формате YYYY-MM-dd")
    public List<CoffeeDto> getCoffeeByDate(@PathVariable String date) {
        return coffeeService.getCoffeeByDate(date);
    }
}
