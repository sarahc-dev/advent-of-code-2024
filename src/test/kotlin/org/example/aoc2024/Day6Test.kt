package org.example.aoc2024

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day6Test {
    @Test
    fun `Part 1 - sample`() {
        assertEquals(41, Day6(sampleInput).part1())
    }

    @Test
    fun `Part 1 - puzzle input`() {
        assertEquals(5329, Day6(puzzleInput).part1())
    }

    @Test
    fun `Part 2 - sample`() {
        assertEquals(6, Day6(sampleInput).part2())
    }

    @Test
    fun `Part 2 - puzzle input`() {
        assertEquals(2162, Day6(puzzleInput).part2())
    }

    private val sampleInput = """
        ....#.....
        .........#
        ..........
        ..#.......
        .......#..
        ..........
        .#..^.....
        ........#.
        #.........
        ......#...
        """.trimIndent()

    private val puzzleInput = ClassLoader.getSystemResource("Day6Input.txt").readText()
}