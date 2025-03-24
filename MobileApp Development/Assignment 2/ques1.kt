import java.util.*

fun insertionSort(arr: IntArray) {
    for (i in 1 until arr.size) {
        val key = arr[i]
        var j = i - 1
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]
            j--
        }
        arr[j + 1] = key
    }
}

fun mergeArraysDescending(arr1: IntArray, arr2: IntArray): IntArray {
    val merged = IntArray(arr1.size + arr2.size)
    var i = arr1.lastIndex
    var j = arr2.lastIndex
    var k = 0

    while (i >= 0 && j >= 0) {
        merged[k++] = if (arr1[i] > arr2[j]) arr1[i--] else arr2[j--]
    }

    while (i >= 0) merged[k++] = arr1[i--]
    while (j >= 0) merged[k++] = arr2[j--]

    return merged
}

fun main() {
    val scanner = Scanner(System.`in`)

    print("Enter size of first array: ")
    val n1 = scanner.nextInt()
    val arr1 = IntArray(n1)
    println("Enter elements of first array:")
    for (i in 0 until n1) arr1[i] = scanner.nextInt()

    print("Enter size of second array: ")
    val n2 = scanner.nextInt()
    val arr2 = IntArray(n2)
    println("Enter elements of second array:")
    for (i in 0 until n2) arr2[i] = scanner.nextInt()

    insertionSort(arr1)
    insertionSort(arr2)

    val mergedArray = mergeArraysDescending(arr1, arr2)

    println("Merged Array in Descending Order: ${mergedArray.joinToString(" ")}")
}
