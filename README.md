# MOOC.fi
### Some of the exercises from University of Helsinki's Object Oriented Programming with Java.<br/><br/>
### Los ejercicios del mooc University of Helsinki's Object Oriented Programming with Java, que me parecieron más interesantes, con  los enunciados de cada uno.




## Instrucciones del ejercicio 33.Dungeon:

In this exercise, you implement a dungeon game. In the game, the player is in a dungeon full of vampires. The player has to destroy the vampires before his lamp runs out of battery and the vampires can suck his blood in the darkness. The player can see the vampires with a blinking of their lamp, after which they have to move blind before the following blinking. With one move, the player can walk as many steps as they want.

The game situation, i.e. the dungeon, the player and the vampires are shown in text form. The first line in the print output tells how many moves the player has left (that is to say, how much battery the lamp has). After that, the print output shows player and vampire positions, which in turn are followed by the game map. In the example below, you see the player (@) and three vampires (v); in this case, the player has enough light for fourteen moves.
  
14  
  
@ 1 2  
v 6 1  
v 7 3  
v 12 2  
  
.................  
......v..........  
.@.........v.....  
.......v.........  
  
The example above shows the lamp has enough battery for 14 blinkings. The player @ is located at 1 2. Note that the coordinates are calculated starting from the high left corner of the game board. In the map below, the character X is located at 0 0, Y is at 2 0 and Z is at 0 2.
  
X.Y..............  
.................  
Z................  
.................  
  
The user can move by giving a sequence of commands and pressing Enter. The commands are:  

    w go up  
    s go down  
    a go left  
    d go right  

When the user commands are executed (the user can give many commands at once), a new game situation is drawn. If the lamp charge reaches 0, the game ends and the text YOU LOSE is printed on the board.

The vampires move randomly in the game, and they take one step for each step the player takes. If the player and a vampire run into each other (even momentarily) the vampire is destroyed. If a vampire tries to step outside the board, or into a place already occupied by another vampire, the move is not executed. When all the vampires are destroyed, the game ends and it prints YOU WIN.

In order to help the tests, create the class Dungeon in your game, with:

    the constructor public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove)

    the values length and height represent the dimension of the dungeon (always a rectangle); vampires stands for the initial number of vampires (the positions of the vampires can be decided randomly); moves determines the initial number of moves; and if vampiresMove is false, the vampires do not move.
    the method public void run(), which starts the game

Attention! The player starts the game in the position 0,0!

Attention! Player and vampires can not move out of the dungeon and two vampires cannot step into the same place!

Attention! Because the random movement of the vampires, the tests might occasionally fail. If you believe your code works, try re-running the tests to see if they succeed on the next try.

Below, you find a couple of examples to help you to understand the situation better:
  
14  
  
@ 0 0  
v 1 2  
v 7 8  
v 7 5  
v 8 0  
v 2 9  
  
@.......v.  
..........  
.v........  
..........  
..........  
.......v..  
..........  
..........  
.......v..  
..v.......  
  
ssd  
13  
  
@ 1 2  
v 8 8  
v 7 4  
v 8 3  
v 1 8  
  
..........  
..........  
.@........  
........v.  
.......v..  
..........  
..........  
..........  
.v......v.  
..........  
  
ssss  
12  
  
@ 1 6  
v 6 9  
v 6 5  
v 8 3  
  
..........  
..........  
..........  
........v.  
..........  
......v...  
.@........  
..........  
..........  
......v...  
  
dd  
11  
  
@ 3 6  
v 5 9  
v 6 7  
v 8 1  
  
..........  
........v.  
..........  
..........  
..........  
..........  
...@......  
......v...  
..........  
.....v....  
  
ddds  
10  
  
@ 6 7  
v 6 6  
v 5 0  
  
.....v....  
..........  
..........  
..........  
..........  
..........  
......v...  
......@...  
..........  
..........  
  
w  
9  
  
@ 6 6  
v 4 0  
  
