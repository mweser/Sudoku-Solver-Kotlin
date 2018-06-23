
import components.Table
import solver.Eliminate
import solver.SingleHidden
import solver.SingleNaked
import util.Logger.printRoundNumberAndCandidateTable

fun main(args: Array<String>) {
    var counter = 0
    var isDone = false

    Table.populateCellsWithValues()
    Eliminate.check()

    while (counter < 10 && !isDone) {
        printRoundNumberAndCandidateTable(counter, Table)
        isDone = solve()
        counter++
    }
}

fun solve(): Boolean {
    var changes = SingleNaked.check()
    changes += SingleHidden.check()

    return changes == 0
}