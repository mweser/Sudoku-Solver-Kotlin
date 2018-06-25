package components

import mapping.BlockIndex
import util.Logger
import util.Mockable

@Mockable
class Block(index: Int): Row(index) {
    val position = BlockIndex.toBlockPosition(index)

    val blockRow = BlockIndex.toBlockRow(index)
    val blockColumn = BlockIndex.toBlockColumn(index)

    val minRow = BlockIndex.toMinRow(index)
    val maxRow = BlockIndex.toMaxRow(index)
    val minColumn = BlockIndex.toMinColumn(index)
    val maxColumn = BlockIndex.toMaxColumn(index)

    fun eliminateCandidateFromOtherRows(value: CellValue, rowToExclude: Row): Int {
        var numEliminated = 0

        for (cell in cells) {
            if (cell.candidates.contains(value) && cell.row.index != rowToExclude.index) {
                cell.candidates.eliminateValue(value)
                numEliminated++
                println("Locked Candidate in Row (Claiming): $value excluded from ${Logger.getCellCoordinates(cell)} \n$cell")
            }
        }

        return numEliminated
    }

    fun eliminateCandidateFromOtherColumns(value: CellValue, columnToExclude: Column): Int {
        var numEliminated = 0

        for (cell in cells) {
            if (cell.candidates.contains(value) && cell.column.index != columnToExclude.index) {
                cell.candidates.eliminateValue(value)
                numEliminated++
                println("Locked Candidate in column (Claiming): $value excluded from ${Logger.getCellCoordinates(cell)} \n$cell")
            }
        }

        return numEliminated
    }

    // todo find way to genericize this with what is also in Row
    fun getUniqueRowForCandidateValue(value: CellValue): Int {
        var uniqueRow = -1

        if (getCandidateValueCount(value) > 3) {
            return -1
        }

        for (cell in cells) {
            if (cell.candidates.contains(value)) {
                if (cell.row.index != uniqueRow && uniqueRow != -1) {
                    return -1
                }

                if (cell.row.index == uniqueRow || uniqueRow == -1) {
                    uniqueRow = cell.row.index
                }
            }
        }
        return uniqueRow
    }

    // todo find way to genericize this with what is also in Row
    fun getUniqueColumnForCandidateValue(value: CellValue): Int {
        var uniqueColumn = -1

        if (getCandidateValueCount(value) > 3) {
            return -1
        }

        for (cell in cells) {
            if (cell.candidates.contains(value)) {
                if (cell.column.index != uniqueColumn && uniqueColumn != -1) {
                    return -1
                }

                if (cell.column.index == uniqueColumn || uniqueColumn == -1) {
                    uniqueColumn = cell.column.index
                }
            }
        }
        return uniqueColumn
    }

}