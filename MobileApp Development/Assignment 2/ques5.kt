fun findIncreasingSequences(arr: IntArray): List<List<Int>> {
    val sequences = mutableListOf<List<Int>>()
    var tempList = mutableListOf(arr[0])

    for (i in 1 until arr.size) {
        if (arr[i] > arr[i - 1]) {
            tempList.add(arr[i])
        } else {
            if (tempList.size > 1) sequences.add(tempList.toList())
            tempList = mutableListOf(arr[i])
        }
    }
    if (tempList.size > 1) sequences.add(tempList.toList())
    return sequences
}

fun findMaxNumbers(arr: IntArray): Pair<Int, Int> {
    var max1 = Int.MIN_VALUE
    var max2 = Int.MIN_VALUE
    for (num in arr) {
        if (num > max1) {
            max2 = max1
            max1 = num
        } else if (num > max2 && num != max1) {
            max2 = num
        }
    }
    return Pair(max1, max2)
}

fun rearrangeOddEven(arr: IntArray): IntArray {
    val odds = arr.filter { it % 2 != 0 }.toMutableList()
    val evens = arr.filter { it % 2 == 0 }.toMutableList()
    val result = mutableListOf<Int>()

    while (odds.isNotEmpty() || evens.isNotEmpty()) {
        if (evens.isNotEmpty()) result.add(evens.removeAt(0))
        if (odds.isNotEmpty()) result.add(odds.removeAt(0))
    }
    return result.toIntArray()
}

fun main() {
    val arr = intArrayOf(1, 3, 5, 4, 7, 10, 2, 3, 5, 8, 12)
    println("Increasing Sequences: ${findIncreasingSequences(arr)}")

    val (max1, max2) = findMaxNumbers(arr)
    println("First Maximum: $max1, Second Maximum: $max2")

    println("Rearranged Array: ${rearrangeOddEven(arr).joinToString(", ")}")
}
