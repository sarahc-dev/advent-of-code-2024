package org.example.aoc2025

class Day6(val input: String) {
    fun part1(): Long {
        val rows = input.split("\n").map { it.trim().split(Regex("\\s+")) }
        var result = 0L
        val (numbers, operators) = rows.dropLast(1) to rows.last()
        for (idx in 0..<rows[0].size) {
            val column = numbers.map { it[idx].toLong() }
            result += calculate(column, operators[idx])
        }
        return result
    }

    fun part2(): Long {
        val rows = input.split("\n")
        var result = 0L
        val numbers = rows.dropLast(1)
        var operators = rows.last().filterNot { it.isWhitespace() }

        var position = numbers[0].length - 1
        val toCalculate = mutableListOf<Long>()
        while (position >= 0) {
            if (numbers.all { it[position] == ' ' }) {
                result += calculate(toCalculate, operators.takeLast(1))
                toCalculate.clear()
                operators = operators.dropLast(1)
                position--
                continue
            }

            toCalculate.add(numbers.map { it[position] }.joinToString("").trim().toLong())

            if (position == 0) {
                result += calculate(toCalculate, operators.takeLast(1))
            }

            position--
        }
        return result
    }

    private fun add(nums: List<Long>) = nums.reduce { acc, num -> acc + num }
    private fun multiply(nums: List<Long>) = nums.reduce { acc, num -> acc * num }
    private fun calculate(nums: List<Long>, operator: String): Long = when (operator) {
        "*" -> multiply(nums)
        else -> add(nums)
    }
}