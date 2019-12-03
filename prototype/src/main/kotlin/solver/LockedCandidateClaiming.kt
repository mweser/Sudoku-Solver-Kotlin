package solver

import components.CellValue
import components.Column
import components.Row
import components.Table
import mapping.BlockIndex
import mapping.GridPosition

object LockedCandidateClaiming : RuleCheck() {

    var count = 0

    override fun check(table: Table): Int {
        count = 0

        for (index in 0 until 9) {
            scanRowType(table, table.rows[index])
            scanRowType(table, table.columns[index])
        }

        return count
    }

    private fun scanRowType(table: Table, row: Row): Int {

        for (valueIndex in CellValue.ONE.ordinal until CellValue.NINE.ordinal) {

            var value = CellValue.values()[valueIndex]

            var uniqueBlock = row.getUniqueBlockPositionForCandidateValue(value)

            if (uniqueBlock != GridPosition.NONE) {
                var blockIndex = BlockIndex.fromBlockPosition(uniqueBlock)
                count += table.blocks[blockIndex].eliminateCandidateFromOtherRows(value, row)
            }
        }

        return count
    }

    private fun scanRowType(table: Table, column: Column): Int {

        for (valueIndex in CellValue.ONE.ordinal until CellValue.NINE.ordinal) {

            var value = CellValue.values()[valueIndex]

            var uniqueBlock = column.getUniqueBlockPositionForCandidateValue(value)

            if (uniqueBlock != GridPosition.NONE) {
                var blockIndex = BlockIndex.fromBlockPosition(uniqueBlock)
                count += table.blocks[blockIndex].eliminateCandidateFromOtherColumns(value, column)
            }
        }

        return count
    }

}