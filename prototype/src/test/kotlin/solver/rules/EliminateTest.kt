package solver.rules

import com.nhaarman.mockito_kotlin.whenever
import components.Block
import components.Cell
import components.CellValue
import components.Column
import components.Row
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import solver.Eliminate
import kotlin.math.min

class EliminateTest {

    private lateinit var cell: Cell

    private var row = Mockito.mock(Row::class.java)
    private var column = Mockito.mock(Column::class.java)
    private var block = Mockito.mock(Block::class.java)

    @Before
    fun setUp() {
        cell = Cell(row = row, column = column, block = block, index = 1)
    }

    /**
     * Create mock rows, columns, and blocks and pass them into Cell
     * Run .eliminateCandidate()
     * Check values on Cell
     */
    @Test
    fun testEliminateOneValueRemainingValueIsFive() {

        whenever(row.values).thenReturn(populateMockWithValues(0, 1, 2, 3, 4, 0, 0, 7, 9))
        whenever(column.values).thenReturn(populateMockWithValues(0, 0, 2, 0, 4, 0, 6, 0, 8))
        whenever(block.values).thenReturn(populateMockWithValues(0, 0, 2, 0, 4, 0, 0, 0, 0))

        Eliminate.eliminateFromCell(cell)

        assert(cell.getNumCandidates() == 1) {"Number of candidates: ${cell.getNumCandidates()}"}
        assert(cell.value == CellValue.NONE) {"$cell"}
    }

    @Test
    fun testEliminateTwoCandidatesRemaining() {
        whenever(row.values).thenReturn(populateMockWithValues(0, 1, 2, 3, 4, 0, 0, 7, 0))
        whenever(column.values).thenReturn(populateMockWithValues(0, 0, 2, 0, 4, 0, 6, 0, 8))
        whenever(block.values).thenReturn(populateMockWithValues(0, 0, 2, 0, 4, 0, 0, 0, 0))

        Eliminate.eliminateFromCell(cell)

        assert(cell.getNumCandidates() == 2 &&
                cell.value == CellValue.NONE &&
                cell.candidates.assertTrueCandidates(CellValue.FIVE, CellValue.NINE))
    }

    @Test
    fun testEliminateNineCandidatesRemaining() {
        whenever(row.values).thenReturn(populateMockWithValues(0))
        whenever(column.values).thenReturn(populateMockWithValues(0))
        whenever(block.values).thenReturn(populateMockWithValues(0))

        Eliminate.eliminateFromCell(cell)
        assert(cell.getNumCandidates() == 9 &&
                cell.value == CellValue.NONE &&
                cell.candidates.assertTrueCandidates(CellValue.FIVE, CellValue.NINE, CellValue.ONE, CellValue.TWO, CellValue.THREE, CellValue.FOUR, CellValue.SIX, CellValue.SEVEN, CellValue.EIGHT))
    }

    @Test
    fun testEliminateAllValuesTaken() {
        whenever(row.values).thenReturn(populateMockWithValues(0, 1, 2, 3, 4, 0, 0, 7, 0))
        whenever(column.values).thenReturn(populateMockWithValues(0, 0, 2, 0, 4, 0, 6, 0, 8))
        whenever(block.values).thenReturn(populateMockWithValues(9, 0, 2, 0, 4, 5, 0, 9, 0))

//        assertFailsWith(java.lang.Exception, cell.eliminateCandidate())

        // todo Assert exception thrown here
        assert(true)
//        assert(cell.numCandidates == 0 &&
//                cell.value == NONE) { "Cell value is ${cell.value}" }
    }

    private fun populateMockWithValues(vararg intValues: Int): Array<CellValue> {
        var valueArray = Array(9) { CellValue.NONE }

        val maxIndex = min(intValues.size, valueArray.size)

        for (i in 0 until maxIndex) {
            valueArray[i] = CellValue.values()[intValues[i]]
        }

        return valueArray
    }
}