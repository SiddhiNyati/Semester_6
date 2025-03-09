fun main() {
    print("Enter Gross Income (INR): ")
    val grossIncome = readLine()?.toDoubleOrNull() ?: return

    val netIncome = grossIncome - 75000
    val tax = calculateIncomeTax(netIncome)
    val eduCess = tax * 0.02
    val higherEduCess = tax * 0.01
    val totalTax = tax + eduCess + higherEduCess
    val finalIncome = netIncome - totalTax

    println("Total Tax Deduction: INR %.2f".format(totalTax))
    println("Net Income after Tax: INR %.2f".format(finalIncome))
}

fun calculateIncomeTax(income: Double): Double {
    return when {
        income <= 400000 -> 0.0
        income in 400001.0..800000.0 -> (income - 300000) * 0.05
        income in 800001.0..1200000.0 -> 20000 + (income - 800000) * 0.10
        income in 1200001.0..1600000.0 -> 60000 + (income - 1200000) * 0.15
        income in 1600001.0..2000000.0 -> 120000 + (income - 1600000) * 0.20
        income in 2000001.0..2400000.0 -> 200000 + (income - 2000000) * 0.25
        else -> 300000 + (income - 2400000) * 0.30
    }
}
