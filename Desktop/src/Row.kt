class Row(val index: Int) {
    var cells = Array<Cell>(9, {Cell(CellValue.EMPTY)})

    fun isDone(): Boolean {

        for (cell in cells) if (cell.value == CellValue.EMPTY) {
            return false
        }
        return true
    }
}
