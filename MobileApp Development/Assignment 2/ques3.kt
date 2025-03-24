import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    fun inputMatrix(rows: Int, cols: Int): Array<IntArray> {
        val matrix = Array(rows) { IntArray(cols) }
        for (i in 0 until rows) for (j in 0 until cols) matrix[i][j] = scanner.nextInt()
        return matrix
    }

    fun isSymmetric(matrix: Array<IntArray>): Boolean {
        for (i in matrix.indices) for (j in matrix[i].indices) if (matrix[i][j] != matrix[j][i]) return false
        return true
    }

    fun isSkewSymmetric(matrix: Array<IntArray>): Boolean {
        for (i in matrix.indices) for (j in matrix[i].indices) if (matrix[i][j] != -matrix[j][i]) return false
        return true
    }

    fun addMatrices(a: Array<IntArray>, b: Array<IntArray>): Array<IntArray>? {
        if (a.size != b.size || a[0].size != b[0].size) return null
        return Array(a.size) { i -> IntArray(a[0].size) { j -> a[i][j] + b[i][j] } }
    }

    fun multiplyMatrices(a: Array<IntArray>, b: Array<IntArray>): Array<IntArray>? {
        if (a[0].size != b.size) return null
        val result = Array(a.size) { IntArray(b[0].size) }
        for (i in result.indices) for (j in result[i].indices) for (k in a[i].indices) result[i][j] += a[i][k] * b[k][j]
        return result
    }

    fun transpose(matrix: Array<IntArray>): Array<IntArray> {
        return Array(matrix[0].size) { i -> IntArray(matrix.size) { j -> matrix[j][i] } }
    }

    fun createCustomMatrix(a: Array<IntArray>, b: Array<IntArray>): Array<IntArray> {
        val n = a.size
        val newMatrix = Array(n) { IntArray(n) }
        for (i in 0 until n) for (j in 0 until n) newMatrix[i][j] = when {
            i > j -> a[i][j]
            i < j -> b[i][j]
            else -> 0
        }
        return newMatrix
    }

    print("Enter matrix dimensions (rows cols): ")
    val rows = scanner.nextInt()
    val cols = scanner.nextInt()

    println("Enter first matrix:")
    val matrixA = inputMatrix(rows, cols)

    println("Enter second matrix:")
    val matrixB = inputMatrix(rows, cols)

    println("Symmetric: ${isSymmetric(matrixA)}")
    println("Skew Symmetric: ${isSkewSymmetric(matrixA)}")

    addMatrices(matrixA, matrixB)?.let { println("Addition:\n" + it.joinToString("\n") { row -> row.joinToString(" ") }) }
        ?: println("Addition not possible")

    multiplyMatrices(matrixA, matrixB)?.let { println("Multiplication:\n" + it.joinToString("\n") { row -> row.joinToString(" ") }) }
        ?: println("Multiplication not possible")

    val transposed = transpose(matrixA)
    println("Transpose of first matrix:\n" + transposed.joinToString("\n") { row -> row.joinToString(" ") })

    if (rows == cols) {
        val customMatrix = createCustomMatrix(matrixA, matrixB)
        println("Custom Matrix:\n" + customMatrix.joinToString("\n") { row -> row.joinToString(" ") })
    } else println("Custom Matrix requires square matrices.")
}
