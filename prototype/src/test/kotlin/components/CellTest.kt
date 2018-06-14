package components

import components.CellValue.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class CellTest {

    var row = Mockito.mock(Row::class.java)
    var column = Mockito.mock(Column::class.java)
    var block = Mockito.mock(Block::class.java)

    @Before
    fun setUp() {

        Mockito.`when`(row.values).thenReturn(arrayOf(NONE, NINE, FIVE, THREE, ONE, TWO, ))

        var cell = Cell()

    }

    /**
     * Create mock rows, columns, and blocks and pass them into Cell
     * Run .eliminate()
     * Check values on Cell
     */
    @Test
    fun testEliminateOneValueRemaining() {





    }

    private fun populateMockWithValues(vararg intValues: Int): Array<CellValue> {
        var A

        for (i in 0 until 9) {

        }

    }
}