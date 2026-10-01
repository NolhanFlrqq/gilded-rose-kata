package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    //Normal item
    @Test
    void normalItem_qualityDecreasesBy1BeforeExpiry(){
        Item[] items = new Item[]{ new Item("Elixir of the Mongoose", 5, 10) };
        GildedRose gilde1 = new GildedRose(items);
        gilde1.updateQuality();
        assertEquals(4, gilde1.items[0].sellIn);
        assertEquals(9, gilde1.items[0].quality);
    }

    @Test
    void normalItem_qualityDecreasesBy2AfterExpiry(){
        Item[] items = new Item[]{ new Item("Elixir of the Mongoose", 0, 10) };
        GildedRose gilde1 = new GildedRose(items);
        gilde1.updateQuality();
        assertEquals(-1, gilde1.items[0].sellIn);
        assertEquals(8, gilde1.items[0].quality);
    }

    @Test
    void normalItem_qualityNeverNegative(){
        Item[] items = new Item[]{ new Item("Elixir of the Mongoose", 0, 1) };
        GildedRose gilde1 = new GildedRose(items);
        gilde1.updateQuality();
        assertEquals(-1, gilde1.items[0].sellIn);
        assertEquals(0, gilde1.items[0].quality);
    }

    //Aged Brie
    @Test
    void agedBrie_qualityIncreasesBy1BeforeExpiry(){
        Item[] items = new Item[]{ new Item("Aged Brie", 5, 10) };
        GildedRose gilde1 = new GildedRose(items);
        gilde1.updateQuality();
        assertEquals(4, gilde1.items[0].sellIn);
        assertEquals(11, gilde1.items[0].quality);
    }

    @Test
    void agedBrie_qualityIncreasesBy2AfterExpiry(){
        Item[] items = new Item[]{ new Item("Aged Brie", 0, 10) };
        GildedRose gilde1 = new GildedRose(items);
        gilde1.updateQuality();
        assertEquals(-1, gilde1.items[0].sellIn);
        assertEquals(12, gilde1.items[0].quality);
    }

    @Test
    void agedBrie_qualityNeverExceeds50(){
        Item[] items = new Item[]{ new Item("Aged Brie", 5, 50) };
        GildedRose gilde1 = new GildedRose(items);
        gilde1.updateQuality();
        assertEquals(4, gilde1.items[0].sellIn);
        assertEquals(50, gilde1.items[0].quality);
    }

    //Sulfuras
    @Test
    void sulfuras_sellInAndQualityNeverChanges(){
        Item[] items = new Item[]{ new Item("Sulfuras, Hand of Ragnaros", 5, 80) };
        GildedRose gilde1 = new GildedRose(items);
        gilde1.updateQuality();
        assertEquals(5, gilde1.items[0].sellIn);
        assertEquals(80, gilde1.items[0].quality);
    }

    //Backstage Passes
    @Test
    void backstagePasses_qualityIncreasesBy1MoreThan10Days(){
        Item[] items = new Item[]{ new Item("Backstage passes to a TAFKAL80ETC concert", 15, 10) };
        GildedRose gilde1 = new GildedRose(items);
        gilde1.updateQuality();
        assertEquals(14, gilde1.items[0].sellIn);
        assertEquals(11, gilde1.items[0].quality);
    }

    @Test
    void backstagePasses_qualityIncreasesBy2Between10And6Days(){
        Item[] items = new Item[]{ new Item("Backstage passes to a TAFKAL80ETC concert", 8, 10) };
        GildedRose gilde1 = new GildedRose(items);
        gilde1.updateQuality();
        assertEquals(7, gilde1.items[0].sellIn);
        assertEquals(12, gilde1.items[0].quality);
    }

    @Test
    void backstagePasses_qualityIncreasesBy3Between5And0Days(){
        Item[] items = new Item[]{ new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10) };
        GildedRose gilde1 = new GildedRose(items);
        gilde1.updateQuality();
        assertEquals(3, gilde1.items[0].sellIn);
        assertEquals(13, gilde1.items[0].quality);
    }

    @Test
    void backstagePasses_qualityDropsTo0AfterConcert(){
        Item[] items = new Item[]{ new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose gilde1 = new GildedRose(items);
        gilde1.updateQuality();
        assertEquals(-1, gilde1.items[0].sellIn);
        assertEquals(0, gilde1.items[0].quality);
    }

    //Conjured
    @Test
    void conjured_qualityDecreasesBy2BeforeExpiry(){
        Item[] items = new Item[]{ new Item("Conjured Mana Cake", 5, 10) };
        GildedRose gilde1 = new GildedRose(items);
        gilde1.updateQuality();
        assertEquals(4, gilde1.items[0].sellIn);
        assertEquals(8, gilde1.items[0].quality);
    }

    @Test
    void conjured_qualityDecreasesBy4AfterExpiry(){
        Item[] items = new Item[]{ new Item("Conjured Mana Cake", 0, 10) };
        GildedRose gilde1 = new GildedRose(items);
        gilde1.updateQuality();
        assertEquals(-1, gilde1.items[0].sellIn);
        assertEquals(6, gilde1.items[0].quality);
    }

    @Test
    void conjured_qualityNeverNegative(){
        Item[] items = new Item[]{ new Item("Conjured Mana Cake", 0, 1) };
        GildedRose gilde1 = new GildedRose(items);
        gilde1.updateQuality();
        assertEquals(-1, gilde1.items[0].sellIn);
        assertEquals(0, gilde1.items[0].quality);
    }
}
