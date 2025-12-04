package org.example.aoc2025

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1Test {
    @Test
    fun `Part 1 - sample`() {
        assertEquals(3, Day1(sampleInput).part1())
    }

    @Test
    fun `Part 1 - puzzle input`() {
        assertEquals(1011, Day1(puzzleInput).part1())
    }

    @Test
    fun `Part 2 - sample`() {
        assertEquals(6, Day1(sampleInput).part2())
    }

    @Test
    fun `Part 2 - puzzle input`() {
        assertEquals(5937, Day1(puzzleInput).part2())
    }

    private val sampleInput = """
        L68
        L30
        R48
        L5
        R60
        L55
        L1
        L99
        R14
        L82
    """.trimIndent()

    private val puzzleInput = ClassLoader.getSystemResource("25Day1Input.txt").readText()

}