package org.example.aoc2024

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day5Test {
    @Test
    fun `Part 1 - sample`() {
        assertEquals(143, Day5(sampleInput).part1())
    }

    @Test
    fun `Part 1 - puzzle input`() {
        assertEquals(5732, Day5(puzzleInput).part1())
    }

    @Test
    fun `Part 2 - sample`() {
        assertEquals(123, Day5(sampleInput).part2())
    }

    @Test
    fun `Part 2 - puzzle input`() {
        assertEquals(4716, Day5(puzzleInput).part2())
    }

    private val sampleInput = """
        47|53
        97|13
        97|61
        97|47
        75|29
        61|13
        75|53
        29|13
        97|29
        53|29
        61|53
        97|53
        61|29
        47|13
        75|47
        97|75
        47|61
        75|61
        47|29
        75|13
        53|13

        75,47,61,53,29
        97,61,53,29,13
        75,29,13
        75,97,47,61,53
        61,13,29
        97,13,75,29,47
        """.trimIndent()

    private val puzzleInput = ClassLoader.getSystemResource("Day5Input.txt").readText()
}