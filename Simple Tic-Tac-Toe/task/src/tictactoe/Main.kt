package tictactoe

fun printBoard(array: List<String>){
    println("---------")

    for (x in 0 until array.count()) {
        if (x == 0 || x == 3 || x == 6) {
            print("| ")
        }
        print(array[x].uppercase() + " ")
        if (x == 2 || x == 5 || x == 8) {
            print("|")
            println()
        }
    }

    println("---------")
}
fun main() {
    // write your code here
    val input = readln()

    val array: List<String> = input.toCharArray().map { it.toString() }
    printBoard(array)
}