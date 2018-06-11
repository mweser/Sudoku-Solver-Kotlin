import input.FileInput
import solver.Solver

fun main(args: Array<String>) {

    Solver.run()

    println(FileInput.importIntArrayList())
}