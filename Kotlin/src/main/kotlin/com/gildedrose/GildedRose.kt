package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            if (items[i].name == "Backstage passes to a TAFKAL80ETC concert") {
                `Backstage passes to a TAFKAL80ETC concert`(i)
            } else {
                if (items[i].name == "Aged Brie") {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1
                    }
                } else {
                    if (items[i].quality > 0) {
                        if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                            items[i].quality = items[i].quality - 1
                        }
                    }
                }

                if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                    items[i].sellIn = items[i].sellIn - 1
                }

                if (items[i].sellIn < 0) {
                    if (items[i].name != "Aged Brie") {
                        if (items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                            if (items[i].quality > 0) {
                                if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                                    items[i].quality = items[i].quality - 1
                                }
                            }
                        } else {
                            items[i].quality = items[i].quality - items[i].quality
                        }
                    } else { // Aged Brie
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1
                        }
                    }
                }
            }
        }
    }

    private fun `Backstage passes to a TAFKAL80ETC concert`(i: Int) {
        if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1

            if (items[i].sellIn < 11) {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1
                }
            }

            if (items[i].sellIn < 6) {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1
                }
            }
        }

        items[i].sellIn = items[i].sellIn - 1

        if (items[i].sellIn < 0) {
            items[i].quality = items[i].quality - items[i].quality
        }
    }

}

