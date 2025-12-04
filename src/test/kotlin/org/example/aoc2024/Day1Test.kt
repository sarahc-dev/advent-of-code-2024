package org.example.aoc2024

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1Test {
    @Test
    fun `Part 1 - sample`() {
        assertEquals(11, Day1(sampleInput).part1())
    }

    @Test
    fun `Part 1 - puzzle input`() {
        assertEquals(1660292, Day1(puzzleInput).part1())
    }

    @Test
    fun `Part 2 - sample`() {
        assertEquals(31, Day1(sampleInput).part2())
    }

    @Test
    fun `Part 2 - puzzle input`() {
        assertEquals(22776016, Day1(puzzleInput).part2())
    }

    private val sampleInput = """
            3   4
            4   3
            2   5
            1   3
            3   9
            3   3
        """.trimIndent()

    private val puzzleInput = ClassLoader.getSystemResource("25Day1Input.txt").readText()
}