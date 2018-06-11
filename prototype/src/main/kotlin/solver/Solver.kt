package solver

import Config
import components.Table

object Solver {

    fun run() {
        Table.populateCellsWithValues()

        var counter = 0
        val maxIterations = 50
        var isDone = false

        while (counter < 50 && !isDone) {
            Iteration().run()
        }

        if (Config.DISPLAY_TABLE) {
            println(Table.toString())
        }
    }
}
