package com.ItemInteractor.repository;

import com.ItemInteractor.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<Item,String> {
//    List<Item> findAllByPrice(double price , Pageable pageable);

    Item findByProductName(String productName);

}

