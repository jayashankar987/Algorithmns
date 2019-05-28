/**
 *                                  B. New Year and the Christmas Ornament
                                        time limit per test1 second
                                        memory limit per test256 megabytes
                                            inputstandard input
                                            outputstandard output

Alice and Bob are decorating a Christmas Tree.

Alice wants only 3 types of ornaments to be used on the Christmas Tree: yellow, blue and red.
They have 𝑦 yellow ornaments, 𝑏 blue ornaments and 𝑟 red ornaments.

In Bob's opinion, a Christmas Tree will be beautiful if:

the number of blue ornaments used is greater by exactly 1 than the number of yellow ornaments, and
the number of red ornaments used is greater by exactly 1 than the number of blue ornaments.
That is, if they have 8 yellow ornaments, 13 blue ornaments and 9 red ornaments, we can choose 4 yellow,
5 blue and 6 red ornaments (5=4+1 and 6=5+1).

Alice wants to choose as many ornaments as possible, but she also wants the Christmas Tree to be beautiful
according to Bob's opinion.

In the example two paragraphs above, we would choose 7 yellow, 8 blue and 9 red ornaments. If we do it,
we will use 7+8+9=24 ornaments. That is the maximum number.

Since Alice and Bob are busy with preparing food to the New Year's Eve, they are asking you to find out
the maximum number of ornaments that can be used in their beautiful Christmas Tree!

It is guaranteed that it is possible to choose at least 6 (1+2+3=6) ornaments.

Input
The only line contains three integers 𝑦, 𝑏, 𝑟 (1≤𝑦≤100, 2≤𝑏≤100, 3≤𝑟≤100) — the number of yellow, blue and red ornaments.

It is guaranteed that it is possible to choose at least 6 (1+2+3=6) ornaments.

Output
Print one number — the maximum number of ornaments that can be used.

Examples
input
8 13 9

output
24

input
13 3 6

output
9

Note
In the first example, the answer is 7+8+9=24.

In the second example, the answer is 2+3+4=9.


 */




import java.util.*

fun main() {

    val reader = Scanner(System.`in`)

    val input = reader.nextLine().split(" ")

    val totalYellowBalls = input[0].toInt()
    val totalBlueBalls = input[1].toInt()
    val totalRedBalls = input[2].toInt()

    println(compute(totalYellowBalls, totalBlueBalls, totalRedBalls))
}

fun compute(totalYellowBalls: Int, totalBlueBalls: Int, totalRedBalls: Int): Int {

    if (totalRedBalls - 1 <= totalBlueBalls && totalRedBalls - 2 <= totalYellowBalls) {
        return totalRedBalls + (totalRedBalls - 1) + (totalRedBalls - 2)
    } else {
        return if (totalRedBalls < totalBlueBalls && totalRedBalls < totalYellowBalls) {
            compute(totalRedBalls, totalRedBalls - 1, totalRedBalls - 2)
        } else if (totalBlueBalls < totalRedBalls && totalBlueBalls < totalYellowBalls) {
            compute(totalBlueBalls - 1, totalBlueBalls, totalBlueBalls + 1)
        } else {
            if (totalYellowBalls + 1 <= totalBlueBalls && totalYellowBalls + 2 <= totalRedBalls) {
                compute(totalYellowBalls, totalYellowBalls + 1, totalYellowBalls + 2)
            } else {
                compute(
                    totalYellowBalls = totalYellowBalls - 1,
                    totalBlueBalls = totalBlueBalls,
                    totalRedBalls = totalRedBalls
                )
            }
        }

    }
}