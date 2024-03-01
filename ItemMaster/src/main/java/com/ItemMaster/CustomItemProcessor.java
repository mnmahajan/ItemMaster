package com.ItemMaster;

import com.ItemMaster.Model.Item;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Item, Item> {

    @Override
    public Item process(Item item) throws Exception {
        return item;
    }
}
