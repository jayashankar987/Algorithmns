/**
 *                                              C. Letters Rearranging
                                                time limit per test1 second
                                                memory limit per test256 megabytes
                                                inputstandard input
                                                outputstandard output


You are given a string 𝑠 consisting only of lowercase Latin letters.

You can rearrange all letters of this string as you wish. Your task is to obtain a good
string by rearranging the letters of the given string or report that it is impossible to do it.

Let's call a string good if it is not a palindrome. Palindrome is a string which is read
from left to right the same as from right to left. For example, strings "abacaba", "aa" and "z"
are palindromes and strings "bba", "xd" are not.

You have to answer 𝑡 independent queries.

Input
The first line of the input contains one integer 𝑡 (1≤𝑡≤100) — number of queries.

Each of the next 𝑡 lines contains one string. The 𝑖-th line contains a string 𝑠𝑖 consisting
only of lowercase Latin letter. It is guaranteed that the length of 𝑠𝑖 is from 1 to 1000 (inclusive).

Output
Print 𝑡 lines. In the 𝑖-th line print the answer to the 𝑖-th query: -1 if it is impossible
to obtain a good string by rearranging the letters of 𝑠𝑖 and any good string which can be
obtained from the given one (by rearranging the letters) otherwise.

Example
input
3
aa
abacaba
xdd

output
-1
abaacba
xdd


Note
In the first query we cannot rearrange letters to obtain a good string.

Other examples (not all) of correct answers to the second query: "ababaca", "abcabaa", "baacaba".

In the third query we can do nothing to obtain a good string.
 */



import java.util.*

fun main() {
    val reader = Scanner(System.`in`)
    val queries = reader.nextLine().toInt()
    val input = arrayOfNulls<String>(queries)

    for (i in 0 until queries) {
        input[i] = reader.nextLine()
    }

    for (i in 0 until input.size) {
        if (!isPalindrome(input[i])) {
            println(input[i])
        } else {
            getNonPalindromeString(input[i])
        }
    }

}

fun isPalindrome(string: String?): Boolean {
    return string == string?.reversed()
}

fun getNonPalindromeString(string: String?) {
    val values = IntArray(26)
    val chars = string?.iterator()
    var cannotBeANonPalindrome = true
    while (chars?.hasNext() == true) {
        val char = chars.nextChar()
        if (char.toInt() != string[0].toInt()) {
            cannotBeANonPalindrome = false
        }
        values[char.toInt() - 'a'.toInt()]++
    }

    if (cannotBeANonPalindrome) {
        println("-1")
    } else {
        var string = ""
        for (i in 0 until 26) {
            for (j in 0 until values[i]) {
                string = string.plus(('a' + i).toString())
            }
        }
        println(string)
    }
}