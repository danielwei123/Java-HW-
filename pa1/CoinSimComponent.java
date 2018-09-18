/**
* class CoinSimComponent
* 
* Determine the location of each bar and label.
* Then call the Bar class to declare three new Bar objects.
*/

import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

public class CoinSimComponent extends JComponent
{
	int twoheadsNum;
	int twotailsNum;
	int headtailNum;

	public void paintComponent(Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g;

		int totalNum = twoheadsNum + twotailsNum + headtailNum;
		
/**
 * Calculate the percentage of each case over total trials.
 */
		int twoheadsPercent = 100 * twoheadsNum / totalNum;
		int twotailsPercent = 100 * twotailsNum / totalNum;
		int headtailPercent = 100 - twoheadsPercent - twotailsPercent;

/**
 * Determine several constant values: vertical buffer, bar width.
 * Then calculate the values of interval between two bars correspondingly.
 */
		int VERTICAL_BUFFER = 40;											//vertical buffer
		int BAR_WIDTH = 60;													//bar width
		int WIDTH = (getWidth()-3*BAR_WIDTH)/4;								//width between each bar
		double SCALE = ((double)getHeight() - 2*VERTICAL_BUFFER) / totalNum;	//scale: number of pixels per application unit (trial)

/**
 * Set the labels shown at the bottom of three bars.
 */
		String label1 =  "Two Heads: " + twoheadsNum +"(" + twoheadsPercent + "%)";
		String label2 =  "A Head and a Tail: " + headtailNum +"(" + headtailPercent + "%)";
		String label3 =  "Two Tails: " + twotailsNum +"(" + twotailsPercent + "%)";

/**
 * Obtain the height of the label.
 */
		Font font = g2.getFont();
		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D labelBounds = font.getStringBounds(label1, context);
		int heightOfLabel = (int)labelBounds.getHeight();
		   
/**
 * Declare three new Bar objects with given parameters.
 */
		Bar bar1 = new Bar(getHeight()-heightOfLabel-VERTICAL_BUFFER,		//location of the bottom of the label
						   WIDTH,										//location of the left side of the bar
						   BAR_WIDTH,									//width of the bar (in pixels)
						   twoheadsNum,									//bar-height
						   SCALE,										//scales: how many pixels per application unit
						   Color.RED, 
						   label1);

		Bar bar2 = new Bar(getHeight()-heightOfLabel-VERTICAL_BUFFER,		//location of the bottom of the label
				   		   2*WIDTH+BAR_WIDTH,							//location of the left side of the bar
				   		   BAR_WIDTH,									//width of the bar (in pixels)
				   		   headtailNum,									//bar-height
				   		   SCALE,										//scales: how many pixels per application unit
				   		   Color.GREEN, 
				   		   label2);

		Bar bar3 = new Bar(getHeight()-heightOfLabel-VERTICAL_BUFFER,		//location of the bottom of the label
						   3*WIDTH+2*BAR_WIDTH,							//location of the left side of the bar
						   BAR_WIDTH,									//width of the bar (in pixels)
						   twotailsNum,									//bar-height
						   SCALE,										//scales: how many pixels per application unit
						   Color.BLUE, 
						   label3);

/**
 * Call draw function to draw three bars defined previously.
 */
		bar1.draw(g2);
		bar2.draw(g2);
		bar3.draw(g2);		
	}
}
