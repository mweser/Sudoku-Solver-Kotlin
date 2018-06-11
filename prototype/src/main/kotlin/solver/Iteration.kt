package solver

import components.Table

/**
 * Class which operates high-level solve algorithm
 */
class Iteration() {

    fun run() {
        // eliminate values across blocks, rows, and columns
        Table.eliminate()


    }
}