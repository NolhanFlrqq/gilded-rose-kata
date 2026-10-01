package com.gildedrose;

public class NormalItemUpdater implements ItemUpdater{

    @Override
    public void update(Item item){
        //sellIn decreases by 1 each day
        item.sellIn--;

        //Once expired, quality degrades twice as fast
        if(item.sellIn < 0){
            item.quality -= 2;
        }
        //Before expiry, quality decreases by 1 each day
        else{
            item.quality--;
        }

        //Quality can never be negative
        if(item.quality < 0) item.quality = 0;
    }
}