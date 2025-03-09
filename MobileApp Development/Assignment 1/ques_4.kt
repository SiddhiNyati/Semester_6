fun sieveOfEratosthenes(start: Int, end: Int): List<Int> {
    if (end < 2) return emptyList()
    val isPrime = BooleanArray(end + 1) { true }
    isPrime[0] = false
    isPrime[1] = false
    for (i in 2..Math.sqrt(end.toDouble()).toInt()) {
        if (isPrime[i]) {
            for (j in i * i..end step i) {
                isPrime[j] = false
            }
        }
    }
    return (maxOf(2, start)..end).filter { isPrime[it] }
}

fun main() {
    print("Enter the start of the range: ")
    val start = readLine()?.toIntOrNull() ?: return println("Invalid input")
    print("Enter the end of the range: ")
    val end = readLine()?.toIntOrNull() ?: return println("Invalid input")

    val primes = sieveOfEratosthenes(start, end)
    println("Prime numbers in the range [$start, $end]: ${primes.joinToString(", ")}")
}
