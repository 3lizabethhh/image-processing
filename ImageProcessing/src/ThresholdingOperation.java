/**Dongzheng (Elizabeth)Xu
 * This operation changes filter displays each pixel of an image in only one of two colours,black or white depending
 * if the brightness score is greater than 100.
 * 
 * Last edited: February 3 2019
 **/
import java.awt.Color;

public class ThresholdingOperation implements ImageOperation {

	@Override
	public Color[][] doOperation(Color[][] imageArray) {
		int GIVENCONDITION=100;// condition given, if above  the colour is white, otherwise black
		int numOfRows = imageArray.length;// num of rows in image
		int numOfColumns = imageArray[0].length;//num of columns in image

		Color [][] result = new Color [numOfRows][numOfColumns]; //each element rep one pixel

		for(int r=0; r<numOfRows; r++) {//run through each column and row
			for(int c=0; c<numOfColumns; c++) {
				
				result[r][c]= new Color (0,0,0);//set default pixel color to white
	
				double bScore= brightness(imageArray[r][c]);	//find the pixel's brightness score
				
				if (bScore>GIVENCONDITION) {
					result[r][c]= new Color (255,255,255);//change color to black if condition is satisfied 
				}
			}
		}
		return result;
	}

	//finds brightness score
	public double brightness( Color p) {

		double brightScore= (0.21)*(p.getRed())+(0.71)*p.getGreen()+(0.07)*p.getBlue() ;
		return brightScore;
	}

}