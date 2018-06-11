package solver

import components.CellValue

class PossibleValueSet(val cellValue: CellValue = CellValue.EMPTY) {

    init { populateWithAllExceptCellValue() }

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