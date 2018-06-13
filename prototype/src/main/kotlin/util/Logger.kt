package util

import components.CellValue

object Logger {

    fun cellValueInitialized(intValue: Int) {
        println("Cell initialized at ")

    }

    fun valueEliminated(value: CellValue, count: Int) {
//        println("$value eliminated, count at $count")
    }
}