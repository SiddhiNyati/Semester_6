fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2 || n == 3) return true
    if (n % 2 == 0 || n % 3 == 0) return false
    var i = 5
    while (i * i <= n) {
        if (n % i == 0 || n % (i + 2) == 0) return false
        i += 6
    }
    return true
}

fun main() {
    print("Enter a number: ")
    val num = readLine()?.toIntOrNull() ?: return println("Invalid input")
    val result = if (isPrime(num)) "a Prime Number" else "not a Prime Number"
    println("$num is $result")
}
