package solver

import components.Table
import util.Config

object Solver {

    fun run() {
        Table.populateCellsWithValues()
        println(Table.toString())

        var counter = 0
        val maxIterations = 50
        var isDone = false

        while (counter < 50 && !Iteration().complete()) {
            counter++
        }

        if (Config.DISPLAY_TABLE) {
            println(Table.toString())
        }
    }
}
