package org.example.aoc2024

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day11Test {
    @Test
    fun `Part 1 - sample`() {
        assertEquals(22, Day11("125 17").part1(6))
        assertEquals(55312, Day11("125 17").part1(25))
    }

    @Test
    fun `Part 1 - puzzle input`() {
        assertEquals(194557, Day11(puzzleInput).part1(25))
    }

    @Test
    fun `Part 2 - sample`() {
        assertEquals(55312, Day11("125 17").part2(25))
    }

    @Test
    fun `Part 2 - puzzle input`() {
        assertEquals(231532558973909, Day11(puzzleInput).part2(75))
    }

    private val puzzleInput = ClassLoader.getSystemResource("24Day11Input.txt").readText()
}