package components

import mapping.BlockMap
import util.Mockable

@Mockable
class Block(index: Int): Row(index) {
    val position = BlockMap.toBlockPosition(index)

    val blockRow = BlockMap.toBlockRow(index)
    val blockColumn = BlockMap.toBlockColumn(index)

    val minRow = BlockMap.toMinRow(index)
    val maxRow = BlockMap.toMaxRow(index)
    val minColumn = BlockMap.toMinColumn(index)
    val maxColumn = BlockMap.toMaxColumn(index)
}