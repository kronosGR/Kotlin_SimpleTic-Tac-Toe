fun main() {
    // put your code here
    var input = readln()

    var total = 0
    for (letter in input) {
        if (input.indexOf(letter.toChar()) == input.lastIndexOf(letter.toChar())) {
            total++
        }
    }
    println(total)
}