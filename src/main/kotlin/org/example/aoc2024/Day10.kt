package org.example.aoc2024

class Day10(input: String) {
    private val map = input.lines()

    fun part1(): Int {
        var total = 0
        for ((index, row) in map.withIndex()) {
            for ((col, num) in row.withIndex()) {
                if (num == '0') total += getScore(Pair(index, col))
            }
        }
        return total
    }

    fun part2(): Int {
        var total = 0
        for ((index, row) in map.withIndex()) {
            for ((col, num) in row.withIndex()) {
                if (num == '0') total += getRating(Pair(index, col))
            }
        }
        return total
    }

    private fun getScore(start: Pair<Int, Int>): Int {
        val trail: MutableList<MutableSet<Pair<Int,Int>>> = mutableListOf(mutableSetOf(start))
        for (num in 0..9) {
            val set: MutableSet<Pair<Int,Int>> = mutableSetOf()
            trail[num].forEach { set.addAll(getNext(num, it)) }
            if (set.isEmpty()) break else trail.add(set)
        }
        return if (trail.size == 10) trail[9].size else 0
    }

    private fun getRating(start: Pair<Int, Int>): Int {
        val trails = mutableListOf(mutableListOf(start))
        var num = 0
        while (num < 10) {
            val temp = mutableListOf<MutableList<Pair<Int,Int>>>()
            trails.forEach { trail ->
                if (trail.size == num + 1) {
                    val next = getNext(num, trail[trail.lastIndex])

                    for (i in next.indices.reversed()) {
                        if (i == 0) trail.add(next[i])
                        else temp.add((trail + next[i]).toMutableList())
                    }
                }
            }
            trails.addAll(temp)
            num++
        }
        return trails.count { it.size == 10 }
    }

    private fun getNext(num: Int, pos: Pair<Int,Int>): MutableList<Pair<Int, Int>> {
        val next = '0' + num + 1
        val list: MutableList<Pair<Int, Int>> = mutableListOf()
        if (pos.first - 1 in map.indices && map[pos.first - 1][pos.second] == next) list.add(Pair(pos.first - 1, pos.second))
        if (pos.first + 1 in map.indices && map[pos.first + 1][pos.second] == next) list.add(Pair(pos.first + 1, pos.second))
        if (pos.second - 1 in map[0].indices && map[pos.first][pos.second - 1] == next) list.add(Pair(pos.first, pos.second - 1))
        if (pos.second + 1 in map[0].indices && map[pos.first][pos.second + 1] == next) list.add(Pair(pos.first, pos.second + 1))
        return list
    }
}