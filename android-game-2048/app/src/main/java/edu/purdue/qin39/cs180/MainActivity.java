package edu.purdue.qin39.cs180;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Stack;

/**
 * MainActivity class that serves the same purpose to an Android app as the heart does to humans
 * Basically, the most important class of the app
 *
 * @author Sahil Pujari (pujari@purdue.edu)
 * @author Tori Shurman (vshurman@purdue.edu)
 */
public class MainActivity extends AppCompatActivity {

    //The context of the app. Context is used to refer to certain resources of the app outside of
    //the MainActivity class
    private static Context mContext;

    /**
     * Get the context of the app
     *
     * @return the context of the app
     */
    public static Context getAppContext() {
        return mContext;
    }

    //An object of our TwentyFortyEight class
    private  TwentyFortyEight twentyFortyEight;

    //An object of CustomGrid class
    private  CustomGrid customGrid;

    //The score box text in the app
    private TextView scoreBox;

    private Stack<int[][]> stack = new Stack<>();
    private Stack<Integer> score = new Stack<>();
    private String operation = "";
    /**
     * Called when the activity is starting.  This is where most initialization
     * should go.
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.
     * @see #onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        twentyFortyEight = new TwentyFortyEight(4);
        customGrid = new CustomGrid(twentyFortyEight);

        GridView grid = (GridView) findViewById(R.id.mainGrid);
        scoreBox = (TextView) findViewById(R.id.scoreBox);

        grid.setAdapter(customGrid);

        //TODO: Call the reset() method of your TwentyFortyClass to reset the board when the app
        //first starts
        twentyFortyEight.reset();
        int[][] copy = new int[4][4];
        for (int i = 0; i < 4; ++i) {
            for(int j = 0; j < 4; ++j) {
                copy[i][j] = this.twentyFortyEight.getBoard()[i][j];
            }
        }
        this.stack.push(copy);
        this.score.push(twentyFortyEight.getScore());
        this.operation = "reset";
        //customGrid.updateGrid(twentyFortyEight.getBoard());
    }

    /**
     * Method invoked when the Up button is pressed
     *
     * @param view - the UI of the app
     */
    public void upAction(View view) {
        if (view == null) {
            return;
        }
        //TODO 1: Use the moveUp method of TwentyFortyEight to implement the logic to be performed
        while(twentyFortyEight.moveUp()) {

        }
        twentyFortyEight.placeRandom();
        int[][] copy = new int[4][4];
        for (int i = 0; i < 4; ++i) {
            for(int j = 0; j < 4; ++j) {
                copy[i][j] = this.twentyFortyEight.getBoard()[i][j];
            }
        }
        this.stack.push(copy);
        this.score.push(twentyFortyEight.getScore());
        this.operation = "up";
        //TODO 2: Call the updateGrid method of CustomGrid and pass your TwentyFortyEight's board
        //as parameter
        customGrid.updateGrid(twentyFortyEight.getBoard());
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight
        scoreBox.setText(String.valueOf(score.peek()));
        //NOTE: You should pass the String value of score to setText. Eg. scoreBox.setText(String.valueOf(twentyFortyEighty.getScore()));
    }

    /**
     * Method invoked when the Down button is pressed
     *
     * @param view - the UI of the app
     */
    public void downAction(View view) {
        if (view == null) {
            return;
        }
        //TODO 1: Use the moveUp method of TwentyFortyEight to implement the logic to be performed
        while(twentyFortyEight.moveDown()) {

        }
        twentyFortyEight.placeRandom();
        int[][] copy = new int[4][4];
        for (int i = 0; i < 4; ++i) {
            for(int j = 0; j < 4; ++j) {
                copy[i][j] = this.twentyFortyEight.getBoard()[i][j];
            }
        }
        this.stack.push(copy);
        this.score.push(twentyFortyEight.getScore());
        this.operation = "down";
        //TODO 2: Call the updateGrid method of CustomGrid and pass your TwentyFortyEight's board
        //as parameter
        customGrid.updateGrid(twentyFortyEight.getBoard());
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight
        scoreBox.setText(String.valueOf(this.score.peek()));
        //NOTE: You should pass the String value of score to setText. Eg. scoreBox.setText(String.valueOf(twentyFortyEighty.getScore()));
    }

    /**
     * Method invoked when the Left button is pressed
     *
     * @param view - the UI of the app
     */
    public void leftAction(View view) {
        if (view == null) {
            return;
        }
        //TODO 1: Use the moveUp method of TwentyFortyEight to implement the logic to be performed
        while(twentyFortyEight.moveLeft()) {

        }
        twentyFortyEight.placeRandom();
        int[][] copy = new int[4][4];
        for (int i = 0; i < 4; ++i) {
            for(int j = 0; j < 4; ++j) {
                copy[i][j] = this.twentyFortyEight.getBoard()[i][j];
            }
        }
        this.stack.push(copy);
        this.score.push(twentyFortyEight.getScore());
        this.operation = "left";
        //TODO 2: Call the updateGrid method of CustomGrid and pass your TwentyFortyEight's board
        //as parameter
        customGrid.updateGrid(twentyFortyEight.getBoard());
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight
        scoreBox.setText(String.valueOf(this.score.peek()));
        //NOTE: You should pass the String value of score to setText. Eg. scoreBox.setText(String.valueOf(twentyFortyEighty.getScore()));
    }

    /**
     * Method invoked when the Right button is pressed
     *
     * @param view - the UI of the app
     */
    public void rightAction(View view) {
        if (view == null) {
            return;
        }
        //TODO 1: Use the moveUp method of TwentyFortyEight to implement the logic to be performed
        while(twentyFortyEight.moveRight()) {

        }
        twentyFortyEight.placeRandom();
        int[][] copy = new int[4][4];
        for (int i = 0; i < 4; ++i) {
            for(int j = 0; j < 4; ++j) {
                copy[i][j] = this.twentyFortyEight.getBoard()[i][j];
            }
        }
        this.stack.push(copy);
        this.score.push(twentyFortyEight.getScore());
        this.operation = "right";
        //TODO 2: Call the updateGrid method of CustomGrid and pass your TwentyFortyEight's board
        //as parameter
        customGrid.updateGrid(twentyFortyEight.getBoard());
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight
        scoreBox.setText(String.valueOf(this.score.peek()));
        //NOTE: You should pass the String value of score to setText. Eg. scoreBox.setText(String.valueOf(twentyFortyEighty.getScore()));
    }

    public void resetAction(View view) {
        if (view == null) {
            return;
        }
        this.customGrid.reset();
        this.stack.clear();
        this.operation = "reset";
        scoreBox.setText("0");
    }

    public void undoAction(View view) {
        if (view == null || this.stack.size() == 1 || this.score.size() == 1) {
            return;
        }
        this.stack.pop();
        this.score.pop();
        this.operation = "undo";
        this.twentyFortyEight.setBoard(this.stack.peek());
        customGrid.updateGrid(this.stack.peek());
        scoreBox.setText(String.valueOf(this.score.peek()));
    }

    public void redoAction(View view) {
        if (view == null) {
            return;
        }
        if (this.operation.equals("up")) {
            this.upAction(view);
        } else if (this.operation.equals("down")) {
            this.downAction(view);
        } else if (this.operation.equals("left")) {
            this.leftAction(view);
        } else if (this.operation.equals("right")) {
            this.rightAction(view);
        } else if (this.operation.equals("undo")) {
            this.undoAction(view);
        } else if (this.operation.equals("reset")) {
            this.resetAction(view);
        } else {
            return;
        }
    }
}