....v.....  
..........  
..........  
..........  
..........  
..........  
......@...  
..........  
..........  
..........  
  
www  
8  
  
@ 6 3  
v 4 0  
  
....v.....  
..........  
..........  
......@...  
..........  
..........  
..........  
..........  
..........  
..........  
  
aa  
7  
  
@ 4 3  
v 4 2  
  
..........  
..........  
....v.....  
....@.....  
..........  
..........  
..........  
..........  
..........  
..........  
  
w  
YOU WIN  




## Instrucciones del ejercicio 43 Game of life:

### El proyecto incorporaba una interfaz gráfica prefabricada para probar el funcionamiento del programa. Los alumnos solo programamos la lógica.


In this exercise, we implement the application logic of a Game of Life, inheriting a pre-made application body.The application body is in a library which has been added to the project singularly, and its source codes are not visible.

ATTENTION: your task won't be extremely difficult, but the exercise descriptions may look a bit confusing, at first. Read the instruction carefully, or ask for help if you can't get started. The exercise is definitely worth of your energies, because the result is beautiful!

Game of Life is a simple "population simulator" which was developed by the mathematician John Conway; see http://en.wikipedia.org/wiki/Conway%27s_Game_of_Life.

Game of Life rules:

    Every living cell dies if they have less than two living neighbours.
    Every living cell keeps on living during the following iteration (i.e. turn) if they have two or three living neighbours.
    Every living cell dies if they have more than three living neighbours.
    Every dead cell is turned back to life if they have exactly three living neighbours.

The abstract class GameOfLifeBoard provides the following functionality

    public GameOfLifeBoard(int length, int height) creates a game board of the defined dimensions
    public boolean[][] getBoard() provides access to the game board, which is a bidimensional table containing boolean values – as you may guess from the method return value! We come back to bidimensional boards later on when needed.
    public int getWidth() returns the board width
    public int getHeight() returns the board height
    public void playTurn() simulates a turn of the game

The class GameOfLifeBoard has also got the following abstract method, which you will have to implement.

    public abstract void turnToLiving(int x, int y) animates the cell whose coordinates are (x, y), that is to say it assigns the value true to it. If the coordinates are outside the board, nothing happens.
    public abstract void turnToDead(int x, int y) kills the cell whose coordinates are (x, y), that is to say it assigns the value false to it. If the coordinates are outside the board, nothing happens.
    public abstract boolean isAlive(int x, int y) tells whether the cell at (x, y) is alive. If the coordinates are outside the board, the method returns false.
    public abstract void initiateRandomCells(double probabilityForEachCell) initiates all the cells of the board: every cell is alive with a probability of probabilityForEachCell. The probability is a double value between [0, 1]. If a method is called with value 1, all the cells have to be alive. Accordingly, if the probability is 0, all the cells have to be dead.
    public abstract int getNumberOfLivingNeighbours(int x, int y) tells the number of living neighbours for the cell at (x, y).
    public abstract void manageCell(int x, int y, int livingNeighbours) managese the cell (x, y) according to the rules of the Game of Life.

Exercise 43.1: GameOfLife implementation, Part 1

Create the class PersonalBoard into the package game; PersonalBoard inherits the class GameOfLifeBoard which is in the package gameoflife. Note that the package gameoflife is not visible in your project, but it comes together with the class library. In the class PersonalBoard, implement the constructor public PersonalBoard(int width, int height), which calls the superclass constructor with the given parameters:

import gameoflife.GameOfLifeBoard;

public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    // ..

You can first replace all the abstract methods with non-abstract ones, which do not do anything particular anyway, so far. However, because the methods are not abstract, this class can create instances, differently than the abstract class GameOfLifeBoard.

Implement the following methods

    public abstract void turnToLiving(int x, int y) animates the cell whose coordinates are (x, y), that is to say it assigns the value true to it. If the coordinates are outside the board, nothing happens.
    public abstract void turnToDead(int x, int y) kills the cell whose coordinates are (x, y), that is to say it assigns the value false to it. If the coordinates are outside the board, nothing happens.
    public abstract boolean isAlive(int x, int y) tells whether the cell at (x, y) is alive. If the coordinates are outside the board, the method returns false.

