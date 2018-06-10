enum class BlockName {
    TOP_LEFT,
    TOP_CENTER,
    TOP_RIGHT,
    CENTER_LEFT,
    CENTER,
    CENTER_RIGHT,
    BOTTOM_LEFT,
    BOTTOM_CENTER,
    BOTTOM_RIGHT
}


class BlockMap {

    companion object {
        fun findBlockName(blockRow: Int, blockColumn: Int): BlockName {
            if (blockRow > 2 || blockColumn > 2) {
                throw IndexOutOfBoundsException()
            }
            return BlockName.values()[findBlockIndex(blockRow, blockColumn)]
        }

        fun findBlockIndex(blockRow: Int, blockColumn: Int): Int {
            return blockRow * 3 + blockColumn
        }

        fun findBlockIndexFromCellIndex(cellIndex: Int): Int {
            val 

        }

        fun findBlockRow(blockIndex: Int): Int {
            return blockIndex % 3
        }

        fun findBlockColumn(blockIndex: Int): Int {
            return blockIndex - 3 * findBlockRow(blockIndex)
        }


        fun findCellIndex(rowIndex: Int, columnIndex: Int): Int {
            return columnIndex + rowIndex * 9
        }

        fun findCellRow(cellIndex: Int): Int {
            return cellIndex / 9
        }

        fun findCellColumn(cellIndex: Int): Int {
            return cellIndex % 9
        }
    }

}




