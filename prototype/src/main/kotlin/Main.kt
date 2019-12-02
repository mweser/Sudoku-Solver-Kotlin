
import components.Table
import solver.DoubleNaked
import solver.Eliminate
import solver.LockedCandidateClaiming
import solver.LockedCandidatePointing
import solver.SingleHidden
import solver.SingleNaked
import util.FileInput.importFileToPuzzleArray
import util.Logger.printRoundNumberAndCandidateTable

fun main(args: Array<String>) {
    var counter = 0
    var isDone = false

    Table.populateCellsWithValues("hard01.txt")
    Eliminate.check()

    while (counter < 30 && !isDone) {
        printRoundNumberAndCandidateTable(counter, Table)
        isDone = solve(counter)
        counter++
    }

    printRoundNumberAndCandidateTable(counter++, Table)

    checkSolution("hard01.txt.soln")

    println("Done")
}

fun checkSolution(inputFile: String) {
    var solutionTable = importFileToPuzzleArray(inputFile)
    var hasMismatch = false


    for(index in 0 until 81) {

        var tableValue = Table.cells.get(index).value.ordinal
        var solutionValue = solutionTable[index]

        if (tableValue != solutionValue) {
            println("ERROR: Mismatch for index $index. Expected: $solutionValue, Actual: $tableValue")
            hasMismatch = true
        }

    }
    if(!hasMismatch) {
        println("Puzzle is correct")
    }
}

fun solve(counter: Int): Boolean {
    var changes = Eliminate.check()
    changes += SingleNaked.check()
    changes += SingleHidden.check()
    changes += LockedCandidatePointing.check()
    changes += LockedCandidateClaiming.check()
    changes += DoubleNaked.check()

    println("Changes for round: $changes")
    return changes == 0
}