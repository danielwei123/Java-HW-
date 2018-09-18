/**
 * This class tests the CoinTossSimulator class.
*/
import java.util.ArrayList;
public class CoinTossSimulatorTester {

/**
 * Create two new arraylists for storing trial numbers.
*/

	static ArrayList<Integer> list1 = new ArrayList<Integer>();
	static ArrayList<Integer> list2 = new ArrayList<Integer>();

/**
 * The Sum class returns the sum of all the values in arraylist.
*/

	public static int Sum(ArrayList<Integer> list, int num) {
		int sum =0;
		list.add(num);
		for (int i=0;i<list.size();i++) {
			sum += list.get(i);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		CoinTossSimulator coinToss = new CoinTossSimulator();		
		
		System.out.println("After constructor:");
		coinToss.run(0);
		System.out.println("Number of trials [exp: " + Sum(list1,0)+ "]: " + coinToss.getNumTrials());
		System.out.println("Two-head tosses: " + coinToss.getTwoHeads());
		System.out.println("Two-tail tosses: " + coinToss.getTwoTails());
		System.out.println("One-head one-tail tosses: " + coinToss.getHeadTails());
		System.out.println("Tosses add up correctly? " + (coinToss.getTwoHeads()+coinToss.getTwoTails()+coinToss.getHeadTails()==coinToss.getNumTrials()));
		System.out.println();
		
		System.out.println("After run(1):");
		coinToss.run(1);
		System.out.println("Number of trials [exp: " + Sum(list1,1)+ "]: " + coinToss.getNumTrials());
		System.out.println("Two-head tosses: " + coinToss.getTwoHeads());
		System.out.println("Two-tail tosses: " + coinToss.getTwoTails());
		System.out.println("One-head one-tail tosses: " + coinToss.getHeadTails());
		System.out.println("Tosses add up correctly? " + (coinToss.getTwoHeads()+coinToss.getTwoTails()+coinToss.getHeadTails()==coinToss.getNumTrials()));
		System.out.println();

		System.out.println("After run(10):");
		coinToss.run(10);
		System.out.println("Number of trials [exp: " + Sum(list1,10)+ "]: "+ coinToss.getNumTrials());
		System.out.println("Two-head tosses: " + coinToss.getTwoHeads());
		System.out.println("Two-tail tosses: " + coinToss.getTwoTails());
		System.out.println("One-head one-tail tosses: " + coinToss.getHeadTails());
		System.out.println("Tosses add up correctly? " + (coinToss.getTwoHeads()+coinToss.getTwoTails()+coinToss.getHeadTails()==coinToss.getNumTrials()));
		System.out.println();

		System.out.println("After run(100):");
		coinToss.run(100);
		System.out.println("Number of trials [exp: "+ Sum(list1,100)+ "]: " + coinToss.getNumTrials());
		System.out.println("Two-head tosses: " + coinToss.getTwoHeads());
		System.out.println("Two-tail tosses: " + coinToss.getTwoTails());
		System.out.println("One-head one-tail tosses: " + coinToss.getHeadTails());
		System.out.println("Tosses add up correctly? " + (coinToss.getTwoHeads()+coinToss.getTwoTails()+coinToss.getHeadTails()==coinToss.getNumTrials()));
		System.out.println();

		coinToss.reset();
		
		System.out.println("Number of trials [exp: " + Sum(list2,0)+ "]: "+ coinToss.getNumTrials());
		System.out.println("Two-head tosses: " + coinToss.getTwoHeads());
		System.out.println("Two-tail tosses: " + coinToss.getTwoTails());
		System.out.println("One-head one-tail tosses: " + coinToss.getHeadTails());
		System.out.println("Tosses add up correctly? " + (coinToss.getTwoHeads()+coinToss.getTwoTails()+coinToss.getHeadTails()==coinToss.getNumTrials()));
		System.out.println();

		System.out.println("After run(1000):");
		coinToss.run(1000);
		System.out.println("Number of trials [exp: "+ Sum(list2,1000)+ "]: " + coinToss.getNumTrials());
		System.out.println("Two-head tosses: " + coinToss.getTwoHeads());
		System.out.println("Two-tail tosses: " + coinToss.getTwoTails());
		System.out.println("One-head one-tail tosses: " + coinToss.getHeadTails());
		System.out.println("Tosses add up correctly? " + (coinToss.getTwoHeads()+coinToss.getTwoTails()+coinToss.getHeadTails()==coinToss.getNumTrials()));
		System.out.println();

}

}
