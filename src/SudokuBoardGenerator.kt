import kotlin.random.Random

class SudokuBoardGenerator {

    private var board = Array(10) {Array(10) {0} }

    // Constructor
    init {

        // initialize board to all zeros
        printBoard()
        generateFullBoardNaive1()
        printBoard()

    }

    fun generateFullBoardNaive2() {

        var currentNum = 1

        //while (currentNum < 10) {

            for (row in 1 until 10) {

                for (col in 1 until 10) {



                    var validCoord = false

                    while(validCoord == false) {

                        // generate random number 1-9
                        var randVal = Random.nextInt(1, 10)

                        // check if the number is in the current row
                        var validRow = valueIsInRow(row, randVal)

                        // check if the number is in the current col
                        var validCol = valueIsInCol(col, randVal)

                        if ((validRow == false) && (validCol == false) && (board[row][col] == 0)) {
                            board[row][col] = randVal

                            println()
                            printBoard()
                            println()

                            validCoord = true
                        }
                    }

                }

                println()
                println()
                println()

                printBoard()

            }

            //++currentNum
        //}

    }

    fun generateFullBoardNaive1() {
        //Create a randomly generated legal Sudoku board with all spaces filled in.

        var currentNum = 1

        /**
         * For each iteration of the col iterator, generate a random row value. Check if the row already contains the value in the current row and col combo.
         */

        while (currentNum < 10) {

            println("*** CurrentNumber: $currentNum")

            val rand = Random

            for (row in 1 until 10) {
                //for (row in 1 until 10) {
                    //board[outer][inner] = i
                    //++i

                    println("Board BEFORE placing number")
                    printBoard()

                    var validLocation = false

                    while(!validLocation) {

                        // generate random col value
                        val randCol = rand.nextInt(1, 10)

                        // check if the space holds a 0 value
                        if (board[randCol][row] == 0) {

                            // check if the currentNum value is already populated in the column
                            if (valueIsInRow(row, currentNum) == false) {
                                // can now place the number in the current index
                                board[randCol][row] = currentNum

                                // set the validLocation var to true.
                                validLocation = true
                            }


                        }



                    }

                    println("Board AFTER placing number")
                    printBoard()

                //}
            }

            ++currentNum

        }
    }

    fun valueIsInRow(row: Int, value: Int): Boolean {

        //Check the board for the value in the given row of the board.
        // returns true if the value is in the given row
        // returns false if the value is NOT in the given row

        var found = false

        for (index in 1 until 10) {

            if (board[index][row] == value) {
                // Row already contains the value
                found = true
                return found
            }

        }

        return found
    }

    fun valueIsInCol(col: Int, value: Int): Boolean {

        // check the board for the value in the given col of the board
        // returns true if the value is in the given col
        // returns false if the value is NOT in the given row

        var found = false

        for (index in 1 until 10) {


            if (board[col][index] == value) {
                found = true
                return found
            }
        }


        return found
    }

    fun generatePuzzleBoard(difficulty: Int) {
        //Generate a Sudoku board with items removed from the board to be solved for a human user.

        /*
        * The difficulty input parameter denotes the number of spaces to be removed from the final board generated.
        * 1 - Easy
        * 2 - Medium
        * 3 - Hard
        *
        * */



    }


    fun printBoard() {


        println()

        for (col in 1 until 10) {
            for (row in 1 until 10) {
                // Print the current 2D array index item
                print(board[col][row].toString() + " ")

                if (row % 3 == 0 && row != 9) {
                    print("| ")
                }

            }

            if (col % 3 == 0 && col != 9) {
                println()
                println("------+-------+------")
            } else {
                println()
            }

        }

        println()

    }



}