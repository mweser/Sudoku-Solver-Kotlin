package solver

import components.Block
import components.Candidates
import components.Cell
import components.CellValue
import components.Column
import components.Row
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class SingleNakedTest {

    private lateinit var cell: Cell

    private var row = Mockito.mock(Row::class.java)
    private var column = Mockito.mock(Column::class.java)
    private var block = Mockito.mock(Block::class.java)
    private var candidates = Candidates()

    @Before
    fun setUp() {
        cell = Cell(row = row, column = column, block = block, index = 1)
        cell.candidates = candidates.clearAllExcept(CellValue.FIVE)

    }

    @Test
    fun testSingleCandidateCheck() {
        SingleNaked.evaluateCell(cell)
        assert(cell.value == CellValue.FIVE) {"Cell value should be FIVE, not ${cell.value}"}
    }

    @Test
    fun testAfterElimination() {


    }

    @Test
    fun testAgainstImmutableCell() {
        cell.value = CellValue.NINE
        assert(!cell.isMutable)

        SingleNaked.evaluateCell(cell)
        assert(!cell.isMutable && cell.value == CellValue.NINE && cell.getNumCandidates() == 0)
    }

    @Test
    fun testShouldFindNoNakedSingles() {
        cell.candidates = candidates.setAll()
        assert(SingleNaked.evaluateCell(cell) == 0)
        assert(cell.value == CellValue.NONE && cell.getNumCandidates() == 9)
    }
}