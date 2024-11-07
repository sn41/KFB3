import java.util.*

object Main {
    // Комментарий
    /* Многострочный комментарий */

    // private - видимые только для этого объекта
    // const - неизменяемые переменные - поля,
    // поэтому используются имена в верхнем регистре.
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
        // Выводим строки на экран
        println("$NAME1: - Который час? Я тебя $TIME1 раз спрашиваю!")
        println("$NAME2: - Сейчас  $FIELD! Я тебе $TIME1 раз отвечаю!")
        println("$NAME1 - Сгинь со скоростью $SPEED километров в час!")

        // Получить строку ответа, для agreement = false, это agreementString2 = "- Счас, разбежался! Сам сгинь!"
        val agreementString =
            if (AGREEMENT) AGREEMENT_STRING1
            else AGREEMENT_STRING2

        // Выводим строку "- Счас, разбежался! Сам сгинь!"
        println(agreementString)

        println("- Сгинь, пропади!")

        //три раза "Тьфу!" через левое плечо.
        repeat(3) { println("- Тьфу!") }

        // Выводим вопрос -
        //   читаем консоль -
        //       по введённому значению находим строку ответа -
        //           выводим эту строку

        // Массив ответов
        val sentences = arrayOf("Нифига!", "Ни за что!", "Никогда!")
        // Вывести вопрос на экран - на экран консоли
        println("$NAME2:- У меня есть три ответа, выбери, какой ты хочешь услышать?")
        // Получить ответ с клавиатуры - с консоли, используя написанную нами функцию my_get_answer()
        //   Она возвращает значение 1 или 2 или 3
        //       а индексы значений списка sentences равны 0,1,2
        //           поэтому приводим диапазон ответов к диапазону индексов, отнимаем 1.
        val answerIndex = myGetAnswer() - 1
        // Получаем строку ответа, читаем элемент списка sentences по его индексу answerIndex
        val answerString = sentences[answerIndex]
        // Печатаем строку ответа
        println("$NAME2:- Вот тебе ответ - $answerString");

        // Пустые строки
        print("\n\n\n")

        println("$NAME1: - Считаю!!!")

        // Заполняем массив отсчётов.
        // Там будет {0,1,2,3,4,5,6,7,8,9,10}
        val delayTips = IntArray(11)

        // Здесь 0 ..delayTips.lastIndex - это диапазон значений индекса массива
        for (i in 0 ..delayTips.lastIndex) {
            delayTips[i] = i
        }

         // можно записать и так
        //        for (i in delayTips.indices){
        //            delayTips[i] = i
        //        }
        //
        //        for (i in 0 .. delayTips.size - 1){
        //            delayTips[i] = i
        //        }
        //
        //        for (i in 0 until delayTips.size){
        //            delayTips[i] = i
        //        }

        // Выполняем цикл -
        //   получаем число из списка - delayTip
        //       преобразуем число delayTip в строку функцией myGetDelayTipString(delayTip)
        //               результат помещаем в переменную delayTipString
        //           выводим на экран эту строку print(delayTipString),
        //       ждём две секунды
        //    проверяем, содержалась ли строка "умею" в выведенной на экран строке delay_tip_string
        //    если содержалась - прекращаем цикл, иначе - переходим к следующей итерации цикла
        //
        // Другими словами, выводим строки на экран, пока мы не прочитаем все значения списка,
        //   соответствующие delay_tips_range
        //       или в выводимой строке не появится слово "умею"
        for (i in 1..10) {
            val delayTip = delayTips[i]
            val delayTipString = myGetDelayTipString(delayTip)
            println(delayTipString)

            //пауза 2000 миллисекунд = 2 секунды перед следующий отчётом
            mySleep(2000L)

            if (delayTipString.contains("умею")) break
        }

        //пауза 2000 миллисекунд 2 секунды
        mySleep(2000L)

        println("$NAME2: - О! Как ты мне надоел. Улетаю, шут с тобой!")

        //финальная пауза 3 миллисекунд = 3 секунды
        mySleep(3000L)

        //очистить экран
        myClearScreen()
    }


    /**
     * Читаем ответ, введённый с клавиатуры,
     * приводим число к диапазону 1-3,
     *
     * то, что меньше 2, считается 1,
     * то, что больше 3, считается 3
     *
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
     * Прочитать ввод с консоли
     *
     * @return - число введённое с клавиатуры
     */
    private fun myReadConsole(): Int {
        val scanner = Scanner(System.`in`)
        return scanner.nextInt()
    }

    /**
     * Преобразует число в строку
     *
     * @param delayTip - отчёт
     * @return название
     */
    private fun myGetDelayTipString(delayTip: Int): String {
        var delayTipString = ""
        // Последовательно сравниваем delayTip со значениями
        // 1, 2, 3
        // если delayTip и значение совпали - выполняем соответствующее присвоение
        // и выходим из оператора when.
        // Например, если delayTip равно 1, выполнится delayTipString = "- Один!"

        // Если ни один из вариантов не совпал с delayTip,
        // тогда выполняется присвоение по-умолчанию
        //      else:
        // Здесь, это -
        //          delayTipString = "- Дальше не умею считать...";
        //
        delayTipString = when (delayTip) {
            1 -> "- Один!"
            2 -> "- Два!"
            3 -> "- Три!"
            else -> "- Дальше не умею считать..."
        }

        return delayTipString
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