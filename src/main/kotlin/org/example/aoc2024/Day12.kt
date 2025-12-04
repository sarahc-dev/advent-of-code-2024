package org.example.aoc2024

class Day12(input: String) {
    private val grid = input.split("\n")
    private val rows = grid.size
    private val cols = grid[0].length
    private val directions = listOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)

    fun part1(): Int {
        val calculated = mutableSetOf<Pair<Int, Int>>()
        var result = 0

        for (gridIndex in 0 until rows) {
            for (rowIndex in 0 until cols) {
                val position = gridIndex to rowIndex
                if (position !in calculated) {
                    val (area, region) = calculateRegion(position)
                    result += area
                    calculated.addAll(region)
                }
            }
        }
        return result
    }

    fun part2(): Int {
        val calculated = mutableSetOf<Pair<Int, Int>>()
        var result = 0

        for (gridIndex in 0 until rows) {
            for (rowIndex in 0 until cols) {
                val position = gridIndex to rowIndex
                if (position !in calculated) {
                    val (area, region) = calculateRegionWithSides(position)
                    result += area
                    calculated.addAll(region)
                }
            }
        }
        return result
    }

    private fun calculateRegion(position: Pair<Int, Int>): Pair<Int, List<Pair<Int, Int>>> {
        // BFS explores level by level using a queue (First in, first out)
        val region = mutableListOf(position)
        val queue = ArrayDeque(listOf(position)) // resizable double-ended queue - allows adding and removing elements from both front and back efficiently
        val char = grid[position.first][position.second]

        var perimeter = 0

        while (queue.isNotEmpty()) {
            val (gridIdx, rowIdx) = queue.removeFirst()

            // check all neighbours
            for ((dr, dc) in directions) {
                val nextPosition = gridIdx + dr to rowIdx + dc

                // next position is out of bounds or not in same group
                if (nextPosition.first < 0 || nextPosition.second < 0 || nextPosition.first >= rows || nextPosition.second >= cols || grid[nextPosition.first][nextPosition.second] != char) {
                    perimeter++
                // in same group - add area and add to queue
                } else if (nextPosition !in region) {
                        region.add(nextPosition)
                        queue.addLast(nextPosition)
                }
            }
        }
        return region.size * perimeter to region
    }

    private fun calculateRegionWithSides(position: Pair<Int, Int>): Pair<Int, List<Pair<Int, Int>>> {
        val queue = ArrayDeque(listOf(position))
        val char = grid[position.first][position.second]
        val region = mutableListOf(position)

        // calculate region
        while (queue.isNotEmpty()) {
            val firstPosition = queue.removeFirst()

            for (direction in directions) {
                val nextPosition = firstPosition.first + direction.first to firstPosition.second + direction.second

                if (nextPosition.first >= 0 && nextPosition.second >= 0 && nextPosition.first < rows && nextPosition.second < cols && grid[nextPosition.first][nextPosition.second] == char) {
                    if (nextPosition !in region) {
                        region.add(nextPosition)
                        queue.addLast(nextPosition)
                    }
                }
            }
        }

        // calculate corners from region list
        val corners = calculateCorners(region)

        return region.size * corners to region
    }

    private fun calculateCorners(region: List<Pair<Int, Int>>): Int {
        val cornerOffsets = listOf(
            // pair of leg offsets and diagonal offset)
            Pair( listOf(-1 to 0, 0 to -1),  -1 to -1 ),  // NW
            Pair( listOf(-1 to 0, 0 to 1),   -1 to 1  ),  // NE
            Pair( listOf(1 to 0, 0 to -1),   1 to -1  ),  // SW
            Pair( listOf(1 to 0, 0 to 1),    1 to 1   ),  // SE
        )

        var corners = 0

        for ((r, c) in region) {
            for ((legs, diagonalOffset) in cornerOffsets) {
                val (l1, l2) = legs
                val p1 = (r + l1.first) to (c + l1.second)
                val p2 = (r + l2.first) to (c + l2.second)
                val pd = (r + diagonalOffset.first) to (c + diagonalOffset.second)

                val in1 = p1 in region
                val in2 = p2 in region
                val inD = pd in region

                // outside corner
                if (!in1 && !in2) corners++
                // inside corner
                else if (in1 && in2 && !inD) corners++
            }
        }
        return corners
    }
}