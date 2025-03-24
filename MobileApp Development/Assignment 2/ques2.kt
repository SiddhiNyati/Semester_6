import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    print("Enter the number of elements: ")
    val n = scanner.nextInt()

    val numbers = IntArray(n)
    println("Enter numbers between 0-100:")
    for (i in 0 until n) numbers[i] = scanner.nextInt()

    val frequency = IntArray(10)

    for (num in numbers) {
        if (num in 1..100) {
            val index = (num - 1) / 10
            frequency[index]++
        }
    }

    for (i in 0 until 10) {
        val lower = i * 10 + 1
        val upper = lower + 9
        println("$lower-$upper: ${frequency[i]}")
    }
}
