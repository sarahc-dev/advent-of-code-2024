package org.example.aoc2025

class Day2(input: String) {
    private val inputList = input.split(",")

    fun part1(): Long {
        var result: Long = 0
        inputList.forEach { id ->
            val (firstId, lastId) = id.split("-").map { it.toLong() }
            for (num in firstId..lastId) {
                result += checkValidId(num.toString())
            }
        }
        return result
    }

    fun part2(): Long {
        var result: Long = 0
        inputList.forEach { id ->
            val (firstId, lastId) = id.split("-").map { it.toLong() }
            for (num in firstId..lastId) {
                result += checkValidIdPart2(num.toString())
            }
        }
        return result
    }

    private fun checkValidId(id: String): Long {
        if (id.length % 2 != 0) return 0
        val midpoint = id.length / 2

        if (id.take(midpoint) == id.substring(midpoint)) return id.toLong()
        return 0
    }

    private fun checkValidIdPart2(id: String): Long {
        for (size in 1..id.length / 2) {
            if (id.windowed(size, size, true).all { it == id.take(size) }) return id.toLong()
        }
        return 0
    }
}