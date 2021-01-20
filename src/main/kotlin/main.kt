fun main() {
    println("Введите сумму в рублях которую вы хотели перевести!")
    var input = readLine()!!.toInt() * 100
    val result = transaction("MasterCard", 100000, input)
    val result1 = transaction(amountTransfers = 50000, amount = input)
    val result2 = transaction("Мир", amount = input)
    println("Сумма перевода будет составлять $result коп. ( ${result / 100} руб. )")
    println("Сумма перевода будет состовлять $result1 коп. ( ${result1 / 100} руб. )")
    println("Сумма перевода будет состовлять $result2 коп. ( ${result2 / 100} руб. )")
}

fun transaction(card: String = "VKpay",
                amountTransfers: Int = 0,
                amount: Int
): Int {
    var cost = amount
    when (card) {
        "MasterCard", "Maestro" -> if (amountTransfers < 75000) cost
        else cost = (amount * 0.94 - 2000).toInt()
        "VKpay" -> cost
        "Visa", "Мир" -> if ((amount * 0.075) < 3500) cost = amount - 3500 else cost = (amount * 0.925).toInt()
    }
    return cost
}