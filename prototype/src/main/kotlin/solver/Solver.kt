package solver

import Config
import components.Table

object Solver {
    val table = Table()

    fun run() {
        if (Config.DISPLAY_TABLE) {
            println(table)
        }

        

    }
}
