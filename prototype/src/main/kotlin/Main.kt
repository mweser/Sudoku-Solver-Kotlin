import components.Table
import solver.BruteForce
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

    var puzzleFileName = "hard01.txt"

    var table = Table()
    table.populateCellsWithValues(puzzleFileName)

//    Eliminate.check()

    while (counter < 30 && !isDone) {
        printRoundNumberAndCandidateTable(counter, table)
        isDone = solve(table, counter)
        counter++
    }

    printRoundNumberAndCandidateTable(counter++, table)

    checkSolution(table, "$puzzleFileName.soln")

    println("Done")
}

fun checkSolution(table: Table, inputFile: String) {
    var solutionTable = importFileToPuzzleArray(inputFile)
    var numMismatches = 0


    for (index in 0 until 81) {

        var tableValue = table.cells[index].value.ordinal
        var solutionValue = solutionTable[index]

        if (tableValue != solutionValue) {
            println("ERROR: Mismatch for index $index. Expected: $solutionValue, Actual: $tableValue")
            numMismatches++
        }

    }
    if (numMismatches == 0) {
        println("Puzzle is correct")
    } else {
        var percentCorrect = (81 - numMismatches) * 100 / 81
        println("Puzzle is $percentCorrect% correct")
    }
}

fun solve(table: Table, counter: Int): Boolean {
    var changes = Eliminate.check(table)
    changes += SingleNaked.check(table)
    changes += SingleHidden.check(table)
    changes += LockedCandidatePointing.check(table)
    changes += LockedCandidateClaiming.check(table)
    changes += DoubleNaked.check(table)
    changes += BruteForce.check(table)


    println("Changes for round: $changes")
    return changes == 0
}