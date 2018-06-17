
import components.Table
import solver.rules.Eliminate
import util.Config

fun main(args: Array<String>) {
    run()
}

fun run() {
    Table.populateCellsWithValues()
    println("\n\n")
    println(Table.toString())

    var counter = 0
    val maxIterations = 50
    var isDone = false

    while (counter < 3 && !isDone) {
        isDone = solve()

        if (Config.DISPLAY_TABLE) {
            println("\n\nRound #${counter + 1}")
            println(Table.toString())
            println()
        }
        counter++
    }

    println("Done")
}

fun solve(): Boolean {

    Eliminate.run()



    return false
}