package org.example.aoc2024

class Day11(input: String) {
    private val inputList = input.split(" ")

    fun part1(times: Int): Int {
        var result = inputList
        repeat(times) {
            result = blink(result)
        }
        return result.count()
    }

    fun part2(times: Int): Long {
        var inputAsCounts = inputList.groupingBy { it }.eachCount().mapValues { it.value.toLong() }
        repeat(times) {
            inputAsCounts = blinkWithCounts(inputAsCounts)
        }
        return inputAsCounts.values.sum()
    }

    private fun blink(input: List<String>): List<String> {
        val list = mutableListOf<String>()
        input.forEach { num -> list.addAll(rules(num)) }
        return list
    }

    private fun blinkWithCounts(input: Map<String, Long>): Map<String, Long> {
        val result = mutableMapOf<String, Long>()
        input.forEach {
            rules(it.key).forEach { stone ->
                result[stone] = result.getOrDefault(stone, 0) + it.value
            }
        }
        return result
    }

    private fun rules(num: String): List<String> =
        when {
            num == "0" -> listOf("1")
            num.length % 2 == 0 -> {
                val index = num.length / 2
                listOf(num.take(index), num.substring(index).toInt().toString())
            }
            else -> listOf((num.toLong() * 2024).toString())
        }
}