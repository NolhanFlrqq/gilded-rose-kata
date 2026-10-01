package com.gildedrose;

public class ConjuredUpdater implements ItemUpdater{

    @Override 
    public void update(Item item){
        item.sellIn--;

        //Conjured items degrade in quality twice as fast as normal items
        if(item.sellIn < 0){
            item.quality -= 4;
        }
        else{
            item.quality -= 2;
        }

        if(item.quality < 0) item.quality = 0;
    }
}