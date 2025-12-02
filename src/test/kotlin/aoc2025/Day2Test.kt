package aoc2025

import org.example.aoc2025.Day2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day2Test {
    @Test
    fun `Part 1 - sample`() {
        assertEquals(1227775554, Day2(sampleInput).part1())
    }

    @Test
    fun `Part 1 - puzzle input`() {
        assertEquals(19386344315, Day2(puzzleInput).part1())
    }

    @Test
    fun `Part 2 - sample`() {
        assertEquals(4174379265, Day2(sampleInput).part2())
    }

    @Test
    fun `Part 2 - puzzle input`() {
        assertEquals(34421651192, Day2(puzzleInput).part2())
    }

    private val sampleInput = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124".trimIndent()

    private val puzzleInput = ClassLoader.getSystemResource("25Day2Input.txt").readText()

}