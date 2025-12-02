package aoc2024

import org.example.aoc2024.Day9
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day9Test {
    @Test
    fun `Part 1 - sample`() {
        assertEquals(1928, Day9(sampleInput).part1())
    }

    @Test
    fun `Part 1 - puzzle input`() {
        assertEquals(6307275788409, Day9(puzzleInput).part1())
    }

    @Test
    fun `Part 2 - sample`() {
        assertEquals(2858, Day9(sampleInput).part2())
    }

    @Test
    fun `Part 2 - puzzle input`() {
        assertEquals(6327174563252, Day9(puzzleInput).part2())
    }

    private val sampleInput = "2333133121414131402".trimIndent()

    private val puzzleInput = ClassLoader.getSystemResource("Day9Input.txt").readText()
}