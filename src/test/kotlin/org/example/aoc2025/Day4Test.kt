package org.example.aoc2025

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day4Test {
    @Test
    fun `Part 1 - sample`() {
        assertEquals(13, Day4(sampleInput).part1())
    }

    @Test
    fun `Part 1 - puzzle input`() {
        assertEquals(1518, Day4(puzzleInput).part1())
    }

    @Test
    fun `Part 2 - sample`() {
        assertEquals(43, Day4(sampleInput).part2())
    }

    @Test
    fun `Part 2 - puzzle input`() {
        assertEquals(8665, Day4(puzzleInput).part2())
    }

    private val sampleInput = """
        ..@@.@@@@.
        @@@.@.@.@@
        @@@@@.@.@@
        @.@@@@..@.
        @@.@@@@.@@
        .@@@@@@@.@
        .@.@.@.@@@
        @.@@@.@@@@
        .@@@@@@@@.
        @.@.@@@.@.
    """.trimIndent()

    private val puzzleInput = ClassLoader.getSystemResource("25Day4Input.txt").readText()
}