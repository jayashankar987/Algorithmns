/**
 * C. Minus and Minus Give Plus
time limit per test3 seconds
memory limit per test256 megabytes
inputstandard input
outputstandard output
Everyone knows that two consecutive (adjacent) "minus" signs can be replaced with a single "plus" sign.

You are given the string 𝑠, consisting of "plus" and "minus" signs only. Zero or more operations can be performed with it. In each operation you can choose any two adjacent "minus" signs, and replace them with a single "plus" sign. Thus, in one operation, the length of the string is reduced by exactly 1.

You are given two strings 𝑠 and 𝑡. Determine if you can use 0 or more operations to get the string 𝑡 from the string 𝑠.

Input
The first line of the input contains an integer 𝑘 (1≤𝑘≤105), denoting the number of test cases in the input. The following lines contain descriptions of the test sets, each set consists of two lines. First comes the line containing 𝑠 (the length of the line 𝑠 does not exceed 2⋅105), then comes the line containing 𝑡 (the length of the line 𝑡 does not exceed 2⋅105). The lines 𝑠 and 𝑡 are non-empty, and they contain only "plus" and "minus" signs.

The sum of the lengths of lines 𝑠 over all test cases in the input does not exceed 2⋅105. Similarly, the sum of the lengths of lines 𝑡 over all test cases in the input does not exceed 2⋅105.

Output
Print 𝑘 lines: the 𝑖-th line must contain YES if the answer to the 𝑖-th test case is positive, otherwise NO. Print YES and NO using uppercase letters only.

Example
inputCopy
5
-+--+
-+++
--------
-+--+-
-
+
--
---
+++
+++
outputCopy
YES
YES
NO
NO
YES

 */

fun main() {
    val n = readLine()!!.toInt()

    for (i in 0 until n) {
        val sString = ArrayList(readLine()!!.split("").map { it })
        val tString = readLine()!!.split("").map { it }

        println(compute(sString, tString))
    }
}

fun compute(x: ArrayList<String>, y: List<String>): String {

    if (x.size < y.size) {
        return "NO"
    } else if (x.size == y.size) {
        return if (x == y) {
            "YES"
        } else {
            "NO"
        }
    } else {
        for (i in 0 until y.size) {
            if (x[i] == y[i]) {
                continue
            } else if (y[i] == "+" && (x[i] == "-" && x[i + 1] == "-")) {
                x[i] = "+"
                x.removeAt(i + 1)
                break
            } else {
                return "NO"
            }
        }
        return compute(x, y)
    }


}


