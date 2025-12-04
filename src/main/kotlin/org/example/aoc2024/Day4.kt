package org.example.aoc2024

class Day4(input: String) {
    private val lines = input.split("\n")

    fun part1(): Int {
        var count = 0
        lines.forEachIndexed { i, line ->
            line.forEachIndexed { j, char ->
                if (char == 'X') {
                    if ("${lines.getOrNull(i)?.getOrNull(j + 1)}${
                            lines.getOrNull(i)?.getOrNull(j + 2)
                        }${lines.getOrNull(i)?.getOrNull(j + 3)}" == "MAS"
                    ) count++
                    if ("${lines.getOrNull(i)?.getOrNull(j - 1)}${
                            lines.getOrNull(i)?.getOrNull(j - 2)
                        }${lines.getOrNull(i)?.getOrNull(j - 3)}" == "MAS"
                    ) count++
                    if ("${lines.getOrNull(i + 1)?.getOrNull(j)}${
                            lines.getOrNull(i + 2)?.getOrNull(j)
                        }${lines.getOrNull(i + 3)?.getOrNull(j)}" == "MAS"
                    ) count++
                    if ("${lines.getOrNull(i - 1)?.getOrNull(j)}${
                            lines.getOrNull(i - 2)?.getOrNull(j)
                        }${lines.getOrNull(i - 3)?.getOrNull(j)}" == "MAS"
                    ) count++
                    if ("${lines.getOrNull(i + 1)?.getOrNull(j + 1)}${
                            lines.getOrNull(i + 2)?.getOrNull(j + 2)
                        }${lines.getOrNull(i + 3)?.getOrNull(j + 3)}" == "MAS"
                    ) count++
                    if ("${lines.getOrNull(i - 1)?.getOrNull(j - 1)}${
                            lines.getOrNull(i - 2)?.getOrNull(j - 2)
                        }${lines.getOrNull(i - 3)?.getOrNull(j - 3)}" == "MAS"
                    ) count++
                    if ("${lines.getOrNull(i - 1)?.getOrNull(j + 1)}${
                            lines.getOrNull(i - 2)?.getOrNull(j + 2)
                        }${lines.getOrNull(i - 3)?.getOrNull(j + 3)}" == "MAS"
                    ) count++
                    if ("${lines.getOrNull(i + 1)?.getOrNull(j - 1)}${
                            lines.getOrNull(i + 2)?.getOrNull(j - 2)
                        }${lines.getOrNull(i + 3)?.getOrNull(j - 3)}" == "MAS"
                    ) count++
                }
            }
        }
        return count
    }

    fun part2(): Int {
        var count = 0
        lines.forEachIndexed { i, line ->
            line.forEachIndexed { j, char ->
                if (char == 'A') {
                    if (
                        ((lines.getOrNull(i - 1)?.getOrNull(j - 1) == 'M' && lines.getOrNull(i + 1)
                            ?.getOrNull(j + 1) == 'S')
                                || (lines.getOrNull(i - 1)?.getOrNull(j - 1) == 'S' && lines.getOrNull(i + 1)
                            ?.getOrNull(j + 1) == 'M')) &&
                        ((lines.getOrNull(i - 1)?.getOrNull(j + 1) == 'M' && lines.getOrNull(i + 1)
                            ?.getOrNull(j - 1) == 'S')
                                || (lines.getOrNull(i - 1)?.getOrNull(j + 1) == 'S' && lines.getOrNull(i + 1)
                            ?.getOrNull(j - 1) == 'M'))
                    ) count++

                }
            }
        }
        return count
    }

}



