package com.example.web.repo;

import com.example.web.entity.CoffeeBeans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeBeansRepo extends JpaRepository<CoffeeBeans,Integer> {
}
