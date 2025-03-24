import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    fun inputSet(size: Int): Set<Int> {
        val set = mutableSetOf<Int>()
        while (set.size < size) set.add(scanner.nextInt())
        return set
    }

    fun powerSet(set: Set<Int>): List<Set<Int>> {
        val list = set.toList()
        val result = mutableListOf<Set<Int>>()
        val total = 1 shl list.size
        for (i in 0 until total) result.add(list.indices.filter { i and (1 shl it) != 0 }.map { list[it] }.toSet())
        return result
    }

    print("Enter size of set A: ")
    val sizeA = scanner.nextInt()
    println("Enter elements of set A:")
    val setA = inputSet(sizeA)

    print("Enter size of set B: ")
    val sizeB = scanner.nextInt()
    println("Enter elements of set B:")
    val setB = inputSet(sizeB)

    val unionSet = setA union setB
    val intersectionSet = setA intersect setB
    val differenceSet = setA subtract setB
    val powerSetA = powerSet(setA)

    println("Union: $unionSet")
    println("Intersection: ${if (intersectionSet.isEmpty()) "Disjoint" else intersectionSet}")
    println("Set A - Set B: $differenceSet")
    println("Power Set of A: $powerSetA")
}
