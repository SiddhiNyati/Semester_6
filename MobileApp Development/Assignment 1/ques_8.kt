import java.util.*

fun getDayOfWeek(day: Int, month: Int, year: Int): String {
    val monthMagicNumbers = intArrayOf(0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5)
    val days = arrayOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    val centuryCode = when (year / 100) {
        16 -> 6
        17 -> 4
        18 -> 2
        19 -> 0
        20 -> 6
        else -> 0
    }

    val lastTwoDigits = year % 100
    val leapYearAdjustment = if (isLeapYear(year) && (month == 1 || month == 2)) -1 else 0

    val sum = lastTwoDigits + (lastTwoDigits / 4) + day + monthMagicNumbers[month - 1] + centuryCode + leapYearAdjustment
    val dayOfWeek = sum % 7

    return days[dayOfWeek]
}

fun isLeapYear(year: Int): Boolean {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
}

fun main() {
    val scanner = Scanner(System.`in`)

    print("Enter day (dd): ")
    val day = scanner.nextInt()

    print("Enter month (mm): ")
    val month = scanner.nextInt()

    print("Enter year (yyyy): ")
    val year = scanner.nextInt()

    val result = getDayOfWeek(day, month, year)
    println("The day of the week for $day/$month/$year is: $result")
}
