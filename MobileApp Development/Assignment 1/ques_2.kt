fun calculateElectricityBill(units: Int): Double {
    val fixedCharges = when {
        units in 1..50 -> 230.0
        units in 51..150 -> 230.0
        units in 151..300 -> 275.0
        units in 301..500 -> 345.0
        else -> 400.0
    }

    var billAmount = fixedCharges
    var remainingUnits = units

    val slabs = listOf(
        Triple(1, 50, 5.00),
        Triple(51, 150, 6.50),
        Triple(151, 300, 7.50),
        Triple(301, 500, 7.85),
        Triple(501, Int.MAX_VALUE, 8.00)
    )

    for ((low, high, rate) in slabs) {
        if (units > low) {
            val chargeableUnits = minOf(high - low + 1, remainingUnits)
            billAmount += chargeableUnits * rate
            remainingUnits -= chargeableUnits
        }
        if (remainingUnits <= 0) break
    }

    return billAmount
}

fun main() {
    print("Enter number of units consumed: ")
    val units = readLine()?.toIntOrNull() ?: return println("Invalid input")
    val totalBill = calculateElectricityBill(units)
    println("Electricity Bill Amount: INR %.2f".format(totalBill))
    println("Number of Units Consumed: $units")
}
