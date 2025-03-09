fun countTriangles(sides: IntArray): Int {
    sides.sort() // Sorting helps in using two-pointer approach
    val n = sides.size
    var count = 0

    for (i in n - 1 downTo 2) { // Fix the largest side at i
        var left = 0
        var right = i - 1
        while (left < right) {
            if (sides[left] + sides[right] > sides[i]) {
                count += (right - left) // All pairs (left to right-1) are valid
                right--
            } else {
                left++
            }
        }
    }
    return count
}

fun main() {
    print("Enter number of sides: ")
    val n = readLine()!!.toInt()
    print("Enter side lengths separated by space: ")
    val sides = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    val result = countTriangles(sides)
    println("Number of valid triangles: $result")
}