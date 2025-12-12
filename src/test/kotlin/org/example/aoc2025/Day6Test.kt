package org.example.aoc2025

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day6Test {
    @Test
    fun `Part 1 - sample`() {
        assertEquals(4277556, Day6(sampleInput).part1())
    }

    @Test
    fun `Part 1 - puzzle input`() {
        assertEquals(6100348226985, Day6(puzzleInput).part1())
    }

    @Test
    fun `Part 2 - sample`() {
        assertEquals(3263827, Day6(sampleInput).part2())
    }

    @Test
    fun `Part 2 - puzzle input`() {
        assertEquals(12377473011151, Day6(puzzleInput).part2())
    }

    private val sampleInput = """
        123 328  51 64 
         45 64  387 23 
          6 98  215 314
        *   +   *   +  
    """.trimIndent()

    private val puzzleInput = ClassLoader.getSystemResource("25Day6Input.txt").readText()
}