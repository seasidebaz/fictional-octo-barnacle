fun main() {

    fun part1(input: List<String>): Int {
        var hpos = 0
        var vpos = 0

        for (i in input.indices) {
            when {
                input[i].startsWith("forward") -> hpos += input[i].replace("forward ", "").toInt()
                input[i].startsWith("up") -> vpos -= input[i].replace("up ", "").toInt()
                input[i].startsWith("down") -> vpos += input[i].replace("down ", "").toInt()
            }
        }

        return hpos * vpos
    }

    fun part2(input: List<String>): Int {
        var hpos = 0
        var vpos = 0
        var aim = 0

        for (i in input.indices) {
            when {
                input[i].startsWith("forward") -> {
                    val unit = input[i].replace("forward ", "").toInt()
                    hpos += unit
                    vpos += unit * aim
                }
                input[i].startsWith("up") -> aim -= input[i].replace("up ", "").toInt()
                input[i].startsWith("down") -> aim += input[i].replace("down ", "").toInt()
            }
        }

        return hpos * vpos
    }

    val input = readInput("Day02")

    println(part1(input))

    println(part2(input))
}
