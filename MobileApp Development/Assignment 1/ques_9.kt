import java.util.*

fun findElements(arr: IntArray) {
    var largest = Int.MIN_VALUE
    var secondLargest = Int.MIN_VALUE
    var smallest = Int.MAX_VALUE
    var secondSmallest = Int.MAX_VALUE

    for (num in arr) {
        if (num > largest) {
            secondLargest = largest
            largest = num
        } else if (num > secondLargest && num != largest) {
            secondLargest = num
        }

        if (num < smallest) {
            secondSmallest = smallest
            smallest = num
        } else if (num < secondSmallest && num != smallest) {
            secondSmallest = num
        }
    }

    println("Largest: $largest")
    println("Second Largest: $secondLargest")
    println("Smallest: $smallest")
    println("Second Smallest: $secondSmallest")
}

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter the number of elements: ")
    val n = scanner.nextInt()
    val arr = IntArray(n)

    println("Enter the elements:")
    for (i in 0 until n) {
        arr[i] = scanner.nextInt()
    }

    findElements(arr)
}

