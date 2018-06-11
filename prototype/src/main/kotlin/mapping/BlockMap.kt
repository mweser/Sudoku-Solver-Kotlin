package mapping

object BlockMap {
    fun fromBlockRowColumn(blockRow: Int, blockColumn: Int): Int {
        return blockRow * 3 + blockColumn
    }

    fun toBlockPosition(blockIndex: Int): GridPosition {
        return GridPosition.values()[blockIndex]
    }

    fun toBlockRow(blockIndex: Int): Int {
        return blockIndex / 3
    }

    fun toBlockColumn(blockIndex: Int): Int {
        return blockIndex % 3
    }
    
    fun toMinRow(blockIndex: Int): Int {
        return toMin(toBlockRow(blockIndex))
    }

    fun toMinColumn(blockIndex: Int): Int {
        return toMin(toBlockColumn(blockIndex))
    }

    fun toMaxRow(blockIndex: Int): Int {
        return toMax(toMinRow(blockIndex))
    }

    fun toMaxColumn(blockIndex: Int): Int {
        return toMax(toMinColumn(blockIndex))
    }

    private fun toMax(value: Int): Int {
        return value + 2
    }

    private fun toMin(value: Int): Int {
        return value * 3
    }
}