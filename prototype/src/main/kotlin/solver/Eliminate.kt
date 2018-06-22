package solver

import components.Cell
import components.CellValue
import components.Table
import util.Logger.printEliminateResults

object Eliminate : RuleCheck() {

    var numEliminated = 0

    override fun check(): Int {
        numEliminated = 0

        for (cell in Table.cells) {
            eliminateFromCell(cell)
        }

        printEliminateResults(this)
        return numEliminated
    }

    internal fun eliminateFromCell(cell: Cell) {
        if (cell.isMutable) {
            var values = ArrayList<CellValue>()
            values.addAll(cell.row.values)
            values.addAll(cell.column.values)
            values.addAll(cell.block.values)

            for (i in CellValue.ONE.ordinal..CellValue.NINE.ordinal) {
                if (values.containsAll(CellValue.values().toList())) {
                    throw Exception("All values taken: cannot assign value to cell\n" +
                            "$cell")
                }

                if (values.contains(CellValue.values()[i]) &&
                        cell.candidates.candidates[i]) {
                    cell.eliminateCandidate(CellValue.values()[i])
                    numEliminated++
                }
            }
        }
    }
}