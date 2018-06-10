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
    fun lookUpBlock(blockRow: Int, blockColumn: Int): BlockName {
        if (blockRow > 8 || blockColumn > 8) {
            throw IndexOutOfBoundsException()
        }

        val indexValue = blockRow * 3 + blockColumn
        return BlockName.values()[indexValue]
    }
}




