package com.bard.kursspring.controllers.v1;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductApi {

    @GetMapping
    public String getProduct() {
        return "Hello World with GET";
    }


    @PostMapping
    public String addProduct(){
        return "Hello World with POST";
    }

    @PutMapping
    public String modProduct(){
        return "Hello World with PUT";
    }

    @DeleteMapping
    public String removeProduct(){
        return "Hello World with DELETE";
    }

}
