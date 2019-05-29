/**
 * B. Bad Days
time limit per test3 seconds
memory limit per test256 megabytes
inputstandard input
outputstandard output
Every day Kotlin heroes analyze the statistics of their website. For 𝑛 days, they wrote out 𝑛 numbers 𝑎1,𝑎2,…,𝑎𝑛, where 𝑎𝑖 is the number of visits on the 𝑖-th day.

They believe that a day is bad if there are at least 2 days before it with a strictly greater number of visits. For example, if 𝑛=8 and 𝑎=[3,1,4,1,5,9,2,6], then the day 4 is bad (because 𝑎4=1, but there are 𝑎1=3 and 𝑎3=4). Also, the day with the number 7 is bad too.

Write a program that finds the number of bad days.

Input
The first line contains an integer 𝑛 (1≤𝑛≤2⋅105), where 𝑛 is the number of days. The second line contains 𝑛 positive integers 𝑎1,𝑎2,…,𝑎𝑛 (1≤𝑎𝑖≤109), where 𝑎𝑖 is the number of website visits on the 𝑖-th day.

Output
Print the number of bad days, i.e. such days that there are at least two days before it with a strictly greater number of visits.

Examples
inputCopy
8
3 1 4 1 5 9 2 6
outputCopy
2
inputCopy
5
1 1 1 1 1
outputCopy
0
inputCopy
13
2 7 1 8 2 8 1 8 2 8 4 5 9
outputCopy
6

 */

fun main() {
    val n = readLine()!!.toInt()
    val days = readLine()!!.split(" ")
    val number = IntArray(2)
    var count = 0

    val list = IntArray(n) { days[it].toInt() }
    if (list.distinct().size != 1) {

        for (i in 0 until days.size) {
            val data = days[i].toInt()
            if (i >= 2 && data < number[number.size - 1] && data < number[number.size - 2]) {
                count++

            }else {
                number.sort()
                if (number[0] < data) {
                    number[0] = data
                }
            }
        }
    }

    println(count)
}