//Name: Chenghao Wei
//USC NetID: chenghaw
//CS 455 PA3
//Spring 2018

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import java.util.Scanner;
import java.io.File;

/**
 * MazeViewer class
 * 
 * Program to read in and display a maze and a path through the maze. At user
 * command displays a path through the maze if there is one.
 * 
 * How to call it from the command line:
 * 
 * java MazeViewer mazeFile
 * 
 * where mazeFile is a text file of the maze. The format is the number of rows
 * and number of columns, followed by one line per row, followed by the entry
 * location, and ending with the exit location. Each maze location is either a
 * wall (1) or free (0). Here is an example of contents of a file for a 3x4
 * maze, with entry location as the top left, and exit location as the bottom
 * right (we count locations from 0, similar to Java arrays):
 * 
 * 3 4 0111 0000 1110 0 0 2 3
 * 
 */

public class MazeViewer {

	private static final char WALL_CHAR = '1';
	private static final char FREE_CHAR = '0';

	public static void main(String[] args) {

		String fileName = "";

		try {

			if (args.length < 1) {
				System.out.println("ERROR: missing file name command line argument");
			} else {
				fileName = args[0];

				JFrame frame = readMazeFile(fileName);

				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				frame.setVisible(true);
			}

		} catch (FileNotFoundException exc) {
			System.out.println("ERROR: File not found: " + fileName);
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}

	/**
	 * readMazeFile reads in maze from the file whose name is given and returns a
	 * MazeFrame created from it.
	 * 
	 * @param fileName
	 *            the name of a file to read from (file format shown in class
	 *            comments, above)
	 * @returns a MazeFrame containing the data from the file.
	 * 
	 * @throws FileNotFoundException
	 *             if there's no such file (subclass of IOException)
	 * @throws IOException
	 *             (hook given in case you want to do more error-checking -- that
	 *             would also involve changing main to catch other exceptions)
	 */
	private static MazeFrame readMazeFile(String fileName) throws IOException {

		File file = new File("testfiles/" + fileName);  // open a file with given name
		Scanner sc = new Scanner(file);

		int row = sc.nextInt();  // the first value in the file is number of rows
		int col = sc.nextInt();  // the second value in the file is number of columns
		boolean[][] mazedata = new boolean[row][col];
		String st = sc.nextLine();

		for (int i = 0; i < row; i++) {
			st = sc.nextLine();  //  scan the next line into "st" as a string
			for (int j = 0; j < col; j++) {
				if (st.charAt(j) == WALL_CHAR) {
					mazedata[i][j] = true;
				} else if (st.charAt(j) == FREE_CHAR) {
					mazedata[i][j] = false;
				}
			}
		}

		// the two values of the second last line represent the coordinate of the entry position
		int entry_x = sc.nextInt();
		int entry_y = sc.nextInt();

		// the two values of the last line represent the coordinate of the exit position
		int exit_x = sc.nextInt();
		int exit_y = sc.nextInt();

		return new MazeFrame(mazedata, new MazeCoord(entry_x, entry_y), new MazeCoord(exit_x, exit_y));

	}

}
