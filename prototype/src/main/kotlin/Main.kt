import components.Table
import solver.Eliminate
import solver.SingleHidden
import solver.SingleNaked
import util.Logger.printCandidateTable
import util.Logger.printRoundNumberAndTable

fun main(args: Array<String>) {
    var counter = 0
    var isDone = false

    Table.populateCellsWithValues()

    while (counter < 10 && !isDone) {
        printRoundNumberAndTable(counter, Table)
        isDone = solve()
        counter++
    }

    printCandidateTable(Table)
}

fun solve(): Boolean {
    var changes = Eliminate.check()
    changes += SingleNaked.check()
    changes += SingleHidden.check()

    return changes == 0
}