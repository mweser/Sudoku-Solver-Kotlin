class Table {

    var blocks = Array(9) {i -> Block(index = i) }
    var rows = Array(9) {i -> Row(index = i) }
    var columns = Array(9) {i -> Column(index = i) }
    var cells = Array(81) {i -> Cell(index = i, value = CellValue.EMPTY) }

    fun printBlocks() {
        for (i in blocks) {
            println(i)
        }
    }


}
