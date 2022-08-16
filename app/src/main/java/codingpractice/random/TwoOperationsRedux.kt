package codingpractice.random

/*
Hackerrank
Two Operations Redux
Given the three integers, x, y, and z convert x to y by repeatedly performing these operations:
adding 1 to x or subtracting 1 from x.
A maximum of z operations can be performed to reach y, and, if necessary, all operations may be the same.
As the operations are applied, keep track of the maximum value that x achieves.
The goal is to create the highest possible value of x somewhere along the way while arriving at the target value within z operations.

Returns - int the maximum integer which can be made from x while converting x to y in at most z steps
if x cannot be converted to y after at most z steps, return -1

Example x= 4, y= 4, z= 4
Output = 6
The maximum achievable value of x is 6
Because a maximum of 4 moves are available, 1 can be added twice till 6 and subtracted twice to arrive back at 4.

Example x= 8, y= 5, z= 3
Output = 8
*/

fun main() {
    println("=======${findMaxNum(5, 3, 4)}")
}

/*
This solution passed 8/13 test cases
todo improvement in test cases
 */
fun findMaxNum(x: Int, y: Int, z: Int): Int {
    var myX = x
    var largeX = -1
    var operations = 0
    if ((myX > y && (myX - z) > y) || (myX < y && (myX + z) < y)) {
        largeX = -1
    } else if ((myX > y && (myX - z) == y)) {
        largeX = myX
    } else if (myX < y && (myX + z) == y) {
        largeX = y
    } else {
        while (operations != z) {
            myX += 1
            operations += 1
            val operationLeft = z - operations
            if ((myX - operationLeft) == y) {
                largeX = myX
                return largeX
            }
        }
    }
    return largeX
}
