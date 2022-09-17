package tictactoe

fun hasSpace(arr: List<String>): Boolean {
    for (i in arr.indices) {
        if (arr[i] == "_") return true
    }
    return false
}

fun hasWon(arr: List<String>, player: String): Boolean {
    if (arr[0] == player && arr[1] == player && arr[2] == player) return true;
    else if (arr[3] == player && arr[4] == player && arr[5] == player) return true;
    else if (arr[6] == player && arr[7] == player && arr[8] == player) return true;
    else if (arr[0] == player && arr[3] == player && arr[6] == player) return true;
    else if (arr[1] == player && arr[4] == player && arr[7] == player) return true;
    else if (arr[2] == player && arr[5] == player && arr[8] == player) return true;
    else if (arr[0] == player && arr[4] == player && arr[8] == player) return true;
    else return arr[6] == player && arr[4] == player && arr[2] == player;
}

fun countP(arr: List<String>, player: String): Int {
    var total = 0
    for (i in arr.indices) {
        if (arr[i] == player) total++
    }
    return total
}

fun checkGame(array: List<String>): Boolean {
    if (hasSpace(array)) {
        // check X if has 3
        if (hasWon(array, "X") && !hasWon(array, "O")) {
            println("X wins")
            return true
        } else if (hasWon(array, "O") && !hasWon(array, "X")) {
            println("O wins")
            return true
        }
        //  else game not finished
        else if (countP(array, "X") - countP(array, "O") == 0) println("Game not finished");
        else println("Impossible");
    } else {
        // check X if has 3
        return if (hasWon(array, "X")) {
            println("X wins")
            true
        } else if (hasWon(array, "O")) {
            println("O wins")
            true
        } else {
            println("Draw")
            true
        }
    }
    return false
}

fun printBoard(array: List<String>) {
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

fun isNumber(str: String?): Boolean {
    if (str == null) {
        return false
    }
    try {
        val d = str.toInt()
    } catch (nfe: NumberFormatException) {
        return false
    }
    return true
}

fun main() {
    // write your code here
    val input = readln()

    val array: MutableList<String> = input.toCharArray().map { it.toString() }.toMutableList()
    printBoard(array)
    // val result = checkGame(array)
    while (true) {
        val location: String = readln()
        val locationArray = location.split(" ".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()
        if (!isNumber(locationArray[0]) || !isNumber(locationArray[1])) {
            println("You should enter numbers!")
            continue
        }

        val x = locationArray[1].toInt()
        val y = locationArray[0].toInt()

        if (x < 1 || x > 3 || y < 1 || y > 3) {
            println("Coordinates should be from 1 to 3!")
            continue
        }


        val index = x - 1 + (y - 1) * 3
        if (index < array.count()) {

            if (!array[index].equals("_")) {
                println("This cell is occupied! Choose another one!")
                continue
            } else {
                array[index] = "X"
                printBoard(array)
                break
            }
        }
    }
}
