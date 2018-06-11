package solver

import components.Table

/**
 * Class which operates high-level solve algorithm
 */
class Iteration() {

    fun complete(): Boolean {
        // eliminate values across blocks, rows, and columns
        Table.eliminate()

        return false
    }
}