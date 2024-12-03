package org.example

class Day3(private val input: String) {
    fun part1(): Int {
        val instructions = Regex("mul\\((\\d+,\\d+)\\)").findAll(input).map { it.groupValues[1].split(",") }
        return instructions.sumOf { it[0].toInt() * it[1].toInt() }
    }

    fun part2(): Int {
        val instructions = Regex("mul\\(\\d+,\\d+\\)|don't\\(\\)|do\\(\\)").findAll(input)
        var accept = true
        var result = 0

        instructions.forEach { instruction ->
            when (instruction.value) {
                "do()" -> accept = true
                "don't()" -> accept = false
                else -> {
                    if (accept) {
                        val nums = Regex("\\d+,\\d+").find(instruction.value)!!.value.split(",").map { it.toInt() }
                        result += (nums[0] * nums[1])
                    }
                }
            }
        }

        return result
    }
}