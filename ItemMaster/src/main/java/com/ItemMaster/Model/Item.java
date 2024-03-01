package com.ItemMaster.Model;

import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class Item {

    private String storeId;

    public Item() {
    }

    private  String sku;

    public Item(String storeId, String sku, String productName, Double price, String lastUpdatedOn) {
        this.storeId = storeId;
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(String lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }


    private String productName;
    private Double price;

    private String lastUpdatedOn;
    DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("DD-MM-YYYY");
}
