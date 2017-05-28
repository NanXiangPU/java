package edu.purdue.qin39.cs180;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class TwentyFortyEight {
    //This instance variable represents the board. Use this to make changes.
    private int[][] board;
    //This variable keeps track of the current score.
    private int score;

    private Random random;
    private int size;
    //Constructor
    public TwentyFortyEight(int boardWidth){
        // TODO
        this.size = boardWidth;
        this.board = new int[boardWidth][boardWidth];
        this.score = 0;
        this.random = new Random();
        int row = random.nextInt(boardWidth);
        int col = random.nextInt(boardWidth);
        board[row][col] = 2;
    }

    //This function resets the board to its initial state
    public void reset() {
        // TODO
        this.board = new int[this.size][this.size];
        this.score = 0;
        int row = random.nextInt(this.size);
        int col = random.nextInt(this.size);
        board[row][col] = 2;
    }

    //This function returns the total number of blank spaces on the board
    public int numBlanks() {
        // TODO
        int size = this.board[0].length;
        int res = 0;
        for(int i = 0; i < size; ++i) {
            for(int j = 0; j < size; ++j) {
                if(this.board[i][j] == 0) {
                    res += 1;
                }
            }
        }
        return res;

    }

    //This function places a 2 at a random blank space on the board.
    //It does nothing if there are no blank spaces.
    public boolean placeRandom(){
        // TODO
        if(this.numBlanks() == 0) {
            return false;
        }

        int boardWidth = this.board[0].length;
        Random random = new Random();
        int row = random.nextInt(boardWidth);
        int col = random.nextInt(boardWidth);
        while(this.board[row][col] != 0) {
            row = random.nextInt(boardWidth);
            col = random.nextInt(boardWidth);
        }
        board[row][col] = 2;
        return true;
    }

    //This function attempts to move a cell at coordinates fromRow,fromCol to
    //the cell toRow,toCol. Refer to the handout for movement rules.
    public boolean moveTo(int fromRow, int fromCol, int toRow, int toCol) {
        /* TODO 1 If the to piece or the from piece is out of bounds, you cannot shift, so do nothing.
        2 If the to piece and the from piece are not adjacent, do nothing.
              3  If the from piece is a 0, do nothing (nothing to add/move)
        4If the from piece and the to piece have the same value, shift the from piece into the to space, by doubling the to space's value and reducing from to zero.
        5If the to piece is zero, simply move the from piece into the to space.
        Preparation Think about what values are valid for each of the four parameters to have.
         Procedure

      1 Implement the moveTo method. This method returns true if a piece was moved, otherwise it returns false.

        Check the bounds of all the variables (both for adjacency and for the bounds of the board itself)
        If the cell we are moving from is 0, return false
        If the to cell is 0, shift the value in the from cell to the to cell and erase the from cell.
        If the values in from and to are the same, add them, place the added value in to, and clear the from value.
        If the cell values are not equal and greater than zero, return false.
        */
        if ((fromRow < 0 || fromRow >= size || toRow < 0 || toRow >= size)
            || (fromCol < 0 || fromCol >= size || toCol < 0|| toCol >= size)
            || (Math.abs(fromRow - toRow) > 1 || Math.abs(fromCol - toCol) > 1)
            || (board[fromRow][fromCol]) == 0
        ) {
          return false;
        }
        if (board[fromRow][fromCol] == board[toRow][toCol]) {
            board[fromRow][fromCol] = 0;
            board[toRow][toCol] *= 2;
            this.score += board[toRow][toCol];
            return true;
        }
        if (board[toRow][toCol] == 0) {
          board[toRow][toCol] = board[fromRow][fromCol];
          board[fromRow][fromCol] = 0;
          return true;
        }
        return false;
        /*
        if (fromCol < board[0].length && fromCol >= 0&&fromRow < board.length&&fromRow >= 0&& toCol < board[0].length&&toCol >= 0&&toRow < board.length&&toRow >=0) {
            if ((fromRow == toRow + 1&&fromCol==toCol)||(fromRow == toRow - 1&&fromCol==toCol) || (fromCol == toCol + 1&&fromRow==toRow )|| (fromCol == toCol - 1||fromRow==toRow)){
                if (board[fromRow][fromCol] != 0) {
                    if (board[fromRow][toCol]==board[fromRow][toCol]) {
                            board[fromRow][fromCol] = 0;
                            board[toRow][toCol] += board[fromRow][fromCol];
                            score+=2*board[toRow][toCol];
                            return true;
                        } else if (board[toRow][toCol] == 0) {
                            board[toRow][toCol] = board[fromRow][fromCol];
                            board[fromRow][fromCol] = 0;
                            return true;
                        }else if(board[fromRow][fromCol]!=board[toRow][toCol]&&board[fromRow][fromCol]>0&&board[toRow][toCol]>0){
                            return false;
                        }
                    }
                }
        }
        return false;
        */
    }
    //The following four functions move the board in a single direction.
    public boolean moveUp(){
        // TODO
        boolean moved = false;
        for(int i=1;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                    moved = moved || this.moveTo(i,j,i - 1,j);
            }
        }
        return moved;
    }

    public boolean moveDown() {
        // TODO
        boolean moved = false;
        for(int i=0;i<board.length - 1;i++){
            for(int j=0;j<board[0].length;j++){
                moved = moved || this.moveTo(i,j,i + 1,j);
            }
        }
        return moved;
    }

    public boolean moveRight() {
        // TODO
        boolean moved = false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                moved = moved || this.moveTo(i,j,i,j+1);
            }
        }
        return moved;
    }

    public boolean moveLeft() {
        // TODO
        boolean moved = false;
        for(int i=0;i<board.length;i++){
            for(int j=1;j<board[0].length;j++){
                moved = moved || this.moveTo(i,j,i,j-1);
            }
        }
        return moved;
    }

    ////////////////////////////////////////////////////////////////////////
    // Do not edit the methods below, they are for testing and running the
    // program.
    ////////////////////////////////////////////////////////////////////////
    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] newBoard) {
        for (int i = 0; i < newBoard.length; ++i) {
            for (int j = 0; j < newBoard[0].length; ++j) {
                this.board[i][j] = newBoard[i][j];
            }
        }
    }


    /**
     * The main will allow you to play the game.
     *
     * @param args
     */
    public static void main(String args[]) {
        int size = 4;
        TwentyFortyEight tfe = new TwentyFortyEight(size);

        tfe.showBoard(size);

        Scanner s = new Scanner(System.in);
        int bestScore = 0;

        while(true) {
            System.out.println("Current score: " + tfe.getScore() + " | Best score: " + bestScore);
            tfe.showBoard(size);

            System.out.println("Enter up, down, left or right to move in that direction.");
            System.out.println("Enter reset to reset the game or quit to exit.");
            String line = s.nextLine();
            boolean reset = false;
            switch(line){
                case "up":
                    while(tfe.moveUp()){
                        // do nothing
                    }
                    tfe.showBoard(size);
                    break;
                case "down":
                    while(tfe.moveDown()){
                        // do nothing
                    }
                    tfe.showBoard(size);
                    break;
                case "left":
                    while(tfe.moveLeft()){
                        // do nothing
                    }
                    tfe.showBoard(size);
                    break;
                case "right":
                    while(tfe.moveRight()){
                        // do nothing
                    }
                    tfe.showBoard(size);
                    break;
                case "reset":
                    tfe.reset();
                    reset = true;
                    break;
                case "quit":
                    return;
                default:
                    System.out.println("Invalid move, Please try again!!!!\n");
                    continue;

            }

            bestScore = Math.max(bestScore, tfe.getScore());
            if (reset == false) {
              boolean moved = tfe.placeRandom();
              if (moved == false) {
                System.out.println("Game over");
                break;
              }
            }
            reset = false;
        }
    }



    public void showBoard(int boardWidth) {
        for(int x = 0; x < boardWidth * 6 + 1; x++){
            System.out.print("-");
        }
        System.out.println();

        for(int x = 0; x < boardWidth; x++) {
            for(int y = 0; y < boardWidth; y++) {
                String square = (board[x][y] == 0)? "":board[x][y] + "";
                System.out.printf("|%5s", square);
            }
            System.out.println("|");

            for(int y = 0; y < boardWidth * 6 + 1; y++){
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public int getScore() {
        return this.score;
    }

}
