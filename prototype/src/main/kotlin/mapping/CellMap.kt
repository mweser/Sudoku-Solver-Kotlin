package mapping


object CellMap {
    fun fromRowColumn(rowIndex: Int, columnIndex: Int): Int {
        return columnIndex + rowIndex * 9
    }

    fun toRow(cellIndex: Int): Int {
        return cellIndex / 9
    }

    fun toColumn(cellIndex: Int): Int {
        return cellIndex % 9
    }

    fun toBlockIndex(cellIndex: Int): Int {
        return BlockMap.fromBlockRowColumn(toBlockRow(cellIndex), toBlockColumn(cellIndex))
    }

    fun toBlockPosition(cellIndex: Int): GridPosition {
        return BlockMap.toBlockPosition(toBlockIndex(cellIndex))
    }

    fun toBlockRow(cellIndex: Int): Int {
        return toBlockRowOrColumn(toRow(cellIndex))
    }

    fun toBlockColumn(cellIndex: Int): Int {
        return toBlockRowOrColumn(toColumn(cellIndex))
    }

    private fun toBlockRowOrColumn(value: Int): Int {
        return value / 3
    }
}