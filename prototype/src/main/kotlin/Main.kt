
import components.Table
import solver.DoubleNaked
import solver.Eliminate
import solver.SingleHidden
import solver.SingleNaked
import util.Logger.printRoundNumberAndCandidateTable

fun main(args: Array<String>) {
    var counter = 0
    var isDone = false

    Table.populateCellsWithValues()
    Eliminate.check()

    while (counter < 3 && !isDone) {
        printRoundNumberAndCandidateTable(counter, Table)
        isDone = solve()
        counter++
    }

    printRoundNumberAndCandidateTable(counter++, Table)
}

fun solve(): Boolean {
    var changes = Eliminate.check()
    changes += SingleNaked.check()
    changes += SingleHidden.check()
    changes += DoubleNaked.check()

    return changes == 0
}