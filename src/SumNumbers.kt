/**
 * A. Three Integers Again
time limit per test1 second
memory limit per test256 megabytes
inputstandard input
outputstandard output
We have three positive integers 𝑎, 𝑏 and 𝑐. You don't know their values, but you know some information about them. Consider all three pairwise sums, i.e. the numbers 𝑎+𝑏, 𝑎+𝑐 and 𝑏+𝑐. You know exactly two (any) of three pairwise sums.

Your task is to find such three positive integers 𝑎, 𝑏 and 𝑐 which match the given information. It means that if you consider 𝑎+𝑏, 𝑎+𝑐 and 𝑏+𝑐, two out of all three of them are given in the input. Among all such triples, you must choose one with the minimum possible sum 𝑎+𝑏+𝑐, and among all triples with the minimum sum, you can print any.

You have to process 𝑞 independent queries.

Input
The first line of the input contains one integer 𝑞 (1≤𝑞≤1000) — the number of queries.

The next 𝑞 lines contain queries. Each query is given as two integers 𝑥 and 𝑦 (2≤𝑥,𝑦≤2⋅109), where 𝑥 and 𝑦 are any two out of the three numbers 𝑎+𝑏, 𝑎+𝑐 and 𝑏+𝑐.

Output
For each query print the answer to it: three positive integers 𝑎, 𝑏 and 𝑐 consistent with the given information. Among all such triples, you have to choose one with the minimum possible sum 𝑎+𝑏+𝑐. Among all triples with the minimum sum, you can print any.

Example
inputCopy
3
123 13
2 2
2000000000 2000000000
outputCopy
111 1 12
1 1 1
1999999999 1 1

 */

fun main() {

    val quries = readLine()!!.toInt()
    val anss = mutableListOf<String>()

    for (i in 0 until quries) {
        var ans: String
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }



        when {
            x == y -> anss.add("${x-1} 1 1")
            x - y > 0 -> {
                val b = 1
                val a = x - y + b
                val c = y - b

                ans = "$a $b $c"
                anss.add(ans)
            }
            else -> {
                val a = 1
                val b = y - x + a
                val c = y - b
                ans = "$a $b $c"
                anss.add(ans)
            }
        }



    }

    for (i in 0 until anss.size) {
        println(anss[i])
    }
}