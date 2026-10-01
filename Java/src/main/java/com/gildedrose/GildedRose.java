package com.gildedrose;

import java.util.Map;

//Represents the Gilded Rose inn and its daily inventory management
class GildedRose {

    //The list of items currently in stock
    Item[] items;

    //Maps each item type to its corresponding update strategy
    private static final Map<String, ItemUpdater> UPDATERS = Map.of(
        "Aged Brie", new AgedBrieUpdater(),
        "Sulfuras, Hand of Ragnaros", new SulfurasUpdater(),
        "Backstage passes to a TAFKAL80ETC concert", new BackstagePassesUpdater(),
        "Conjured Mana Cake", new ConjuredUpdater()
    );

    //Default updater for normal items
    private static final ItemUpdater DEFAULT_UPDATER = new NormalItemUpdater();

    //Initializes the inn with its inventory
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        //Update quality and sellIn for each item in the inventory
        for (Item item : items) {
            ItemUpdater updater = UPDATERS.getOrDefault(item.name, DEFAULT_UPDATER);
            updater.update(item);
        }
    }
}
