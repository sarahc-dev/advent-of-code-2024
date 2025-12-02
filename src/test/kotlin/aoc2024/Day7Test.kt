package aoc2024

import org.example.aoc2024.Day7
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day7Test {
    @Test
    fun `Part 1 - sample`() {
        assertEquals(3749, Day7(sampleInput).part1())
    }

    @Test
    fun `Part 1 - puzzle input`() {
        assertEquals(1582598718861, Day7(puzzleInput).part1())
    }

    @Test
    fun `Part 2 - sample`() {
        assertEquals(11387, Day7(sampleInput).part2())
    }

    @Test
    fun `Part 2 - puzzle input`() {
        assertEquals(165278151522644, Day7(puzzleInput).part2())
    }

    private val sampleInput = """
        190: 10 19
        3267: 81 40 27
        83: 17 5
        156: 15 6
        7290: 6 8 6 15
        161011: 16 10 13
        192: 17 8 14
        21037: 9 7 18 13
        292: 11 6 16 20
        """.trimIndent()

    private val puzzleInput = ClassLoader.getSystemResource("Day7Input.txt").readText()
}