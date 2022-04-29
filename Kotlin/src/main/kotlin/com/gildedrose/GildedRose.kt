package com.gildedrose


class GildedRose(var items: Array<Item>) {

    private val BACK_STAGE_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert"
    private val AGED_BRIE = "Aged Brie"
    private val SULFURAS = "Sulfuras, Hand of Ragnaros"


    fun updateQuality() {
        for (i in items.indices) {
            when (items[i].name) {
                BACK_STAGE_TO_A_TAFKAL80ETC_CONCERT -> `Backstage passes to a TAFKAL80ETC concert`(i)
                AGED_BRIE -> `Aged Brie`(i)
                SULFURAS -> `Sulfuras`(i)
                else -> regularItems(i)
            }
        }
    }
    
    private fun backstagePassesHypeRule(i: Int) {
        singleIncreaseQuality(i)

        if (items[i].sellIn < 11) {
            singleIncreaseQuality(i)
        }

        if (items[i].sellIn < 6) {
            singleIncreaseQuality(i)
        }
    }

    private fun qualityIsLessthanFifty(i: Int) = items[i].quality < 50

    private fun qualityIsZeroWhenSellInDatePassedRule(i: Int) {
        if (items[i].sellIn < 0) {
            items[i].quality = 0
        }
    }

    private fun passDay(i: Int) {
        items[i].sellIn = items[i].sellIn - 1
    }

    private fun singleIncreaseQuality(i: Int) {
        if (qualityIsLessthanFifty(i)) {
            items[i].quality = items[i].quality + 1
        }
    }

    private fun singleDecreaseQuality(i: Int) {
        if (items[i].quality > 0) {
            items[i].quality = items[i].quality - 1
        }
    }

    private fun `Backstage passes to a TAFKAL80ETC concert`(i: Int) {
        backstagePassesHypeRule(i)

        passDay(i)

        qualityIsZeroWhenSellInDatePassedRule(i)
    }

    private

    private fun `Aged Brie`(i: Int) {
        singleIncreaseQuality(i)

        passDay(i)

        if (items[i].sellIn < 0) {
            singleIncreaseQuality(i)
        }
    }

    private fun `Sulfuras`(i: Int) {

    }

    private fun regularItems(i: Int) {
        singleDecreaseQuality(i)

        passDay(i)

        if (items[i].sellIn < 0) {
            singleDecreaseQuality(i)
        }
    }

}

