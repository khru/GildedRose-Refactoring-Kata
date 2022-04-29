package com.gildedrose


class GildedRose(var items: Array<Item>) {

    private val BACK_STAGE_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert"
    private val AGED_BRIE = "Aged Brie"
    private val SULFURAS = "Sulfuras, Hand of Ragnaros"


    fun updateQuality() {
        for (i in items.indices) {
            if (items[i].name == BACK_STAGE_TO_A_TAFKAL80ETC_CONCERT) {
                `Backstage passes to a TAFKAL80ETC concert`(i)
            } else if (items[i].name == AGED_BRIE) {
                `Aged Brie`(i)
            } else if (items[i].name == SULFURAS) {

            } else {
                if (items[i].quality > 0) {
                    items[i].quality = items[i].quality - 1
                }

                passDay(i)

                if (items[i].sellIn < 0) {
                    if (items[i].quality > 0) {
                        items[i].quality = items[i].quality - 1
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

    private fun passDay(i: Int) {
        items[i].sellIn = items[i].sellIn - 1
    }

    private fun `Backstage passes to a TAFKAL80ETC concert`(i: Int) {
        qualityIncreasesWithDateRule(i)

        passDay(i)

        qualityIsZeroWhenSellInDatePassedRule(i)
    }

    private fun `Aged Brie`(i: Int) {
        if (qualityIsLessthanFifty(i)) {
            items[i].quality = items[i].quality + 1
        }

        passDay(i)

        if (items[i].sellIn < 0) {
            if (qualityIsLessthanFifty(i)) {
                items[i].quality = items[i].quality + 1
            }
        }
    }

}

