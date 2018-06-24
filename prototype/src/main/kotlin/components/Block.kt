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

}