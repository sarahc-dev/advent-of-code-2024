package org.example.aoc2024

class Day2(input: String) {
    private val reports = input.split("\n").map { report -> report.split(" ").map { it.toInt()} }
    fun part1(): Int {
        return reports.count {
            isSafe(it)
        }
    }
    fun part2(): Int {
        var count = 0
        for (report in reports) {
            if (isSafe(report)) {
                count++
            } else {
                for (i in 0..report.size) {
                    if (isSafe(report.filterIndexed { index, _ -> index != i })) {
                        count++
                        break
                    }
                }
            }
        }
        return count
    }

     private fun isSafe(report: List<Int>): Boolean {
         return report.withIndex().all { it.index == 0 || it.value - report[it.index - 1] in 1..3} || report.withIndex().all { it.index == 0 || report[it.index - 1] - it.value in 1..3}
    }
}