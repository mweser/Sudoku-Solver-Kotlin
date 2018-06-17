
import components.Table
import solver.rules.Eliminate
import solver.rules.SingleHidden
import solver.rules.SingleNaked
import util.Config

fun main(args: Array<String>) {
    run()
}

fun run() {
    Table.populateCellsWithValues()
    println("\n\n")
    println(Table)

    var counter = 0
    val maxIterations = 50
    var isDone = false

    while (counter < 10 && !isDone) {
        isDone = solve()

        if (Config.DISPLAY_TABLE) {
            println("\n\nRound #${counter + 1}")
            println(Table)
            println()
        }
        counter++
    }

    println("Done")
}

fun solve(): Boolean {

    var changes = 0

    changes += Eliminate.check()
    changes += SingleNaked.check()
    changes += SingleHidden.check()


    return changes == 0
}