package com.gildedrose


class GildedRose(var items: Array<Item>) {

    private val BACK_STAGE_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert"
    private val AGED_BRIE = "Aged Brie"
    private val SULFURAS = "Sulfuras, Hand of Ragnaros"

    fun updateQuality() {
        for (i in items.indices) {
            val item = items[i]
            strategy(item.name)(item)
        }
    }

    private fun strategy(itemName: String): (Item) -> Unit = when (itemName) {
        BACK_STAGE_TO_A_TAFKAL80ETC_CONCERT -> ::backstagePassesTo_a_TAFKAL80ETC_concert
        AGED_BRIE -> ::agedBrie
        SULFURAS -> fun(_: Item) {}
        else -> ::regularItems
    }

    private fun backstagePassesHypeRule(item: Item) {
        singleIncreaseQuality(item)

        if (item.sellIn < 11) {
            singleIncreaseQuality(item)
        }

        if (item.sellIn < 6) {
            singleIncreaseQuality(item)
        }
    }

    private fun qualityIsLessThanFifty(item: Item) = item.quality < 50

    private fun qualityIsZeroWhenSellInDatePassedRule(item: Item) {
        if (item.sellIn < 0) {
            item.quality = 0
        }
    }

    private fun passDay(item: Item) {
        item.sellIn = item.sellIn - 1
    }

    private fun singleIncreaseQuality(item: Item) {
        if (qualityIsLessThanFifty(item)) {
            item.quality = item.quality + 1
        }
    }

    private fun singleDecreaseQuality(item: Item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1
        }
    }

    private fun backstagePassesTo_a_TAFKAL80ETC_concert(item: Item) {
        backstagePassesHypeRule(item)

        passDay(item)

        qualityIsZeroWhenSellInDatePassedRule(item)
    }

    private fun agedBrie(item: Item) {
        singleIncreaseQuality(item)

        passDay(item)

        if (item.sellIn < 0) {
            singleIncreaseQuality(item)
        }
    }

    private fun regularItems(item: Item) {
        singleDecreaseQuality(item)

        passDay(item)

        if (item.sellIn < 0) {
            singleDecreaseQuality(item)
        }
    }

}

