package solver

import Config
import components.Table

object Solver {

    fun run() {
        Table.populateCellsWithValues()

        if (Config.DISPLAY_TABLE) {
            println(Table.toString())
        }
    }
}
