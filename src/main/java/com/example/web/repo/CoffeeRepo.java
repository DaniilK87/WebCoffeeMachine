package com.example.web.repo;

import com.example.web.dto.coffeeDto.AllCoffeeInfoDto;
import com.example.web.dto.coffeeDto.CoffeeDto;
import com.example.web.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoffeeRepo extends JpaRepository<Coffee, Integer> {

    @Query("SELECT new com.example.web.dto.coffeeDto.AllCoffeeInfoDto (c.coffeeType, c.date, cb.portion, w.portion) "
            + "FROM Coffee c LEFT JOIN c.coffeeBeans cb LEFT JOIN  c.water w")
    List<AllCoffeeInfoDto> getAllInfoCoffee();

    List<Coffee> findAllByDate(String date);
}
