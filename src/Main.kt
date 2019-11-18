import java.lang.NumberFormatException
import kotlin.random.Random

fun main(args: Array<String>) {
    val generatedNumber = Random.nextInt(1, 100)
    var steps = 7 // i had to :(
    var enteredNumber: Int?

    println("Select a difficulty level. 1- Easy, 2- Medium, 3- Hard")
    val difficultyLevel = readLine()
    if (difficultyLevel != null) {
        if (difficultyLevel == "1" || difficultyLevel == "2" || difficultyLevel == "3") {
            when (difficultyLevel) {
                "1" -> steps = 7
                "2" -> steps = 5
                "3" -> steps = 3
            }
            println("You chose level $difficultyLevel")
        } else {
            println("You must choose 1, 2 or 3")
            return
        }
    }

    println("Guess the number between 1 and 100, in $steps steps")
    val anotherTurn = steps
    while (steps-- > 0) {
        try {
            enteredNumber = readLine()?.toInt()
        } catch (e: NumberFormatException) {
            println("Not a number")
            println("Guess the number between 1 and 100, in ${++steps} steps")
            continue
        }
        if ((enteredNumber != null) && (enteredNumber in 1..100)) {
             if (enteredNumber.toInt() == generatedNumber) {
                println("You won!")
                break
            }
            if (steps == 0) {
                println("Restart")
                println("Guess the number between 1 and 100, in $anotherTurn steps")
                steps = anotherTurn
                continue
            } 
            if (enteredNumber.toInt() > generatedNumber) {
                println("Take lower")
            }
            if (enteredNumber.toInt() < generatedNumber) {
                println("Take higher")
            }

        } else {
            println("Make sure you choose in range of 1..100, you have ${++steps} steps")
            continue

        }
    }
}






