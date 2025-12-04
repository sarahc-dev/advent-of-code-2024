package org.example.aoc2024

class Day9(val input: String) {
    fun part1(): Long {
        val list = createList()
        while (list.contains(".")) {
            list[list.indexOf(".")] = list[list.lastIndex]
            list.removeAt(list.lastIndex)
        }

        var checksum: Long = 0
        list.forEachIndexed { index, n ->
            checksum += index * n.toInt()
        }
        return checksum
    }

    fun part2(): Long {
        val list = createList()
        for (num in list[list.lastIndex].toInt() downTo 0) {
            val countNum = list.count { it == num.toString() }
            val numIndex = list.indexOf(num.toString())
            val spaceIndex = list.windowed(countNum).indexOf(List(countNum) { "." })
            if (spaceIndex != -1 && spaceIndex < numIndex) {
                for (pos in spaceIndex..<spaceIndex + countNum) {
                    list[pos] = num.toString()
                }
                for (pos in numIndex..<numIndex + countNum) {
                    list[pos] = "."
                }
            }
        }

        var checksum: Long = 0
        list.forEachIndexed { index, n ->
            if (n != ".") checksum += index * n.toInt()
        }
        return checksum
    }

    private fun createList(): MutableList<String> {
        val list = mutableListOf<String>()
        for ((index, char) in input.withIndex()) {
            if (index % 2 == 0) {
                for (num in 1..char.digitToInt()) list.add("${index / 2}")
            } else {
                for (num in 1..char.digitToInt()) list.add(".")
            }
        }
        return list
    }
}