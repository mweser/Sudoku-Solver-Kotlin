package util

import java.io.File

object FileInput {

    const val inputFilePath =
            "/Users/matthewweser/code/kotlin/SudokuSolverKotlin/prototype/src/main/resources/input/"


    fun importFileToPuzzleArray(name: String): ArrayList<Int> {
        var intArrayList = ArrayList<Int>()
        intArrayList.addAll(readFile(name).split(" ", "\n", " \n", ",").map { it.toInt() })
        return intArrayList
    }

    private fun readFile(name: String): String {
        val fileName = "${inputFilePath}$name"
        return File(fileName).readText()
    }
}