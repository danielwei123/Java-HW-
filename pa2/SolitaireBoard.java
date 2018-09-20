import java.util.ArrayList;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

/*
class SolitaireBoard
The board for Bulgarian Solitaire.  You can change what the total number of cards is for the game
by changing NUM_FINAL_PILES, below.  Don't change CARD_TOTAL directly, because there are only some values
for CARD_TOTAL that result in a game that terminates.
(See comments below next to named constant declarations for more details on this.)
*/

public class SolitaireBoard {

    public static final int NUM_FINAL_PILES = 9;
    // number of piles in a final configuration
    // (note: if NUM_FINAL_PILES is 9, then CARD_TOTAL below will be 45)

    public static final int CARD_TOTAL = NUM_FINAL_PILES * (NUM_FINAL_PILES + 1) / 2;
    // bulgarian solitaire only terminates if CARD_TOTAL is a triangular number.
    // see: http://en.wikipedia.org/wiki/Bulgarian_solitaire for more details
    // the above formula is the closed form for 1 + 2 + 3 + . . . + NUM_FINAL_PILES

    // Note to students: you may not use an ArrayList -- see assgt description for
    // details.

    /**
     * Representation invariant:
	 * 
	 * number of piles should be between 1 and 45
	 * number of card in each pile should be between 0 and 45
	 * CARD_TOTAL:total card number should be 45 
	 */

    // <add instance variables here>
    private int[] cardArray = new int[CARD_TOTAL];  //construct an array for piles
    private int numPile;  //number of piles

    /**
	 * Creates a solitaire board with the configuration specified in piles. piles
	 * has the number of cards in the first pile, then the number of cards in the
	 * second pile, etc. PRE: piles contains a sequence of positive numbers that sum
	 * to SolitaireBoard.CARD_TOTAL
	 */
    public SolitaireBoard(ArrayList<Integer> piles) {
        for (int i=0;i<piles.size();i++) {
            cardArray[i] = piles.get(i);
        }
        numPile = piles.size();

        assert isValidSolitaireBoard();  // check if the array is valid
    }

    /**
	 * Creates a solitaire board with a random initial configuration.
	 */
    public SolitaireBoard() {
        int sum = 0; 					// how many cards already in the array
        while (sum < CARD_TOTAL) {
            Random generator = new Random();
            int numCard = 1 + generator.nextInt(CARD_TOTAL - sum); // how many cards in next pile
            cardArray[numPile++] = numCard; // add "numCard" cards into array
            sum += numCard;					//update the number of total cards in the array
        }
		
        assert isValidSolitaireBoard();	// check if the array is valid
    }

    /**
	 * Plays one round of Bulgarian solitaire. Updates the configuration according
	 * to the rules of Bulgarian solitaire: Takes one card from each pile, and puts
	 * them all together in a new pile. The old piles that are left will be in the
	 * same relative order as before, and the new pile will be at the end.
	 */
    public void playRound() {
    
        int[] newArray = new int[CARD_TOTAL];  //create a temp array named "newArray" with size of CARD_TOTAL
        int newNumPile = 0;	//number of piles in newArray

        for (int i=0;i<=numPile;i++) {
            if (cardArray[i]>0) {
                newArray[newNumPile++] = cardArray[i]-1;  //after each operation, each pile is reduced by one
            }
        }
        newArray[newNumPile] = newNumPile++;  //the last pile size in the new array is the pile number of the old array
        numPile = newNumPile;  //replace numPile with newNumPile
        cardArray = newArray;  //replace cardArray with newArray

    }

    /**
	 * Returns true iff the current board is at the end of the game. That is, there
	 * are NUM_FINAL_PILES piles that are of sizes 1, 2, 3, . . . , NUM_FINAL_PILES,
	 * in any order.
	 */

    public boolean isDone() {
        Set set1 = new HashSet();
        Set set2 = new HashSet();

        //create set1 of {1,2,3,4,5,6,7,8,9}
        for (int i = 1; i <= NUM_FINAL_PILES; i++) {
            set1.add(i);
            
        }

        //create set2 which contains the pile size in cardArray
        for (int i = 0; i < NUM_FINAL_PILES; i++) {
            set2.add(cardArray[i]);
            
        }

        //compare if set1 and set2 are equal
        if (set1.equals(set2)) {
            return true;
        } else {
            return false;
        }

    }

    /**
	 * Returns current board configuration as a string with the format of a
	 * space-separated list of numbers with no leading or trailing spaces. The
	 * numbers represent the number of cards in each non-empty pile.
	 */
    public String configString() {

        String str="";
        for (int i=0;i<numPile-1;i++) {
            if (cardArray[i]==0) continue; //skip the pile with no card in it
            str = str+cardArray[i]+" ";  //put the card number of next pile into the string
        }
        str += cardArray[numPile-1];  //put the card number of the last pile into the string

        return str;
        
    }

    /**
	 * Returns true iff the solitaire board data is in a valid state (See
	 * representation invariant comment for more details.)
	 */
    private boolean isValidSolitaireBoard() {
        boolean valid = true;
        int sum=0;  //the total number of cards in the array

        for (int i=0;i<cardArray.length;i++) {
            sum += cardArray[i];
            if (cardArray[i]<0 || cardArray[i]>45) {  //card number in each pile should be between 0 and 45
                valid = false;
            }
        }
        
        if (sum!=CARD_TOTAL) {							//total card number in all piles should be CARD_TOTAL
            valid = false;
        }
        
        return valid;
        
    }

}
