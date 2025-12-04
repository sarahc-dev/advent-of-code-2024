package org.example.aoc2024

import kotlin.math.abs

class Day1(input: String) {
    private val numberList = input.split(Regex("\\s+")).map { it.toInt() }
    private val leftList = numberList.filterIndexed { index, _ -> index % 2 == 0 }.sorted()
    private val rightList = numberList.filterIndexed { index, _ -> index % 2 != 0 }.sorted()

    fun part1(): Int {
        return (leftList zip rightList).sumOf { (a, b) -> abs(a - b) }
    }

    fun part2(): Int {
        return leftList.fold(0) { acc, leftNum ->
                acc + leftNum * rightList.count { rightNum -> rightNum == leftNum }
            }
    }
}