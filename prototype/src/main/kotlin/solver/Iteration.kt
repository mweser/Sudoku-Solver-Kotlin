package solver

import components.Table

/**
 * Class which operates high-level solve algorithm
 */
class Iteration() {

    fun complete(): Boolean {
        return Table.eliminate()
    }
}