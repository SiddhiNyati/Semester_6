fun isPerfectNumber(n: Int): Boolean {
    if (n < 2) return false
    var sum = 1
    for (i in 2..n / 2) {
        if (n % i == 0) sum += i
    }
    return sum == n
}

fun findPerfectNumbers(start: Int, end: Int): List<Int> {
    return (start..end).filter { isPerfectNumber(it) }
}

fun main() {
    print("Enter the start of the range: ")
    val start = readLine()?.toIntOrNull() ?: return println("Invalid input")
    print("Enter the end of the range: ")
    val end = readLine()?.toIntOrNull() ?: return println("Invalid input")

    val perfectNumbers = findPerfectNumbers(start, end)
    if (perfectNumbers.isEmpty()) {
        println("No perfect numbers found in the range [$start, $end].")
    } else {
        println("Perfect numbers in the range [$start, $end]: ${perfectNumbers.joinToString(", ")}")
    }
}
