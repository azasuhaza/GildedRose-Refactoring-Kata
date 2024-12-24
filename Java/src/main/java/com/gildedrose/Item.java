package com.gildedrose;

public class Item {

    public String name;

    public int dayItemToBeSold;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.dayItemToBeSold = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.dayItemToBeSold + ", " + this.quality;
    }
}
