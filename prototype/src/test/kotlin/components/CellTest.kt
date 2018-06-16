package components

import com.nhaarman.mockito_kotlin.whenever
import components.CellValue.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import kotlin.math.min

class CellTest {

    lateinit var cell: Cell

    var row = mock(Row::class.java)
    var column = mock(Column::class.java)
    var block = mock(Block::class.java)

    @Before
    fun setUp() {


        cell = Cell(row = row, column = column, block = block, index = 1)
    }

    /**
     * Create mock rows, columns, and blocks and pass them into Cell
     * Run .eliminate()
     * Check values on Cell
     */
    @Test
    fun testEliminateOneValueRemainingValueIsFive() {

        whenever(row.values).thenReturn(populateMockWithValues(0, 1, 2, 3, 4, 0, 0, 7, 9))
        whenever(column.values).thenReturn(populateMockWithValues(0, 0, 2, 0, 4, 0, 6, 0, 8))
        whenever(block.values).thenReturn(populateMockWithValues(0, 0, 2, 0, 4, 0, 0, 0, 0))

        cell.eliminate()
        assert(cell.numCandidates == 0 && cell.value == FIVE)
    }

    @Test
    fun testEliminateTwoCandidatesRemaining() {
        whenever(row.values).thenReturn(populateMockWithValues(0, 1, 2, 3, 4, 0, 0, 7, 0))
        whenever(column.values).thenReturn(populateMockWithValues(0, 0, 2, 0, 4, 0, 6, 0, 8))
        whenever(block.values).thenReturn(populateMockWithValues(0, 0, 2, 0, 4, 0, 0, 0, 0))

        cell.eliminate()
        assert(cell.numCandidates == 2 &&
                cell.value == NONE &&
                cell.candidates.assertTrueCandidates(FIVE, NINE))
    }

    @Test
    fun testEliminateNineCandidatesRemaining() {
        whenever(row.values).thenReturn(populateMockWithValues(0))
        whenever(column.values).thenReturn(populateMockWithValues(0))
        whenever(block.values).thenReturn(populateMockWithValues(0))

        cell.eliminate()
        assert(cell.numCandidates == 9 &&
                cell.value == NONE &&
                cell.candidates.assertTrueCandidates(FIVE, NINE, ONE, TWO, THREE, FOUR, SIX, SEVEN, EIGHT))
    }

    @Test
    fun testEliminateAllValuesTaken() {
        whenever(row.values).thenReturn(populateMockWithValues(0, 1, 2, 3, 4, 0, 0, 7, 0))
        whenever(column.values).thenReturn(populateMockWithValues(0, 0, 2, 0, 4, 0, 6, 0, 8))
        whenever(block.values).thenReturn(populateMockWithValues(9, 0, 2, 0, 4, 5, 0, 9, 0))

        cell.eliminate()

        assert(cell.numCandidates == 0 &&
                cell.value == NONE) { "Cell value is ${cell.value}" }
    }

    private fun populateMockWithValues(vararg intValues: Int): Array<CellValue> {
        var valueArray = Array(9) { NONE }

        val maxIndex = min(intValues.size, valueArray.size)

        for (i in 0 until maxIndex) {
            valueArray[i] = CellValue.values()[intValues[i]]
        }

        return valueArray
    }
}