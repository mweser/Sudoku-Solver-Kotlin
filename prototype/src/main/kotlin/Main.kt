
import components.Table
import solver.DoubleHidden
import solver.DoubleNaked
import solver.Eliminate
import solver.LockedCandidateClaiming
import solver.LockedCandidatePointing
import solver.SingleHidden
import solver.SingleNaked
import util.Logger.printRoundNumberAndCandidateTable

fun main(args: Array<String>) {
    var counter = 0
    var isDone = false

    Table.populateCellsWithValues("test.txt")
    Eliminate.check()

    while (counter < 30 && !isDone) {
        printRoundNumberAndCandidateTable(counter, Table)
        isDone = solve(counter)
        counter++
    }

    printRoundNumberAndCandidateTable(counter++, Table)
}

fun solve(counter: Int): Boolean {
    var changes = Eliminate.check()
    changes += SingleNaked.check()
    changes += SingleHidden.check()
    changes += LockedCandidatePointing.check()
    changes += LockedCandidateClaiming.check()
    changes += DoubleNaked.check()
    changes += DoubleHidden.check()


    println("Changes for round: $changes")
    return changes == 0
}