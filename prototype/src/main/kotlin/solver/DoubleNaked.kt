//package solver
//
//import components.Cell
//import components.Row
//import components.Table
//
//object DoubleNaked : RuleCheck() {
//
//    var count = 0
//
//    override fun check(): Int {
//
//        for (cell in Table.cells) if (cell.getNumCandidates() == 2) {
//
//        }
//
//        return 0
//    }
//
//    fun <T : Row> checkForIdenticalCandidatePair(cell: Cell, vararg rowTypes: T) {
//        for (rowType in rowTypes) {
//            checkForIdenticalCandidatePair(cell, rowType)
//        }
//    }
//
//    fun <T : Row> checkForIdenticalCandidatePair(cell: Cell, rowType: T) {
//
//        for (matchingCell in rowType.getOtherCells(cell)) {
//            if (matchingCell.getNumCandidates() == 2 && matchingCell.candidates == cell.candidates) {
//
//                for (otherCell in rowType.getOtherCells(cell, matchingCell)) {
//                    otherCell.eliminateCandidates()
//
//                }
//
//            }
//        }
//
//    }
//
//}