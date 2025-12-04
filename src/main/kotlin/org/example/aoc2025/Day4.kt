package org.example.aoc2025

class Day4(input: String) {
    private val grid = input.split("\n")
    private val rows = grid.size
    private val cols = grid[0].length
    private val directions = listOf(-1 to -1, -1 to 0, -1 to 1, 0 to -1, 0 to 1, 1 to -1, 1 to 0, 1 to 1)

    fun part1(): Int {
        var result = 0
        for (rowIndex in 0 until rows) {
            for (colIndex in 0 until cols) {
                if (grid[rowIndex][colIndex] == '@') {
                    val position = rowIndex to colIndex
                    if (position.isAccessible(grid)) result++
                }
            }
        }
        return result
    }

    fun part2(): Int {
        val removable = grid.toMutableList()
        var result = 0
        var canContinue = true

        while (canContinue) {
            val removed = conductRemoval(removable)
            result += removed
            if (removed == 0) canContinue = false
        }
        return result
    }

    private fun Pair<Int, Int>.isAccessible(grid: List<String>): Boolean {
        var count = 0
        for ((dr, dc) in directions) {
            val positionToCheck = this.first + dr to this.second + dc
            if (positionToCheck.first in 0..<rows && positionToCheck.second in 0..<cols) {
                if (grid[positionToCheck.first][positionToCheck.second] == '@') count++
            }
        }
        return count < 4
    }

    private fun conductRemoval(removableGrid: MutableList<String>): Int {
        val toBeRemoved = mutableListOf<Pair<Int, Int>>()
        for (rowIndex in 0 until rows) {
            for (colIndex in 0 until cols) {
                if (removableGrid[rowIndex][colIndex] == '@') {
                    val position = rowIndex to colIndex
                    if (position.isAccessible(removableGrid)) toBeRemoved.add(position)
                }
            }
        }
        for (roll in toBeRemoved) {
            val newRow = removableGrid[roll.first].replaceRange(roll.second, roll.second + 1, "x")
            removableGrid[roll.first] = newRow
        }
        return toBeRemoved.size
    }
}