package collection

fun find(supportList: List<String>, targetList: List<String>): String {
    var foundLanguage = ""
    for (target in targetList) {
        if (supportList.any { it == target }) {
            foundLanguage = target
            break
        }
    }
    return foundLanguage
}