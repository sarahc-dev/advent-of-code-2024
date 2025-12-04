package org.example.aoc2025

class Day3(input: String) {
    private val inputList = input.split("\n")

    fun part1(): Int {
        var result = 0
        inputList.forEach { bank ->
            val first = bank.dropLast(1).max()
            val second = bank.substring(bank.indexOf(first) + 1).max()
            result += "$first$second".toInt()
        }
        return result
    }

    fun part2(): Long {
        var result: Long = 0
        inputList.forEach { bank ->
            result += getLargest(bank)
        }
        return result
    }

    private fun getLargest(bank: String): Long {
        val result = mutableListOf<Char>()
        var remaining = bank
        repeat(12) { index ->
                val next = remaining.dropLast(11 - index).max()
                result.add(next)
                remaining = remaining.substring(remaining.indexOf(next) + 1)
            }
        return result.joinToString("").toLong()
    }
}