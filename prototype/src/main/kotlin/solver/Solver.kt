package solver

import util.Config
import components.Table

object Solver {

    fun run() {
        Table.populateCellsWithValues()

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
