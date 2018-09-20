//Name: Chenghao Wei
//USC NetID: chenghaw
//CS 455 PA3
//Spring 2018

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * MazeComponent class
 * 
 * A component that displays the maze and path through it if one has been found.
 */
public class MazeComponent extends JComponent {

	private static final int START_X = 10; // top left of corner of maze in frame
	private static final int START_Y = 10;
	private static final int BOX_WIDTH = 20; // width and height of one maze "location"
	private static final int BOX_HEIGHT = 20;
	private static final int INSET = 2;  // how much smaller on each side to make entry/exit inner box
	
	private int numRows;    // number of rows
	private int numCols;    // number of columns
	private int entry_row;  // row number of the entry coordinate
	private int entry_col;  // column number of the entry coordinate
	private int exit_row;  // row number of the exit coordinate
	private int exit_col;  // column number of the exit coordinate
	
	private boolean [][] maze;  //  initialize a maze
	private MazeCoord coord1 = new MazeCoord(0,0);
	private LinkedList<MazeCoord> list = new LinkedList<MazeCoord>() ;
    // build a LinkedList to store the coordinates of each step
	
	/**
	 * Constructs the component.
	 * 
	 * @param maze
	 *            the maze to display
	 */
	public MazeComponent(Maze maze) {
		numRows = maze.numRows();
		numCols = maze.numCols();
		
		this.maze = new boolean [numRows][numCols];

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				this.maze[i][j] = maze.maze[i][j];
			}
		}
		
		entry_row = maze.getEntryLoc().getRow();
		entry_col = maze.getEntryLoc().getCol();
		exit_row = maze.getExitLoc().getRow();
		exit_col = maze.getExitLoc().getCol();
		
		coord1 = maze.getExitLoc();
		list = maze.list ;
	
	}

	/**
	 * Draws the current state of maze including the path through it if one has been found.
	 * 
	 * @param g
	 *            the graphics context
	 */
    public void paintComponent(Graphics g) {
    	//  draw black block for each position of true; draw white block for each position of false; 
    		for (int i=0;i<numRows;i++) {
    			for (int j=0;j<numCols;j++) {
    			    if (this.maze[i][j]) {
    			        	g.setColor(Color.BLACK);
    			    }
    			    else {g.setColor(Color.WHITE);}
    			    g.drawRect(START_X+j*BOX_WIDTH, START_Y+i*BOX_HEIGHT,BOX_WIDTH,BOX_HEIGHT);
    			    g.fillRect(START_X+j*BOX_WIDTH, START_Y+i*BOX_HEIGHT,BOX_WIDTH,BOX_HEIGHT);
    			}
    		}
    		
        //  draw the outer line of the entire maze by black
        g.setColor(Color.BLACK);
        g.drawRect(START_X, START_Y, numCols*BOX_WIDTH, numRows*BOX_HEIGHT);
    		
        //  draw the entry block with yellow
        g.setColor(Color.YELLOW);
        g.drawRect(START_X+entry_col*BOX_WIDTH+INSET, START_Y+entry_row*BOX_HEIGHT+INSET,BOX_WIDTH-INSET-INSET,BOX_HEIGHT-INSET-INSET);
        g.fillRect(START_X+entry_col*BOX_WIDTH+INSET, START_Y+entry_row*BOX_HEIGHT+INSET,BOX_WIDTH-INSET-INSET,BOX_HEIGHT-INSET-INSET);
        
        // draw the exit block with green
        g.setColor(Color.GREEN);
        g.drawRect(START_X+exit_col*BOX_WIDTH+INSET, START_Y+exit_row*BOX_HEIGHT+INSET,BOX_WIDTH-INSET-INSET,BOX_HEIGHT-INSET-INSET);
        g.fillRect(START_X+exit_col*BOX_WIDTH+INSET, START_Y+exit_row*BOX_HEIGHT+INSET,BOX_WIDTH-INSET-INSET,BOX_HEIGHT-INSET-INSET);
    		
        //  use list iterator to traverse all the steps stored in the list
		ListIterator<MazeCoord> iter = list.listIterator();

		// connect the centers of each neighboring block in the list with blue line to show the found path
		g.setColor(Color.BLUE);
		while (iter.hasNext()) {
			MazeCoord coord2 = iter.next();   			
		    g.drawLine(START_X+coord1.getCol()*BOX_WIDTH+BOX_WIDTH/2, START_Y+coord1.getRow()*BOX_HEIGHT+BOX_HEIGHT/2,
		    		       START_X+coord2.getCol()*BOX_WIDTH+BOX_WIDTH/2, START_Y+coord2.getRow()*BOX_HEIGHT+BOX_HEIGHT/2);
		    coord1 = coord2;
		}

    	}

}
