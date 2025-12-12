package org.example.aoc2025

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day5Test {
    @Test
    fun `Part 1 - sample`() {
        assertEquals(3, Day5(sampleInput).part1())
    }

    @Test
    fun `Part 1 - puzzle input`() {
        assertEquals(694, Day5(puzzleInput).part1())
    }

    @Test
    fun `Part 2 - sample`() {
        assertEquals(14, Day5(sampleInput).part2())
    }

    @Test
    fun `Part 2 - puzzle input`() {
        assertEquals(352716206375547, Day5(puzzleInput).part2())
    }

    private val sampleInput = """
        3-5
        10-14
        16-20
        12-18
        
        1
        5
        8
        11
        17
        32
    """.trimIndent()

    private val puzzleInput = ClassLoader.getSystemResource("25Day5Input.txt").readText()
}