package com.ust.Laptop_Purchase.Service;

import com.speedment.jpastreamer.application.JPAStreamer;
import com.ust.Laptop_Purchase.Entity.Laptop;
import com.ust.Laptop_Purchase.repo.LaptopRepository;
//import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;
    private JPAStreamer jpaStreamer;
    private LaptopRepository repo;


    public List<Laptop> recommendLaptops(double budget) {
        List<Laptop> laptops;
        laptops = jpaStreamer.stream(Laptop.class)
                .filter(laptop -> laptop.getPrice() <= budget)
                .toList();
        return laptops;
    }

    public Laptop saveProduct(Laptop laptop) {
        return laptopRepository.save(laptop);
    }
}