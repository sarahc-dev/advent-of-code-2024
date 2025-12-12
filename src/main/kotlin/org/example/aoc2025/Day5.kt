package org.example.aoc2025

class Day5(input: String) {
    val inputList = input.split("\n")

    fun part1(): Int {
        var freshCount = 0
        val (ids, ingredients) = inputList.partition { it.contains("-") }
        val idRange = ids.map { id -> id.split("-") }.map { it[0].toLong()..it[1].toLong() }

        ingredients
            .filter { it != "" }
            .map { it.toLong() }
            .forEach { ingredient ->
                if (idRange.any { ingredient in it }) freshCount++
            }
        return freshCount
    }

    fun part2(): Long {
        val ranges = inputList
            .filter { it.contains("-") }
            .map {
                val (start, end) = it.split("-")
                start.toLong() to end.toLong()
            }
            .sortedBy { it.first }
            .toMutableList()

        val merged = mutableListOf<Pair<Long, Long>>()

        for ((start, end) in ranges) {
            if (merged.isEmpty() || merged.last().second < start - 1) {
                // no overlap, add new range
                merged.add(start to end)
            } else {
                // overlap, merge with last range
                val last = merged.last()
                merged[merged.size - 1] = last.first to maxOf(last.second, end)
            }
        }

        return merged.sumOf { it.second - it.first + 1 }
    }
}