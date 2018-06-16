package components

import com.nhaarman.mockito_kotlin.whenever
import components.CellValue.FIVE
import components.CellValue.NONE
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

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

//    @Test
//    fun testEliminateTwoCandidatesRemaining() {
//
//        whenever(row.values).thenReturn(populateMockWithValues(0, 1, 2, 3, 4, 0, 0, 7, 0))
//        whenever(column.values).thenReturn(populateMockWithValues(0, 0, 2, 0, 4, 0, 6, 0, 8))
//        whenever(block.values).thenReturn(populateMockWithValues(0, 0, 2, 0, 4, 0, 0, 0, 0))
//
//        cell.eliminate()
//        assert(cell.numCandidates == 2 && cell.value == NONE)
//    }
//
//    private fun assertCandidateValues(candidates: Candidates, vararg candidateValues: CellValue): Boolean {
//
//        for (candidateValue in candidateValues) {
//
//
//        }
//
//
//    }

    private fun populateMockWithValues(vararg intValues: Int): Array<CellValue> {
        var valueArray = Array(9) { NONE }

        for (i in 0 until valueArray.size) {
            valueArray[i] = CellValue.values()[intValues[i]]
        }

        return valueArray
    }
}