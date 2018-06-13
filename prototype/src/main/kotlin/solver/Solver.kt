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

        while (counter < 5 && !Iteration().complete()) {
            if (Config.DISPLAY_TABLE) {
                println("Round #${counter + 1}")
                println(Table.toString())
                println()
            }
            counter++
        }

    }
}
