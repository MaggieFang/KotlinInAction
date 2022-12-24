package ObjectInterface

class Chapter7_0_OperatorOverloading {
}

data class Point(val x: Int, val y: Int)

operator fun Point.plus(other: Point): Point {
    return Point(this.x + other.x, this.y + other.y)
}

operator fun Point.times(other: Point): Point {
    return Point(this.x * other.x, this.y * other.y)
}

operator fun Point.div(other: Point): Point {
    return Point(this.x / other.x, this.y / other.y)
}

operator fun Point.rem(other: Point): Point {
    return Point(this.x % other.x, this.y % other.y)
}

operator fun Point.minus(other: Point): Point {
    return Point(this.x - other.x, this.y - other.y)
}

operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("invalid coordinate index $index")
    }
}

operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}

data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, value: Int) {
    when (index) {
        0 -> x = value
        1 -> y = value
        else -> throw IndexOutOfBoundsException("invalid coordinate index $index")
    }
}


fun main() {
    val point1 = Point(1, 2)
    val point2 = Point(2, 1)
    val plusResult = point1 + point2
    val timesResult = point1 * point2
    print('a' * 3)
    println(point1[0])
}

