//we included the import statements for you
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
* Bar class
* A labeled bar that can serve as a single bar in a bar graph.
* The text for the label is centered under the bar.
* 
* NOTE: we have provided the public interface for this class. Do not change
* the public interface. You can add private instance variables, constants,
* and private methods to the class. You will also be completing the
* implementation of the methods given.
* 
*/
public class Bar 
{
	private int xLeft;				//location of the left side of the bar
	private int yTop;				//location of the top of the bar 
	private int rectHeight;			//rectangle height
	private int rectWidth;			//rectangle width
	private Color rectColor;			//rectangle color
	private String rectLabel;		
	private int labelLength;			//length of label


/**
   Creates a labeled bar.  You give the height of the bar in application
   units (e.g., population of a particular state), and then a scale for how
   tall to display it on the screen (parameter scale). 

   @param bottom  location of the bottom of the label
   @param left  location of the left side of the bar
   @param width  width of the bar (in pixels)
   @param barHeight  height of the bar in application units
   @param scale  how many pixels per application unit
   @param color  the color of the bar
   @param label  the label at the bottom of the bar
*/
public Bar(int bottom, int left, int width, int barHeight,
           double scale, Color color, String label) 
{
	xLeft = left;														//xLeftL: the left side location of the bar
	yTop = (int)(bottom - barHeight*scale);								//yTop: the top location of the bar
	rectHeight = (int)(barHeight*scale);									//rectHeight: height of the bar
	rectWidth = width;													//rectWidth: width of the bar
	rectLabel = label;													//label below the bar
	rectColor = color;													//the color of the bar
	
}

/**
   Draw the labeled bar. 
   @param g2  the graphics context
*/
public void draw(Graphics2D g2) {
	
	Rectangle rect = new Rectangle(xLeft, yTop, rectWidth, rectHeight);	//Declare a new rectangle object.
	
	g2.setColor(rectColor);
	g2.fill(rect);
	g2.draw(rect);
	
    Font font = g2.getFont();
    FontRenderContext context = g2.getFontRenderContext();
    Rectangle2D labelBounds = font.getStringBounds(rectLabel, context);
    labelLength= (int)labelBounds.getWidth();								//Get width of the label.

	g2.setColor(Color.BLACK);											//Set the color back to black.
	g2.drawString(rectLabel, xLeft+(rectWidth-labelLength)/2, yTop+rectHeight+(int)labelBounds.getHeight());	//Print the label at the bottom of the bar.
}

}
