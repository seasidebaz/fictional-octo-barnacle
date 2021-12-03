import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt").readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)

/**
 * Converts binary string to int
 */
fun fromBinaryString(input: String): Int {
    var num = input.toLong()
    var decimal = 0
    var i = 0
    var remainder: Long
    
    while(num.toInt() != 0) {
        remainder = num % 10
        num /= 10
        decimal += (remainder * Math.pow(2.0, i.toDouble())).toInt()
        ++i
    }
    
    return decimal
}