fun main() {
    println("Введите сумму в рублях которую вы хотели перевести!")
    var input = readLine()!!.toInt() * 100
    transaction("MasterCard", 100000, input)
    transaction(amountTransfers = 50000, amount = input)
    transaction("Мир", amount = input)
}

fun transaction(card: String = "VKpay", amountTransfers: Int = 0, amount: Int) {
    var cost = when (card) {
        "MasterCard", "Maestro" -> comissionForMastercardAndMaestro(amountTransfers, amount)
        "Visa", "Мир" -> comissionForVisaAndMir(amount)
        else -> amount
    }
    println("Сумма перевода будет состовлять $cost коп. ( ${cost / 100} руб. )")
}

fun comissionForMastercardAndMaestro(amountTransfers: Int = 0, amount: Int): Int {
    return if (amountTransfers < 75000) amount else (amount * 0.94 - 2000).toInt()
}

fun comissionForVisaAndMir(amount: Int): Int {
    return if ((amount * 0.075) < 3500) amount - 3500 else (amount * 0.925).toInt()
}