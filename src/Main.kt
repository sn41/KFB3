import java.util.*

object Main {
    // Комментарий
    /* Многострочный комментарий */
    private const val FIELD = 10.58
    private const val NAME1 = "Вася"
    private const val NAME2 = "Джин"
    private const val TIME1 = 10
    private const val SPEED = 100.0f
    private const val AGREEMENT = false
    private const val AGREEMENT_STRING1 = "- Ну, я пошёл..."
    private const val AGREEMENT_STRING2 = "- Счас, разбежался! Сам сгинь!"

    //метод
    @Throws(InterruptedException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        println("$NAME1: - Который час? Я тебя $TIME1 раз спрашиваю!")
        println("$NAME2: - Сейчас  $FIELD! Я тебе $TIME1 раз отвечаю!")
        println("$NAME1 - Сгинь со скоростью $SPEED километров в час!")

        //Получить строку ответа, для agreement = false
//        val agreementString =
//            if (agreement) agrimentString1
//            else agrimentString2

        //Ответить
        println(
            if (AGREEMENT) AGREEMENT_STRING1
            else AGREEMENT_STRING2
        )

        println("- Сгинь, пропади!")

        //три раза "Тьфу!" через левое плечо.
        repeat(3) { println("- Тьфу!") }

        //вопрос - ответ
        //массив ответов
        val sentences = arrayOf("Нифига!", "Ни за что!", "Никогда!")
        //вывести вопрос на экран - на экран консоли
        println("$NAME2:- У меня есть три ответа, выбери, какой ты хочешь услышать?")
        //получить ответ с клавиатуры - с консоли, используя написанную нами функцию getAnswer()
        val answer = myGetAnswer() - 1

        println("$NAME2:- Вот тебе ответ - ${sentences[answer]}");

        //Пустые строки
        print("\n\n\n")

        println("$NAME1: - Считаю!!!")

        //заполняем массив отсчётов {0,1,2,3,4,5,6,7,8,9,10}
        val delayTips = IntArray(11)
        for (i in 1..<delayTips.size) {
            delayTips[i] = i
        }

        //цикл - проговариваем отсчёты,
        // пока или отчёты не кончатся,
        // или в строке не появится слово "умею"
        for (i in 1..10) {
            val delayTip = delayTips[i]
            val delayTipString = myGetDelayTipString(delayTip)
            println(delayTipString)
            //пауза 2000 миллисекунд = 2 секунды перед слудующий отчётом
            mySleep(2000L)
            if (delayTipString.contains("умею")) break
        }

        //пауза 2000 миллисекунд 2 секунды перед слудующий отчётом
        mySleep(2000L)

        println("$NAME2: - О! Как ты мне надоел. Улетаю, шут с тобой!")

        //финальная пауза 3 миллисекунд = 3 секунды перед слудующий отчётом
        mySleep(3000L)

        //очистить экран
        myClearScreen()
    }


    /**
     * читаем ответ введёный с клавиатуры
     * если введено число не находящееся в ожидаемом диапазоне 1-3,
     * приводим его к этому диапазону,
     * то, что меньше 1, считается 1,
     * то, что больше 3, считается 3
     * @return - ответ в диапазоне 1-3
     */
    fun myGetAnswer(): Int {
        //читаем значение, ввёдёное с консоли
        val answerTmp = myReadConsole()

        //приводим прочитанное число к диапазону 1-3
        val answer = if (answerTmp < 2) {
            1
        } else if (answerTmp == 2) {
            2
        } else {
            3
        }
        return answer
    }

    /**
     * читаем значение, ввёдёное с консоли
     * @return - число введёное с клавиатуры
     */
    private fun myReadConsole(): Int {
        val scanner = Scanner(System.`in`)
        return scanner.nextInt()
    }

    /**
     * Преобразует отсчёт в виде числа в строку
     * @param delayTip отчёт
     * @return строка отчёта
     */
    private fun myGetDelayTipString(delayTip: Int): String {
        var delayString = ""
        delayString = when (delayTip) {
            1 -> "- Один!"
            2 -> "- Два!"
            3 -> "- Три!"
            else -> "- Дальше не умею считать..."
        }

        return delayString
    }


    /** Очистить экран. */
    private fun myClearScreen() = repeat(70) { println("") }

    /**
     * Приостанавливает выполненение потока команд на delay миллисекунд
     * @param delay - время задержки в миллисекундах
     * @throws InterruptedException - если что-то пойдёт не так...
     */
    @Throws(InterruptedException::class)
    private fun mySleep(delay: Long) {
        Thread.sleep(delay)
    }
}