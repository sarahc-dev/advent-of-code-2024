package org.example.aoc2024

class Day5(val input: String) {
    private val splitInput = input.split("\n\n")
    private val rules = splitInput[0].split("\n").map { rule -> rule.split("|").map { it.toInt() }.let { it[0] to it[1] } }
    private val updates = splitInput[1].split("\n").map { update -> update.split(",").map { it.toInt() } }

    fun part1(): Int {
        var count = 0
        for (update in updates) {
            val filteredRules = rules.filter { it.first in update && it.second in update }
            if (filteredRules.all { update.indexOf(it.first) < update.indexOf(it.second) }) {
                count += update[update.size / 2]
            }
        }
        return count
    }

    fun part2(): Int {
        var count = 0
        for (update in updates) {
            val filteredRules = rules.filter { it.first in update && it.second in update }
            if (!filteredRules.all { update.indexOf(it.first) < update.indexOf(it.second) }) {
                val mutable = update.toMutableList()
                while (!filteredRules.all { mutable.indexOf(it.first) < mutable.indexOf(it.second) }) {
                    filteredRules.forEach {
                        val firstIndex = mutable.indexOf(it.first)
                        val secondIndex = mutable.indexOf(it.second)
                        if (firstIndex > secondIndex) {
                            val temp = mutable[firstIndex]
                            mutable[firstIndex] = mutable[secondIndex]
                            mutable[secondIndex] = temp
                        }
                    }
                }
                count += mutable[mutable.size / 2]
            }
        }
        return count
    }
}