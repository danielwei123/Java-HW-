/**
* class CoinTossSimulator
* 
* Simulates trials of repeatedly tossing two coins and allows the user to access the
* cumulative results.
* 
* NOTE: we have provided the public interface for this class.  Do not change
* the public interface.  You can add private instance variables, constants, 
* and private methods to the class.  You will also be completing the 
* implementation of the methods given. 
* 
* Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
* 
*/

import java.util.Random;

public class CoinTossSimulator {

	private int trialsNum;
	private int twoheadsNum;
	private int twotailsNum;
	private int headtailsNum;
	
	private Random generator;
/**
   Creates a coin toss simulator with no trials done yet.
*/
public CoinTossSimulator() {
	trialsNum = 0;
	twoheadsNum = 0;
	twotailsNum = 0;
	headtailsNum = 0;
}


/**
   Runs the simulation for numTrials more trials. Multiple calls to this method
   without a reset() between them *add* these trials to the current simulation.
   
   @param numTrials  number of trials to for simulation; must be >= 1
 */
public void run(int numTrials) {
	trialsNum += numTrials;
	int coin1;
	int coin2;
	generator = new Random();
	
	//Denote 0 as head, 1 as tail.
	
	for (int i=0;i<numTrials;i++) {
		
		coin1 = generator.nextInt(2);
		coin2 = generator.nextInt(2);
		
		if (coin1+coin2==0) {twoheadsNum++;}
		else if(coin1+coin2==2) {twotailsNum++;}
		else {headtailsNum++;}
	}
}


/**
   Get number of trials performed since last reset.
*/
public int getNumTrials() {
    return trialsNum; // DUMMY CODE TO GET IT TO COMPILE
}


/**
   Get number of trials that came up two heads since last reset.
*/
public int getTwoHeads() {
    return twoheadsNum; // DUMMY CODE TO GET IT TO COMPILE
}


/**
  Get number of trials that came up two tails since last reset.
*/  
public int getTwoTails() {
    return twotailsNum; // DUMMY CODE TO GET IT TO COMPILE
}


/**
  Get number of trials that came up one head and one tail since last reset.
*/
public int getHeadTails() {
    return headtailsNum; // DUMMY CODE TO GET IT TO COMPILE
}


/**
   Resets the simulation, so that subsequent runs start from 0 trials done.
 */
public void reset() {
	trialsNum = 0;
	twoheadsNum = 0;
	twotailsNum = 0;
	headtailsNum = 0;
}

}
