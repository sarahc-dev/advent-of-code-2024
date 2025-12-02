package org.example.aoc2024

class Day7(input: String) {
    private val equations = input.split("\n").map { line -> line.split(": ") }.map { values ->
        Pair(values[0].toLong(), values[1].split(" ").map { it.toInt() })
    }

    fun part1(): Long {
        var result: Long = 0
        for (line in equations) {
            if (isConfiguration(line)) result += line.first
        }
        return result
    }

    fun part2(): Long {
        val operators = listOf('*', '+', '|')
        var result: Long = 0
        for (line in equations) {
            if (isConfiguration(line, operators)) result += line.first
        }
        return result
    }

    private fun isConfiguration(pair: Pair<Long, List<Int>>, operators: List<Char> = listOf('*', '+')): Boolean {
        for (combination in generateOperatorCombinations(pair.second.size - 1, operators)) {
            var result = pair.second[0].toLong()
            for (x in combination.indices) {
                when (combination[x]) {
                    '*' -> result *= pair.second[x + 1]
                    '+' -> result += pair.second[x + 1]
                    else -> result = "$result${pair.second[x + 1]}".toLong()
                }
            }
            if (result == pair.first) return true
        }
        return false
    }

    private fun generateOperatorCombinations(size: Int, operators: List<Char>): List<List<Char>> {
        return operators.flatMap { operator ->
            if (size == 1) {
                listOf(listOf(operator))
            } else {
                generateOperatorCombinations(size - 1, operators).map { listOf(operator) + it }
            }
        }
    }
}