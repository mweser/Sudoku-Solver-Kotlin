package mapping

object BlockMap {
    fun fromBlockRowColumn(blockRow: Int, blockColumn: Int): Int {
        return blockRow * 3 + blockColumn
    }

    fun toBlockName(blockIndex: Int): BlockPositions {
        return BlockPositions.values()[blockIndex]
    }

    fun toBlockRow(blockIndex: Int): Int {
        return blockIndex / 3
    }

    fun toBlockColumn(blockIndex: Int): Int {
        return blockIndex % 3
    }

    fun toMinRow(blockIndex: Int): Int {
        return toBlockRow(blockIndex) * 3
    }

    fun toMaxRow(blockIndex: Int): Int {
        return toMinRow(blockIndex) + 2
    }

    fun toMinColumn(blockIndex: Int): Int {
        return toBlockColumn(blockIndex) * 3
    }

    fun toMaxColumn(blockIndex: Int): Int {
        return toMinColumn(blockIndex) + 2
    }
}