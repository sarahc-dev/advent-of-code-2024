package org.example.aoc2024

class Day8(input: String) {
    private val grid = input.split("\n")
    fun part1(): Int {
        val antinodes: MutableList<Pair<Int, Int>> = mutableListOf()

        val antennas: MutableMap<Char, MutableList<Pair<Int, Int>>> = mutableMapOf()
        grid.forEachIndexed { index, row ->
            row.forEachIndexed { col, char ->
                if (char != '.') antennas.getOrPut(char) { mutableListOf() }.add(Pair(index, col))
            }
        }

        antennas.keys.forEach { key ->
            if (antennas[key]!!.size > 1) {
            val combinations = antennas[key]?.let { generateCombinations(it.toList()) }
            combinations?.forEach {
                val rowDiff = it.second.first - it.first.first
                val colDiff = it.second.second - it.first.second
                antinodes.add(Pair(it.first.first - rowDiff, it.first.second - colDiff))
                antinodes.add(Pair(it.second.first + rowDiff, it.second.second + colDiff))
            }
            }
        }
        return antinodes.toSet().filter { it.first in grid.indices && it.second in grid[0].indices }.size
    }

    fun part2(): Int {
        val antinodes: MutableList<Pair<Int, Int>> = mutableListOf()

        val antennas: MutableMap<Char, MutableList<Pair<Int, Int>>> = mutableMapOf()
        grid.forEachIndexed { index, row ->
            row.forEachIndexed { col, char ->
                if (char != '.') {
                    antennas.getOrPut(char) { mutableListOf() }.add(Pair(index, col))
                    antinodes.add(Pair(index, col))
                }
            }
        }

        antennas.keys.forEach { key ->
            if (antennas[key]!!.size > 1) {
                val combinations = antennas[key]?.let { generateCombinations(it.toList()) }
                combinations?.forEach {
                    val rowDiff = it.second.first - it.first.first
                    val colDiff = it.second.second - it.first.second
                    var left = Pair(it.first.first - rowDiff, it.first.second - colDiff)
                    var right = Pair(it.second.first + rowDiff, it.second.second + colDiff)

                    while (left.first in grid.indices && left.second in grid[0].indices) {
                        antinodes.add(left)
                        left = Pair(left.first - rowDiff, left.second - colDiff)
                    }
                    while (right.first in grid.indices && right.second in grid[0].indices) {
                        antinodes.add(right)
                        right = Pair(right.first + rowDiff, right.second + colDiff)
                    }
                }
            }
        }
        return antinodes.toSet().size
    }

    private fun generateCombinations(antennas: List<Pair<Int, Int>>): List<Pair<Pair<Int, Int>, Pair<Int, Int>>> {
        return antennas.flatMapIndexed { index, firstPair ->
            antennas.drop(index + 1).map { secondPair -> firstPair to secondPair }
        }
    }
}