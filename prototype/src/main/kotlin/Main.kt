
import components.Table
import solver.DoubleHidden
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

    while (counter < 30 && !isDone) {
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
    changes += DoubleHidden.check()
    println("Changes for round: $changes")
    return changes == 0
}