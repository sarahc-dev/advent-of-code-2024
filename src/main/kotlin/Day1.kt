package org.example

import kotlin.math.absoluteValue

class Day1(input: String) {
    private val numsOnly = input.split(Regex("\\s+")).map { it.toInt() }
    private val leftList = numsOnly.filterIndexed { index, _ -> index % 2 == 0 }.sorted()
    private val rightList = numsOnly.filterIndexed { index, _ -> index % 2 != 0 }.sorted()

    fun part1(): Int {
        return leftList.mapIndexed { index, num -> (num - rightList[index]).absoluteValue }.sum()
    }

    fun part2(): Int {
        return leftList.sumOf { leftNum ->
            leftNum * rightList.filter { rightNum -> rightNum == leftNum }.size
        }
    }
}