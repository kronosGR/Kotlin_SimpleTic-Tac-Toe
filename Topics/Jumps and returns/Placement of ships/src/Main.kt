import java.util.Arrays
import java.util.StringJoiner

fun main() {
    // put your code here
    val array = arrayOf(1, 2, 3, 4, 5)
    val xs: ArrayList<Int> = ArrayList<Int>()
    val ys: ArrayList<Int> = ArrayList<Int>()
    val xse: ArrayList<Int> = ArrayList<Int>()
    val yse: ArrayList<Int> = ArrayList<Int>()

    val (x1, y1) = readln().split(" ").map { it -> it.toInt() }
    val (x2, y2) = readln().split(" ").map { it -> it.toInt() }
    val (x3, y3) = readln().split(" ").map { it -> it.toInt() }

    xs.add(x1)
    xs.add(x2)
    xs.add(x3)

    ys.add(y1)
    ys.add(y2)
    ys.add(y3)

    for (item in array) {
        if (!xs.contains(item)) {
            xse.add(item)
        }
        if (!ys.contains(item)) {
            yse.add(item)
        }
    }

    println(xse.joinToString(" "))
    println(yse.joinToString(" "))


}