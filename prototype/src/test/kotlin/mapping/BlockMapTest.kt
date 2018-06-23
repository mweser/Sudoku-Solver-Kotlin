package mapping

import org.junit.Test

class BlockMapTest {

    private val indices = populateIndexValues()
    private var results = ArrayList<Int>()
    private var expectedArray = ArrayList<Int>()

    @Test
    fun fromBlockRowColumn() {
        var rows = arrayListOf(0, 0, 0, 1, 1, 1, 2, 2, 2)
        var columns = arrayListOf(0, 1, 2, 0, 1, 2, 0, 1, 2)

        for (i in 0 until indices.size) {
            results.add(BlockMap.fromBlockRowColumn(rows[i], columns[i]))
        }

        assert(results == indices)
        {"\nRows:      $rows\nColumns:   $columns\nExpected:  $indices\nResult:    $results"}

    }

    @Test
    fun toBlockRow() {
        expectedArray = arrayListOf(0, 0, 0, 1, 1, 1, 2, 2, 2)

        for (index in indices) {
            results.add(BlockMap.toBlockRow(index))
        }

        assert(results == expectedArray)
        {"\nInput:    $indices\nExpected: $expectedArray\nResult:   $results"}
    }

    @Test
    fun toBlockColumn() {
        expectedArray = arrayListOf(0, 1, 2, 0, 1, 2, 0, 1, 2)

        for (index in indices) {
            results.add(BlockMap.toBlockColumn(index))
        }

        assert(results == expectedArray)
        {"\nInput:    $indices\nExpected: $expectedArray\nResult:   $results"}
    }

    private fun populateIndexValues(startIndex: Int = 0, endIndex: Int = 9, step: Int = 1): ArrayList<Int> {
        var array = ArrayList<Int>()
        for (index in startIndex until endIndex step step) {
            array.add(index)
        }

        return array
    }
}