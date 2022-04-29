package com.gildedrose

class GildedRose(var items: Array<Item>) {

    private val BACK_STAGE_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert"

    fun updateQuality() {
        for (i in items.indices) {
            if (items[i].name == BACK_STAGE_TO_A_TAFKAL80ETC_CONCERT) {
                `Backstage passes to a TAFKAL80ETC concert`(i)
            } else {
                if (items[i].name == "Aged Brie") {
                    if (qualityIsLessthanFifty(i)) {
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
                        if (items[i].name != BACK_STAGE_TO_A_TAFKAL80ETC_CONCERT) {
                            if (items[i].quality > 0) {
                                if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                                    items[i].quality = items[i].quality - 1
                                }
                            }
                        } else {
                            items[i].quality = items[i].quality - items[i].quality
                        }
                    } else { // Aged Brie
                        if (qualityIsLessthanFifty(i)) {
                            items[i].quality = items[i].quality + 1
                        }
                    }
                }
            }
        }
    }

    private fun qualityIncreasesWithDateRule(i: Int) {
        if (qualityIsLessthanFifty(i)) {
            items[i].quality = items[i].quality + 1

            if (items[i].sellIn < 11) {
                if (qualityIsLessthanFifty(i)) {
                    items[i].quality = items[i].quality + 1
                }
            }

            if (items[i].sellIn < 6) {
                if (qualityIsLessthanFifty(i)) {
                    items[i].quality = items[i].quality + 1
                }
            }
        }
    }

    private fun qualityIsLessthanFifty(i: Int) = items[i].quality < 50

    private fun qualityIsZeroWhenSellInDatePassedRule(i: Int) {
        if (items[i].sellIn < 0) {
            items[i].quality = items[i].quality - items[i].quality
        }
    }

    private fun `Backstage passes to a TAFKAL80ETC concert`(i: Int) {
        qualityIncreasesWithDateRule(i)

        items[i].sellIn = items[i].sellIn - 1

        qualityIsZeroWhenSellInDatePassedRule(i)
    }

}

