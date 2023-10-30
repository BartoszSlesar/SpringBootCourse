package com.bard.kursspring.controllers.v1;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductApi {

    //PARAMETR
//    @GetMapping
//    public String getProduct(@RequestParam  String name,
//                             @RequestParam(required = false,defaultValue = "") String surname) {
//        return "Hello " + name + " " + surname;
//    }
//PATH
//    @GetMapping("/{name}")
//    public String getProduct(@PathVariable  String name) {
//        return "Hello " + name;
//    }
//HEADER
//    @GetMapping
//    public String getProduct(@RequestHeader String name) {
//        return "Hello " + name;
//    }

//    BODY
@GetMapping
public ResponseEntity<String> getProduct(@RequestBody String name) {
    return new ResponseEntity<>("Hello " + name, HttpStatus.OK);
}

    @PostMapping
    public String addProduct() {
        return "Hello World with POST";
    }

    @PutMapping
    public String modProduct() {
        return "Hello World with PUT";
    }

    @DeleteMapping
    public String removeProduct() {
        return "Hello World with DELETE";
    }

}
