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
        fun indexToBlockName(blockRow: Int, blockColumn: Int) : BlockName {
            if (blockRow > 2 || blockColumn > 2) {
                throw IndexOutOfBoundsException()
            }
            return BlockName.values()[blockRow * 3 + blockColumn]
        }

        fun findBlockRowFromIndex(blockIndex: Int) : Int {
            return blockIndex % 3
        }

        fun findBlockColumnFromIndex(blockIndex: Int) : Int {
            return blockIndex - 3 * findBlockRowFromIndex(blockIndex)
        }

        fun findCellRowFromIndex(cellIndex: Int) : Int {


            return 0
        }

        fun findCellColumnFromIndex(cellIndex: Int) : Int {

            return 0
        }
    }

}




