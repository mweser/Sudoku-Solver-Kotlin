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
        fun indexToBlockName(blockRow: Int, blockColumn: Int): BlockName {
            return indexToBlockName(blockRow * 3 + blockColumn)
        }

        fun indexToBlockName(index: Int): BlockName {
            if (index > 8) {
                throw IndexOutOfBoundsException()
            }
            return BlockName.values()[index]
        }
    }

}




