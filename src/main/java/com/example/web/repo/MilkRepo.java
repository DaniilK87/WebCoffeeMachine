package com.example.web.repo;

import com.example.web.entity.Milk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilkRepo extends JpaRepository<Milk,Integer> {
}
