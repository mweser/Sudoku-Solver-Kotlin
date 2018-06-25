package mapping

import org.junit.Test

class CellIndexTest {

    // [0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80]
    private val cellIndices = populateIndexValues()

    @Test
    fun toBlockIndex() {
        val expectedArray: ArrayList<Int> =
                        // [0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80]
                arrayListOf(0, 1,  0,  2,  0, 2,  4,  5,  4,  3,  4,  6,  8,  6,  8,  7,  8)

        var results = ArrayList<Int>()

        for (index in cellIndices) {
            results.add(CellIndex.toBlockIndex(index))
        }
        assert(results == expectedArray) {"\nExpected: $expectedArray\nResults:  $results"}
    }

    @Test
    fun toBlockRow() {
        val expectedArray: ArrayList<Int> =
                        // [0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80]
                arrayListOf(0, 0,  0,  0,  0,  0,  1,  1,  1,  1,  1,  2,  2,  2,  2,  2,  2)

        var results = ArrayList<Int>()

        for (index in cellIndices) {
            results.add(CellIndex.toBlockRow(index))
        }
        assert(results == expectedArray) {"\nExpected: $expectedArray\nResults:  $results"}
    }

    @Test
    fun toBlockColumn() {
        val expectedArray: ArrayList<Int> =
                        // [0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80]
                arrayListOf(0, 1,  0,  2,  0,  2,  1,  2,  1,  0,  1,  0,  2,  0,  2,  1,  2)

        var results = ArrayList<Int>()

        for (index in cellIndices) {
            results.add(CellIndex.toBlockColumn(index))
        }
        assert(results == expectedArray) {"\nExpected: $expectedArray\nResults:  $results"}
    }

    @Test
    fun toRow() {
        val expectedArray: ArrayList<Int> =
                        // [0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80]
                arrayListOf(0, 0,  1,  1,  2,  2,  3,  3,  4,  5,  5,  6,  6,  7,  7,  8,  8)

        var results = ArrayList<Int>()

        for (index in cellIndices) {
            results.add(CellIndex.toRow(index))
        }
        assert(results == expectedArray) {"\nExpected: $expectedArray\nResults:  $results"}

    }

    @Test
    fun toColumn() {
        val expectedArray: ArrayList<Int> =
                        // [0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80]
                arrayListOf(0, 5,  1,  6,  2,  7,  3,  8,  4,  0,  5,  1,  6,  2,  7,  3,  8)

        var results = ArrayList<Int>()

        for (index in cellIndices) {
            results.add(CellIndex.toColumn(index))
        }
        assert(results == expectedArray) {"\nExpected: $expectedArray\nResults:  $results"}

    }

    private fun populateIndexValues(startIndex: Int = 0, endIndex: Int = 81, step: Int = 5): ArrayList<Int> {
        var array = ArrayList<Int>()
        for (index in startIndex until endIndex step step) {
            array.add(index)
        }

        return array
    }
}