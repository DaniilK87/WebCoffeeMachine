package com.example.web.service;

import com.example.web.dto.milkDto.MilkCapacityDto;
import com.example.web.entity.Milk;
import com.example.web.repo.MilkRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MilkServiceImpl implements MilkService{

    private final MilkRepo milkRepo;

    @Override
    public void addMilk(MilkCapacityDto milkCapacityDto) {
        Milk milk = new Milk();
        if (getLastMilkCapacity() == 1) {
            milk.setCapacity(milkCapacityDto.getCapacity());
        } else {
            milk.setCapacity(getLastMilkCapacity() + milkCapacityDto.getCapacity());
        }
        milkRepo.save(milk);
    }

    @Override
    public String getMilkCapacity() {
        List<Milk> milkList = milkRepo.findAll();
        Milk milk = milkList.get(milkList.size() - 1);
        return "В емкости для молока осталось " + milk.getCapacity();
    }

    private int getLastMilkCapacity() {
        List<Milk> milkList = milkRepo.findAll();
        if (milkList.isEmpty()) {
            return 1;
        } else {
            Milk milk = milkList.get(milkList.size() - 1);
            return milk.getCapacity();
        }
    }
}
