import components.Table
import solver.Eliminate
import solver.SingleHidden
import solver.SingleNaked

fun main(args: Array<String>) {
    var counter = 0
    var isDone = false

    Table.populateCellsWithValues()

    while (counter < 10 && !isDone) {
        println("\nRound #${counter + 1}\n$Table")
        isDone = solve()
        counter++
    }
}

fun solve(): Boolean {
    var changes = Eliminate.check()
    changes += SingleNaked.check()
    changes += SingleHidden.check()

    return changes == 0
}