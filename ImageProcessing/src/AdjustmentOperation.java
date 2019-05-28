/**Dongzheng (Elizabeth)Xu
 * This operation changes the brightness of each pixel depending on its Euclidean distance from the upper-left
 * corner of the image.
 * 
 * Last edited: February 3 2019
 **/
import java.awt.Color;

public class AdjustmentOperation implements ImageOperation {

	@Override
	public Color[][] doOperation(Color[][] imageArray) {
		int numOfRows = imageArray.length;// num of rows in image
		int numOfColumns = imageArray[0].length;//num of columns in image

		Color [][] result = new Color [numOfRows][numOfColumns]; //each element represents one pixel

		for(int r=0; r<numOfRows; r++) {//run through each pixel in each column and row of the image
			for(int c=0; c<numOfColumns; c++) {

				result[r][c]= EuclidDist(r,c,imageArray); //gets pixel with Euclidean adjustment and sets it as a resulting pixel
			}
		}
		return result;
	}

	public Color EuclidDist( int x, int y,Color[][] imageArray) { 

		//defines euclidean distance and relation to brightness adjustment
		double D=Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
		double M=Math.sqrt(Math.pow(imageArray.length,2)+Math.pow(imageArray[0].length,2));
		double adjustBrightness = D/M;

		//find pixel colour
		int red = (int)(imageArray[x][y].getRed()*adjustBrightness);
		int green =(int) (imageArray[x][y].getGreen()*adjustBrightness);
		int blue = (int)(imageArray[x][y].getBlue()*adjustBrightness);

		//set a pixel
		Color color = new Color (red,green,blue);

		return color;
	}

}