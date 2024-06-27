package com.example.web.service;

import com.example.web.dto.coffeeBeansDto.CoffeeBeansCapacityDto;
import com.example.web.entity.CoffeeBeans;
import com.example.web.repo.CoffeeBeansRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoffeeBeansServiceImpl implements CoffeeBeansService{

    private final CoffeeBeansRepo coffeeBeansRepo;

    @Override
    public void addCoffeeBeans(CoffeeBeansCapacityDto coffeeBeansDTO) {
        CoffeeBeans coffeeBeans = new CoffeeBeans();
        if (getLastCoffeeBeansCapacity() == 1) {
            coffeeBeans.setCapacity(coffeeBeansDTO.getCapacity());
        } else {
            coffeeBeans.setCapacity(getLastCoffeeBeansCapacity() + coffeeBeansDTO.getCapacity());
        }
        coffeeBeansRepo.save(coffeeBeans);

    }

    @Override
    public String getCoffeeBeansCapacity() {
        List<CoffeeBeans> coffeeBeansList = coffeeBeansRepo.findAll();
        CoffeeBeans beans = coffeeBeansList.get(coffeeBeansList.size() - 1);
        return "В емкости для зерен осталось " + beans.getCapacity();
    }

    private int getLastCoffeeBeansCapacity() {
        List<CoffeeBeans> coffeeBeansList = coffeeBeansRepo.findAll();
        if (coffeeBeansList.isEmpty()) {
            return 1;
        } else {
            CoffeeBeans beans = coffeeBeansList.get(coffeeBeansList.size() - 1);
            return beans.getCapacity();
        }
    }
}
