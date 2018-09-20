//Name: Chenghao Wei
//USC NetID: chenghaw
//CS 455 PA3
//Spring 2018

import java.util.LinkedList;

/**
 * Maze class
 * 
 * Stores information about a maze and can find a path through the maze (if
 * there is one).
 * 
 * Assumptions about structure of the maze, as given in mazeData, entryLoc, and
 * endLoc (parameters to constructor), and the path: -- no outer walls given in
 * mazeData -- search assumes there is a virtual border around the maze (i.e.,
 * the maze path can't go outside of the maze boundaries) -- entry location for
 * a path is maze coordinate entryLoc -- exit location is maze coordinate
 * exitLoc -- mazeData input is a 2D array of booleans, where true means there
 * is a wall at that location, and false means there isn't (see public FREE /
 * WALL constants below) -- in mazeData the first index indicates the row. e.g.,
 * mazeData[row][col] -- only travel in 4 compass directions (no diagonal paths)
 * -- can't travel through walls
 * 
 */

public class Maze {

	public static final boolean FREE = false;
	public static final boolean WALL = true;
	
	private int numRows;
	private int numCols;
	public static final int left=1;
	public static final int right=2;
	public static final int up=3;
	public static final int down=4;	

	boolean [][] maze;

	private MazeCoord getEntryLoc;
	private MazeCoord getExitLoc;
	LinkedList<MazeCoord> list = new LinkedList<MazeCoord>() ;
	
	/**
	 * Constructs a maze.
	 * 
	 * @param mazeData
	 *            the maze to search. See general Maze comments above for what goes
	 *            in this array.
	 * @param entryLoc
	 *            the location in maze to entry the search (not necessarily on an
	 *            edge)
	 * @param exitLoc
	 *            the "exit" location of the maze (not necessarily on an edge) PRE:
	 *            0 <= entryLoc.getRow() < mazeData.length and 0 <=
	 *            entryLoc.getCol() < mazeData[0].length and 0 <= endLoc.getRow() <
	 *            mazeData.length and 0 <= endLoc.getCol() < mazeData[0].length
	 * 
	 */
	public Maze(boolean[][] mazeData, MazeCoord entryLoc, MazeCoord exitLoc) {
		numRows = mazeData.length;
		numCols = mazeData[0].length;
		maze = new boolean [numRows][numCols];
		
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
					maze[i][j] = mazeData[i][j];
				}
			}
		
		getEntryLoc = new MazeCoord(entryLoc.getRow(),entryLoc.getCol());
		getExitLoc = new MazeCoord(exitLoc.getRow(),exitLoc.getCol());
	}

	/**
	 * Returns the number of rows in the maze
	 * 
	 * @return number of rows
	 */
	public int numRows() {
		return numRows;
	}

	/**
	 * Returns the number of columns in the maze
	 * 
	 * @return number of columns
	 */
	public int numCols() {
		return numCols;
	}

	/**
	 * Returns true iff there is a wall at this location
	 * 
	 * @param loc
	 *            the location in maze coordinates
	 * @return whether there is a wall here PRE: 0 <= loc.getRow() < numRows() and 0
	 *         <= loc.getCol() < numCols()
	 */
	public boolean hasWallAt(MazeCoord loc) {
	    return (maze[loc.getRow()][loc.getCol()])?true:false; // return the value of given coordinate is true or false
	}

	/**
	 * Returns the entry location of this maze.
	 */
	public MazeCoord getEntryLoc() {
		return getEntryLoc;
	}

	/**
	 * Returns the exit location of this maze.
	 */
	public MazeCoord getExitLoc() {
		return getExitLoc;
	}

	/**
	 * Returns the path through the maze. First element is entry location, and last
	 * element is exit location. If there was not path, or if this is called before
	 * a call to search, returns empty list.
	 * 
	 * @return the maze path
	 */
	public LinkedList<MazeCoord> getPath() {
		
		return list;

	}

	/** 
	 * Find a path from entry location to the exit location (see Maze constructor
	 * parameters, entryLoc and exitLoc) if there is one. Client can access the path
	 * found via getPath method.
	 * 
	 * @return whether a path was found.
	 */
	public boolean search() {
	    // call searchHelper function with all directions and return the union result
		return searchHelper(getEntryLoc.getRow(),getEntryLoc.getCol(),up) || 
			   searchHelper(getEntryLoc.getRow(),getEntryLoc.getCol(),down) ||
			   searchHelper(getEntryLoc.getRow(),getEntryLoc.getCol(),left) ||
			   searchHelper(getEntryLoc.getRow(),getEntryLoc.getCol(),right); 

	}
	
	public boolean valid(int x, int y) {
		if(x>=0 && x<numRows && y>=0 && y<numCols && !maze[x][y]) {
			return true;
		}
		else return false;
	}
	
	public boolean searchHelper(int x, int y, int dirc) {
        // dirc: direction of the last step to current step
		if (x==getExitLoc.getRow() && y==getExitLoc.getCol()) {
			return true;
		}

		if (valid(x,y)) {
			maze[x][y]=true;
            // set the position to be wall to prevent coming to the same position again
			
			if (dirc!=left && searchHelper(x,y-1,right)) {
				list.add(new MazeCoord(x,y));	// add the position into the path LinkedList
				return true;
			}
			else if (dirc!=right && searchHelper(x,y+1,left)) {
				list.add(new MazeCoord(x,y));	// add the position into the path LinkedList
				return true;	
			}
			else if (dirc!=up && searchHelper(x-1,y,down)) {		
				list.add(new MazeCoord(x,y));	// add the position into the path LinkedList
				return true;
			}
			else if (dirc!=down && searchHelper(x+1,y,up)) {		
				list.add(new MazeCoord(x,y));	// add the position into the path LinkedList
				return true;
			}
	
			else {
				maze[x][y]=false;	// set the position back to free
				return false;
			}
		} 
		
		return false;
		
	}

}
