fun main() {

    fun nextIsGreater(num1: Int, num2: Int): Boolean {
        return num2 > num1
    }

    fun part1(input: List<String>): Int {

        var totalGreater = 0

        for (i in 0..input.size - 2) {
            totalGreater += if (nextIsGreater(input[i].toInt(), input[i + 1].toInt())) {
                1
            } else {
                0
            }
        }

        return totalGreater
    }

    fun part2(input: List<String>): Int {

        var totalGreater = 0

        for (i in 0..input.size - 4) {
            val firstWindow = input[i].toInt() + input[i + 1].toInt() + input[i + 2].toInt()
            val secondWindow = input[i + 1].toInt() + input[i + 2].toInt() + input[i + 3].toInt()
            totalGreater += if (nextIsGreater(firstWindow, secondWindow)) {
                1
            } else {
                0
            }
        }

        return totalGreater
    }

    val input = readInput("Day01")
    println(part1(input))

    println(part2(input))
}
