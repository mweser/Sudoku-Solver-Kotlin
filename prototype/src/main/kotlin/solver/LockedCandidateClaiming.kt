package solver

import components.CellValue
import components.Row
import components.Table

object LockedCandidateClaiming: RuleCheck() {

    var count = 0

    override fun check(): Int {
        count = 0

        for (index in 0 until 9) {
            scanRowType(Table.rows[index])
            scanRowType(Table.columns[index])
        }

        return count
    }

    private fun <T : Row> scanRowType(row: T): Int {

        for (value in CellValue.values()) {



        }



        return count
    }

}