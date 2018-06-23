package components

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

    fun getOtherCells(vararg cellsToExclude: Cell): ArrayList<Cell> {
        var excludedCellArray = cells
        for (cell in cellsToExclude) {
            excludedCellArray.remove(cell)
        }

        return excludedCellArray
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