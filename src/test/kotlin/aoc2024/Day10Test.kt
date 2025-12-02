package aoc2024

import org.example.aoc2024.Day10
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day10Test {
    @Test
    fun `Part 1 - sample`() {
        assertEquals(36, Day10(sampleInput).part1())
    }

    @Test
    fun `Part 1 - puzzle input`() {
        assertEquals(607, Day10(puzzleInput).part1())
    }

    @Test
    fun `Part 2 - sample`() {
        assertEquals(81, Day10(sampleInput).part2())
    }

    @Test
    fun `Part 2 - puzzle input`() {
        assertEquals(1384, Day10(puzzleInput).part2())
    }

    private val sampleInput = """
        89010123
        78121874
        87430965
        96549874
        45678903
        32019012
        01329801
        10456732
    """.trimIndent()

    private val puzzleInput = ClassLoader.getSystemResource("Day10Input.txt").readText()
}