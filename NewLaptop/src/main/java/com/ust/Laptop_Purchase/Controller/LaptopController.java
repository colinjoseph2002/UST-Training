package com.ust.Laptop_Purchase.Controller;

import com.ust.Laptop_Purchase.Entity.Laptop;
import com.ust.Laptop_Purchase.Service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ust")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @PostMapping("/add_laptop")
    public Laptop addLaptop(@RequestBody Laptop laptop) {
        return laptopService.saveProduct(laptop);
    }

    @GetMapping("/laptops")
    public List<Laptop> recommendLaptops(@RequestParam double budget) {
        return laptopService.recommendLaptops(budget);
    }




}


