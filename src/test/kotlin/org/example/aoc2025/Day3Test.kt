package org.example.aoc2025

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day3Test {
    @Test
    fun `Part 1 - sample`() {
        assertEquals(357, Day3(sampleInput).part1())
    }

    @Test
    fun `Part 1 - puzzle input`() {
        assertEquals(17166, Day3(puzzleInput).part1())
    }

    @Test
    fun `Part 2 - sample`() {
        assertEquals(3121910778619, Day3(sampleInput).part2())
    }

    @Test
    fun `Part 2 - puzzle input`() {
        assertEquals(169077317650774, Day3(puzzleInput).part2())
    }

    private val sampleInput = """
        987654321111111
        811111111111119
        234234234234278
        818181911112111
    """.trimIndent()

    private val puzzleInput = ClassLoader.getSystemResource("25Day3Input.txt").readText()
}