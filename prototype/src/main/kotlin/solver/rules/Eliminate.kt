package solver.rules

import components.Table

object Eliminate {

    fun run(): Int {

        for (cell in Table.cells) {
            cell.eliminate()
        }

        return 0
    }

}