package com.gildedrose

import com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut
import java.nio.file.Files
import java.nio.file.Paths
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun outputIsGoldenMaster() {
        val goldenMaster = String(Files.readAllBytes(Paths.get("src/test/resources/fixture_100_days.txt")))
        val output = tapSystemOut  {
            main(emptyArray())
        }

        assertEquals(goldenMaster, output);
    }

}


