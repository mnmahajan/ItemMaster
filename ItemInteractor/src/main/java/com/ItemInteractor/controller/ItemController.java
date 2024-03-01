package com.ItemInteractor.controller;

import com.ItemInteractor.Model.Item;
import com.ItemInteractor.repository.ItemRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    ItemRepo itemRepo;
    @GetMapping("/productName")
    public Item getItem(String pName){
        return itemRepo.findByProductName(pName);
    }

    @GetMapping("/all")
    public List<Item> getAllItems(){
        return itemRepo.findAll();
    }
    @PutMapping("/{item}")
    public Item updateItem(Item item){
        return itemRepo.save(item);
    }

}
