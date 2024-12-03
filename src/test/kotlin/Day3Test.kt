import org.example.Day3
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day3Test {
    @Test
    fun `Part 1 - sample`() {
        val sampleInput = """xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"""
        assertEquals(161, Day3(sampleInput).part1())
    }

    @Test
    fun `Part 1 - puzzle input`() {
        assertEquals(175700056, Day3(puzzleInput).part1())
    }

    @Test
    fun `Part 2 - sample`() {
        val sampleInput = """xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"""
        assertEquals(48, Day3(sampleInput).part2())
    }

    @Test
    fun `Part 2 - puzzle input`() {
        assertEquals(71668682, Day3(puzzleInput).part2())
    }

    private val puzzleInput = ClassLoader.getSystemResource("Day3Input.txt").readText()
}