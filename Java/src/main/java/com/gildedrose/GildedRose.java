package com.gildedrose;

class GildedRose {
    Item[] items;

    public static final int LOWEST_POSSIBLE_QUALITY = 0;
    public static final int HIGHEST_POSSIBLE_QUALITY = 50;
    
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        
        for (int i = 0; i < items.length; i++) {
          checkExpiry(items[i]);
          expireProductNonSulfurus(items[i]);
        }
    }

    private void checkExpiry(Item item) {
      if (item.dayItemToBeSold < 0)
        assignQualityForExpiredItems(item);
      else
        assignQualityForFreshItem(item);      
    }

    private void assignQualityForExpiredItems(Item item) {
      if(isAgedBrie(item) && item.quality < HIGHEST_POSSIBLE_QUALITY) 
        item.quality = item.quality + 1;
      else {
        item.quality = item.quality - 1;
      }
    }

    private void expireProductNonSulfurus(Item item) {
      if(!isSulfurus(item)) {
        item.dayItemToBeSold = item.dayItemToBeSold -1;
      }   
    }

    private boolean isSulfurus(Item item) {
      if(item.name.equals("Sulfuras, Hand of Ragnaros"))
        return true;
      return false;
    }

    private boolean isAgedBrie(Item item) {
      if(item.name.equals("Aged Brie"))
        return true;
      return false;
    }
    
    private boolean isBackstageConcert(Item item) {
      if(item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
        return true;
      return false;
    }
    
    private void assignQualityForFreshItem(Item item) {
      if(isAgedBrie(item) && isBackstageConcert(item) && isSulfurus(item)) {
        item.quality = item.quality - 1;
      } else {
          if(isBackstageConcert(item) && item.dayItemToBeSold < 11) 
            item.quality = item.quality + 1;
      }   
    }
}
