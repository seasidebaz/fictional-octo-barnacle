fun main() {

    fun part1(input: List<String>): Int {

        var gamma = ""
        var epsilon = ""

        for (col in input.first().indices) {
            gamma += input.groupingBy { it[col] }.eachCount().maxWithOrNull(compareBy { it.value })!!.key.toString()
            epsilon += input.groupingBy { it[col] }.eachCount().minWithOrNull(compareBy { it.value })!!.key.toString()
        }
        println(gamma)
        println(epsilon)

        return fromBinaryString(gamma) * fromBinaryString(epsilon)
    }
    
    fun part2(input: List<String>): Int {

        val oxygen = input.toMutableList()
        val co2 = input.toMutableList()

        var finalOxy = ""
        var finalCo2 = ""
        
        for (col in input.first().indices) {
            var counts = oxygen.groupingBy { it[col] }.eachCount()
            var pattern = if (counts['0'] == counts['1']) '1' else counts.maxWithOrNull(compareBy { it.value })!!.key

            oxygen.removeAll {it[col] != pattern}
            println(oxygen)
            
            if (oxygen.count() == 1) finalOxy = oxygen.first()

            counts = co2.groupingBy { it[col] }.eachCount()
            pattern = if (counts['0'] == counts['1']) '0' else counts.minWithOrNull(compareBy { it.value })!!.key
            co2.removeAll {it[col] != pattern}
            println(co2)
            
            if (co2.count() == 1) finalCo2 = co2.first()
        }

        println(finalOxy)
        println(finalCo2)

        return fromBinaryString(finalOxy) * fromBinaryString(finalCo2)
    }

    val input = readInput("Day03")

    println(part1(input))

    println(part2(input))
}
