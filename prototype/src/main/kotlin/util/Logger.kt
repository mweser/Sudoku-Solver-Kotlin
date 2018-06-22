package util

import components.Cell
import components.CellValue
import components.Row
import components.Table
import solver.Eliminate
import solver.SingleHidden
import solver.SingleNaked

object Logger {

    val SHOW_CANDIDATES = false
    val SHOW_ELIMINATE = false
    val SHOW_NAKED_SINGLES = false
    val SHOW_HIDDEN_SINGLES = false
    val SHOW_SET = true

    fun printRoundNumberAndTable(counter: Int, table: Table) {
        println("\nRound #${counter + 1}\n$table")
    }

    fun printFoundHiddenSingle(cell: Cell, value: Int) {
        if (SHOW_HIDDEN_SINGLES) println("Hidden single found for ${CellValue.values()[value]} in $cell")
    }

    fun printEliminateResults(eliminate: Eliminate) {
        if (SHOW_ELIMINATE) println("Candidates eliminated: ${eliminate.numEliminated}")
    }

    fun printHiddenSingleResults(singleHidden: SingleHidden) {
        if (SHOW_HIDDEN_SINGLES) println("Hidden single check: ${singleHidden.instancesFound} instances found ")
    }

    fun printNakedSingleResults(singleNaked: SingleNaked) {
        if (SHOW_NAKED_SINGLES)  println("Naked single check: ${singleNaked.valuesSet} values set ")
    }

    fun printAllCandidates(table: Table) {
        if (SHOW_CANDIDATES) {
            var printString = ""

            for (cell in table.cells) if (cell.getNumCandidates() > 0) {
                printString += "Cell ${cell.index + 1} candidates (${cell.getNumCandidates()}): ${cell.candidates} "
            }

            println("$printString")
        }
    }

    fun cellValueInitialized(cell: Cell) {
//        println("Cell initialized ${getCellId(cell)}")
    }

    fun valueEliminated(value: CellValue, count: Int) {
//        println("$value eliminated, count at $count")
    }

    fun cellValueUpdated(cell: Cell) {
       if (SHOW_SET) println("set${getCellId(cell)}")
    }

    fun <T : Row> rowValues(row: T, values: Array<CellValue>) {
//        println("Values in Row ${row.index + 1}: $values")
    }

    fun cellSetToImmutable(cell: Cell) {
//        println("Cell set to immutable: ${getCellId(cell)}")
    }

    private fun getCellId(cell: Cell): String {
        return "(${cell.row.index + 1},${cell.column.index + 1}) --> ${cell.value}\t\t(${cell.rule})"
    }
}