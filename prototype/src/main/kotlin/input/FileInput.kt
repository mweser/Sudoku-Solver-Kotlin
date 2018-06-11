package input

import java.io.File

object FileInput {

    const val inputFilePath =
            "/Users/matthewweser/code/kotlin/SudokuSolverKotlin/prototype/src/main/resources/input/"

    fun readFile() {
        val fileName = "${inputFilePath}easy01.txt"
        val content = File(fileName).readText()
        println(content)
    }

    

}