Hint: You have access to the bidimensional table of the superclass through the superclass method getBoard(). Bidimensional tables are used as normal tables, but they are assigned two indexes. The first index tells the row and the second tells the column. For instance, the following program chunk creates a 10 x 10 table, and prints the value at (3,1).

boolean[][] values = new boolean[10][10];
System.out.println(values[3][1]);

Accordingly, we can print the value at (x,y) of our PersonalBoard's superclass, in the following way:

boolean[][] board = getBoard();
System.out.println(board[x][y]);

And an index (x,y) can be assigned a value in the following way:

boolean[][] board = getBoard();
board[x][y] = true;

Or straight, using a helping variable:

getBoard()[x][y] = true;

Test your implementation with the following program.

package game;

public class Main {
    public static void main(String[] args) {
        PersonalBoard board = new PersonalBoard(7, 5);

        board.turnToLiving(2, 0);
        board.turnToLiving(4, 0);

        board.turnToLiving(3, 3);
        board.turnToLiving(3, 3);

        board.turnToLiving(0, 2);
        board.turnToLiving(1, 3);
        board.turnToLiving(2, 3);
        board.turnToLiving(3, 3);
        board.turnToLiving(4, 3);
        board.turnToLiving(5, 3);
        board.turnToLiving(6, 2);

        GameOfLifeTester tester = new GameOfLifeTester(board);
        tester.play();
    }
}

The output should look like the following:

Press enter to continue, otherwise quit: <enter>

  X X

X     X
 XXXXX

Press enter to continue, otherwise quit: stop
Thanks!

Exercise 43.2: GameOfLife implementation, Part 2

Implement the method public abstract void initiateRandomCells(double probabilityForEachCell) initiates all the cells of the board: every cell is alive with a probability of probabilityForEachCell. The probability is a double value between [0, 1].

Test the method. Given the value 0.0, there should be no cell alive; given the value 1.0, all the cells should be alive (i.e. visible in the form of X characters). With the value 0.5, around fifty precent of the cells should be alive.

        PersonalBoard board = new PersonalBoard(3, 3);
        board.initiateRandomCells(1.0);

        GameOfLifeTester tester = new GameOfLifeTester(board);
        tester.play();

Press enter to continue, otherwise quit: <enter>

XXX
XXX
XXX
Press enter to continue, otherwise quit: stop
Thanks!

Exercise 43.3: GameOfLife Implementation, part 3

Implement the method getNumberOfLivingNeighbours(int x, int y), which calculates the number of neighbour cells which are alive. Central cells have eight neighbours, the ones on the side have five, and the ones in the corner have only three.

Test the method with the following sentences (of course, you can create your own test instances!):

PersonalBoard board = new PersonalBoard(7, 5);

board.turnToLiving(0, 1);
board.turnToLiving(1, 0);
board.turnToLiving(1, 2);
board.turnToLiving(2, 2);
board.turnToLiving(2, 1);

System.out.println("Neighbours alive (0,0): " + board.getNumberOfLivingNeighbours(0, 0));
System.out.println("Neighbours alive (1,1): " + board.getNumberOfLivingNeighbours(1, 1));

The print output should look like the following:

Neighbours alive (0,0): 2
Neighbours alive (1,1): 5

Exercise 43.4: GameOfLife Implementation, Part 4

Only one method is missing: manageCell(int x, int y, int livingNeighbours). Game of Life rules were the following:

    Every living cell dies if they have less than two living neighbours.
    Every living cell keeps on living during the following iteration (i.e. turn) if they have two or three living neighbours.
    Every living cell dies if they have more than three living neighbours.
    Every dead cell is turned back to life if they have exactly three living neighbours.

Implement the method manageCell(int x, int y, int livingNeighbours) according to the following rules. It's good to program and test one rule at one time!
