package components

import mapping.GridPosition
import util.Logger
import util.Mockable

@Mockable
class Row(val index: Int) {
    var cells = ArrayList<Cell>()
    var size = 0
    var candidates = Candidates()
    var values = Array(9) { CellValue.NONE }
        get() = Array(9) { i -> cells[i].value }

    fun addCell(cell: Cell): Boolean {
        return if (size > 9) {
            false
        } else {
            cells.add(cell)
            candidates.eliminateValue(cell.value)
            size++
            true
        }
    }

    fun eliminateCandidateFromCellsOutsideBlock(value: CellValue, block: Block): Int {

        var numEliminated = 0

        for (cell in cells) {
            if (cell.candidates.contains(value) && cell.block.index != block.index) {
                cell.candidates.eliminateValue(value)
                numEliminated++
                println("Locked Candidate (Pointing): $value excluded from ${Logger.getCellCoordinates(cell)} \n$cell")
            }
        }

        return numEliminated
    }

    fun getOtherCells(vararg cellsToExclude: Cell): ArrayList<Cell> {
        var excludedCellArray = ArrayList<Cell>()
        excludedCellArray.addAll(cells)

        for (cell in cellsToExclude) {
            excludedCellArray.remove(cell)
        }

        return excludedCellArray
    }

    // todo find way to genericize this
    fun getUniqueBlockPositionForCandidateValue(value: CellValue): GridPosition {
        var blockPosition = GridPosition.NONE

        if (getCandidateValueCount(value) > 3) {
            return GridPosition.NONE
        }

        for (cell in cells) {
            if (cell.candidates.contains(value)) {
                if (cell.block.position != blockPosition && blockPosition != GridPosition.NONE) {
                    return GridPosition.NONE
                }

                if (cell.block.position == blockPosition || blockPosition == GridPosition.NONE) {
                    blockPosition = cell.block.position
                }
            }
        }

        return blockPosition
    }

    fun getCandidateValuesWithNumOccurrences(numOccurrences: Int): ArrayList<CellValue> {
        var values = ArrayList<CellValue>()

        for (value in CellValue.values()) if (getCandidateValueCount(value) == numOccurrences) {
            values.add(value)
        }

        return values
    }

    fun getCellsWithCandidateValue(value: CellValue): ArrayList<Cell> {
        var cellList = ArrayList<Cell>()

        for (cell in cells) if (cell.candidates.contains(value)) {
            cellList.add(cell)
        }

        return cellList
    }

    fun getCandidateValueCount(value: Int): Int {
        return getCandidateValueCount(CellValue.values()[value])
    }

    fun getCandidateValueCount(value: CellValue): Int {
        var count = 0

        for (cell in cells) {
            if (cell.candidates.contains(value)) {
                count++
            }
        }

        return count
    }

    override fun toString(): String {
        return "${printCellValues()}"
    }

    private fun printCellValues(): String {
        var values = ""
        for (i in 0 until cells.size) {
            values += "${checkForNoValue(cells[i].value.ordinal)}${addDividerEveryThirdColumn(i)}"
        }
        return values
    }

    private fun checkForNoValue(value: Int): String {
        return when (value) {
            CellValue.NONE.ordinal -> " _"
            else -> " $value"
        }
    }

    private fun addDividerEveryThirdColumn(columnIndex: Int): String {
        return when {
            columnIndex % 3 == 2 && columnIndex < cells.size - 1 -> " |"
            else -> ""
        }
    }
}

@Mockable
class Column(index: Int) : Row(index)