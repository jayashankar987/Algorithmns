/**
 * D. Got Any Grapes?
time limit per test1 second
memory limit per test256 megabytes
inputstandard input
outputstandard output

For simplicity, we'll assume that there are only three types of grapes: green grapes,
purple grapes and black grapes.

Andrew, Dmitry and Michal are all grapes' lovers, however their preferences of grapes are different.
To make all of them happy, the following should happen:

Andrew, Dmitry and Michal should eat at least 𝑥, 𝑦 and 𝑧 grapes, respectively.
Andrew has an extreme affinity for green grapes, thus he will eat green grapes and green grapes only.
On the other hand, Dmitry is not a fan of black grapes — any types of grapes except black would do for him.
In other words, Dmitry can eat green and purple grapes.
Michal has a common taste — he enjoys grapes in general and will be pleased with any types of grapes,
as long as the quantity is sufficient.
Knowing that his friends are so fond of grapes, Aki decided to host a grape party with them.
He has prepared a box with 𝑎 green grapes, 𝑏 purple grapes and 𝑐 black grapes.

However, Aki isn't sure if the box he prepared contains enough grapes to make everyone happy.
Can you please find out whether it's possible to distribute grapes so that everyone is happy or
Aki has to buy some more grapes?

It is not required to distribute all the grapes, so it's possible that some of them will remain unused.

Input
The first line contains three integers 𝑥, 𝑦 and 𝑧 (1≤𝑥,𝑦,𝑧≤105) — the number of grapes Andrew,
Dmitry and Michal want to eat.

The second line contains three integers 𝑎, 𝑏, 𝑐 (1≤𝑎,𝑏,𝑐≤105) — the number of green,
purple and black grapes in the box.

Output
If there is a grape distribution that allows everyone to be happy, print "YES", otherwise print "NO".

Examples
input
1 6 2
4 3 3

output
YES

input
5 1 1
4 3 2

output
NO

Note
In the first example, there is only one possible distribution:

Andrew should take 1 green grape, Dmitry should take 3 remaining green
grapes and 3 purple grapes, and Michal will take 2 out of 3 available black grapes.

In the second test, there is no possible distribution, since Andrew is not be able to eat enough green grapes.*/


import java.util.*

fun main(args: Array<String>) {

    val reader = Scanner(System.`in`)
    val input1 = reader.nextLine()
    val input2 = reader.nextLine()

    val neededGrapes = input1.split(" ")
    val andrewWants = neededGrapes[0].toInt()
    val dmitryWants = neededGrapes[1].toInt()
    val michalWants = neededGrapes[2].toInt()

    val totalAvailableGrapes = input2.split(" ")

    var totalGreenGrapes = totalAvailableGrapes[0].toInt()
    var totalPurpleGrapes = totalAvailableGrapes[1].toInt()
    var totalBlackGrapes = totalAvailableGrapes[2].toInt()


    if (andrewWants > totalGreenGrapes) {
        println("NO")
        return
    } else {
        totalGreenGrapes -= andrewWants;
    }

    if (dmitryWants > (totalGreenGrapes + totalPurpleGrapes)) {
        println("NO")
        return
    } else {
        totalGreenGrapes -= dmitryWants
        if (totalGreenGrapes < 0) {
            totalPurpleGrapes += totalGreenGrapes
            totalGreenGrapes = 0
        }
    }

    if (michalWants > (totalGreenGrapes + totalPurpleGrapes + totalBlackGrapes)) {
        println("NO")
        return
    }

    println("YES")

}