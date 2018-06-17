package util

import java.io.File

object FileInput {

    const val inputFilePath =
            "/Users/matthewweser/code/kotlin/SudokuSolverKotlin/prototype/src/main/resources/input/"


    fun importIntArrayList(): ArrayList<Int> {
        var intArrayList = ArrayList<Int>()
        intArrayList.addAll(readFile().split(" ", "\n", " \n", ",").map { it.toInt() })
        return intArrayList
    }

    private fun readFile(): String {
        val fileName = "${inputFilePath}easy01.txt"
        return File(fileName).readText()
    }
}