/**
* class CoinSimViewer
* 
* First require user to enter the number of trials. Then check if the input value is positive. 
* If not, keep requiring user to input new values until it is a positive integer.
* 
* Then call CoinTossSimulator class to simulate the coin tossing situation.
* Finally, the computer will automatically open a frame window to show the results of simulation
* with bar plots and labels indicating the trail numbers and percentage of each case.
*/

import java.util.Scanner;
import javax.swing.JFrame;

public class CoinSimViewer {

	public static void main(String[] args) {

/**
 	An interactive interface allowing user to input the number of trials
 */
		System.out.print("Enter number of trials: ");
		Scanner sc = new Scanner(System.in);
		int numTrials = sc.nextInt();

/**
	Check if the input value is positive. If not, keep requiring user to input new values until it is a positive integer.
*/
		
		while (numTrials<=0) {
			System.out.println("ERROR: Number entered must be greater than 0.");
			System.out.print("Enter number of trials: ");
			numTrials = sc.nextInt();
		}
		
		CoinTossSimulator coinToss = new CoinTossSimulator();		//Use constructor to initialize a new CoinTossSimulator class object.
		coinToss.run(numTrials);									//Run the simulator with numTrials runs.

/**
	Open a new frame window for showing the results of CoinTossSimulator with bar plot.
*/
		
		JFrame frame = new JFrame(); 
		
		frame.setSize(800,500);									//Set the window size as (800, 500).
		frame.setTitle("CoinSim");								//Set the title of the window as "CoinSim".
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CoinSimComponent component = new CoinSimComponent();		//Declare a new CoinSimComponent object named "component".
		component.twoheadsNum=coinToss.getTwoHeads();
		component.twotailsNum=coinToss.getTwoTails();
		component.headtailNum=coinToss.getHeadTails();
		frame.add(component);
		
		frame.setVisible(true);									//Set the window to be visible.
	}

}
