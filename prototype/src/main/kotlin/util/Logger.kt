package util

import components.Cell
import components.CellValue
import components.Row
import components.Table
import solver.Eliminate
import solver.SingleHidden
import solver.SingleNaked

object Logger {

    fun printRoundNumberAndTable(counter: Int, table: Table) {
        println("\nRound #${counter + 1}\n$table")

    }

    fun printFoundHiddenSingle(cell: Cell, value: Int) {
        println("Hidden single found for ${CellValue.values()[value]} in $cell")
    }

    fun printEliminateResults(eliminate: Eliminate) {
        println("$eliminate\n")
    }

    fun printHiddenSingleResults(singleHidden: SingleHidden) {
        println("\nHidden single check: ${singleHidden.instancesFound} instances found\n")
    }

    fun printNakedSingleResults(singleNaked: SingleNaked) {
        println("\nNaked single check: ${singleNaked.valuesSet} values set\n")
    }

    fun cellValueInitialized(cell: Cell) {
//        println("Cell initialized ${getCellId(cell)}")
    }

    fun valueEliminated(value: CellValue, count: Int) {
//        println("$value eliminated, count at $count")
    }

    fun cellValueUpdated(cell: Cell) {
        println("set${getCellId(cell)}")
    }

    fun <T: Row> rowValues(row: T, values: Array<CellValue>) {
//        println("Values in Row ${row.index + 1}: $values")
    }

    fun cellSetToImmutable(cell: Cell) {
//        println("Cell set to immutable: ${getCellId(cell)}")
    }

    private fun getCellId(cell: Cell): String {
        return "(${cell.row.index + 1},${cell.column.index + 1}) --> ${cell.value}"
    }
}