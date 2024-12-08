import org.example.Day8
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day8Test {
    @Test
    fun `Part 1 - sample`() {
        assertEquals(14, Day8(sampleInput).part1())
    }

    @Test
    fun `Part 1 - puzzle input`() {
        assertEquals(261, Day8(puzzleInput).part1())
    }

    @Test
    fun `Part 2 - sample`() {
        assertEquals(34, Day8(sampleInput).part2())
    }

    @Test
    fun `Part 2 - puzzle input`() {
        assertEquals(898, Day8(puzzleInput).part2())
    }

    private val sampleInput = """
        ............
        ........0...
        .....0......
        .......0....
        ....0.......
        ......A.....
        ............
        ............
        ........A...
        .........A..
        ............
        ............
        """.trimIndent()

    private val puzzleInput = ClassLoader.getSystemResource("Day8Input.txt").readText()
}