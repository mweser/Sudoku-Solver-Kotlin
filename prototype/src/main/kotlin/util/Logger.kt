package util

import components.Candidates
import components.Cell
import components.CellValue
import components.Row
import components.Table
import solver.DoubleNaked
import solver.Eliminate
import solver.SingleHidden
import solver.SingleNaked

object Logger {

    val SHOW_CANDIDATES = false
    val SHOW_ELIMINATE = false
    val SHOW_NAKED_SINGLES = false
    val SHOW_NAKED_DOUBLES = false
    val SHOW_HIDDEN_DOUBLES = true
    val SHOW_HIDDEN_SINGLES = false
    val SHOW_SET = true
    val SHOW_CELL_CONTENTS = false

    val horizontalBar = "----------------------"
    val horizontalBarLong = "-------------------------------------------------------------------------"
    val thickHorizontalLong = "========================================================================="

    fun printHiddenDoubleResults(cell1: Cell, cell2: Cell) {
        if (SHOW_HIDDEN_DOUBLES) println("Hidden double found in cells ${getCellCoordinates(cell1)} and ${getCellCoordinates(cell2)}")
    }

    fun printHiddenDoubleElimination(cell1: Cell, cell2: Cell) {
        if (SHOW_HIDDEN_DOUBLES && SHOW_ELIMINATE) println("Candidates eliminated for hidden double: \n$cell1 and\n $cell2")
    }

    fun printNakedDoublesResults(doubleNaked: DoubleNaked) {
        if (SHOW_NAKED_DOUBLES) println("Doubles found: ${doubleNaked.count}")
    }

    fun <T : Row> printFoundNakedDoubles(cell: Cell, otherCell: Cell, candidates: Candidates, rowType: T) {
        if (SHOW_NAKED_DOUBLES) println("Found naked double $candidates in ${getCellCoordinates(cell)} and " +
                "${getCellCoordinates(otherCell)} along ${rowType.javaClass} ${rowType.index + 1}")
    }

    fun printEliminateCandidatesFromCell(cell: Cell, candidates: Candidates) {
        if (SHOW_NAKED_DOUBLES) println("Eliminated $candidates ${getCellContents(cell)}")
    }

    fun printCandidateTable(table: Table) {
        var out = "\n"

        for (index in 0 until 27) {
            var row = table.rows[index / 3]
            out += printRowOfCandidates(row, index)

            if (index % 9 == 8 && index != 26) {
                out += "$thickHorizontalLong\n"
            } else if (index % 3 == 2 && index != 26) {
                out += "$horizontalBarLong\n"
            }
        }

        println(out)
    }

    fun printRowOfCandidates(row: Row, index: Int): String {
        var outString = ""
        var startValue = (index % 3) * 3 + 1

        for (index in 0 until row.cells.size) {
            var cell = row.cells[index]

            for (value in startValue until (startValue + 3)) {

                outString += when {
                    cell.candidates.contains(value) -> "$value "
                    cell.value != CellValue.NONE -> "${cell.value.ordinal} "
                    else -> "  "
                }
            }

            outString += when {
                index == row.cells.size - 1 -> "\n"
                index % 3 == 2 -> "|| "
                else -> "| "

            }
        }

        return outString
    }

    fun printRoundNumberAndCandidateTable(counter: Int, table: Table) {
        println("\nRound #${counter + 1}")
        printCandidateTable(table)
    }

    fun printRoundNumberAndTable(counter: Int, table: Table) {
        println("\nRound #${counter + 1}\n$table")
    }

    fun printFoundHiddenSingle(cell: Cell, value: Int) {
        if (SHOW_HIDDEN_SINGLES) println("Hidden single found for ${CellValue.values()[value]}\n${getCellContents(cell)}")
    }

    fun printEliminateResults(eliminate: Eliminate) {
        if (SHOW_ELIMINATE) println("Candidates eliminated: ${eliminate.numEliminated}")
    }

    fun printHiddenSingleResults(singleHidden: SingleHidden) {
        if (SHOW_HIDDEN_SINGLES) println("Hidden single check: ${singleHidden.instancesFound} instances found ")
    }

    fun printNakedSingleResults(singleNaked: SingleNaked) {
        if (SHOW_NAKED_SINGLES) println("Naked single check: ${singleNaked.valuesSet} values set ")
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
//        println("Cell initialized ${getCellSetString(cell)}")
    }

    fun valueEliminated(value: CellValue, count: Int) {
//        println("$value eliminated, count at $count")
    }

    fun cellValueUpdated(cell: Cell) {
        if (SHOW_SET) println("set${getCellSetString(cell)}")
    }

    fun <T : Row> rowValues(row: T, values: Array<CellValue>) {
//        println("Values in Row ${row.index + 1}: $values")
    }

    fun cellSetToImmutable(cell: Cell) {
//        println("Cell set to immutable: ${getCellSetString(cell)}")
    }

    private fun getCellContents(cell: Cell): String {
        return if (SHOW_CELL_CONTENTS) "$cell" else ""
    }

    fun getCellCoordinates(cell: Cell): String {
        return "Cell (${cell.row.index + 1},${cell.column.index + 1})"
    }

    private fun getCellSetString(cell: Cell): String {
        return "${getCellCoordinates(cell)} --> ${cell.value.ordinal}\t\t\t[${cell.rule}]"
    }
}