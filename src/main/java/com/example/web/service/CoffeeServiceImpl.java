package com.example.web.service;

import com.example.web.constants.CoffeeConstants;
import com.example.web.dto.coffeeDto.AllCoffeeInfoDto;
import com.example.web.dto.coffeeDto.CoffeeDto;
import com.example.web.entity.Coffee;
import com.example.web.entity.CoffeeBeans;
import com.example.web.entity.Milk;
import com.example.web.entity.Water;
import com.example.web.exception.NoCoffeeBeansException;
import com.example.web.exception.NoDateException;
import com.example.web.exception.NoMilkException;
import com.example.web.exception.NoWaterException;
import com.example.web.repo.CoffeeBeansRepo;
import com.example.web.repo.CoffeeRepo;
import com.example.web.repo.MilkRepo;
import com.example.web.repo.WaterRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService{

    private final CoffeeRepo coffeeRepo;
    private final CoffeeBeansRepo coffeeBeansRepo;
    private final WaterRepo waterRepo;
    private final MilkRepo milkRepo;

    @Override
    public CoffeeDto getAmericano() {
        Coffee americano = new Coffee();
        LocalDate date = LocalDate.now();
        americano.setDate(date.toString());
        americano.setCoffeeType(CoffeeConstants.COFFEE_AMERICANO);
        CoffeeDto americanoDto = new CoffeeDto();
        americanoDto.setId(americano.getId());
        americanoDto.setCoffeeType(americano.getCoffeeType());
        americanoDto.setDate(americano.getDate());

        CoffeeBeans coffeeBeans = new CoffeeBeans();
        if (getCoffeeBeansCapacity() < CoffeeConstants.BEANS_TO_AMERICANO) throw new NoCoffeeBeansException("не хватает кофейных зерен");
        coffeeBeans.setPortion(CoffeeConstants.BEANS_TO_AMERICANO);
        coffeeBeans.setCapacity(getCoffeeBeansCapacity() - coffeeBeans.getPortion());
        coffeeBeans.setCoffee(americano);

        Water water = new Water();
        if (getWaterCapacity() < CoffeeConstants.WATER_TO_AMERICANO) throw new NoWaterException("не хватает воды");
        water.setPortion(CoffeeConstants.WATER_TO_AMERICANO);
        water.setCapacity(getWaterCapacity() - water.getPortion());
        water.setCoffee(americano);

        coffeeBeansRepo.save(coffeeBeans);
        waterRepo.save(water);
        coffeeRepo.save(americano);
        return americanoDto;
    }

    @Override
    public CoffeeDto getLatte() {
        Coffee latte = new Coffee();
        LocalDate date = LocalDate.now();
        latte.setDate(date.toString());
        latte.setCoffeeType(CoffeeConstants.COFFEE_LATTE);
        CoffeeDto latteDto = new CoffeeDto();
        latteDto.setId(latte.getId());
        latteDto.setCoffeeType(latte.getCoffeeType());
        latteDto.setDate(latte.getDate());

        CoffeeBeans coffeeBeans = new CoffeeBeans();
        if (getCoffeeBeansCapacity() < CoffeeConstants.BEANS_TO_LATTE) throw new NoCoffeeBeansException("не хватает кофейных зерен");
        coffeeBeans.setPortion(CoffeeConstants.BEANS_TO_LATTE);
        coffeeBeans.setCapacity(getCoffeeBeansCapacity() - coffeeBeans.getPortion());
        coffeeBeans.setCoffee(latte);

        Water water = new Water();
        if (getWaterCapacity() < CoffeeConstants.WATER_TO_LATTE) throw new NoWaterException("не хватает воды");
        water.setPortion(CoffeeConstants.WATER_TO_LATTE);
        water.setCapacity(getWaterCapacity() - water.getPortion());
        water.setCoffee(latte);

        Milk milk = new Milk();
        if (getMilkCapacity() < CoffeeConstants.MILK_TO_LATTE) throw new NoMilkException("не хватает молока");
        milk.setPortion(CoffeeConstants.MILK_TO_LATTE);
        milk.setCapacity(getMilkCapacity() - milk.getPortion());
        milkRepo.save(milk);

        coffeeBeansRepo.save(coffeeBeans);
        waterRepo.save(water);
        coffeeRepo.save(latte);
        return latteDto;
    }

    @Override
    public CoffeeDto getEspresso() {
        Coffee espresso = new Coffee();
        LocalDate date = LocalDate.now();
        espresso.setDate(date.toString());
        espresso.setCoffeeType(CoffeeConstants.COFFEE_ESPRESSO);
        CoffeeDto espressoDto = new CoffeeDto();
        espressoDto.setId(espresso.getId());
        espressoDto.setCoffeeType(espresso.getCoffeeType());
        espressoDto.setDate(espresso.getDate());

        CoffeeBeans coffeeBeans = new CoffeeBeans();
        if (getCoffeeBeansCapacity() < CoffeeConstants.BEANS_TO_ESPRESSO) throw new NoCoffeeBeansException("не хватает кофейных зерен");
        coffeeBeans.setPortion(CoffeeConstants.BEANS_TO_ESPRESSO);
        coffeeBeans.setCapacity(getCoffeeBeansCapacity() - coffeeBeans.getPortion());
        coffeeBeans.setCoffee(espresso);

        Water water = new Water();
        if (getWaterCapacity() < CoffeeConstants.WATER_TO_LATTE) throw new NoWaterException("не хватает воды");
        water.setPortion(CoffeeConstants.WATER_TO_ESPRESSO);
        water.setCapacity(getWaterCapacity() - water.getPortion());
        water.setCoffee(espresso);

        coffeeBeansRepo.save(coffeeBeans);
        waterRepo.save(water);
        coffeeRepo.save(espresso);
        return espressoDto;
    }

    @Override
    public List<AllCoffeeInfoDto> getAllInfoCoffee() {
        List<AllCoffeeInfoDto> list = coffeeRepo.getAllInfoCoffee();
        return list;
    }

    @Override
    public List<CoffeeDto> getCoffeeByDate(String date) {
        List<Coffee> coffeeList = coffeeRepo.findAllByDate(date);
        if (coffeeList.isEmpty()) throw new NoDateException("в этот день кофе не готовили");
        List<CoffeeDto> coffeeDtoList = coffeeList.stream().map(coffee -> {
            CoffeeDto coffeeDto = new CoffeeDto();
            coffeeDto.setId(coffee.getId());
            coffeeDto.setDate(coffee.getDate());
            coffeeDto.setCoffeeType(coffee.getCoffeeType());
            return coffeeDto;
        }).collect(Collectors.toList());
        return coffeeDtoList;
    }

    private int getCoffeeBeansCapacity()  {
        List<CoffeeBeans> coffeeBeansList = coffeeBeansRepo.findAll();
        if (coffeeBeansList.isEmpty()) throw new NoCoffeeBeansException("нету кофейных зерен");
        CoffeeBeans beans = coffeeBeansList.get(coffeeBeansList.size() - 1);
        return beans.getCapacity();
    }

    private int getWaterCapacity() {
        List<Water> waterList = waterRepo.findAll();
        if (waterList.isEmpty()) throw new NoWaterException("нету воды");
        Water water = waterList.get(waterList.size() - 1);
        return water.getCapacity();
    }

    private int getMilkCapacity() {
        List<Milk> milkList = milkRepo.findAll();
        if (milkList.isEmpty()) throw new NoMilkException("нету молока");
        Milk milk = milkList.get(milkList.size() - 1);
        return milk.getCapacity();
    }
}
