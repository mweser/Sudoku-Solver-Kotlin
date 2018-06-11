package solver

import components.CellValue

class PossibilitySet(val cellValue: CellValue = CellValue.EMPTY) {

    var array = ArrayList<CellValue>()
    var prevArray = ArrayList<CellValue>()

    fun eliminateValue(cellValue: CellValue) {
        array.remove(cellValue)
    }

    fun populateWithAllExceptCellValue() {
        for (index in 1 until 10) {
            if (cellValue.ordinal != index) {
                array.add(CellValue.values()[index])
            }
        }
    }
}