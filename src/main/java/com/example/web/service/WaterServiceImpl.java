package com.example.web.service;

import com.example.web.dto.waterDto.WaterCapacityDto;
import com.example.web.entity.Water;
import com.example.web.repo.WaterRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WaterServiceImpl implements WaterService{

    private final WaterRepo waterRepo;

    @Override
    public void addWater(WaterCapacityDto waterCapacityDto) {
        Water water = new Water();
        if (getLastWaterCapacity() == 1) {
            water.setCapacity(waterCapacityDto.getCapacity());
        } else {
            water.setCapacity(getLastWaterCapacity() + waterCapacityDto.getCapacity());
        }

        waterRepo.save(water);
    }

    @Override
    public String getWaterCapacity() {
        List<Water> waterList = waterRepo.findAll();
        Water water = waterList.get(waterList.size() - 1);
        return "В емкости для воды осталось " + water.getCapacity();
    }

    private int getLastWaterCapacity() {
        List<Water> waterList = waterRepo.findAll();
        if (waterList.isEmpty()) {
            return 1;
        } else {
            Water water = waterList.get(waterList.size() - 1);
            return water.getCapacity();
        }
    }
}
