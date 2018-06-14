package components

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class CellTest {

    var row = Mockito.mock(Row::class.java)
    var block = Mockito.mock(Row::class.java)
    var column = Mockito.mock(Row::class.java)

    @Before
    fun setUp() {
    }

    /**
     * Create mock rows, columns, and blocks and pass them into Cell
     * Run .eliminate()
     * Check values on Cell
     */
    @Test
    fun testEliminateOneValueRemaining() {





    }
}