fun main() {
    println("Введите слова, разделенные пробелами:")
    val input = readLine()
    val words = input?.split(" ")// разбиваем строку на отдельные слова, разделенные пробелами

    if (words != null) {
        val wordGroups = groupWords(words)

        for ((_, group) in wordGroups) { //_ - пустое значение, т.к. ключ нам не нужен, нужно только значение
            println(group.joinToString(", "))
        }
    }
}

fun groupWords(words: List<String>): Map<String, List<String>> {
    val wordGroups = mutableMapOf<String, MutableList<String>>()

    for (word in words) {
        val key = word.toCharArray().sorted().joinToString("")

        if (!wordGroups.containsKey(key)) {
            wordGroups[key] = mutableListOf()
        }

        wordGroups[key]?.add(word)
    }

    return wordGroups
}
