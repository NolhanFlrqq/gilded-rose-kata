package com.gildedrose;

public class BackstagePassesUpdater implements ItemUpdater{

    @Override
    public void update(Item item){
        item.sellIn--;

        //After the concert, quality drops to 0
        if(item.sellIn < 0){
            item.quality = 0;
        }
        //5 days or less remaining
        else if(item.sellIn < 6){
            item.quality += 3;
        }
        //10 days or less remaining
        else if(item.sellIn < 11){
            item.quality += 2;
        }
        //More than 10 days remaining
        else{
            item.quality++;
        }

        if(item.quality > 50) item.quality = 50;
    }
}