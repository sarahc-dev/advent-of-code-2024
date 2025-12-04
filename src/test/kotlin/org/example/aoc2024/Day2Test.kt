package org.example.aoc2024

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day2Test {
    @Test
    fun `Part 1 - sample`() {
        assertEquals(2, Day2(sampleInput).part1())
    }

    @Test
    fun `Part 1 - puzzle input`() {
        assertEquals(257, Day2(puzzleInput).part1())
    }

    @Test
    fun `Part 2 - sample`() {
        assertEquals(4, Day2(sampleInput).part2())
    }

    @Test
    fun `Part 2 - puzzle input`() {
        assertEquals(328, Day2(puzzleInput).part2())
    }

    private val sampleInput = """
         7 6 4 2 1
         1 2 7 8 9
         9 7 6 2 1
         1 3 2 4 5
         8 6 4 4 1
         1 3 6 7 9
        """.trimIndent()

    private val puzzleInput = ClassLoader.getSystemResource("25Day2Input.txt").readText()
}