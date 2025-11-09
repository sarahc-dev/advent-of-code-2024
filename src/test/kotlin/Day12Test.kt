import org.example.Day12
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day12Test {
    @Test
    fun `Part 1 - sample`() {
        assertEquals(1930, Day12(sampleInput).part1())
    }

    @Test
    fun `Part 1 - puzzle input`() {
        assertEquals(1352976, Day12(puzzleInput).part1())
    }

    @Test
    fun `Part 2 - sample`() {
        assertEquals(1206, Day12(sampleInput).part2())
    }

    @Test
    fun `Part 2 - another sample`() {
        assertEquals(368, Day12(anotherSample).part2())
    }

    @Test
    fun `Part 2 - puzzle input`() {
        assertEquals(808796, Day12(puzzleInput).part2())
    }

    private val sampleInput = """
        RRRRIICCFF
        RRRRIICCCF
        VVRRRCCFFF
        VVRCCCJFFF
        VVVVCJJCFE
        VVIVCCJJEE
        VVIIICJJEE
        MIIIIIJJEE
        MIIISIJEEE
        MMMISSJEEE
    """.trimIndent()

    private val anotherSample = """
        AAAAAA
        AAABBA
        AAABBA
        ABBAAA
        ABBAAA
        AAAAAA
    """.trimIndent()

    private val puzzleInput = ClassLoader.getSystemResource("Day12Input.txt").readText()
}