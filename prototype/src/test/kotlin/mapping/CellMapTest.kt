package mapping

import org.junit.Before
import org.junit.Test

class CellMapTest {

    @Before
    fun setUp() {
        val cellIndices = populateIndexValues()
        println(cellIndices)
    }

    @Test
    fun fromRowColumn() {

        assert(true)
    }

    @Test
    fun toBlockIndex() {
        val expectedArray: ArrayList<Int> =
                arrayListOf(0, 1, 1, 2, 1, 2)



    }

    @Test
    fun toBlockName() {
    }

    @Test
    fun toBlockRow() {
    }

    @Test
    fun toBlockColumn() {
    }

    @Test
    fun toRow() {
    }

    @Test
    fun toColumn() {
    }

    fun populateIndexValues(startIndex: Int = 0, endIndex: Int = 81, step: Int = 5): ArrayList<Int> {
        var array = ArrayList<Int>()
        for (index in startIndex until endIndex step step) {
            array.add(index)
        }

        return array
    }
}