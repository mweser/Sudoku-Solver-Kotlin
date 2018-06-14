//package components
//
//import components.CellValue.NONE
//import org.junit.Before
//import org.junit.Test
//import org.mockito.Mockito.`when`
//import org.mockito.Mockito.mock
//
//class CellTest {
//
//    lateinit var cell: Cell
//
//    var row = mock(Row::class.java)
//    var column = mock(Column::class.java)
//    var block = mock(Block::class.java)
//
//    @Before
//    fun setUp() {
//
//        `when`(row.values).thenReturn(populateMockWithValues(0, 1, 2, 3, 4, 0, 0, 7, 8, 9))
//        `when`(column.values).thenReturn(populateMockWithValues(0, 0, 2, 0, 4, 0, 6, 0, 8, 0))
//        `when`(block.values).thenReturn(populateMockWithValues(0, 0, 2, 0, 4, 0, 0, 0, 0, 0))
//
//        cell = Cell(row = row, column = column, block = block, index = 1)
//    }
//
//    /**
//     * Create mock rows, columns, and blocks and pass them into Cell
//     * Run .eliminate()
//     * Check values on Cell
//     */
//    @Test
//    fun testEliminateOneValueRemaining() {
//
//        //cell.eliminate()
//
//        assert(true)
//
//    }
//
//    private fun populateMockWithValues(vararg intValues: Int): Array<CellValue> {
//        var valueArray = Array<CellValue>(0) { NONE }
//
//        for (i in 0 until 9) {
//            valueArray[i] = CellValue.values()[intValues[i]]
//        }
//
//        return valueArray
//    }
//}