package solver

import components.Block
import components.Cell
import components.Column
import components.Row
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class SingleHiddenTest {

    private lateinit var cell: components.Cell
    private lateinit var otherCell: components.Cell

    private var row = Mockito.mock(Row::class.java)
    private var column = Mockito.mock(Column::class.java)
    private var block = Mockito.mock(Block::class.java)

    private var otherRow = Mockito.mock(Row::class.java)
    private var otherColumn = Mockito.mock(Column::class.java)
    private var otherBlock = Mockito.mock(Block::class.java)

    @Before
    fun setUp() {
        cell = Cell(row = row, column = column, block = block, index = 1)
        cell = Cell(row = row, column = column, block = block, index = 1)

    }

    @Test
    fun check() {
    }

    @Test
    fun testOtherCellSameAsCurrentCell() {
//        assert(!SingleHidden.otherCellHasCandidate(cell, cell, CellValue.FIVE.ordinal))
//        {"Should assert false given the duplicate cells"}
    }

    @Test
    fun testCandidateNotInOtherCell() {


    }

    @Test
    fun testCandidateInOtherCell() {


    }

    @Test
    fun testCheckWithHiddenSingleInRow() {


    }
    @Test
    fun testCheckWithHiddenSingleInColumn() {


    }

    @Test
    fun testCheckWithHiddenSingleInBlock() {


    }

    @Test
    fun testCheckWithSameHiddenSingleInRow() {


    }

    @Test
    fun testCheckWithHiddenSingleInMultiplePlaces() {


    }

    @Test
    fun testCheckWithHiddenSingleInNone() {


    }

    @Test
    fun testCheckWithHiddenSingleInAllThreeRowTypes() {


    }





}