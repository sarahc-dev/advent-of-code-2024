package org.example.aoc2024

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day4Test {
    @Test
    fun `Part 1 - sample`() {
        assertEquals(18, Day4(sampleInput).part1())
    }

    @Test
    fun `Part 1 - puzzle input`() {
        assertEquals(2370, Day4(puzzleInput).part1())
    }

    @Test
    fun `Part 2 - sample`() {
        assertEquals(9, Day4(sampleInput).part2())
    }

    @Test
    fun `Part 2 - puzzle input`() {
        assertEquals(1908, Day4(puzzleInput).part2())
    }

    private val sampleInput = """
        MMMSXXMASM
        MSAMXMSMSA
        AMXSXMAAMM
        MSAMASMSMX
        XMASAMXAMM
        XXAMMXXAMA
        SMSMSASXSS
        SAXAMASAAA
        MAMMMXMMMM
        MXMXAXMASX
        """.trimIndent()

    private val puzzleInput = ClassLoader.getSystemResource("Day4Input.txt").readText()
}