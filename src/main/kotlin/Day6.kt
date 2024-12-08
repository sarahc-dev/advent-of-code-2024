package org.example

class Day6(val input: String) {
    private val grid = input.split("\n")

    fun part1(): Int {
        val positions: MutableList<Pair<Int,Int>> = mutableListOf()
        var direction = "UP"
        var inGrid = true

        grid.forEachIndexed { index, row -> if (row.contains('^')) positions.add(Pair(index, row.indexOf('^'))) }

        while (inGrid) {
            val next = next(direction, positions.last())
            if (next.first in grid.indices && next.second in grid[0].indices) {
                if (grid[next.first][next.second] != '#') {
                    positions.add(next)
                } else direction = turnRight(direction)
            } else inGrid = false
        }
        return positions.toSet().size
    }

    fun part2(): Int {
        var count = 0
        val firstPosition = grid.indexOfFirst { row -> row.contains('^') }.let { Pair(it, grid[it].indexOf('^')) }

        for ((index, row) in grid.withIndex()) {
            for ((column, char) in row.withIndex()) {
                val positions = mutableListOf(firstPosition)
                var direction = "UP"
                var inGrid = true
                if (char != '.') continue
                val testGrid: List<String> = grid.mapIndexed { i, r ->
                    if (i == index) {
                        r.mapIndexed { col, c ->
                            if (col == column && grid[index][column] == '.') '#' else c
                        }.joinToString("")
                    } else r
                }

                while (inGrid && positions.size < 10000) {
                    val next = next(direction, positions.last())
                    if (next.first in grid.indices && next.second in grid[0].indices) {
                        if (testGrid[next.first][next.second] != '#') {
                            positions.add(next)
                        } else direction = turnRight(direction)
                    } else inGrid = false
                }
                if (inGrid) count++
            }
        }
        return count
    }

    private fun next(direction: String, current: Pair<Int, Int>) = when (direction) {
            "UP" -> Pair(current.first - 1, current.second)
            "DOWN" -> Pair(current.first + 1, current.second)
            "RIGHT" -> Pair(current.first, current.second + 1)
            else -> Pair(current.first, current.second - 1)
    }

    private fun turnRight(direction: String) = when (direction) {
            "UP" -> "RIGHT"
            "RIGHT" -> "DOWN"
            "DOWN" -> "LEFT"
            else -> "UP"
    }
}