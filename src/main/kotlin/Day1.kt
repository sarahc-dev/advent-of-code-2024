package org.example

import kotlin.math.abs

class Day1(input: String) {
    private val numberList = input.split(Regex("\\s+")).map { it.toInt() }
    private val partitioned = numberList.withIndex().partition { it.index % 2 == 0 }

    fun part1(): Int {
        return partitioned.let { (leftList, rightList) ->
            leftList.map { it.value }.sorted() zip rightList.map { it.value }.sorted()
        }.sumOf { (a, b) -> abs(a - b) }
    }

    fun part2(): Int {
        return partitioned.first.map { it.value }
            .fold(0) { acc, leftNum ->
                acc + leftNum * partitioned.second.map { it.value }.count { rightNum -> rightNum == leftNum }
            }
    }
}