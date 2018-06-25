package solver

import components.Block
import components.CellValue
import components.Table

object LockedCandidatePointing : RuleCheck() {

    var count = 0

    override fun check(): Int {
        count = 0

        for (index in 0 until 9) {
            scanBlock(Table.blocks[index])
        }

        return count
    }

    private fun scanBlock(block: Block): Int {

        for (valueIndex in CellValue.ONE.ordinal until CellValue.NINE.ordinal) {

            var value = CellValue.values()[valueIndex]

            var uniqueRow = block.getUniqueRowForCandidateValue(value)
            var uniqueColumn = block.getUniqueColumnForCandidateValue(value)

            if (uniqueRow != -1) {
               count += Table.rows[uniqueRow].eliminateCandidateFromCellsOutsideBlock(value, block)
            }

            if (uniqueColumn != -1) {
               count += Table.columns[uniqueColumn].eliminateCandidateFromCellsOutsideBlock(value, block)
            }

        }

        return count
    }

}
