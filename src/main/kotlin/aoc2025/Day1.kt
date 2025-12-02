package org.example.aoc2025

class Day1(input: String) {
    private val inputList = input.split("\n")

    fun part1(): Int {
        var dial = 50
        var countOf0 = 0

        inputList.forEach { input ->
            dial = calculateNextDial(dial, input.first(), input.drop(1).toInt())
            if (dial == 0) countOf0++
        }

        return countOf0
    }

    fun part2(): Int {
        var dial = 50
        var countOf0 = 0

        inputList.forEach { input ->
            val (newDial, count) = calculateNextDialAndRotations(dial, input.first(), input.drop(1).toInt())
            dial = newDial
            countOf0 += count
        }
        return countOf0
    }

    private fun calculateNextDial(start: Int, direction: Char, turn: Int): Int {
        val remainder = turn % 100
        return when (direction) {
            'L' -> if (start - remainder < 0) 100 - (remainder - start) else start - remainder
            else -> {
                if (start + remainder == 100) 0
                else if (start + remainder > 100) remainder - (100 - start)
                else start + remainder
            }
        }
    }

    private fun calculateNextDialAndRotations(start: Int, direction: Char, turn: Int): Pair<Int, Int> {
        var count = turn / 100
        val remainder = turn % 100
        return when (direction) {
            'L' -> {
                if (start - remainder == 0) 0 to ++count
                else if (start - remainder < 0) {
                    if (start == 0) return 100 - remainder to count
                    else 100 - (remainder - start) to ++count
                } else start - remainder to count
            }
            else -> {
                if (start + remainder == 100) 0 to ++count
                else if (start + remainder > 100) remainder - (100 - start) to ++count
                else start + remainder to count
            }
        }
    }
}