package com.gildedrose;

public class AgedBrieUpdater implements ItemUpdater{

    @Override 
    public void update(Item item){
        item.sellIn--;

        //Once expired, quality increases by 2 instead of 1
        if(item.sellIn < 0){
            item.quality += 2;
        }
        //Quality increases by 1 each day
        else{
            item.quality++;
        }

        //Quality can never exceed 50
        if(item.quality > 50) item.quality = 50;
    }
}