package com.example.web.repo;

import com.example.web.entity.Water;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaterRepo extends JpaRepository<Water,Integer> {
}
